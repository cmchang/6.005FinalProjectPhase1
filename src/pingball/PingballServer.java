package pingball;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class PingballServer {
    /**
     * This will handle all of the clients and make sure the boards are updating in-sync
     * 
     * Concurrency 
     * -serverSocket is private final object that is confined to this class.
     * -lock is final so it cannot be changed and it is used to protect the global 
     *      board connection list (Boards Handler Instance)
     * -one board connection list object is used across all of the clients
     * Whenever anything changes the board connection list
     * 
     */
        
    private final ServerSocket serverSocket;      
    private final Object lock = new Object(); //used to protect global variable thread safety
    public static BoardsHandler boardHandler = new BoardsHandler(); // global variable protected by the lock
        
    
    /**
     * Make a PingBallServer that listens for connections on port.
     * 
     * @param port port number, requires 0 <= port <= 65535
     */
    public PingballServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    /**
     * Run the server, listening for client connections and handling them.
     * Never returns unless an exception is thrown.
     * 
     * @throws IOException if the main server socket is broken
     *                     (IOExceptions from individual clients do *not* terminate serve())   
     */
    public void serve() throws IOException {        
        // block until a client connects. when a client connects, run it in a new thread
        while (true){   
            Socket socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            
            String fromSocket = in.readLine();
            Board newBoard = GrammarFactory.parse(fromSocket); // Carolyn updating this
            
            Client client = new Client(socket, lock, boardHandler);
            client.setBoard(newBoard);
            Thread thread = new Thread(client);           
            // handle the client    
            thread.start();
        }        
    }
    
    /**
     * Instantiate a pingball server
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        int port = 10987; // default port
        Queue<String> arguments = new LinkedList<String>(Arrays.asList(args));
        
        try {
            while (!arguments.isEmpty()){ 
                String flag = arguments.remove();
                try {
                    if (flag.equals("--port")){
                        port = Integer.parseInt(arguments.remove());
                        if (port<0 || port > 655535){
                            throw new IllegalArgumentException("port " +port+ " out of range");
                        }
                    } else {
                        throw new IllegalArgumentException("unknown option: \"" + flag + "\"");
                    }
                } catch (NoSuchElementException nsee) {
                    throw new IllegalArgumentException("missing argument for " + flag);
                } catch (NumberFormatException nfe) {
                    throw new IllegalArgumentException("unable to parse number for " + flag);
                }      
            }
        } catch (IllegalArgumentException iae) {
            System.err.println(iae.getMessage());
            System.err.println("usage: PingballServer [--port PORT]");
            return;
        }        
        
        try {            
            runPingballServer(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Runs a new server
     * @param port port that we are going to connect to
     * @throws Exception
     */
    public static void runPingballServer(int port) throws Exception {
        PingballServer server = new PingballServer(port);        
        server.serve();
    }

}
