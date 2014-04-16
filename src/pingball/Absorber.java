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
    
    private Ball absorbedBall = null;
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
    
    /**
     * width and height must be positive integers <= 20
     * @param name
     * @param x
     * @param y
     * @param width
     * @param height
     * @param gizmos other Gadgets whos actions are connected to this gadget's trigger
     */
    public Absorber(String name, int x, int y, int width, int height, List<Gadget> gizmos) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        walls.add(new LineSegment(x, x+width, y, y)); // wall 1 - top
        walls.add(new LineSegment(x, x+width, y+height, y+height)); //wall 2 - bottom
        walls.add(new LineSegment(x, x, y, y+height)); // wall 3 - left
        walls.add(new LineSegment(x+width, x+width, y, y+height)); //wall 4 - right
        this.gizmos = gizmos;
        
    }
    
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public String getType() {
        return "absorber";
    }

    @Override
    public double getTimeToCollision(Ball ball) {        
        double time = 10000.0;
        for (int j = 0; j < walls.size(); j++) {                                              
            double timeLine = Geometry.timeUntilWallCollision(walls.get(j), ball.getCircle(), ball.getMove());
            if (timeLine < time) {
                time = timeLine;
            }
        }
        if (time == 10000.0) System.err.println("error in getting time for ball to hit absorber");
        return time;
    }

    @Override
    public void action() {
        Vect zeroVect = new Vect(new Angle(0)).times(0);

        if (absorbedBall != null){            
            if (absorbedBall.getMove().equals(zeroVect)){ //we have a non-moving ball inside
                absorbedBall.setMove(new Vect(new Angle(Math.PI/2.0)).times(50)); // start the ejection process
            } else {
                //absorber has a moving ball inside it -> no action                             
            }        
        } else {
            //absorber is not holding a ball   -> no action       
        }
    }
    
    // not applicable
    @Override
    public double getCoefficient() {
        return Double.NEGATIVE_INFINITY;
    }

    /**
     * Absorbs the ball. If theres a ball inside it, it calls action() which shoots it out.
     */
    @Override
    public void reflectBall(Ball ball) {
        // doesn't reflectBall. ball is captured
        if (absorbedBall != null) {            
            if (!ballIsInside()) absorbedBall = null; //check if ball is inside the absorber (could've already been moving)
            action(); 
            return;
        }
        
        absorbedBall = ball;
        ball.setMove(new Vect(new Angle(0)).times(0));
        ball.setCircle(new Circle(x+width-.25,y+height-.25, 0.5));
        
    }
    
    @Override
    public void trigger(){
        System.err.println("Must pass in a ball to trigger for Absorber");
    }
    
    @Override
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
        if (absorbedBall == null) return false;
        double xLoc = absorbedBall.getCircle().getCenter().x();
        double yLoc = absorbedBall.getCircle().getCenter().y();
        
        return x<=xLoc && xLoc<=x+width && y<=yLoc && yLoc<=y+height;                        
        
    }
    
    /** returns the walls, which are line segments, of the absorber*/
    public List<LineSegment> getPosition(){
        return walls;
    }

}
