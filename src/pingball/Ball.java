package pingball;

import physics.Circle;
import physics.Vect;

public class Ball {
    //same as in warmup
    
    private Vect move;
    private Circle circle;
    
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
    
    public int getX() {
        return (int) circle.getCenter().x();
    }

    public int getY() {
        return (int) circle.getCenter().y();
    }

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public Vect getMove() {
        return move;
    }

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
