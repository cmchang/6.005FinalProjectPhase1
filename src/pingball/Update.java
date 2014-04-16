package pingball;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




import physics.Angle;
import physics.Circle;
import physics.Vect;
import pingball.BoardsHandler.Connection;
import pingball.BoardsHandler.Orientation;
import pingball.Wall.Boundary;
import pingball.Wall.Visibility;

class Update implements Runnable {
    private Board board;    
    double mu; // = board.friction1;
    double mu2;//  = board.friction2;

    double deltaT = (long) (1.0 / 1000.0);
    double minTime = deltaT * 10;
    private BufferedReader in;
    private Object lock;
    private BoardsHandler connectionsIn;



    
    /**
     * Constructor for Update class
     * @param boardIn board to update
     */
    Update(Board boardIn, BufferedReader in, Object lock, BoardsHandler connectionsIn){
        board = boardIn;
        mu = board.friction1;
        mu2 = board.friction2;
        this.in = in;
        this.lock = lock;
        this.connectionsIn = connectionsIn;
    }
    
    /**
     * Runnable method of the Update class which starts when the thread is started.
     * This method updates the location of the ball every timestep.
     * 
     * Also updates the location of the flippers.
     * 
     * Determines when balls collide with objects and appropriately reflects the ball in the case that it does.
     * Updates the ball location based on its velocity, while accounting for friction and gravity.
     */
    
    public void run() {
       try {
          while(true) {
              
              // read userInputs and start new boardConnections if necessary
              String userInput="";              
              try {
                userInput = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
              String[] cmds = userInput.split(" ");
              if (cmds.length==3){
                  Orientation o = null;
                  if (cmds[0].equals("v")) o = Orientation.VERTICAL;
                  if (cmds[0].equals("h")) o = Orientation.HORIZONTAL;
                  synchronized(lock){
                //      connectionsIn.addConnection(cmds[1], cmds[2], o);
                  }
              }
              
            //update wall visibilities based on connections
              Map<Boundary,Visibility> visibleWalls = new HashMap<Boundary,Visibility>();                                          
              for (Gadget gadget: board.objects){
                  if (!gadget.getType().equals("wall")) continue;
                  Wall wall = (Wall) gadget;
                  
                  for (Connection c: connectionsIn.getConnections(board)){
                      if (wall.boundary.equals(c.boundary)) visibleWalls.put(wall.boundary, Visibility.INVISIBLE);                                               
                  }
                  if (!visibleWalls.containsKey(wall.boundary)) visibleWalls.put(wall.boundary, Visibility.SOLID);
              }
              if (!(visibleWalls.size()==4)) System.err.println("Size of visibile walls should be 4.");
              board.setWallVisibilites(visibleWalls);
              

              Gadget closerObj = null;
              Thread.sleep((long) deltaT); 
              for (int i = 0; i < board.getBalls().size(); i ++) {
                  Vect oldVect = board.getBalls().get(i).getMove();
                  Vect frictScaled = oldVect.times(1.0 - mu * deltaT - mu2 * oldVect.length() * deltaT); // formula from spec sheet.
                  double yComp = frictScaled.dot(Vect.Y_HAT); // gravity doesn't affect X-Velocity
                  double xComp = frictScaled.dot(Vect.X_HAT) + board.gravity * deltaT; // gravity affects Y-Velocity by Vf = Vi + at                  
                  double magnitude = Math.hypot(xComp, yComp);
                  Vect frictGravVect;
                  if (xComp == 0 && yComp == 0) {
                      frictGravVect = new Vect(new Angle(0.0)).times(0.0);
                  } else {
                      frictGravVect = new Vect(new Angle(xComp, yComp)).times(magnitude);
                  }
                  board.getBalls().get(i).setMove(frictGravVect);
              }
              //TODO handle incoming balls
              for (Ball ball: connectionsIn.receiveBalls()){
                  board.addBall(ball);
              }
              
              //update ball collisons
              for (Ball ball: board.getBalls()) {
                  double time = 10000.0;                  
                  for (Gadget gadget: board.objects){ //includes walls,absorbers,bumpers,flipper
                      double timeLine = gadget.getTimeToCollision(ball);
                      if (timeLine < time) {
                          time = timeLine;
                          closerObj = gadget;                          
                      }
                  }
                  
                  if (time<minTime) {
                      if (closerObj.getType().equals("absorber")){
                          closerObj.trigger(ball); //trigger method should be generated right here...
                      } else if (closerObj.getType().equals("wall")){
                          Wall closeWall = (Wall) closerObj;
                          if (closeWall.visible.equals(Visibility.SOLID)) closerObj.reflectBall(ball);
                          if (closeWall.visible.equals(Visibility.INVISIBLE)){ //send the ball to the other board
                              
                              board.getBalls().remove(ball);
                              
                              //TODO fix ball location
                              for (Connection c : connectionsIn.getConnections(board)){
                                  if (c.boundary.equals(closeWall.boundary)){                                                                            
                                      Circle newCircle = board.newBallLocation(ball.getCircle(),closeWall.boundary);                                      
                                      Ball newBall = new Ball(newCircle, ball.getMove());
                                      connectionsIn.sendBall(c, newBall);                                      
                                  }                                      
                              }                              
                          }
                      } else {
                          closerObj.reflectBall(ball);
                          closerObj.trigger();
                      }
                  }
              }
              
              for (int i = 0; i < board.getBalls().size(); i ++) {                 
                  board.getBalls().get(i).move(deltaT);
              }
  
              //move the flippers
              for (Gadget flipper:board.objects){
                  if (flipper.getType().equals("flipper")){
                      ((Flipper) flipper).move(deltaT);
                  }
              }
          }
      } catch (InterruptedException e) {
          System.out.println("Thread interrupted.");
      }
    }

}
