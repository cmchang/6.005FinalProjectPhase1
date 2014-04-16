package pingball;

import physics.Geometry;
import physics.LineSegment;
import physics.Vect;

public class Wall implements Gadget {

    Boundary boundary;
    Visibility visible;
    
    LineSegment wall;
    int xlength = 20;
    int ylength = 20;
    
    public Wall(Boundary boundary, Visibility visible){
        this.boundary = boundary;
        this.visible = visible;
        
        switch (boundary){
        case TOP:
            wall = new LineSegment(0, 0, xlength+2, 0);
            break;
        case BOTTOM:
            wall = new LineSegment(0, ylength+1, xlength+2, ylength+1);
            break;
        case LEFT:
            wall = new LineSegment(0, 0, 0, ylength+2);
            break;
        case RIGHT:
            wall = new LineSegment(xlength+1, 0, xlength+1, ylength+2);
            break;
        }
        
    }
    
    public enum Boundary { LEFT,RIGHT,TOP,BOTTOM };
    public enum Visibility { SOLID,INVISIBLE }; 
    
    public String getName() {
        return visible.toString();
    }

    public String getType() {
       return "wall";
    }

    public double getTimeToCollision(Ball ball) {                                                                                 
        return Geometry.timeUntilWallCollision(wall, ball.getCircle(), ball.getMove());
        
    }

    public void action() {
//        System.err.println("This shouldn't be called.(action for wall)");
    }

    public double getCoefficient() {
        return 1.0;
    }

    public void reflectBall(Ball ball) {
        Vect newVect = Geometry.reflectWall(wall, ball.getMove());
        ball.setMove(newVect);
    }

    public void trigger() {
//        System.err.println("This shouldn't be called.(trigger for wall)");
    }

    public void trigger(Ball ball) {
//        System.err.println("This shouldn't be called.(trigger ball for wall)");
    }

}
