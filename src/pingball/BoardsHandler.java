package pingball;

import java.util.ArrayList;
import java.util.HashMap;

import physics.LineSegment;

public class BoardsHandler {
/**
 *  This class will keep track of all the connections between the boards' walls
 * 
 */
 
     public BoardsHandler() {
     }
     
    //String: UniqueBoardName, Board: corresponding Board
    private HashMap<String, Board> Boards; 
    
    // i.e. "BoardNameLeft" -> "BoardName2Right
    // two entries for each connection
    private HashMap<String, String> BoardConnections; 
    
    /**
     * Constructor method.  
     * Called when the first client is connected to the server and a board is created.
     * 
     * @param board
     */
    public BoardsHandler(Board board){
        
    }
    
    /**
     * Checks if there is a board connection, updates BoardConnections as necessary
     * Adds board to Boards
     * @param board
     */
    public void addBoard(Board board){
        
    }
    
    /**
     * Checks if there is a board connection, updates BoardConnections as necessary
     * Removes board from Boards
     * @param board
     */
    public void removeBoard(Board board){
        
    }
    
    /**
     * Given identifying IDs for two boards, this method returns a boolean indicating
     * if they have a wall connecting to eachother's board
     * @param board1ID
     * @param board2ID
     * @return
     */
    public boolean isConnected(String board1ID, String board2ID){
        return true;
    }
}
