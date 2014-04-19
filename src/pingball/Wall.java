package pingball;

import java.util.List;

import physics.Geometry;
import physics.LineSegment;
import physics.Vect;
import pingball.BoardsHandler.Connection;

/**
 * Representation of a side of a wall in board space. Compatible with gadget
 *
 */
public class Wall implements Gadget {

    Boundary boundary;
    Visibility visible;
    Connection connection = null;
    
    LineSegment wall;
    private final int xlength = 20;
    private final int ylength = 20;
    
    /**
     * Initialize a side of a wall in board space.
     * 
     * @param boundary Boundary enum of the wall - either Boundary.LEFT,RIGHT,TOP,BOTTOM
     * @param visible Visibiltiy enum of the wall, either Visibility.INVISIBLE.SOLID
     */
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
    /**
     * Boundary of the wall -- either left,right,top or bottom 
     */
    public enum Boundary { LEFT,RIGHT,TOP,BOTTOM };
    
    /**
     * Enum to keep track of whether the wall is solid or invisible. 
     */
    public enum Visibility { SOLID,INVISIBLE }; 
    
    /**
     * Returns the visibility of the wall. 
     */
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
        //no action for wall
    }

    public double getCoefficient() {
        return 1.0;
    }

    public void reflectBall(Ball ball) {
        Vect newVect = Geometry.reflectWall(wall, ball.getMove());
        ball.setMove(newVect);
    }

    public void trigger() {
    }

    /**
     * sets the Connection object of the Wall
     * @param connection connection object to be set
     */
    public void setConnection(Connection connection){
        this.connection = connection;
    }
    
    /**
     * Removes the connection of the Wall
     */
    public void removeConnetion(){
        this.connection = null;
    }
    
    /**
     * sets the Visibility enum of the Wall - 
     * @param visibility either Visibility.INVISIBLE or Visibility.SOLID
     */
    public void setVisibility(Visibility visibility) {
        this.visible = visibility;        
    }

    
    public void setGizmos(List<Gadget> list) {        
    }

}
