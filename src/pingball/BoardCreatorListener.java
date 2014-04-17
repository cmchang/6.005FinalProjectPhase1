package pingball;

import java.util.ArrayList;

import pingball.Bumper.Shape;
import pingball.Flipper.Side;

public class BoardCreatorListener extends GrammarBaseListener{
   private static ArrayList<Gadget> gadgets = new ArrayList<Gadget>();
   private static ArrayList<Ball> balls = new ArrayList<Ball>();

   private static Board board;
   
   private static void resetBoardObjects(){
       gadgets = new ArrayList<Gadget>();
       balls = new ArrayList<Ball>();
   }
   
   public static Board getBoard(){
       for(Gadget gadget: gadgets) board.addGadget(gadget);
       for(Ball ball: balls) board.addBall(ball);
       
//       System.out.println("There are " + balls.size() + " balls and " + gadgets.size() + " gadgets in this board.");
       resetBoardObjects();
       return board;
   }
    
    public void exitBoard(GrammarParser.BoardContext ctx) {
//        String ObjectType = ctx.getChild(0).toString();
        String ObjectName = ctx.getChild(1).getChild(2).toString();
        String gravity = ctx.getChild(2).getChild(2).toString();
        String friction1 = ctx.getChild(3).getChild(2).toString();
        String friction2 = ctx.getChild(4).getChild(2).toString();
        board = FileParser.CreateBoard(ObjectName, Double.parseDouble(gravity), Double.parseDouble(friction1), Double.parseDouble(friction2));
    }
    
    public void exitObject(GrammarParser.ObjectContext ctx) {
        ArrayList<Double> doubleContent = new ArrayList<Double>();
        String ObjectType = ctx.getChild(0).getChild(0).toString();
        String ObjectName = ctx.getChild(1).getChild(0).toString();
        for(int x = 2; x < ctx.getChildCount(); x++){
            int lastIndex = ctx.getChild(x).getChildCount() - 1;
            String content = ctx.getChild(x).getChild(lastIndex).toString();
            double value = Double.parseDouble(content);
            doubleContent.add(value);
        }
        
        if (ObjectType.equals("ball")){        
            if(doubleContent.size() != 4) System.err.println("error creating ball: file was parsed incorrectly or did not contain the correct amount of information");
            balls.add(FileParser.createBall(ObjectName, doubleContent.get(0), doubleContent.get(1), doubleContent.get(2), doubleContent.get(3)));
        } else if (ObjectType.equals("squareBumper")){
            if(doubleContent.size() != 2) System.err.println("error creating squareBumper: file was parsed incorrectly or did not contain the correct amount of information");
            gadgets.add(FileParser.createBumper(Shape.SQUARE, ObjectName, doubleContent.get(0).intValue(), doubleContent.get(1).intValue(), 0));
        } else if (ObjectType.equals("circleBumper")){
            if(doubleContent.size() != 2) System.err.println("error creating circleBumper: file was parsed incorrectly or did not contain the correct amount of information");
            gadgets.add(FileParser.createBumper(Shape.CIRCLE, ObjectName, doubleContent.get(0).intValue(), doubleContent.get(1).intValue(), 0));
        } else if (ObjectType.equals("triangleBumper")){
            if(doubleContent.size() != 3) System.err.println("error creating triangleBumper: file was parsed incorrectly or did not contain the correct amount of information");
            gadgets.add(FileParser.createBumper(Shape.TRIANGLE, ObjectName, doubleContent.get(0).intValue(), doubleContent.get(1).intValue(), doubleContent.get(2).intValue()));
        } else if (ObjectType.equals("leftFlipper")){
            if(doubleContent.size() != 3) System.err.println("error creating leftFlipper: file was parsed incorrectly or did not contain the correct amount of information");
            gadgets.add(FileParser.createFlipper(Side.LEFT, ObjectName, doubleContent.get(0).intValue(), doubleContent.get(1).intValue(), doubleContent.get(2).intValue()));
        } else if (ObjectType.equals("rightFlipper")){
            if(doubleContent.size() != 3) System.err.println("error creating rightFlipper: file was parsed incorrectly or did not contain the correct amount of information");
            gadgets.add(FileParser.createFlipper(Side.RIGHT, ObjectName, doubleContent.get(0).intValue(), doubleContent.get(1).intValue(), doubleContent.get(2).intValue()));
        } else if (ObjectType.equals("absorber")){
            if(doubleContent.size() != 4) System.err.println("error creating absorber: file was parsed incorrectly or did not contain the correct amount of information");
            gadgets.add(FileParser.createAbsorber(ObjectName, doubleContent.get(0).intValue(), doubleContent.get(1).intValue(), doubleContent.get(2).intValue(), doubleContent.get(3).intValue()));            
        }
        
    }

}

    