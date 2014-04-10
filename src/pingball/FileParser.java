package pingball;

import java.io.File;

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
    private Board CreateBoard(){
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
    private Ball createBall(String text){
        return new Ball(null, null);
    }
    
    /**
     * This method creates a new Bumper object given a line of text that supplies the information
     * for the Bumper
     * @param text from File
     * @return new Bumper object
     */
    private Bumper createBumper(String text){
        return new Bumper();
    }
    
    /**
     * This method creates a new Flipper object given a line of text that supplies the information
     * for the Flipper
     * @param text from File
     * @return new Flipper object
     */
    private Flipper createFlipper(String text){
        return new Flipper();
    }
    
    /**
     * This method creates a new Absorber object given a line of text that supplies the information
     * for the Absorber
     * @param text from File
     * @return new Absorber object
     */
    private Absorber createAbsorber(String text){
        return new Absorber();
    }
    
}
