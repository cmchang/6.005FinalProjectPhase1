package pingball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import physics.Angle;
import physics.Circle;
import physics.Vect;

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

    /**
     * Instantiate a new client
     * @param socket the port it is connecting on
     * @param lock the lock protecting the global variable connectionsIn
     * @param connectionsIn boardHandler with all the relationships between boards
     */
    Client(Socket socket, Object lock, BoardsHandler connectionsIn){
        this.board = new Board();
        Angle start = new Angle(2.0);
        Angle start2 = new Angle(3.0);
        Circle cir1 = new Circle(5.0, 5.0, .01);
        Circle cir2 = new Circle(2.0, 2.0, .01);
        Vect v1 = new Vect(start, 10.0);
        Vect v2 = new Vect(start2, 10.0);
        Ball ball = new Ball(cir1, v1);
        Ball ball2 = new Ball(cir2, v2);
        board.add(ball);
        board.add(ball2);
        this.socket = socket;
        this.lock = lock;
        Client.connections = connectionsIn;
    }
    
    /**
     * Function that runs a specific client
     */
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
            Runnable r = new Update(board, in, lock, connections);
            new Thread(r).start();
            board.animate(out, 20);        
        } finally {
            out.close();
            in.close();
        }
    }
}
