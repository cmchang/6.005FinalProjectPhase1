package warmup;

import java.util.ArrayList;
import java.util.List;

import physics.LineSegment;

public class Board {

    List<Ball> balls = new ArrayList<Ball>();
    List<LineSegment> walls = new ArrayList<LineSegment>();
    private int xlength;
    private int ylength;
    private final int framerate;
    
    public Board() {
        this.xlength = 20;
        this.ylength = 20;
        this.framerate = 1;
        walls.add(new LineSegment(0, 0, xlength+2, 0));
        walls.add(new LineSegment(0, ylength+1, xlength+2, ylength+1));
        walls.add(new LineSegment(0, 0, 0, ylength+2));
        walls.add(new LineSegment(xlength+1, 0, xlength+1, ylength+2));
    }
    
    public void add(Ball ball) {
        balls.add(ball);
    }
    
    public void animate() {
        try {
            while (true) {
                long startTime = System.currentTimeMillis();
                System.out.println(this.toString());
                long endTime = System.currentTimeMillis();
                long duration = endTime - startTime;
                Thread.sleep(1000/framerate - duration);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }        
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        char[][] field = new char[xlength+2][ylength+2];
        for (int i = 0; i < xlength+2; i++) {
            for (int j = 0; j < ylength+2; j++) {
                if (i == 0 || i == 21 || j == 0 || j == 21 ) {
                    field[i][j] = '.';
                } else {
                    field[i][j] = ' ';
                }
            }
        }
        for (Ball b: balls) {
            field[b.getX() + 1][b.getY() + 1] = '*';
        }
        for (int i = 0; i < xlength+2; i++) {
            for (int j = 0; j < ylength+2; j++) {
                output.append(field[i][j]);
            }
            output.append('\n');
        }
        return output.toString();
    }

}
