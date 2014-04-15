package warmup;

import physics.Angle;
import physics.Circle;
import physics.Vect;

public class Ball {
    
    private Vect move;
    private Circle circle;
    
    public Ball(double xIn, double yIn, Angle directionIn, double speedIn) {
        this.setCircle(new Circle(xIn, yIn, .01));
        this.setMove(new Vect(directionIn, speedIn));
    }
    
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

    public void move(double minTime) {
        double x = circle.getCenter().x() + minTime * move.dot(move.X_HAT) * move.length() * .001;
        double y = circle.getCenter().y() + minTime * move.dot(move.Y_HAT) * move.length() * .001;
        this.setCircle(new Circle(x, y, .01));
    }

}