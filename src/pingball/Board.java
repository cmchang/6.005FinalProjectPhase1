package pingball;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import physics.Circle;
import physics.LineSegment;
import pingball.Ball;
import pingball.Bumper.Shape;
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
    int xlength;
    int ylength;
    
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
            System.out.println(gadget);
            if (gadget.getType().equals("flipper")){
                List<LineSegment> position = ((Flipper) gadget).getPosition();
                //TODO: FINISH FLIPPER
            } else if (gadget.getType().equals("bumper")) {
                int xcoord;
                int ycoord;
                if (((Bumper) gadget).getShape().equals(Shape.SQUARE)) {
                    List<LineSegment> squareWalls = (List<LineSegment>) ((Bumper) gadget).getPosition();
                    xcoord = (int) squareWalls.get(0).p1().x();
                    ycoord = (int) squareWalls.get(0).p1().y();
                    field[xcoord][ycoord] = '#';
                } else if (((Bumper) gadget).getShape().equals(Shape.CIRCLE)) {
                    Circle circ = (Circle) ((Bumper) gadget).getPosition();
                    xcoord = (int) circ.getCenter().x();
                    ycoord = (int) circ.getCenter().y();
                    field[xcoord][ycoord] = '0';
                } else if (((Bumper) gadget).getShape().equals(Shape.TRIANGLE)) {
                    List<LineSegment> triWalls = (List<LineSegment>) ((Bumper) gadget).getPosition();
                    int orient = ((Bumper) gadget).getOrientation();
                    switch (orient) {
                    case 0:
                        xcoord = (int) triWalls.get(0).p1().x();
                        ycoord = (int) triWalls.get(0).p1().y();
                        field[xcoord][ycoord] = '/';
                        break;
                    case 90:
                        xcoord = (int) triWalls.get(0).p1().x();
                        ycoord = (int) triWalls.get(0).p1().y();
                        field[xcoord][ycoord] = '\\';
                        break;
                    case 180:
                        xcoord = (int) triWalls.get(0).p1().x();
                        ycoord = (int) triWalls.get(1).p1().y();
                        field[xcoord][ycoord] = '/';
                        break;
                    case 270:
                        xcoord = (int) triWalls.get(0).p1().x();
                        ycoord = (int) triWalls.get(1).p1().y();
                        field[xcoord][ycoord] = '\\';
                        break;
                    default:
                        System.err.println("invalid orientation");
                        break;
                    }
                }
            } else if (gadget.getType().equals("absorber")) {
                //TODO: FINISH ABSORBER
            }
        }
        
        for (int i = 0; i < xlength+2; i++) {
            for (int j = 0; j < ylength+2; j++) {
                output.append(field[i][j]);
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
}
