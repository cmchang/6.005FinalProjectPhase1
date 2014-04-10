package pingball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

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
    private final Board board;
    private final Object lock;
    public static BoardsHandler connections = new BoardsHandler(); //global variable. even though its public, its protected by the lock

    /** TODO */
    Client(Socket socket, Board board, Object lock, BoardsHandler connectionsIn){
        this.socket = socket;
        this.board = board;
        this.lock = lock;
        this.connections = connectionsIn;
    }
    /** TODO */
    public void run() {
        // handle the client
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
        
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        try {
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                String output = "TODO";
                if (output != null) {
                    // TODO FINISH
                    out.flush();
                }                      
            }        
        // if we get here, either line is null(server is closed) 
        // or we hit boom in non-debug mode or bye was called
            
        } finally {
            out.close();
            in.close();
        }
    }
}
