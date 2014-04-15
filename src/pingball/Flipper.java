package pingball;

import java.util.ArrayList;
import java.util.List;

import physics.Angle;
import physics.Geometry;
import physics.LineSegment;
import physics.Vect;

/**
 * represents the Flipper object within the board
 *
 */
public class Flipper implements Gadget {
    private final String name;
    private final int x;
    private final int y;
    private double angularVelocity;
    
    
    /** orientation can be anything -- rotates the initial everything*/
    private int orientation;
    
    /** must be either right or left */
    private final Status status;
    
    /** state is either 0 or 90*/
    private final int state;
    
    LineSegment wall;
    
    /**list of objects that react when this is triggered */
    List<Gadget> gizmos = new ArrayList<Gadget>();
    
    
    
    /**
     * width and height must be positive integers <= 20
     * @param name
     * @param x
     * @param y
     * @param orientation
     * @param leftOrRight
     * @param state
     */
    public Flipper(String name,int x,int y,int orientation, Status leftOrRight, int state){
        this.name = name;
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.status = leftOrRight;
        this.state = state;
           
        this.angularVelocity = 0;
        
        switch (orientation) {
        case 0:
            if (status.equals(Status.LEFT)) wall = new LineSegment(x,y, x,y+2);
            if (status.equals(Status.RIGHT)) wall = new LineSegment(x+2,y, x+2,y+2);
            break;
        case 90:
            if (status.equals(Status.LEFT)) wall = new LineSegment(x+2,y, x,y);
            if (status.equals(Status.RIGHT)) wall = new LineSegment(x+2,y+2, x,y+2);
            break;
        case 180:
            if (status.equals(Status.LEFT)) wall = new LineSegment(x+2,y+2, x+2,y);
            if (status.equals(Status.RIGHT)) wall = new LineSegment(x,y+2, x,y);
            break;
        case 270:
            if (status.equals(Status.LEFT)) wall = new LineSegment(x,y+2, x+2,y+2);
            if (status.equals(Status.RIGHT)) wall = new LineSegment(x,y, x+2,y);
            break;
        default:
            System.err.println("Invalid orientation");
            break;
        } 
    }
    
    public enum Status { LEFT, RIGHT};
    
    public String getName() {
        return name;
    }

    public String getType() {
        return "flipper";
    }

    public double getTimeToCollision(Ball ball) {
        double time = 10000.0;
        double timeLine = 10000.0;
        
        // not sure if this rotation code is doing what i want. I think its right though.
        if (status.equals(Status.LEFT)){
            timeLine = Geometry.timeUntilRotatingWallCollision(wall, 
                    new Vect(x,y).rotateBy(new Angle(((double) orientation)/180.0*Math.PI)), 
                    angularVelocity, ball.getCircle(), ball.getMove());
        } else if (status.equals(Status.RIGHT)) { 
            timeLine = Geometry.timeUntilRotatingWallCollision(wall, 
                    new Vect(x+2,y).rotateBy(new Angle(((double) orientation)/180.0*Math.PI)), 
                    angularVelocity, ball.getCircle(), ball.getMove());
        }
        if (timeLine < time) {
            time = timeLine;
        }        
        if (time == 10000.0) System.err.println("error in getting time for ball to hit flipper");
        return time;
    }

    public void action() {
        // TODO Auto-generated method stub
        
    }

    public double getCoefficient() {
        // TODO Auto-generated method stub
        return 0;
    }

    public void reflectBall(Ball ball) {
        // TODO Auto-generated method stub
        
    }

    public void trigger() {
        // TODO Auto-generated method stub
        
    }

    public void trigger(Ball ball) {
        // TODO Auto-generated method stub
        
    }

   
}
