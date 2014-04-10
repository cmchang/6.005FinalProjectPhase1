package pingball;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
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
    public static BoardsHandler connections = new BoardsHandler(); // global variable protected by the lock
    
    /**
     * Make a PingBallServer that listens for connections on port.
     * 
     * @param port port number, requires 0 <= port <= 65535
     */
    public Server(int port, boolean debug) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    /**
     * Run the server, listening for client connections and handling them.
     * Never returns unless an exception is thrown.
     * 
     * @throws IOException if the main server socket is broken
     *                     (IOExceptions from individual clients do *not* terminate serve())   
     */
    public void serve(Board board) throws IOException {        
        // block until a client connects. when a client connects, run it in a new thread
        while (true){   
            Socket socket = serverSocket.accept();
            Thread client = new Thread(new Client(socket, board, lock, connections));           
            // handle the client    
            client.start();
        }
    }

}
