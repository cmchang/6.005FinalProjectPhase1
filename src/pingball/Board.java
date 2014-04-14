package pingball;

import java.util.ArrayList;
import java.util.List;

import physics.LineSegment;
import pingball.Ball;

public class Board {
    // similar as in warm-up
    // except walls --> gadgets
    // the BoardsHandler will keep track of all the wall line segments, no longer stored here
    
    private List<Ball> balls = new ArrayList<Ball>();
    private String name;
    List<LineSegment> walls = new ArrayList<LineSegment>();
    List<Gadget> objects = new ArrayList<Gadget>();

    public Board() {
        int xlength = 20;
        int ylength = 20;
        walls.add(new LineSegment(0, 0, xlength+2, 0));
        walls.add(new LineSegment(0, ylength+1, xlength+2, ylength+1));
        walls.add(new LineSegment(0, 0, 0, ylength+2));
        walls.add(new LineSegment(xlength+1, 0, xlength+1, ylength+2));
    }
    
    /**
     * Check the boundary condition of the wall
     * @return boolean of whether to reflect or pass ball
     */
    private boolean checkBoundry() {
        return false;
    }
    
    /**
     * mutator, add a given ball to the board
     * @param ball
     */
    public void add(Ball ball) {
        balls.add(ball);
    }
    
    /**
     * mutator, remove a given ball from the baord
     */
    private void removeBall(Ball ball) {}
    
    /**
     * mutator, add a given gadget to board
     */
    private void addGadget(Gadget gadget) {}
    
    @Override
    public String toString() {
        return null;
    }
    
    /**
     * observer, animate the board (ie print out repeatly
     * at specified framerate
     */
    public void animate(int framerate) {
        try {
            while (true) {
                long startTime = System.currentTimeMillis();
                System.out.println(this.toString());
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
        getBalls().add(ball);
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public void setBalls(List<Ball> balls) {
        this.balls = balls;
    }
}
