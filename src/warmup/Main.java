package warmup;
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
        Angle start2 = new Angle(3.0);
        Ball ball = new Ball(5.0, 5.0, start, 2.0);
        Ball ball2 = new Ball(3.0, 2.0, start2, 2.0);
        board.add(ball);
        board.add(ball2);
        Runnable r = new Update(board);
        new Thread(r).start();
        board.animate();
    }
    
    
    
}