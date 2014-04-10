package warmup;

import physics.Geometry;
import physics.Vect;

class Update implements Runnable {
    private Board board;
    private double minTime;
    
    Update(Board boardIn){
        board = boardIn;
        minTime = 0.5;
    }
    
    public void run() {
       try {
          while(true) {
              double[] times = new double[board.balls.size()];
              int[] close = new int[board.balls.size()];
              Thread.sleep(1);
              for (int i = 0; i < board.balls.size(); i ++) {
                  times[i] = 10000.0;
                  close[i] = -1;
                  for (int j = 0; j < board.walls.size(); j++) {
                      double timeLine = Geometry.timeUntilWallCollision(board.walls.get(j), board.balls.get(i).getCircle(), board.balls.get(i).getMove());
                      if (timeLine < times[i]) {
                          times[i] = timeLine;
                          close[i] = j;
                      }
                  }
              }
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
