package pingball;


import java.util.ArrayList;
import java.util.List;

import physics.Circle;
import physics.Geometry;
import physics.LineSegment;
import physics.Vect;
import pingball.Ball;
import pingball.Gadget;

/**
 * 
 * Rep Invar:
 * -only triangles can have non-infinity orientation. they have to be defined with an orientation
 * -circles have to have empty list of walls
 * -triangles and squares have to have null circle object
 * -orientation can only be 0,90,180 or 270
 * -walls have to connect (triangle and square)
 *
 */
public class Bumper implements Gadget {

    private final String name;    
    private final Shape shape;
    List<Gadget> gizmos = new ArrayList<Gadget>();
    
    private List<LineSegment> walls = new ArrayList<LineSegment>();
    private LineSegment wallReflecting = null;
    private Circle circle = null;
    private int orientation;
    
    public Bumper(Shape shape, String name, int x, int y){
        this.name=name;
        this.shape=shape;
        if (shape.equals(Shape.CIRCLE)){
            circle = new Circle(x, y, .5);
        } else if (shape.equals(Shape.SQUARE)){
            walls.add(new LineSegment(x,y,x+1,y)); //top
            walls.add(new LineSegment(x,y+1,x+1,y+1)); //bottom
            walls.add(new LineSegment(x,y,x,y+1)); //left
            walls.add(new LineSegment(x+1,y,x+1,y+1)); //right
        } else if(shape.equals(Shape.TRIANGLE)){
            System.err.println("error: triangle must have an orientation with it");
        }
    }
    
    public Bumper(Shape shape, String name, int x, int y, int orientation){
        this.name=name;
        this.shape=shape;
        this.orientation=orientation;
        if (shape.equals(Shape.CIRCLE)){
            circle = new Circle(x, y, .5);
            System.err.println("error: circle doesnt need an orientation with it");
        } else if (shape.equals(Shape.SQUARE)){
            walls.add(new LineSegment(x,y,x+1,y)); //top
            walls.add(new LineSegment(x,y+1,x+1,y+1)); //bottom
            walls.add(new LineSegment(x,y,x,y+1)); //left
            walls.add(new LineSegment(x+1,y,x+1,y+1)); //right
            System.err.println("error: square doesnt need an orientation with it");
        } else if(shape.equals(Shape.TRIANGLE)){
            switch (orientation) {
            case 0:
                walls.add(new LineSegment(x,y,x+1,y)); // top
                walls.add(new LineSegment(x,y,x,y+1)); // left
                walls.add(new LineSegment(x,y+1,x+1,y)); // hyp
                break;
            case 90:
                walls.add(new LineSegment(x,y,x+1,y)); // top
                walls.add(new LineSegment(x+1,y,x+1,y+1)); // right
                walls.add(new LineSegment(x,y,x+1,y+1)); // hyp
                break;
            case 180:
                walls.add(new LineSegment(x,y+1,x+1,y+1)); // bottom
                walls.add(new LineSegment(x+1,y,x+1,y+1)); // right
                walls.add(new LineSegment(x,y+1,x+1,y)); // hyp
                break;
            case 270:
                walls.add(new LineSegment(x,y+1,x+1,y+1)); // bottom
                walls.add(new LineSegment(x,y,x,y+1)); // left
                walls.add(new LineSegment(x,y,x+1,y+1)); // hyp
                break;
            default:
                System.err.println("invalid orientation");
                break;
            }
        }
    }

    public Bumper(Shape shape, String name, int x, int y, List<Gadget> gizmos){
        this.name=name;
        this.shape=shape;
        this.gizmos = gizmos;
        if (shape.equals(Shape.CIRCLE)){
            circle = new Circle(x, y, .5);
        } else if (shape.equals(Shape.SQUARE)){
            walls.add(new LineSegment(x,y,x+1,y)); //top
            walls.add(new LineSegment(x,y+1,x+1,y+1)); //bottom
            walls.add(new LineSegment(x,y,x,y+1)); //left
            walls.add(new LineSegment(x+1,y,x+1,y+1)); //right
        } else if(shape.equals(Shape.TRIANGLE)){
            System.err.println("error: triangle must have an orientation with it");
        }
    }

    public Bumper(Shape shape, String name, int x, int y, int orientation, List<Gadget> gizmos){
        this.name=name;
        this.shape=shape;
        this.gizmos = gizmos;
        if (shape.equals(Shape.CIRCLE)){
            circle = new Circle(x, y, .5);
            System.err.println("error: circle doesnt need an orientation with it");
        } else if (shape.equals(Shape.SQUARE)){
            walls.add(new LineSegment(x,y,x+1,y)); //top
            walls.add(new LineSegment(x,y+1,x+1,y+1)); //bottom
            walls.add(new LineSegment(x,y,x,y+1)); //left
            walls.add(new LineSegment(x+1,y,x+1,y+1)); //right
            System.err.println("error: square doesnt need an orientation with it");
        } else if(shape.equals(Shape.TRIANGLE)){
            switch (orientation) {
            case 0:
                walls.add(new LineSegment(x,y,x+1,y)); // top
                walls.add(new LineSegment(x,y,x,y+1)); // left
                walls.add(new LineSegment(x,y+1,x+1,y)); // hyp
                break;
            case 90:
                walls.add(new LineSegment(x,y,x+1,y)); // top
                walls.add(new LineSegment(x+1,y,x+1,y+1)); // right
                walls.add(new LineSegment(x,y,x+1,y+1)); // hyp
                break;
            case 180:
                walls.add(new LineSegment(x,y+1,x+1,y+1)); // bottom
                walls.add(new LineSegment(x+1,y,x+1,y+1)); // right
                walls.add(new LineSegment(x,y+1,x+1,y)); // hyp
                break;
            case 270:
                walls.add(new LineSegment(x,y+1,x+1,y+1)); // bottom
                walls.add(new LineSegment(x,y,x,y+1)); // left
                walls.add(new LineSegment(x,y,x+1,y+1)); // hyp
                break;
            default:
                System.err.println("invalid orientation");
                break;
            }
        }
        
    }       
    
    public enum Shape{TRIANGLE, SQUARE, CIRCLE};
    
    
    public String getName() {
        return name;
    }
    
    public Shape getShape() {
        return shape;
    }

    
    public String getType() {
        return "bumper";
    }

    
    public double getTimeToCollision(Ball ball) {
        if (circle == null){
            double time = 10000.0;
            for (int j = 0; j < walls.size(); j++) {                                              
                double timeLine = Geometry.timeUntilWallCollision(walls.get(j), ball.getCircle(), ball.getMove());
                if (timeLine < time) {
                    time = timeLine;
                    wallReflecting = walls.get(j);
                }
            }
            if (time == 10000.0) System.err.println("error in getting time for ball to hit bumper");
            return time;
        } else {            
            return Geometry.timeUntilCircleCollision(circle, ball.getCircle(), ball.getMove());
        }
    }

    
    public void action() {    
        //has no action
    }

    
    public double getCoefficient() {
        return 1.0;
    }

    
    public void reflectBall(Ball ball) {
        if (circle == null){
            if (wallReflecting == null) System.err.println("error in getting the wall thats reflecting");
            Vect newVect = Geometry.reflectWall(wallReflecting, ball.getMove(), getCoefficient());
            ball.setMove(newVect);
        } else {
            Vect newVect = Geometry.reflectCircle(circle.getCenter(), ball.getCircle().getCenter(), ball.getMove(), getCoefficient());
            ball.setMove(newVect);
        }
        
    }

    
    public void trigger() {
        for (Gadget gizmo:gizmos){
            gizmo.action();
        }  
    }

    
    public void trigger(Ball ball) {    
        System.err.println("Bumper doesn't need a ball passed in for the trigger. This method shouldnt be called");
    }

    /** 
     * Returns the means for the location of  the bumper
     * list of line segments for square and triangle
     * circle object for circular bumper
     */
    public Object getPosition(){
        if (circle==null) return walls;
        else return circle;
    }

    public int getOrientation() {
        return orientation;
    }
    
}
