package pingball;

import java.util.ArrayList;
import java.util.List;

import physics.Angle;
import physics.Geometry;
import physics.LineSegment;
import physics.Vect;

/**
 * represents the Flipper object within the board. Flipper is of length 2L
 * 
 * Rep invar: 
 * -when its not rotating, state must be 0, 90, or -90
 * -finalWall should be null when its not rotating
 * -orientation should be 0,90,180 or 270
 * -side has to be Side.LEFT or Side.RIGHT
 * -x and y have to be such that the flipper doesnt go off the board
 * 
 * 
 *
 */
public class Flipper implements Gadget {
    private final String name;
    private final int x;
    private final int y;
    private double angularVelocity;
    
    
    /** orientation can be 0,90,180 or 270 -- rotates the initial everything*/
    private int orientation;
    
    /** must be either right or left */
    private final Side side;
    
    /** state is between 0 and 90 for left bumper. 
     * state is between -90 and 0 for right bumper.
     */
    private double state;
    
    /** defined by x1,y1 -> x2,y2 where p1 is the pivot point*/
    LineSegment wall;
    
    /**list of objects that react when this is triggered */
    List<Gadget> gizmos = new ArrayList<Gadget>();
    
    /** finalWall should be null when we are not rotating. This LineSegment is to ensure we are exactly at 90 degrees*/
    private LineSegment finalWall = null;
    
    
    /**
     * width and height must be positive integers <= 20
     * @param name
     * @param x
     * @param y
     * @param orientation
     * @param leftOrRight
     */
    public Flipper(String name,int x,int y,int orientation, Side leftOrRight){
        this.name  = name;
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.side = leftOrRight;
        this.state = 0;
           
        this.angularVelocity = 0;
        
        switch (orientation) {
        case 0:
            if (side.equals(Side.LEFT)) wall = new LineSegment(x,y, x,y+2);
            if (side.equals(Side.RIGHT)) wall = new LineSegment(x+2,y, x+2,y+2);
            break;
        case 90:
            if (side.equals(Side.LEFT)) wall = new LineSegment(x+2,y, x,y);
            if (side.equals(Side.RIGHT)) wall = new LineSegment(x+2,y+2, x,y+2);
            break;
        case 180:
            if (side.equals(Side.LEFT)) wall = new LineSegment(x+2,y+2, x+2,y);
            if (side.equals(Side.RIGHT)) wall = new LineSegment(x,y+2, x,y);
            break;
        case 270:
            if (side.equals(Side.LEFT)) wall = new LineSegment(x,y+2, x+2,y+2);
            if (side.equals(Side.RIGHT)) wall = new LineSegment(x,y, x+2,y);
            break;
        default:
            System.err.println("Invalid orientation");
            break;
        } 
    }
    
    public enum Side { LEFT, RIGHT};
    
    
    public String getName() {
        return name;
    }

    
    public String getType() {
        return "flipper";
    }

    
    public double getTimeToCollision(Ball ball) {
        double time = Double.POSITIVE_INFINITY;
        double timeLine = Double.POSITIVE_INFINITY;
        
        // not sure if this rotation code is doing what i want. I think its right though.
        if (side.equals(Side.LEFT)){
            timeLine = Geometry.timeUntilRotatingWallCollision(wall, 
                    new Vect(x,y).rotateBy(new Angle((orientation)/180.0*Math.PI)), 
                    angularVelocity, ball.getCircle(), ball.getMove());
        } else if (side.equals(Side.RIGHT)) { 
            timeLine = Geometry.timeUntilRotatingWallCollision(wall, 
                    new Vect(x+2,y).rotateBy(new Angle((orientation)/180.0*Math.PI)), 
                    angularVelocity, ball.getCircle(), ball.getMove());
        }
        if (timeLine < time) {
            time = timeLine;
        }        
        //if (time == Double.POSITIVE_INFINITY) System.err.println("error in getting time for ball to hit flipper");
        return time;
    }

    
    public void action() { 
        //won't work action until its done rotating
        if (state == 90|state == -90|state == 0) {
            if (side.equals(Side.LEFT) && state < 45){ // in the 0 degrees position
                finalWall = Geometry.rotateAround(wall, new Vect(x,y).rotateBy(new Angle((orientation)/180.0*Math.PI))
                        , new Angle(90.0 /180.0*Math.PI));
                angularVelocity = 1080.0/180.0*Math.PI;            
            
            } else if (side.equals(Side.LEFT) && state > 45){ // in the 90 degrees position
                finalWall = Geometry.rotateAround(wall, new Vect(x,y).rotateBy(new Angle((orientation)/180.0*Math.PI))
                        , new Angle(-90.0 /180.0*Math.PI));
                angularVelocity = 1080.0/180.0*Math.PI;
            
            } else if (side.equals(Side.RIGHT) && state > -45){ // in the 0 degrees position
                finalWall = Geometry.rotateAround(wall, new Vect(x+2,y).rotateBy(new Angle((orientation)/180.0*Math.PI))
                        , new Angle(-90.0 /180.0*Math.PI));
                angularVelocity = 1080.0/180.0*Math.PI;
                
            } else if (side.equals(Side.RIGHT) && state < -45){ // in the -90 degrees position
                finalWall = Geometry.rotateAround(wall, new Vect(x+2,y).rotateBy(new Angle((orientation)/180.0*Math.PI))
                        , new Angle(90.0 /180.0*Math.PI));
                angularVelocity = 1080.0/180.0*Math.PI;
                
            }
        }
        
        
    }

    
    public double getCoefficient() {
        return 0.95;
    }

    
    public void reflectBall(Ball ball) {
        if (side.equals(Side.LEFT)){
            Vect newVect = Geometry.reflectRotatingWall(wall, new Vect(x,y).rotateBy(new Angle((orientation)/180.0*Math.PI)), 
                    angularVelocity, ball.getCircle(), ball.getMove(), getCoefficient());
            ball.setMove(newVect);
        } else if (side.equals(Side.RIGHT)){
            Vect newVect = Geometry.reflectRotatingWall(wall, new Vect(x+2,y).rotateBy(new Angle((orientation)/180.0*Math.PI)), 
                    angularVelocity, ball.getCircle(), ball.getMove(), getCoefficient());            
            ball.setMove(newVect);
        }                    
    }

    
    public void trigger() {
        //action(); should only flip if it is self triggering
        for (Gadget gizmo:gizmos){
            gizmo.action();
        }       
    }

    
    public void move(double stepSize) {
        // .001 is millisecond conversion

        Vect newP2 = Geometry.rotateAround(wall.p2(), wall.p1(), new Angle(angularVelocity*stepSize*.001));
        wall = new LineSegment(wall.p1().x(),wall.p1().y(), newP2.x(),newP2.y());        
        state += angularVelocity*stepSize*.001;
        
        updateVelocity();
    }
    
    /**
     * Assures that the flipper stops when it is supposed to and sets the state and wall to exactly what its supposed to be
     * 
     * Changes the velocity to 0 when it gets too far.
     */
    private void updateVelocity() {
        if (side.equals(Side.LEFT)){
            if (state>=90 && angularVelocity > 0){ // moving counterclockwise, away from start
                state = 90;
                angularVelocity = 0;   
                wall = new LineSegment(finalWall.p1(),finalWall.p2());
                finalWall = null;
            } else if (state <= 0 && angularVelocity < 0){ //moving clockwise, towards start
                state = 0;
                angularVelocity = 0;
                wall = new LineSegment(finalWall.p1(),finalWall.p2());
                finalWall = null;
            }
        } else if (side.equals(Side.RIGHT)){
            if (state<=-90 && angularVelocity < 0){ //moving clockwise, away from start
                angularVelocity = 0;
                state = -90;
                wall = new LineSegment(finalWall.p1(),finalWall.p2());
                finalWall = null;
            } else if (state >= 0 && angularVelocity > 0){ // moving counterclockwise, towards start
                angularVelocity = 0;
                state = 0;
                wall = new LineSegment(finalWall.p1(),finalWall.p2());
                finalWall = null;
            }
        }
        
    }
    
    /** returns the location of the flipper, which is a singular line segment. but it is in a list for ease of use with diff gadgets*/
    public List<LineSegment> getPosition(){
        List<LineSegment> position = new ArrayList<LineSegment>();
        position.add(wall);
        return position;
    }
    
    public int getOrientation() {
        return orientation;
    }
    
    public Side getSide() {
        return side;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }

    public void setGizmos(List<Gadget> list) {
        gizmos = list;        
    }
   
}