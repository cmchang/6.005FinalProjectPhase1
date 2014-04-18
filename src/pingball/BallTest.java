package pingball;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import physics.Angle;
import physics.Circle;
import physics.Vect;

public class BallTest {
    
    private Ball testBall, namedBall;
    private Circle cir1, cir2;
    private Vect v1, v2;
    
    @Before
    public void setUp(){
        Angle start = new Angle(2.0);
        Angle start2 = new Angle(3.0);
        cir1 = new Circle(5.0, 3.0, .01);
        cir2 = new Circle(2.0, 2.0, .01);
        v1 = new Vect(start, 10.0);
        v2 = new Vect(start2, 8.0);
        testBall = new Ball(cir1, v1);
        namedBall = new Ball(cir2, v2, "hi");
    }
    
    @Test
    public void testBasic() {
        assertEquals(namedBall.name(), "hi");
        assertEquals(namedBall.hasName(), true);
        assertEquals(testBall.hasName(), false);
        assertEquals(namedBall.getType(), "ball");
        assertEquals(testBall.getX(), 5);
        assertEquals(testBall.getY(), 3);
    }
    
    @Test
    public void testCircle() {
        assertEquals(testBall.getCircle(), cir1);
        assertEquals(namedBall.getCircle(), cir2);
        testBall.setCircle(cir2);
        assertEquals(testBall.getCircle(), cir2);
    }
    
    @Test
    public void testMove() {
        assertEquals(testBall.getMove(), v1);
        assertEquals(namedBall.getMove(), v2);
        testBall.setMove(v2);
        assertEquals(testBall.getMove(), v2);
    }
    
    @Test
    public void testMovement() {
        assertEquals(testBall.getCircle(), cir1);
        assertEquals(testBall.getMove(), v1);
        testBall.move(0.0);
        assertEquals(testBall.getCircle(), cir1);
        assertEquals(testBall.getMove(), v1);
        testBall.move(1.0);
        assertEquals(testBall.getCircle().equals(cir1), false);
        assertEquals(testBall.getMove().equals(v1), true);
    }

}
