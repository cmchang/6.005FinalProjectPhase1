package pingball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import pingball.Wall.Boundary;

/**
 * This class keeps track of all the connections between the boards walls.
 * Also facilitates sending balls through walls.
 */
public class BoardsHandler {
    /**
     *  This class will keep track of all the connections between the boards' walls
     * Constructor method. Called when the first client is connected to the server and a board is created.
     */

    // String: UniqueBoardName, Board: corresponding Board
    // List<Connection> are the list of connection objects that indicate that the board is connected to another board.
    //      Connection objects simply store the name of the otherBoard and the boundary that theyre connected on
    // ConcurrentLinkedQueue<Ball> is a threadsafe queue that stores balls that need to be put into the String that the balls are mapped to
    final private HashMap<String, List<Connection>> map = new HashMap<String, List<Connection>>();
    final private HashMap<String, ConcurrentLinkedQueue<Ball>> queue = new HashMap<String, ConcurrentLinkedQueue<Ball>>();

    
     public BoardsHandler() {
     }
         
    /**
     * This class is simply a storage unit for an invisible boundary:
     * It contains the name of the board that through the boundary and the boundary in question
     * 
     * name is unique String name of the other board
     * boundary an enum; can be Boundary.LEFT, Boundary.RIGHT, Boundary.RIGHT, Boundary.TPO
     */    
    public class Connection{
        final String name;
        final Boundary boundary;      
        
        /** can only be initialized inside BoardsHandler*/
        private Connection(String name, Boundary boundary){
            this.name = name;
            this.boundary = boundary;            
        }        
    }
    
    /**
     * Orientation of the connection. Can be either a horizontal or vertical connection
     *
     */
    public enum Orientation {HORIZONTAL,VERTICAL};
    
    
    /**
     * Constructor method for connections between boards. Given two board names and the orientation that they're connected in,
     * this creates the Connection objects and initializes the list of queues.
     * 
     * @param board1 the name of the LEFT or TOP board
     * @param board2 the name of the RIGHT or BOTTOM board
     * @param o an enum, defined as Orientation.HORIZONTAL or Orientation.VERTICAL
     */
    public void addConnection(String board1, String board2, Orientation o){
        List<Connection> cList1 = new ArrayList<Connection>();
        List<Connection> cList2 = new ArrayList<Connection>();
        
        if (!map.containsKey(board1))  map.put(board1, new ArrayList<Connection>());
        if (!map.containsKey(board2))  map.put(board2, new ArrayList<Connection>());
        
        if (o.equals(Orientation.VERTICAL)) { // if we have a horizontal connection between two boards                                   
            if (!map.get(board1).isEmpty()) cList1.addAll(map.get(board1)); // add all existing connections
            for (Connection existing:cList1){ 
                if (existing.name.equals(board2)) cList1.remove(existing); // boards can be overridden in terms of connectivity 
            }            
            cList1.add(new Connection(board2,Boundary.BOTTOM));            
            map.put(board1, cList1);
            queue.put(board1, new ConcurrentLinkedQueue<Ball>());
            
            
            if (!map.get(board2).isEmpty()) cList2.addAll(map.get(board2));
            for (Connection existing:cList2){
                if (existing.name.equals(board1)) cList2.remove(existing); // boards can be overridden in terms of connectivity 
            }            
            cList2.add(new Connection(board1,Boundary.TOP));
            map.put(board2, cList2);
            queue.put(board2, new ConcurrentLinkedQueue<Ball>());
        
        } else if (o.equals(Orientation.HORIZONTAL)){
            
            if (!map.get(board1).isEmpty()) cList1.addAll(map.get(board1));
            for (Connection existing:cList1){
                if (existing.name.equals(board2)) cList1.remove(existing); // boards can be overridden in terms of connectivity 
            }
            cList1.add(new Connection(board2,Boundary.RIGHT));
            map.put(board1, cList1);
            queue.put(board1, new ConcurrentLinkedQueue<Ball>());
            
            
            if (!map.get(board2).isEmpty()) cList2.addAll(map.get(board2));
            for (Connection existing:cList2){
                if (existing.name.equals(board1)) cList2.remove(existing); // boards can be overridden in terms of connectivity 
            }       
            cList2.add(new Connection(board1,Boundary.LEFT));
            map.put(board2, cList2);
            queue.put(board2, new ConcurrentLinkedQueue<Ball>());
        }
    }    


    /**
     * Checks if there is a board connection, updates BoardConnections as necessary
     * Removes board from Boards
     * @param board
     */
    public void removeBoard(Board board){
        if (map.containsKey(board.name())) {
            map.remove(board.name());
            queue.put(board.name(), new ConcurrentLinkedQueue<Ball>()); // all balls lost
        }        
        for (String key:map.keySet()){ // for each board
            for (Connection c:map.get(key)){ // for all the connections
                if (c.name.equals(board.name())){ // if board is connected
                    map.get(key).remove(c); // remove the connection from the board                    
                }                    
            }
        }        
    }    

    /**
     * Returns the List of active connections associated with a board.
     * 
     * @param board board boundaries you want to check for connections
     * @return a list of Connection objects which each contain a name of another boards at a certain boundary
     */
    public synchronized List<Connection> getConnections(Board board){
        if (map.containsKey(board.name())) return map.get(board.name());
        return new ArrayList<Connection>();
    }
    


    /** Method called by individual clients in the update class to get the already position corrected 
     * balls to add to their list of balls.
     * 
     * @param name name of the board that is receiving balls
     * @return list of balls that are being received
     */
    public List<Ball> receiveBalls(String name) {
        List<Ball> newList = new ArrayList<Ball>();
        if (!queue.containsKey(name)) return newList;
        while(!queue.get(name).isEmpty()) newList.add(queue.get(name).remove());        
        return newList;
    }


    /**Method that allows an individual client to send a ball to another client using the Connection object.
     * 
     * @param c Connection object that is on the wall connecting the boards
     * @param ball Ball that is to be sent through the wall
     */
    public void sendBall(Connection c, Ball ball) {       
        if (!queue.containsKey(c.name)) queue.put(c.name, new ConcurrentLinkedQueue<Ball>());        
        queue.get(c.name).add(ball);       
    }


}
