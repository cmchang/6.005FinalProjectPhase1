package pingball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import physics.LineSegment;
import pingball.Wall.Boundary;

public class BoardsHandler {
/**
 *  This class will keep track of all the connections between the boards' walls
 * 
 */
 
     public BoardsHandler() {
     }
     
    //String: UniqueBoardName, Board: corresponding Board
    //private HashMap<String, Board> Boards; 
     // use Board.name
    
    // i.e. "BoardNameLeft" -> "BoardName2Right
    // two entries for each connection
    
     
//     // the strings in the list are concats of the name followed by a / followed by the wall (left,right,top,bottom)
//    private HashMap<String, List<String>> boardConnections; 
    
    private HashMap<String, List<Connection>> map = new HashMap<String, List<Connection>>();;

    
    /**
     * Constructor method.  
     * Called when the first client is connected to the server and a board is created.
     * 
     * @param board
     */
//    public BoardsHandler(Board board, HashMap<String, List<String>> connections){
//        boardConnections = connections;
//        map = new HashMap<String, List<Connection>>();        
//    }
    
    public class Connection{
        String name;
        Boundary boundary;
        
        Connection(String name, Boundary boundary){
            this.name = name;
            this.boundary = boundary;
        }
    }
    
//    private HashMap<String, List<Connection>> parseConnections(HashMap<String, List<String>> connections) {
//        HashMap<String, List<Connection>> map = new HashMap<String, List<Connection>>(); 
//        
//        for (String key:connections.keySet()){
//            List<Connection> connectionList = new ArrayList<Connection>();
//            for (String value:connections.get(key)){
//                String[] elements = value.split("/");
//                
//                String name = elements[0]; 
//                String wallside = elements[1];
//                Boundary wall = null;
//                if (wallside.equals("left")){
//                    wall = Boundary.LEFT;                            
//                } else if (wallside.equals("top")){
//                    wall = Boundary.TOP;
//                } else if (wallside.equals("bottom")){
//                    wall = Boundary.BOTTOM;
//                } else if (wallside.equals("right")){
//                    wall = Boundary.RIGHT;
//                } else {
//                    System.err.println("invalid connection within method: parseConnections");
//                }
//                connectionList.add(new Connection(name,wall));                     
//            }
//            map.put(key, connectionList);
//        }
//        return map;
//        
//    }
    public enum Orientation {HORIZONTAL,VERTICAL};
    
    /** board1 has to be left or top; board2 has to be right or bottom*/
    public void addConnection(String board1, String board2, Orientation o){
        List<Connection> c1 = new ArrayList<Connection>();
        List<Connection> c2 = new ArrayList<Connection>();
        if (o.equals(Orientation.HORIZONTAL)) {                                    
            if (!map.get(board1).isEmpty()) c1.addAll(map.get(board1));
            for (Connection existing:c1){
                if (existing.name.equals(board2)) c1.remove(existing); // boards can be overridden in terms of connectivity 
            }            
            c1.add(new Connection(board2,Boundary.BOTTOM));            
            map.put(board1, c1);
            
            
            if (!map.get(board2).isEmpty()) c2.addAll(map.get(board2));
            for (Connection existing:c2){
                if (existing.name.equals(board1)) c2.remove(existing); // boards can be overridden in terms of connectivity 
            }            
            c2.add(new Connection(board1,Boundary.TOP));
            map.put(board2, c2);
        
        } else if (o.equals(Orientation.VERTICAL)){
            
            if (!map.get(board1).isEmpty()) c1.addAll(map.get(board1));
            for (Connection existing:c1){
                if (existing.name.equals(board2)) c1.remove(existing); // boards can be overridden in terms of connectivity 
            }
            c1.add(new Connection(board2,Boundary.RIGHT));
            map.put(board1, c1);
            
            
            if (!map.get(board2).isEmpty()) c2.addAll(map.get(board2));
            for (Connection existing:c2){
                if (existing.name.equals(board1)) c2.remove(existing); // boards can be overridden in terms of connectivity 
            }       
            c2.add(new Connection(board1,Boundary.LEFT));
            map.put(board2, c2);
        }
    }
    
//    /**
//     * Checks if there is a board connection, updates BoardConnections as necessary
//     * Adds board to Boards
//     *  
//     * @param board
//     */
//    public void addBoard(Board board){
//        List<Connection> otherActiveConnections = new ArrayList<Connection>(); 
//        for (String key:activeMap.keySet()){ // for each active board
//            if (isConnected(key,board.name())){ //if the boards are supposed to be connected
//                otherActiveConnections.add(getConnection(board.name(),key)); // get connection. how the board is connected to other boards 
//            }
//        }
//        
//        activeMap.put(board.name(), otherActiveConnections);
//    }
    /** returns connection from board 1 to board 2*/
    public Connection getConnection(String board1, String board2) {
        for (Connection c: map.get(board1)){
            if (c.name.equals(board2)) return c;
        }
        return null;
    }


    /**
     * Checks if there is a board connection, updates BoardConnections as necessary
     * Removes board from Boards
     * @param board
     */
    public void removeBoard(Board board){
        if (map.containsKey(board.name())) map.remove(board.name());
        
        for (String key:map.keySet()){ // for each board
            for (Connection c:map.get(key)){ // for all the connections
                if (c.name.equals(board.name())){ // if board is connected
                    map.get(key).remove(c); // remove the connection from the board                    
                }                    
            }
        }        
    }
    
    /**
     * Given identifying IDs for two boards, this method returns a boolean indicating
     * if they have a wall connecting to eachother's board
     * @param board1ID
     * @param board2ID
     * @return
     */
    public boolean isConnected(String board1ID, String board2ID){
        for (Connection connection: map.get(board1ID)){
            if (connection.name.equals(board2ID)) return true;
        }
        for (Connection connection:map.get(board2ID)){
            if (connection.name.equals(board1ID)) return true;
        }
        return false;
    }
}
