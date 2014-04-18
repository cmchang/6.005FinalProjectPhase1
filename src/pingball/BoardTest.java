package pingball;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {
    
    private Board fullBoard, gravBoard;
    
    @Before
    public void setUp(){
        fullBoard = new Board("name1", 5.0, 0.01, 0.02);
        gravBoard = new Board("name2", 10.0);
    }
    
    @Test
    public void testBasics() {
        assertEquals(fullBoard.name(), "name1");
        assertEquals(gravBoard.name(), "name2");
        assertEquals(fullBoard.friction1, 0.01, 0.001);
        assertEquals(fullBoard.friction2, 0.02, 0.001);
        assertEquals(gravBoard.friction1, 0.025, 0.001);
        assertEquals(gravBoard.friction2, 0.025, 0.001);
        assertEquals(fullBoard.gravity, 5.0, 0.001);
        assertEquals(gravBoard.gravity, 10.0, 0.001);
    }

}
