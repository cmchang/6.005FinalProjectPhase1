package pingball;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.Socket;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * The individual clients that are connecting to the server
 * 
 * Handles the connections and their views
 * 
 * Class of type Runnable that represents an individual user.. runs in its own thread
 * The user plays on a board created by the server and has to possess a lock on the board to modify connections
 * To keep track of the connections, the client needs a lock from the server to update the global variable
 * 
 * Rep is final and private with the exception of the lock and connections (these need to be globalized)
 *
 */
public class Client implements Runnable{
    
    private final Socket socket;
    private Board board;
    
    private final Object lock;
    public final BoardsHandler connections; //global variable. even though its public, its protected by the lock

    /**
     * Instantiate a new client
     * @param socket the port it is connecting on
     * @param lock the lock protecting the global variable connectionsIn
     * @param connectionsIn boardHandler with all the relationships between boards
     */
    Client(Socket socket, Object lock, BoardsHandler connectionsIn){
//        this.board = new Board();
//        Angle start = new Angle(2.0);
//        Angle start2 = new Angle(3.0);
//        Circle cir1 = new Circle(5.0, 5.0, .01);
//        Circle cir2 = new Circle(2.0, 2.0, .01);
//        Vect v1 = new Vect(start, 10.0);
//        Vect v2 = new Vect(start2, 10.0);
//        Ball ball = new Ball(cir1, v1);
//        Ball ball2 = new Ball(cir2, v2);
//        board.addBall(ball);
//        board.addBall(ball2);
        //this.board = GrammarFactory.parse(new File("src/pingball/Boards/board2.txt"));
        this.socket = socket;
        this.lock = lock;
        this.connections = connectionsIn;
    }
    
    /**
     * Function that runs a specific client
     */   
    public void run() {
        // handle the client
        // need to initialize a board
        
        
        try {
            handleConnection(socket);
        } catch (IOException e) {
            e.printStackTrace();
        }  finally { 
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }  
    }
    
    /**
     * Handle a single client connection. Returns when client disconnects.
     * 
     * @param socket socket where the client is connected
     * @throws IOException if connection has an error or terminates unexpectedly
     */
    private void handleConnection(Socket socket) throws IOException { 
        //TODO test socket.isConnected();
        if (!socket.isConnected()) {
            Runnable r = new Update(board, new BufferedReader(new StringReader("")), lock, connections);
            new Thread(r).start();
            board.animate(20);
        } else {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            /*PrintWriter out = new PrintWriter(socket.getOutputStream(), true);*/
            try {
                Runnable r = new Update(board, in, lock, connections);
                new Thread(r).start();
                board.animate(/*out, */20);        
            } finally {
                /*out.close();*/
                in.close();
            }
        }
    }
    
    public static void main(String[] args) {
        //Command-line argument parsing
        final int numArgs = args.length;
        String hostname = "";
        String fileName = args[numArgs-1];
        File file = new File(fileName); // file is required to be the last argument        
        int port = 10987;  //default port
        Queue<String> arguments = new LinkedList<String>(Arrays.asList(args));
        
        try {
            if ( ! file.isFile()) throw new IllegalArgumentException("file not found: \"" + file + "\"");               
            while ((arguments.size()>(numArgs-1))){ // last arg is the filename, required.
                String flag = arguments.remove();
                try {
                    if (flag.equals("--port")){
                        port = Integer.parseInt(arguments.remove());
                        if (port<0 || port > 655535){
                            throw new IllegalArgumentException("port " +port+ " out of range");
                        }
                    } else if (flag.equals("--host")){
                        hostname = arguments.remove();
                    }  else {
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
            System.err.println("usage: PingballClient [--host HOST] [--port PORT] FILE");
            return;
        }
        try {
            runPingballClient(hostname, port, file, fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void runPingballClient(String hostname, int port, File file, String fileName) throws Exception{
        //System.out.println(myBoard.toString());
        if (hostname != null) {
            //join the server
            Socket socket = new Socket(hostname,port);            
            //BufferedReader in1 = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(GrammarFactory.FileToString(file));
            
        } else {
            // single-play
            Socket socket = new Socket(); // we don't need a socket.
            Object lock = new Object(); //used to protect global variable thread safety
            BoardsHandler connections = new BoardsHandler(); // global variable protected by the lock                        
            
            Client client = new Client(socket, lock, connections);
            client.setBoard(GrammarFactory.parse(file));
            Thread thread = new Thread(client);
            thread.start();            
        }
        
        //new File("src/pingball/Boards/board1.txt")
    }

    void setBoard(Board boardToSet) {
        this.board = boardToSet;        
    }
}
