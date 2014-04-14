package pingball;

import physics.Angle;
import physics.Geometry;
import physics.Vect;

class Update implements Runnable {
    private Board board;
    private double minTime;
    
    double mu = board.friction1;
    double mu2 = board.friction2;
    double deltaT = minTime/1000;
    
    Update(Board boardIn){
        board = boardIn;
        minTime = 0.5;
        
    }
    /**
     * Runnable method of the Update class which starts when the thread is started.
     * This method updates the location of the ball every timestep.
     * 
     * Determines when balls collide with objects and appropriately reflects the ball in the case that it does.
     * Updates the ball location based on its velocity, while accounting for friction and gravity.
     */
    public void run() {
       try {
          while(true) {
              
              double[] times = new double[board.getBalls().size()];
              int[] close = new int[board.getBalls().size()];
              Thread.sleep(1); 
              for (int i = 0; i < board.getBalls().size(); i ++) {
                  times[i] = 10000.0;
                  close[i] = -1;
                  for (int j = 0; j < board.objects.size(); j++) {                                            
                              
                      double timeLine = Geometry.timeUntilWallCollision(board.walls.get(j), board.getBalls().get(i).getCircle(), board.getBalls().get(i).getMove());
                      if (timeLine < times[i]) {
                          times[i] = timeLine;
                          close[i] = j;
                      }
                  }
              }
              for (int k = 0; k < board.getBalls().size(); k ++) {
                  if (times[k] < minTime) {
                      Vect newVect = Geometry.reflectWall(board.walls.get(close[k]), board.getBalls().get(k).getMove());
                      Ball newBall = new Ball(board.getBalls().get(k).getCircle(), newVect); 
                      board.getBalls().set(k, newBall);
                  }
              }
              for (int i = 0; i < board.getBalls().size(); i ++) {
                  
                  Vect oldVect = board.getBalls().get(i).getMove();
                  Vect frictScaled = oldVect.times(1.0 - mu*deltaT - mu2*oldVect.length()*deltaT); // formula from spec sheet.
                  
                  double xComp = frictScaled.dot(frictScaled.X_HAT); // gravity doesn't affect X-Velocity
                  double yComp = frictScaled.dot(frictScaled.Y_HAT) - board.gravity*deltaT; // gravity affects Y-Velocity by Vf = Vi + at                  
                  double magnitude = Math.hypot(xComp, yComp);                  
                  Vect frictGravVect = new Vect(new Angle(xComp, yComp)).times(magnitude);                  
                  
                  board.getBalls().get(i).setMove(frictGravVect);                  
                  board.getBalls().get(i).move(minTime);
                  
              }
          }
      } catch (InterruptedException e) {
          System.out.println("Thread interrupted.");
      }
    }
}
