package warmup;
import java.util.ArrayList;

import physics.Angle;

import physics.Angle;

/**
 * TODO: put documentation for your class here
 */
public class Main {
    
    /**
     * TODO: describe your main function's command line arguments here
     */
    public static void main(String[] args) {

        Board board = new Board();
        Angle start = new Angle(2.0);
        Ball ball = new Ball(5.0, 5.0, start, 1.0);
        board.add(ball);
        Runnable r = new Update(board);
        new Thread(r).start();
        board.animate();
    }
    
    
    
}