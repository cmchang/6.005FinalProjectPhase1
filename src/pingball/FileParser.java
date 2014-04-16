package pingball;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import physics.Angle;
import physics.Circle;
import physics.Vect;
import pingball.Bumper.Type;
import pingball.Flipper.Side;

public class FileParser {
    // Reads in a given file, creates corresponding board
    
    /**
     * The constructor method, given a file
     * @param file
     */
    public FileParser(File file){
        
    }
    
    /**
     * This method creates a new Board object, after calling helper methods to parse the file
     */
    public static Board CreateBoard(){
        return new Board();
    }
    
    /**
     * This method does the string manipulation to breakdown the text file
     */
    private void parseTextFile(){
        
    }
    
    /**
     * This method creates a new Ball object given a line of text that supplies the information
     * for the Ball (String:name, int:x, int:y, double:xVelocity, double:yVelocity)
     * @param text from File
     * @return new Ball object
     */
    public static Ball createBall(String name, double xLoc, double yLoc, double xVel, double yVel){
        double r = .5;
        Circle circleIn = new Circle(xLoc, yLoc,r);
        Vect vectIn = new Vect(xVel,yVel);
        return new Ball(circleIn, vectIn);
    }
    
    /**
     * This method creates a new Bumper object given a line of text that supplies the information
     * for the Bumper
     * @param text from File
     * @return new Bumper object
     */
    public static Bumper createBumper(Type type, String name, int xLoc, int yLoc, int orientation){
//        new Bumper(name,x,y,Type.SQUARE);
        
        //add switch case for each constructor
        return new Bumper(type, name, xLoc, yLoc, orientation);
    }
    
    /**
     * This method creates a new Flipper object given a line of text that supplies the information
     * for the Flipper
     * @param text from File
     * @return new Flipper object
     */
    public static Flipper createFlipper(String text){
        String name = null;
        int x= -9999;
        int y = -9999;
        int orientation = -9999;
        Side side = Side.LEFT;
        int state = 0;
        
        List<Gadget> connectedGadgets = new ArrayList<Gadget>();
        if (connectedGadgets.size()>0) {
            return new Flipper(name, x, y, orientation, side, state, connectedGadgets);
        } else {
            return new Flipper(name, x, y, orientation, side, state);
        }
    }
    
    /**
     * This method creates a new Absorber object given a line of text that supplies the information
     * for the Absorber
     * @param text from File
     * @return new Absorber object
     */
    public static Absorber createAbsorber(String text){
        String name = null;
        int x= -9999;
        int y = -9999;
        int height=-9999;
        int width=-9999;
        
        List<Gadget> connectedGadgets = new ArrayList<Gadget>();
        if (connectedGadgets.size()>0) {
            return new Absorber(name, x, y, height, width, connectedGadgets);
        } else {
            return new Absorber(name, x, y, height, width);
        }
    }
    
}
