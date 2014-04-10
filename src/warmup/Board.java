package warmup;

import java.util.ArrayList;

import physics.LineSegment;

public class Board {
    private ArrayList<Ball> balls;
    private ArrayList<LineSegment> boardObjs;
    private final int sizeX;
    private final int sizeY;
    private final int framerate = 1;
    
    /*
     * Board:
     * Contains the string representation of walls, bumpers, and flippers
     */
    private char[][] Board;
    
    public Board(ArrayList<Ball> balls, int sizeX, int sizeY){
        this.balls = balls;
        
        boardObjs = new ArrayList<LineSegment>();
        boardObjs.add(new LineSegment(0.0, 0.0, sizeX+2, 0.0)); //top border
        boardObjs.add(new LineSegment(sizeX+2, 0.0, sizeX+2, sizeY+2)); //right border
        boardObjs.add(new LineSegment(0.0, sizeY+2, sizeX+2, sizeY+2)); //bottom border
        boardObjs.add(new LineSegment(0.0, 0.0, 0.0, sizeY+2)); //left border
        
        this.sizeX = sizeX;
        this.sizeY = sizeY;

        //create the Board rep: a list of lists containing a string
        Board = new char[sizeX+2][sizeY+2];
        
        //Add all spaces
        for(int x = 0; x< sizeX+2; x++){
            for(int y = 0; y < sizeY+2; y++){
                Board[x][y] = ' ';
            }
        }
        
        //Add the boarder string representation to the Board
        for(int x = 0; x< sizeX+2; x++){
            Board[x][0] = '.';
            Board[x][sizeY+1] = '.';
        }
        for(int y = 0; y < sizeY+2; y++){
            Board[0][y] = '.';
            Board[sizeX+1][y] = '.';
        }
        
    }

    
    public void addBall(Ball ball){
        balls.add(ball);
    }
    
    public void checkCollisions(){
        for(Ball ball:balls){
            CheckWallCollision(ball);
        }
    }
    
    public void animate() {
        try {
            while (true) {
                long startTime = System.currentTimeMillis();
                for(Ball ball: balls) ball.timeStep();
                checkCollisions();
                System.out.println(printBoard());
                long endTime = System.currentTimeMillis();
                long duration = endTime - startTime;
                Thread.sleep(1000/framerate - duration);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }        
    }
    

    public String printBoard(){
        String output = "";
        for(int y = 0; y < sizeY+2; y++){
            for(int x = 0; x < sizeX+2; x++){
                boolean addedBall = false;
                for(Ball ball: balls){
                    if(x-1 == ball.getRoundedLocX() && y-1 == ball.getRoundedLocY()){
                        if(Board[x][y] != '.'){
                            output+= "O";
                            addedBall = true;
                        }
                    }
                }
                
                if(addedBall){
                    addedBall = false;
                }else{
                    output+= Board[x][y];
                }
            }
            output+="\n";
        }
        output+= balls.get(0).getBallInfo();
        return output;
    }
    
    private void CheckWallCollision(Ball ball){
        //can rewrite later to it can iterate through objects and balls to check for collisions
        //lazy version now since there are only walls...
        double posX = ball.getPreciseLocX();
        double posY = ball.getPreciseLocY();
        if(posY < 0) ball.collision(boardObjs.get(0));
        if(posY > sizeY) ball.collision(boardObjs.get(2));
        if(posX < 0) ball.collision(boardObjs.get(3));
        if(posX > sizeX) ball.collision(boardObjs.get(1));
        
    }
}
