package pingball;

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
              double[] times = new double[board.getBalls().size()];
              int[] close = new int[board.getBalls().size()];
              Thread.sleep(1);
              for (int i = 0; i < board.getBalls().size(); i++) {
                  times[i] = 10000.0;
                  close[i] = -1;
                  for (int j = 0; j < board.walls.size(); j++) {
                      double timeLine = Geometry.timeUntilWallCollision(board.walls.get(j), board.getBalls().get(i).getCircle(), board.getBalls().get(i).getMove());
                      if (timeLine < times[i]) {
                          times[i] = timeLine;
                          close[i] = j;
                      }
                  }
              }
              for (int k = 0; k < board.getBalls().size(); k++) {
                  if (times[k] < minTime) {
                      Vect newVect = Geometry.reflectWall(board.walls.get(close[k]), board.getBalls().get(k).getMove());
                      Ball newBall = new Ball(board.getBalls().get(k).getCircle(), newVect); 
                      board.getBalls().set(k, newBall);
                  }
              }
              for (int i = 0; i < board.getBalls().size(); i++) {
                  board.getBalls().get(i).move(minTime);
              }
          }
      } catch (InterruptedException e) {
          System.out.println("Thread interrupted.");
      }
    }
}
