package pingball;

import physics.Circle;
import physics.Vect;

public class Ball {
    //same as in warmup
    
    private Vect move;
    private Circle circle; // 
    
    //methods:
    
    /**
     * Constructor
     * @param circleIn circle defining ball location
     * @param vectIn vector defining ball movement
     */
    public Ball(Circle circleIn, Vect vectIn) {
        this.circle = circleIn;
        this.move = vectIn;
    }
    
    /** 
     * Gets the X location of the ball
     * @return returns the X coordinate of the center of the ball 
     */
    public int getX() {
        return (int) circle.getCenter().x();
    }
    
    /** 
     * Gets the Y location of the ball
     * @return returns the Y coordinate of the center of the ball 
     */
    public int getY() {
        return (int) circle.getCenter().y();
    }
    
    /** 
     * Gets the circle defining ball location
     * @return the circle that represents the ball location
     */
    public Circle getCircle() {
        return circle; // should this be a copy?
    }
    /**
     * Sets the circle defining the ball location with the parameter passed in
     * @param circle A Circle object that defines ball location
     */
    public void setCircle(Circle circle) {
        this.circle = circle;
    }
    
    /**
     * Gets the vector defining ball velocity
     * @return the vector that represents ball velocity
     */
    public Vect getMove() {
        return move;
    }
    
    /**
     * Sets the vector defining theball movement with the parameter passed in
     * @param move A Vector that defines ball movement
     */
    public void setMove(Vect move) {
        this.move = move;
    }

    /**
     * move the ball a specified step size forward in direction move
     * @param stepSize
     */
    public void move(double stepSize) {
        double x = circle.getCenter().x() + stepSize * move.dot(move.X_HAT) * move.length() * .001;
        double y = circle.getCenter().y() + stepSize * move.dot(move.Y_HAT) * move.length() * .001;
        this.setCircle(new Circle(x, y, .1));
    }
}
