package warmup;

import physics.Angle;
import physics.Geometry;
import physics.LineSegment;
import physics.Vect;

class Update implements Runnable {
    private Board board;
    private double minTime;
    
    Update(Board boardIn){
        board = boardIn;
        minTime = 1.0;
    }
    
    public void run() {
       try {
          while(true) {
              double[] times = new double[board.balls.size()];
              int[] close = new int[board.balls.size()];
              Thread.sleep(5);
              for (int i = 0; i < board.balls.size(); i ++) {
                  times[i] = 10000.0;
                  close[i] = -1;
                  for (int j = 0; j < board.walls.size(); j++) {
                      double timeLine = Geometry.timeUntilWallCollision(board.walls.get(j), board.balls.get(i).getCircle(), board.balls.get(i).getMove());
//                      System.out.println(board.balls.get(i).getCircle().getCenter().x());
//                      System.out.println(board.balls.get(i).getCircle().getCenter().y());
//                      System.out.println(board.balls.get(i).getMove());
//                      System.out.println(timeLine);
//                      System.out.println(board.walls.get(j));
                      if (timeLine < times[i]) {
                          times[i] = timeLine;
                          close[i] = j;
                      }
                  }
              }
//              System.out.println(times[0]);
              for (int k = 0; k < board.balls.size(); k ++) {
                  if (times[k] < minTime) {
                      Vect newVect = Geometry.reflectWall(board.walls.get(close[k]), board.balls.get(k).getMove());
                      Ball newBall = new Ball(board.balls.get(k).getCircle(), newVect); 
                      board.balls.set(k, newBall);
                  }
              }
              for (int i = 0; i < board.balls.size(); i ++) {
                  board.balls.get(i).move(minTime);
              }
          }
      } catch (InterruptedException e) {
          System.out.println("Thread interrupted.");
      }
    }
}
