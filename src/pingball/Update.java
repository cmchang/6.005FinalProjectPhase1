package pingball;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import physics.Angle;
import physics.Circle;
import physics.Geometry;
import physics.Geometry.VectPair;
import physics.Vect;
import pingball.BoardsHandler.Connection;
import pingball.Wall.Boundary;
import pingball.Wall.Visibility;

/**
 * This class is basically a method for the clients. 
 * 
 * The clients run the runnable method of this class and the board is continually updated
 * at a certain rate. The board is updated based on ball movements, collisons, flipper movements,
 * gadget triggers/actions as well as gravity,friction and board connection considerations.
 */
class Update implements Runnable {
    private final Board board;    
    private final double mu; // = board.friction1;
    private final double mu2;//  = board.friction2;
    private final double deltaT = 1.0 / 1000.0;
    private final double minTime = deltaT* 10;
    //private final BufferedReader in;
    private final Object lock;
    private final BoardsHandler boardHandler;
 

    /**
     * Constructor for Update class
     * @param boardIn board to update
     * @param lock shared lock obtained from the server
     * @param connectionsIn shared boardshandler obtained from the server
     */
    Update(Board boardIn, BufferedReader in, Object lock, BoardsHandler connectionsIn){
        board = boardIn;
        mu = board.friction1;
        mu2 = board.friction2;
        //this.in = in;
        this.lock = lock;
        this.boardHandler = connectionsIn;
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
      // try {
          while(true) {                                          
              
            //update wall visibilities based on connections
              Map<Boundary,Visibility> visibleWalls = new HashMap<Boundary,Visibility>();                                          
              for (Gadget gadget: board.objects){
                  if (!gadget.getType().equals("wall")) continue;
                  Wall wall = (Wall) gadget; // for each wall....
                  synchronized(lock) {
                      for (Connection c: boardHandler.getConnections(board)){ 
                          
                          if (wall.boundary.equals(c.boundary)) { //the correct connection to the correct wall
                              visibleWalls.put(wall.boundary, Visibility.INVISIBLE); //if a wall matches a connection boundary, set as invisible
                              wall.setConnection(c);
                          }
                      }
                  }
                  if (!visibleWalls.containsKey(wall.boundary)) {
                      visibleWalls.put(wall.boundary, Visibility.SOLID); // else set it as solid
                      wall.removeConnetion();
                  }
              }
              if (!(visibleWalls.size()==4)) System.err.println("Size of visibile walls should be 4.");
              board.setWallVisibilites(visibleWalls);
              
              // add in gravity and friction to the boards velocity based on the timestep
              Gadget closestGadg = null;
              try {
//                  System.out.println((long) deltaT * 10);
                Thread.sleep(1);
              } catch (InterruptedException e) {
                e.printStackTrace();
              } 
              for (int i = 0; i < board.getBalls().size(); i ++) {
                  Vect oldVect = board.getBalls().get(i).getMove();
                  Vect frictScaled = oldVect.times(1.0 - mu * deltaT - mu2 * oldVect.length() * deltaT); // formula from spec sheet.
                  double xComp = frictScaled.dot(Vect.X_HAT); // gravity doesn't affect X-Velocity
                  double yComp = frictScaled.dot(Vect.Y_HAT) + board.gravity * deltaT; // gravity affects Y-Velocity by Vf = Vi + at                  
                  double magnitude = Math.hypot(xComp, yComp);
                  Vect frictGravVect;
                  if (xComp == 0.0 && yComp == 0.0) {
                      frictGravVect = new Vect(new Angle(0.0)).times(0.0);
                  } else {
                      frictGravVect = new Vect(new Angle(xComp, yComp)).times(magnitude);
                  }
                  board.getBalls().get(i).setMove(frictGravVect);
              }
              //add in incoming balls
              synchronized(lock){
                  for (Ball ball: boardHandler.receiveBalls(board.name())){             
                      board.addBall(ball);
                  }
              }
              
              //update ball velocities based on collisons with other gadgets, including walls, or balls
              synchronized(lock){
                  List<Ball> ballToRemove = new ArrayList<Ball>(); 
                  for (Ball ball: board.getBalls()) {
                      if (!ball.isTrapped){
                          boolean dirty = false;
                          double time = 10000.0;
                          Ball closestBall = null;
                          boolean gadgetCollision = true;
                          for (Gadget gadget: board.objects){ //includes walls,absorbers,bumpers,flipper
                              double timeLine = gadget.getTimeToCollision(ball);
                              if (timeLine < time) { // find the gadget that has the smallest collision time
                                  time = timeLine;
                                  closestGadg = gadget;
                              }
                          }
                          for (Ball otherBall: board.getBalls()) {
                              if (!otherBall.isTrapped){
                                  if (!ball.equals(otherBall)) {
                                      double timeBall = Geometry.timeUntilBallBallCollision(ball.getCircle(), ball.getMove(), otherBall.getCircle(), otherBall.getMove());
                                      if (timeBall < time) {
                                          time = timeBall;
                                          closestBall = otherBall;
                                          gadgetCollision = false;
                                      }
                                  }
                              }
                          }
                          if (time<minTime) { // if the time is small enough to be considered a collision
        
                              dirty = true;
                              if (!gadgetCollision) {
                                  Vect vect1 = ball.getCircle().getCenter();
                                  Vect vect2 = closestBall.getCircle().getCenter();
                                  VectPair velocities = Geometry.reflectBalls(vect1, 1, ball.getMove(), vect2, 1, closestBall.getMove());
                                  ball.setMove(velocities.v1);
                                  closestBall.setMove(velocities.v2);
                              } else {
                                  if (closestGadg.getType().equals("wall")){ // if its a wall, we need to check if its solid/invisible
            //                          dirty = true;
                                      Wall closeWall = (Wall) closestGadg;
                                      if (closeWall.visible.equals(Visibility.SOLID)) closestGadg.reflectBall(ball);
                                      if (closeWall.visible.equals(Visibility.INVISIBLE)){ //send the ball to the other board                                      
                                          ballToRemove.add(ball);
                                          dirty = true;
                                          synchronized(lock) {
                                              for (Connection c : boardHandler.getConnections(board)){
                                                  if (c.boundary.equals(closeWall.boundary)){  //then c contains the name of the board thats connected to it                                                                      
                                                      Circle newCircle = board.newBallLocation(ball.getCircle(),closeWall.boundary);  //put ball on other side of board                              
                                                      Ball newBall = new Ball(newCircle, ball.getMove(), ball.name());
                                                      boardHandler.sendBall(c, newBall);      //send ball to other board through BoardsHandler                           
                                                  }                                      
                                              }
                                          }
                                      }                      
                                  } else { // its a bumper or flipper or absorber
            //                          dirty = true;
                                      closestGadg.reflectBall(ball);
                                      closestGadg.trigger();
                                  }
                              }
                          }
        //              }
                          if (!dirty) {
            //                  move the ball forward based on the timestep
            //                  for (int i = 0; i < board.getBalls().size(); i ++) {
                //                  System.out.println("Vect");
                //                  System.out.println(board.getBalls().get(i).getMove().length());
                //                  System.out.println("Pos");
                //                  System.out.println(board.getBalls().get(i).getX());
                                  ball.move(deltaT);
                          }
                      }
                  }
                  board.getBalls().removeAll(ballToRemove);
              }
              //move the flippers based on the timestep
              for (Gadget flipper:board.objects){
                  if (flipper.getType().equals("flipper")){
                      ((Flipper) flipper).move(deltaT);
                  }
              }
              
          }
      //} //catch (InterruptedException e) {
          //System.out.println("Thread interrupted.");
      //}
    }

}
