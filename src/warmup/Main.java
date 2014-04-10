package warmup;
import java.util.ArrayList;

import physics.Angle;

/**
 * TODO: put documentation for your class here
 */
public class Main {
    
    /**
     * TODO: describe your main function's command line arguments here
     */
    public static void main(String[] args) {
        Ball ball = new Ball(5.0, 5.0, new Angle(-.45), 1.0);
        Ball ball2 = new Ball(10.0, 5.0, new Angle(.45), 1.0);
        ArrayList<Ball> balls = new ArrayList();
        balls.add(ball);
        balls.add(ball2);
        Board board = new Board(balls, 20, 20);
        board.animate();

    }
    
    
    
}