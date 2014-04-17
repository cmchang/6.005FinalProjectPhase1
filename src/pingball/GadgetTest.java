package pingball;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import physics.Angle;
import physics.Circle;
import physics.Vect;
import pingball.Bumper.Shape;
import pingball.Flipper.Side;

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
    Ball ball1;
    double deltaT;
    
    @Before
    public void setUp() throws Exception {
        ball1 = new Ball(new Circle(1,1,.5), new Vect(new Angle(0), 5));
        deltaT = (double) (1.0 / 1000.0);
    }
    
    @Test
    public void testFlipper(){
        
        Flipper flipper = new Flipper("flip1", 5, 5, 0, Side.LEFT, 0);
        flipper.reflectBall(ball1);        
        assertTrue(ball1.getMove().length()==5*flipper.getCoefficient());
    }
    
  
    @Test
    public void testAbsorber(){
        //TODO
    }
    
    @Test
    public void testBumper(){
        Bumper triBumper = new Bumper(Shape.CIRCLE, "tri1", 5, 5);
        triBumper.reflectBall(ball1);        
        assertTrue(ball1.getMove().length()==5*triBumper.getCoefficient());
        
    }
    
    @Test
    public void testBall(){
        assertTrue(ball1.getType().equals("ball"));
        assertTrue(ball1.getX()==1);
        ball1.move(100*deltaT);
        assertTrue(ball1.getX()==3);
        ball1.move(100000*deltaT);
        assertTrue(ball1.getX()==2503);
        assertTrue(ball1.getY()==1);
        
        System.out.println(ball1.getCircle().getRadius());
        assertTrue(ball1.getCircle().getRadius()==0.5);

    }    
    
    @Test
    public void testBoard(){
        //TODO
    }
}
