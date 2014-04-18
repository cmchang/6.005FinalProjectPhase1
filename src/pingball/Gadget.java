package pingball;

import java.util.List;
/**
 * Interface
 * Defined by type, position, action, coefficient
 * 
 * Methods:
 * timeToCollision, reflect, getPosition, getType, action
 * 
 * note: getPosition returns a different type of object depending on the type
 *      circles --> Vect, LineSegments --> Vect(p1), Vect(p2)
 * 
 */
public interface Gadget {

    
    /**
     * Get the unique name/ID of the gadget.
     * @return the name
     */
    public String getName();
    
    /**
     * Returns the name of the type of Gadget created
     * @return a String indicating the type
     * 
     * The returned String will can be:
     *      "flipper", "bumper", "absorber", "wall"
     * 
     */
    public String getType();
    
    /**
     * Returns the amount of time it would take the ball to collide with this gadget
     * @return the time
     */
    public double getTimeToCollision(Ball ball);
    
    /**
     * This method returns the type of action will occur in response to a ball collision.
     * This method will execute the necessary action. 
     */
    public void action();
    
    /**
     * This method returns the coefficient of reflection of the corresponding gadget
     * @return
     */
    public double getCoefficient();
    
    /**
     * Given a ball, this method will induce the ball to change direction due to a
     * collision with this Gadget.
     * @param ball the ball that is reflecting off this gadget
     */
    public void reflectBall(Ball ball);
        
    /**
     * Trigger this gadget.  Called when a ball collides with this gadget.
     */
    
    public void trigger();
    

    public void setGizmos(List<Gadget> list);
    
}
