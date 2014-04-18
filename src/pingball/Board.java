package pingball;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import physics.Circle;
import physics.LineSegment;
import pingball.Ball;
import pingball.Bumper.Shape;
import pingball.Flipper.Side;
import pingball.Wall.Boundary;
import pingball.Wall.Visibility;

/**
 * Representation of all the walls, gadgets and balls on a single Pingball board. Each client plays on a single board.
 *
 */
public class Board {
    // similar as in warm-up
    // except walls --> gadgets
    // the BoardsHandler will keep track of the relationships between wall line segments
    private List<Ball> balls = Collections.synchronizedList(new ArrayList<Ball>());
    private String name = "Default";
    private final int xlength = 20;
    private final int ylength = 20;

    
    List<Gadget> objects = new ArrayList<Gadget>();
    //private HashMap<Gadget,List<Gadget>> gizmos;
    
    double friction1 = 0.025; // will need some init methods to set up constants based on board parsing. or make not final
    double friction2 = 0.025;
    double gravity = 25.0;
    
    /**
     * This method is a constructor for the board given a name, gravity, AND friction.
     * @param name
     * @param gravity
     * @param friction1
     * @param friction2
     */
    public Board(String name, double gravity, double friction1, double friction2){
        this.name = name;
        this.gravity = gravity;
        this.friction1 = friction1;
        this.friction2 = friction2;
        buildWalls();
    }
    
    /**
     * This method is a constructor for the board given a name and gravity.
     * @param name
     * @param gravity
     */
    public Board(String name, double gravity){
        this.name = name;
        this.gravity = gravity;
        buildWalls();
                
    }
    
    /**
     * initialize the walls of a board. As a default, boards are of size 20L by 20L
     */
    private void buildWalls(){
        List<Wall> walls = new ArrayList<Wall>();
        walls.add(new Wall(Boundary.TOP, Visibility.SOLID));
        walls.add(new Wall(Boundary.BOTTOM, Visibility.SOLID));
        walls.add(new Wall(Boundary.LEFT, Visibility.SOLID));
        walls.add(new Wall(Boundary.RIGHT, Visibility.SOLID));        
        objects.addAll(walls);
    }
    
    /**
     * Given a HashMap of STRINGS indicating the fire connections (trigger -> action) between objects,
     * create a similar HashMap of GADGETS indicating the same relationship.
     * Note: The resulting HashMap is called "gizmos".
     * @param gizmosStr
     */
    public void addGizmos(HashMap<String,List<String>> gizmosStr){
        HashMap<Gadget,List<Gadget>> gizmos = new HashMap<Gadget, List<Gadget>>();
        Gadget triggerGadget;

        for(String triggerGadgetStr: gizmosStr.keySet()){
            List<Gadget> curActionGadgets = new ArrayList<Gadget>();
            if(GadgetExists(triggerGadgetStr)){
                triggerGadget = nameToGadget(triggerGadgetStr);
                if(gizmos.containsKey(triggerGadget)) curActionGadgets = gizmos.get(triggerGadget);
            }else{
                System.err.println("Board file must be incorrect.  Fire directions matches objects that don't exits in the board.");
                triggerGadget = null;
            }
            
            for(String actionGadgetStr: gizmosStr.get(triggerGadgetStr)){
                if(GadgetExists(actionGadgetStr)){
                    Gadget actionGadget = nameToGadget(actionGadgetStr);
                    curActionGadgets.add(actionGadget);
                }else{
                    System.err.println("Board file must be incorrect.  Fire directions matches objects that don't exits in the board.");
                }
            }
            gizmos.put(triggerGadget, curActionGadgets);
        }
        //this.gizmos = gizmos;        
        setGizmosToGadgets(gizmos);
    }
    
    /**
     * This method sets the corresponding fire commands in gizmos to the correct gadgets
     * @param gizmos, the HashMap indicating the relationship between all the trigger objects and action objects
     */
    private void setGizmosToGadgets(HashMap<Gadget, List<Gadget>> gizmos) {
        for (Gadget gadget:objects){
            if (gizmos.containsKey(gadget)){
                gadget.setGizmos(gizmos.get(gadget));
            } else {
                gadget.setGizmos(new ArrayList<Gadget>());
            }
        }   
    }

    /**
     * A helper method for addGizmos.  
     * This method takes in a name of gadget and returns the actual Gadget it refers to.  
     * This should only be called if it is known that the Gadget exists in the board (i.e. is contained in objects).
     * 
     * @param name
     * @return the corresponding Gadget that name refers to
     */
    private Gadget nameToGadget(String name){
        for(Gadget gadget: objects){
            if(gadget.getName().equals(name)){
                return gadget;
            }
        }
        System.err.println("Board file must be incorrect.  Fire directions matches objects that don't exits in the board.");
        return null;
    }
    
    /**
     * A helper method for addGizmos.
     * This Method takes in a name of a gadget and returns whether or not the Gadget it refers to exists.
     * 
     * @param name
     * @return a boolean indicating if the corresponding Gadget exists in the board
     */
    private boolean GadgetExists(String name){
        for(Gadget gadget: objects){
            if(gadget.getName().equals(name)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * This method returns the name of the board
     * @return String indicating board name
     */
    public String name(){
        return name;
    }

    /**
     * mutator, add a given gadget to board
     */
    public void addGadget(Gadget gadget) {
        objects.add(gadget);
    }
    
    @Override
    public String toString() {
        //TODO: FIX ORIENTATION
        StringBuilder output = new StringBuilder();
        char[][] field = new char[xlength+2][ylength+2];
        for (int i = 0; i < xlength+2; i++) {
            for (int j = 0; j < ylength+2; j++) {
                if (i == 0 || i == 21 || j == 0 || j == 21 ) {
                    field[i][j] = '.';
                } else {
                    field[i][j] = ' ';
                }
            }
        }
        for (Ball b: balls) {
            if (b.getX() > 20 || b.getY() > 20){

                System.out.println(b.getCircle());
                System.out.println(b.getMove());

            }
            field[b.getX() + 1][b.getY() + 1] = '*';
        }
        
        for (Gadget gadget: objects){ //includes walls,absorbers,bumpers,flipper
            int xcoord;
            int ycoord;
            if (gadget.getType().equals("flipper")){
//                List<LineSegment> flipWalls = ((Flipper) gadget).getPosition();
                int orient = ((Flipper) gadget).getOrientation();
                Side side = ((Flipper) gadget).getSide();
                xcoord = ((Flipper) gadget).getX();
                ycoord = ((Flipper) gadget).getY()+1;
                switch (orient) {
                case 0:
                    field[xcoord + 1][ycoord] = '-';
                    if (side.equals(Side.RIGHT)) field[xcoord - 1 + 1][ycoord] = '-';
                    if (side.equals(Side.LEFT)) field[xcoord + 1 + 1][ycoord] = '-';
                    break;
                case 90:
                    field[xcoord + 1][ycoord] = '|';
                    if (side.equals(Side.RIGHT)) field[xcoord + 1][ycoord + 1] = '|';
                    if (side.equals(Side.LEFT)) field[xcoord + 1][ycoord - 1] = '|';
                    break;
                case 180:
                    field[xcoord + 1][ycoord] = '-';
                    field[xcoord - 1 + 1][ycoord] = '-';
                    if (side.equals(Side.RIGHT)) field[xcoord + 1 + 1][ycoord] = '-';
                    if (side.equals(Side.LEFT)) field[xcoord - 1 + 1][ycoord] = '-';
                    break;
                case 270:
                    field[xcoord + 1][ycoord] = '|';
                    if (side.equals(Side.RIGHT)) field[xcoord + 1][ycoord - 1] = '|';
                    if (side.equals(Side.LEFT)) field[xcoord + 1][ycoord + 1] = '|';
                    break;
                default:
                    System.err.println("invalid orientation");
                    break;
                }
            } else if (gadget.getType().equals("bumper")) {
                if (((Bumper) gadget).getShape().equals(Shape.SQUARE)) {
                    @SuppressWarnings("unchecked")
                    List<LineSegment> squareWalls = (List<LineSegment>) ((Bumper) gadget).getPosition();
                    xcoord = (int) squareWalls.get(0).p1().x();
                    ycoord = (int) squareWalls.get(0).p1().y()+1;
                    field[xcoord+1][ycoord] = '#';
                } else if (((Bumper) gadget).getShape().equals(Shape.CIRCLE)) {
                    Circle circ = (Circle) ((Bumper) gadget).getPosition();
                    xcoord = (int) circ.getCenter().x();
                    ycoord = (int) circ.getCenter().y()+1;
                    field[xcoord+1][ycoord] = '0';
                } else if (((Bumper) gadget).getShape().equals(Shape.TRIANGLE)) {
                    @SuppressWarnings("unchecked")
                    List<LineSegment> triWalls = (List<LineSegment>) ((Bumper) gadget).getPosition();
                    int orient = ((Bumper) gadget).getOrientation();
                    switch (orient) {
                    case 0:
                        xcoord = (int) triWalls.get(0).p1().x();
                        ycoord = (int) triWalls.get(0).p1().y()+1;
                        field[xcoord+1][ycoord] = '/';
                        break;
                    case 90:
                        xcoord = (int) triWalls.get(0).p1().x();
                        ycoord = (int) triWalls.get(0).p1().y()+1;
                        field[xcoord+1][ycoord] = '\\';
                        break;
                    case 180:
                        xcoord = (int) triWalls.get(0).p1().x();
                        ycoord = (int) triWalls.get(1).p1().y()+1;
                        field[xcoord+1][ycoord] = '/';
                        break;
                    case 270:
                        xcoord = (int) triWalls.get(0).p1().x();
                        ycoord = (int) triWalls.get(1).p1().y()+1;
                        field[xcoord+1][ycoord] = '\\';
                        break;
                    default:
                        System.err.println("invalid orientation");
                        break;
                    }
                }
            } else if (gadget.getType().equals("absorber")) {
                int xmin = ((Absorber) gadget).getX();
                int ymin = ((Absorber) gadget).getY();
                int width = ((Absorber) gadget).getWidth();
                int height = ((Absorber) gadget).getHeight();
//                for (int i=0; i < height; i++) {
//                field[xmin+1][ymin+1] = '=';
//                field[xmin + width][ymin+1] = '=';
//            }
                for (int j=0; j < width; j++) {
                    field[xmin + j + 1][ymin] = '=';
                    field[xmin + j + 1][ymin + height] = '=';
                }
            } else if (gadget.getType().equals("wall")){
                String otherBoard;
                if (((Wall) gadget).visible.equals(Visibility.INVISIBLE)) {
                    
                    otherBoard = ((Wall) gadget).connection.name;
                    otherBoard = otherBoard.substring(0, Math.min(20, otherBoard.length()));
                    
                    if (((Wall) gadget).boundary.equals(Boundary.BOTTOM)) {
                        for (int i=1;i<otherBoard.length();i++){
                            field[i][21] = otherBoard.charAt(i);                            
                        }

                    } else if (((Wall) gadget).boundary.equals(Boundary.TOP)) {
                        for (int i=1;i<otherBoard.length();i++){
                            field[i][0] = otherBoard.charAt(i);
                        }
                    } else if (((Wall) gadget).boundary.equals(Boundary.LEFT)) {
                        for (int j=1;j<otherBoard.length();j++){
                            field[0][j] = otherBoard.charAt(j);
                            //System.out.println(otherBoard.charAt(j)); 
                        }
                    } else if (((Wall) gadget).boundary.equals(Boundary.RIGHT)) {
                        for (int j=1;j<otherBoard.length();j++){
                            field[21][j] = otherBoard.charAt(j);
                        }
                    } 
                }
            }
        }
        
        for (int i = 0; i < xlength+2; i++) {
            for (int j = 0; j < ylength+2; j++) {
                output.append(field[j][i]);
            }
            output.append('\n');
        }
        return output.toString();
    }
    
    /**
     * observer, animate the board (ie print out repeatly
     * at specified framerate
     * @param out 
     */
    public void animate(PrintWriter out,  int framerate) {
        try {
            while (true) {
                long startTime = System.currentTimeMillis();
                out.println(this.toString().replaceAll("/n", "&"));
                out.flush();

                long endTime = System.currentTimeMillis();
                long duration = endTime - startTime;
                Thread.sleep(Math.abs(1000/framerate - duration));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }        
    }
    
    /**
     * mutator, add a ball to the board
     * @param ball
     */
    public void addBall(Ball ball) {
        balls.add(ball);
    }
    
    /**
     * Returns the list of Balls that it has
     * @return the list of Balls contained in the Board
     */
    public List<Ball> getBalls() {
        return this.balls;
    }
    
//    /**
//     * Sets a the list of Balls currently contained in the board with the list passed in
//     * @param balls a list of balls contained in the board
//     */
//    public void setBalls(List<Ball> balls) {
//        this.balls = balls;
//    }

    /**
     * updates the visibilities of the wall given a map 
     * @param map structure that maps a boundary to its visibility where Boundary and Visibility are both enums
     */
    public void setWallVisibilites(Map<Boundary, Visibility> map) {
        for (Gadget gadget: objects){
            if (!gadget.getType().equals("wall")) continue;
            Wall wall = (Wall) gadget; // for each wall
                        
            wall.setVisibility(map.get(wall.boundary));             
        }
        
    }
    /**
     * Method for passing a ball through an invisible wall. returns a circle that is on the opposite wall.
     * @param circle representation of the location of the original circle
     * @param boundary Boundary enum which is either Boundary.TOP,BOTTOM,LEFT,RIGHT
     * @return new circle on the opposite side of the wall
     */
    public Circle newBallLocation(Circle circle, Boundary boundary) {
        if (boundary.equals(Boundary.BOTTOM) || boundary.equals(Boundary.TOP)){
            return new Circle(circle.getCenter().x(),20.0-circle.getCenter().y(),circle.getRadius());
        } else {
            return new Circle(20.0-circle.getCenter().x(),circle.getCenter().y(),circle.getRadius());
        }
    }


}
