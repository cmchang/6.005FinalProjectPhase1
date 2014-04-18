package pingball;

import java.util.ArrayList;
import java.util.List;

import physics.Angle;
import physics.Circle;
import physics.Geometry;
import physics.LineSegment;
import physics.Vect;

/**
 * Represents the absorber object within the board.
 *  
 * Rep Invar:
 * -absorbed ball is null when there is nothing in there.
 */
public class Absorber implements Gadget {
    
    private final String name;
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    
    private boolean hasBall = false;
    Ball absorbedBall;
    List<LineSegment> walls = new ArrayList<LineSegment>();
    
    /**list of objects that react when this is triggered */
    List<Gadget> gizmos = new ArrayList<Gadget>();
    
    /**
     * width and height must be positive integers <= 20
     * @param name
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public Absorber(String name, int x, int y, int width, int height) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        walls.add(new LineSegment(x,y,  x+width,y)); // wall 1 - top
        walls.add(new LineSegment(x,y+height, x+width,y+height)); //wall 2 - bottom
        walls.add(new LineSegment(x,y, x,y+height)); // wall 3 - left
        walls.add(new LineSegment(x+width,y, x+width,y+height)); //wall 4 - right
        
    }    
    
    public String getName() {
        return name;
    }
    
    public String getType() {
        return "absorber";
    }
    
    public double getTimeToCollision(Ball ball) {        
        double time = Double.POSITIVE_INFINITY;
        for (int j = 0; j < walls.size(); j++) {                                              
            double timeLine = Geometry.timeUntilWallCollision(walls.get(j), ball.getCircle(), ball.getMove());
            if (timeLine < time) {
                time = timeLine;
            }
        }        
        return time;
    }

    public void action() {
        //System.out.println("hi");
        if (hasBall){
            //System.out.println(absorbedBall.getMove());
            if (absorbedBall.getCircle().equals(new Circle( (double)(x+width)-.25/2.0,(double)(y+height)-.25/2.0, .25))){ //we have a non-moving ball inside                
                absorbedBall.setMove(new Vect(Angle.DEG_90,50.0)); // start the ejection process
                absorbedBall.isTrapped = false;
            } else {
                //absorber has a moving ball inside it -> no action                             
            }        
        } else {
            //absorber is not holding a ball   -> no action       
        }
    }
    
    // not applicable
    public double getCoefficient() {
        return Double.NEGATIVE_INFINITY;
    }

    /**
     * Absorbs the ball. If theres a ball inside it, it calls action() which shoots it out.
     */
    public void reflectBall(Ball ball) {
        // doesn't reflectBall. ball is captured
        if (hasBall) {            
            //TODO reflect the ball that just came in
            
            if (!ballIsInside()) {
                hasBall = false;; //check if ball is inside the absorber (could've already been moving)                
            } else {
                action(); //fire the ball out
                return;
            }
        }
        absorbedBall = ball;
        hasBall = true;
        ball.isTrapped = true;
        ball.setMove(new Vect(Angle.DEG_270,0.0));        
        ball.setCircle(new Circle( (double)(x+width)-.25/2.0,(double)(y+height)-.25/2.0, ball.getCircle().getRadius()));
    }
    
    
    public void trigger(){
        System.err.println("Must pass in a ball to trigger for Absorber");
    }
    
    
    public void trigger(Ball ball){
        reflectBall(ball);
        for (Gadget gizmo:gizmos){
            gizmo.action();
        }
    }
    
    
    /**
     * checks to see if the ball is inside the absorber
     * @return
     */
    private boolean ballIsInside(){
        if (!hasBall) return false;
        double xLoc = absorbedBall.getCircle().getCenter().x();
        double yLoc = absorbedBall.getCircle().getCenter().y();

        return x<=xLoc && xLoc<=x+width && y<=yLoc && yLoc<=y+height;                        
        
    }
    
    /** returns the walls, which are line segments, of the absorber*/
    public List<LineSegment> getPosition(){
        return walls;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }

    public void setGizmos(List<Gadget> list) {
        gizmos = list;        
    }

}
