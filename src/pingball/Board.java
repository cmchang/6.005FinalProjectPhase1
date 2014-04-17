package pingball;

import java.io.PrintWriter;
import java.util.ArrayList;
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
    
    private List<Ball> balls = new ArrayList<Ball>();
    private String name;
    private final int xlength;
    private final int ylength;
    
    List<Gadget> objects = new ArrayList<Gadget>();
    
    final double friction1 = 0.025; // will need some init methods to set up constants based on board parsing. or make not final
    final double friction2 = 0.025;
    final double gravity = 25.0;
    
    /**
     * initialize the walls of a board. As a default, boards are of size 20L by 20L
     */
    public Board() {
        xlength = 20;
        ylength = 20;
        List<Wall> walls = new ArrayList<Wall>();
        walls.add(new Wall(Boundary.TOP, Visibility.SOLID));
        walls.add(new Wall(Boundary.BOTTOM, Visibility.SOLID));
        walls.add(new Wall(Boundary.LEFT, Visibility.SOLID));
        walls.add(new Wall(Boundary.RIGHT, Visibility.SOLID));        
        objects.addAll(walls);
    }
    
    /**
     * Check the boundary condition of the wall
     * @return boolean of whether to reflect or pass ball
     */
    private boolean checkBoundry(Wall wall) {
        return (wall.visible.equals(Visibility.INVISIBLE));
    }
    
    public String name(){
        return name;
    }
    /**
     * mutator, remove a given ball from the board
     */
    private void removeBall(Ball ball) {}
    
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
            field[b.getX() + 1][b.getY() + 1] = '*';
        }
        
        for (Gadget gadget: objects){ //includes walls,absorbers,bumpers,flipper
            int xcoord;
            int ycoord;
            if (gadget.getType().equals("flipper")){
                List<LineSegment> flipWalls = ((Flipper) gadget).getPosition();
                int orient = ((Flipper) gadget).getOrientation();
                Side side = ((Flipper) gadget).getSide();
                xcoord = ((Flipper) gadget).getX();
                ycoord = ((Flipper) gadget).getY();
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
                    List<LineSegment> squareWalls = (List<LineSegment>) ((Bumper) gadget).getPosition();
                    xcoord = (int) squareWalls.get(0).p1().x();
                    ycoord = (int) squareWalls.get(0).p1().y();
                    field[xcoord+1][ycoord] = '#';
                } else if (((Bumper) gadget).getShape().equals(Shape.CIRCLE)) {
                    Circle circ = (Circle) ((Bumper) gadget).getPosition();
                    xcoord = (int) circ.getCenter().x();
                    ycoord = (int) circ.getCenter().y();
                    field[xcoord+1][ycoord] = '0';
                } else if (((Bumper) gadget).getShape().equals(Shape.TRIANGLE)) {
                    List<LineSegment> triWalls = (List<LineSegment>) ((Bumper) gadget).getPosition();
                    int orient = ((Bumper) gadget).getOrientation();
                    switch (orient) {
                    case 0:
                        xcoord = (int) triWalls.get(0).p1().x();
                        ycoord = (int) triWalls.get(0).p1().y();
                        field[xcoord+1][ycoord] = '/';
                        break;
                    case 90:
                        xcoord = (int) triWalls.get(0).p1().x();
                        ycoord = (int) triWalls.get(0).p1().y();
                        field[xcoord+1][ycoord] = '\\';
                        break;
                    case 180:
                        xcoord = (int) triWalls.get(0).p1().x();
                        ycoord = (int) triWalls.get(1).p1().y();
                        field[xcoord+1][ycoord] = '/';
                        break;
                    case 270:
                        xcoord = (int) triWalls.get(0).p1().x();
                        ycoord = (int) triWalls.get(1).p1().y();
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
                for (int i=0; i < height; i++) {
                    for (int j=0; j < width; j++) {
                        field[xmin + j + 1][ymin + i] = '=';
                    }
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
     */
    public void animate(PrintWriter out, int framerate) {
        try {
            while (true) {
                long startTime = System.currentTimeMillis();
                out.println(this.toString());
                out.flush();
                long endTime = System.currentTimeMillis();
                long duration = endTime - startTime;
                Thread.sleep(1000/framerate - duration);
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
    
    /**
     * Sets a the list of Balls currently contained in the board with the list passed in
     * @param balls a list of balls contained in the board
     */
    public void setBalls(List<Ball> balls) {
        this.balls = balls;
    }

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

    public void addGizmos(HashMap<String, List<String>> createTriggerActions) {
        // TODO Auto-generated method stub
        
    }
}
