package pingball;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import physics.Angle;
import physics.Circle;
import physics.LineSegment;
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
        Flipper flipperL = new Flipper("flip1", 5, 5, 0, Side.LEFT);
        Flipper flipperR = new Flipper("flip2", 5, 5, 90, Side.RIGHT);
        Flipper flipperL2 = new Flipper("flip3", 5,5, 270, Side.LEFT);
        Flipper flipperAligned = new Flipper("flip4",5,1,0,Side.RIGHT);
            
        assertTrue(flipperL.getName().equals("flip1"));
        assertTrue(flipperR.getName().equals("flip2"));
        assertTrue(flipperL.getType().equals("flipper"));
        assertTrue(flipperR.getType().equals("flipper"));
        assertTrue(flipperL.getSide().toString().equals("LEFT"));
        assertTrue(flipperR.getSide().toString().equals("RIGHT"));
        assertTrue(flipperL.getPosition().size()==1);
        assertTrue(flipperR.getPosition().size()==1);
        assertTrue(Math.abs(flipperL.getPosition().get(0).p1().y() - flipperL.getPosition().get(0).p2().y()) == 2);
        assertTrue(flipperR.getPosition().get(0).p1().x() - flipperR.getPosition().get(0).p2().x() == 2);
        assertTrue(flipperL2.getPosition().get(0).p1().x() - flipperL2.getPosition().get(0).p2().x() == -2);
        assertTrue(flipperL2.getPosition().get(0).p1().equals(flipperR.getPosition().get(0).p2()));
        
        assertTrue(flipperL.getOrientation()==0);
        assertTrue(flipperR.getOrientation()==90);
        assertTrue(flipperL2.getOrientation()==270);
        
        
        assertTrue(flipperL.getTimeToCollision(ball1)==Double.POSITIVE_INFINITY);
        assertTrue(flipperAligned.getTimeToCollision(ball1)!=Double.POSITIVE_INFINITY);
        
        assertTrue(flipperAligned.getTimeToCollision(ball1)==1.1);


        Angle initialAngle = ball1.getMove().angle();
        flipperAligned.reflectBall(ball1); // when you hit a circle from the left, the ball goes down        
        assertTrue(ball1.getMove().angle().equals(initialAngle.minus(Angle.DEG_180)));
        flipperAligned.reflectBall(ball1);
        assertTrue(ball1.getMove().angle().equals(initialAngle));
//        assertTrue(circBumperAligned.getTimeToCollision(ball1)==Double.POSITIVE_INFINITY);
//        assertTrue(ball1.getMove().length()==5*circBumper.getCoefficient()); 
//
//        
        
        
        Flipper flipper = new Flipper("flip1", 5, 5, 0, Side.LEFT);
        flipper.reflectBall(ball1);    

        assertTrue((ball1.getMove().length()- 5*Math.pow(flipper.getCoefficient(), 3)) < .1 );
    }
    
  
    @Test
    public void testAbsorber(){
        Absorber abs = new Absorber("abs1", 5, 5, 5, 5);
        Absorber absAligned = new Absorber("abs2",5,1,5,5);
        
        assertTrue(abs.absorbedBalls.size()==0);
        assertTrue(abs.walls.size()==4);
        assertTrue(abs.getName().equals("abs1"));
        assertTrue(abs.getType().equals("absorber"));
        assertTrue(abs.getHeight()==abs.getWidth());
        assertTrue(abs.getHeight()==5);
        assertTrue(abs.getX()==5);
        assertTrue(abs.getY()==5);
        assertTrue(abs.getPosition().size()==4);
        assertTrue(abs.getCoefficient()==Double.NEGATIVE_INFINITY);
        assertTrue(abs.getTimeToCollision(ball1)==Double.POSITIVE_INFINITY);
        assertTrue(absAligned.getTimeToCollision(ball1)==.7);
        ball1.move(5*deltaT);
        assertTrue(absAligned.getTimeToCollision(ball1)==.675);
        
        
    }
    
    @Test
    public void testCircleBumper(){
        Bumper circBumper = new Bumper(Shape.CIRCLE, "circ1", 5, 5);
        Bumper circBumperAligned = new Bumper(Shape.CIRCLE,"circ2",5,1);
            
        assertTrue(circBumper.getName().equals("circ1"));
        assertTrue(circBumper.getType().equals("bumper"));               
        assertTrue(circBumper.getShape().toString().equals("CIRCLE"));
        assertTrue(((Circle) circBumper.getPosition()).getCenter().toString().equals("<5.0,5.0>"));
        assertTrue(circBumper.getOrientation()==0);
        assertTrue(circBumper.getTimeToCollision(ball1)==Double.POSITIVE_INFINITY);
        assertTrue(circBumperAligned.getTimeToCollision(ball1)==0.6);

        Angle initialAngle = ball1.getMove().angle();
        circBumperAligned.reflectBall(ball1); // when you hit a circle from the left, the ball goes down        

        assertTrue(ball1.getMove().angle().equals(initialAngle.minus(Angle.DEG_180)));
        assertTrue(circBumperAligned.getTimeToCollision(ball1)==Double.POSITIVE_INFINITY);
        assertTrue(ball1.getMove().length()==5*circBumper.getCoefficient()); 
   
    }
    
    @SuppressWarnings("unchecked")
    @Test 
    public void testTriangleBumper(){
        Bumper triBumper = new Bumper(Shape.TRIANGLE, "tri1", 5, 5, 0);
        Bumper triBumper2 = new Bumper(Shape.TRIANGLE,"tri2",5,1, 90);
            
        assertTrue(triBumper.getName().equals("tri1"));
        assertTrue(triBumper.getType().equals("bumper"));               
        assertTrue(triBumper.getShape().toString().equals("TRIANGLE"));
        assertTrue(((List<LineSegment>) triBumper.getPosition()).size()==3);
        assertTrue(triBumper.getOrientation()==0);
        assertTrue(triBumper2.getOrientation()==90);
        assertTrue(triBumper.getTimeToCollision(ball1)==Double.POSITIVE_INFINITY);
        assertTrue(triBumper2.getTimeToCollision(ball1)==0.9);

        Angle initialAngle = ball1.getMove().angle();
        triBumper.reflectBall(ball1);         
        
        assertTrue(ball1.getMove().angle().equals(initialAngle));
        ball1.move(5*deltaT);
        assertTrue(triBumper2.getTimeToCollision(ball1)==.875);
        assertTrue(ball1.getMove().length()==5*triBumper.getCoefficient()); 
    }
    
    @SuppressWarnings("unchecked")
    @Test
    public void testSquareBumper(){
        Bumper sqBumper = new Bumper(Shape.SQUARE, "sq1", 5, 5);
        Bumper sqBumper2 = new Bumper(Shape.SQUARE,"sq2",5,1);
            
        assertTrue(sqBumper.getName().equals("sq1"));
        assertTrue(sqBumper.getType().equals("bumper"));               
        assertTrue(sqBumper.getShape().toString().equals("SQUARE"));
        assertTrue(((List<LineSegment>) sqBumper.getPosition()).size()==4);
        assertTrue(sqBumper.getOrientation()==0);
        assertTrue(sqBumper2.getOrientation()==0);
        assertTrue(sqBumper.getTimeToCollision(ball1)==Double.POSITIVE_INFINITY);

        assertTrue(sqBumper2.getTimeToCollision(ball1)==0.7);

        Angle initialAngle = ball1.getMove().angle();
        sqBumper.reflectBall(ball1);         
        
        assertTrue(ball1.getMove().angle().equals(initialAngle));
        ball1.move(5*deltaT);
        assertTrue(sqBumper2.getTimeToCollision(ball1)==.675);
        assertTrue(ball1.getMove().length()==5*sqBumper.getCoefficient()); 
    }
    
    @Test
    public void testBall(){
        assertTrue(ball1.getType().equals("ball"));
        assertTrue(ball1.getX()==1);        
        assertTrue(ball1.getMove().toString().equals("<5.0,0.0>"));
        
        ball1.move(100*deltaT);
        
        assertTrue(ball1.getX()==3);
        
        ball1.move(100000*deltaT);
        
        assertTrue(ball1.getX()==2503);
        assertTrue(ball1.getY()==1);
        
        assertTrue(ball1.getCircle().getRadius()==0.5);        
        assertTrue(ball1.getMove().toString().equals("<5.0,0.0>"));
        
        ball1.setCircle(new Circle(5,5,5));
        ball1.setMove(new Vect(new Angle(Math.PI),10));
        
        assertTrue(ball1.getX()==5);
        assertTrue(ball1.getY()==5);
        assertTrue(ball1.getCircle().getRadius()==5);
        assertTrue(ball1.getMove().toString().substring(0,7).equals("<-10.0,"));
        
    }    
    
    @Test
    public void testBoard(){
        //TODO
    }
}