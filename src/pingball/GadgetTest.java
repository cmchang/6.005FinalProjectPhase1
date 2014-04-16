package pingball;

import org.junit.Before;
import org.junit.Test;
/**
 * Testing strategy:
 * 
 * Test various aspects of the Flipper, Bumper and Absorber. 
 *      -test what happens when they are hit by a ball, e.g. if they react properly. 
 *      -test what happens when hit by two balls at the same time
 *      -test what happens if they are set up as triggers in certain board files
 *    For flipper:
 *      -make sure it is correctly rotating`
 *      -test what happens when flipper is in motion and hits ball
 *      -test left and right flippers
 *    For absorber:
 *      -test what happens when a ball hits absorber with/without a ball already inside
 *      -test what happens when absorber is self-triggering 
 *      -assure that absorber ejects/absorbs balls correctly
 *    For bumper:
 *      -test square, circle and triangle bumper shapes
 *      -test that ball bounces off at correct speed
 *      
 *      
 * Additionally, test general combinations of the objects and placements of them in testBoard
 * Test correct gravity and friction effects 
 * Test correct coordinate system
 * 
 * Test diameter of ball and its appearance and refresh rates
 * Test ball velocity ranges
 * 
 *
 */
public class GadgetTest {
    
    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void testFlipper(){
        //TODO
    }
    
  
    @Test
    public void testAbsorber(){
        //TODO
    }
    
    @Test
    public void testBumper(){
        //TODO
    }
    
    @Test
    public void testBall(){
        //TODO
    }    
    
    @Test
    public void testBoard(){
        //TODO
    }
}
