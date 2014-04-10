package pingball;

import java.util.ArrayList;
import java.util.List;

import physics.LineSegment;
import warmup.Ball;

public class Board {
    // similar as in warm-up
    // except walls --> gadgets
    // the BoardsHandler will keep track of all the wall line segments, no longer stored here
    
    private List<Ball> balls;
    private String name;
    List<LineSegment> objects = new ArrayList<LineSegment>();

    public Board() {}
    
    /**
     * Check the boundary condition of the wall
     * @return boolean of whether to reflect or pass ball
     */
    private boolean checkBoundry() {
        return false;
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
    public void animate(int framerate) {}
    
    /**
     * mutator, add a ball to the board
     * @param ball
     */
    public void addBall(Ball ball) {
        balls.add(ball);
    }
}
