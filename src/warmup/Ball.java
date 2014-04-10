package warmup;
import physics.Angle;
import physics.Circle;
import physics.Vect;
import physics.LineSegment;
import physics.Geometry;

public class Ball {
    private Circle ball;
    private Vect velocity;
    
    public Ball(double posX, double posY, Angle direction, double speed){
        ball = new Circle(posX, posY, .1);
        velocity = new Vect(direction, speed);
    }
    
    public void timeStep(){
        double posX = ball.getCenter().x() + velocity.x()*velocity.length();
        double posY = ball.getCenter().y() + velocity.y()*velocity.length();
        ball = new Circle(posX, posY, 0.1);
    }
    //wallSide: 0 = top, 1 = right, 2 = bottom, 3 = left
    public void collision(LineSegment obstruction){
        velocity = Geometry.reflectWall(obstruction, velocity);
    }
    
    public double getPreciseLocX(){
        return ball.getCenter().x();
    }
    
    public double getPreciseLocY(){
        return ball.getCenter().y();
    }
    
    public int getRoundedLocX(){
        return (int)ball.getCenter().x();
    }
    
    public int getRoundedLocY(){
        return (int)ball.getCenter().y();
    }    
    
    public String getBallInfo(){
        
        return "Ball position: " + ball.getCenter().x()+", " + ball.getCenter().y() +
               "\nBall velocity: " + velocity.angle() + ", " + velocity.length();
    }
}
