package pingball;

public interface Gadget {
    /*
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
    
    /**
     * Returns the name of the type of Gadget created
     * @return a String indicating the type
     */
    public String getType();
    
    /**
     * Returns the amount of time it would take the ball to collide with this gadget
     * @return the time
     */
    public double getTimeToCollision(Ball ball);
    
    /**
     * This method returns the type of action will occur in response to a ball collision
     * @return the action
     */
    public String getAction();
    
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
        
}
