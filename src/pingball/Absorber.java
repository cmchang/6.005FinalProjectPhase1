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
    
    List<Ball> absorbedBalls = new ArrayList<Ball>(); // this should be a list of balls
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
        if (ballIsInside()){
            //System.out.println(absorbedBall.getMove());
            absorbedBalls.get(0).setMove(new Vect(Angle.DEG_90,50.0)); // start the ejection process
//            absorbedBalls.get(0).isTrapped = false;
//            absorbedBalls.remove(0);
        }
    }
    
    // not used
    public double getCoefficient() {
        return Double.NEGATIVE_INFINITY;
    }

    /**
     * Absorbs the ball. If theres a ball inside it, it calls action() which shoots it out.
     */
    public void reflectBall(Ball ball) {
        // doesn't reflectBall. ball is captured. only shoots a ball out if is a self trigger
        storeBall(ball);
    }
    
    /**
     * Absorbs the ball. If theres a ball inside it, it calls action() which shoots it out.
     */
    private void storeBall(Ball ball) {
        ball.isTrapped = true;
        ball.setMove(new Vect(Angle.DEG_270,0.0));
        ball.setCircle(new Circle( (double)(x+width)-.25/2.0,(double)(y+height)-.25/2.0, ball.getCircle().getRadius()));
        absorbedBalls.add(ball);
        
    }

    public void trigger(){
        for (Gadget gizmo:gizmos){
            gizmo.action();
        }
    }
    
    
    /**
     * checks to see if the ball is inside the absorber
     * @return
     */
    private boolean ballIsInside(){
        for (Ball ball:absorbedBalls){
            double xLoc = ball.getCircle().getCenter().x();
            double yLoc = ball.getCircle().getCenter().y();
            boolean inside = x<=xLoc && xLoc<=x+width && y<=yLoc && yLoc<=y+height;
            if (!inside) {
                ball.isTrapped = false;
                absorbedBalls.remove(ball);
            }
        }
        return absorbedBalls.size()>0;                        
        
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
