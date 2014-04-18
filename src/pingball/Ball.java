package pingball;

import physics.Circle;
import physics.Vect;

public class Ball {
    //same as in warmup
    
    // move is the vector of the balls movement
    // circle is the shape representing the ball
    private Vect move;
    private Circle circle;
    private String name = "";
    
    public boolean isTrapped = false;
    
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
     * Constructor
     * @param circleIn circle defining ball location
     * @param vectIn vector defining ball movement
     * @param name Name of the ball--unique
     */
    public Ball(Circle circleIn, Vect vectIn, String name) {
        this.circle = circleIn;
        this.move = vectIn;
        this.name = name;
    }
    
    public String name(){
        return name;
    }
    
    public boolean hasName(){
        return !name.equals("");
    }
    
    public String getType(){
        return "ball";
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
//        System.out.println(stepSize * move.dot(Vect.Y_HAT) * move.length());
        double x = circle.getCenter().x() + stepSize * move.dot(Vect.X_HAT) * move.length();
        double y = circle.getCenter().y() + stepSize * move.dot(Vect.Y_HAT) * move.length();
        this.setCircle(new Circle(x, y, circle.getRadius()));
    }
}
