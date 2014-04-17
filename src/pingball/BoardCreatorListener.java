package pingball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import pingball.Bumper.Shape;
import pingball.Flipper.Side;

public class BoardCreatorListener extends GrammarBaseListener{
   private static ArrayList<Gadget> gadgets = new ArrayList<Gadget>();
   private static ArrayList<Ball> balls = new ArrayList<Ball>();
   private static ArrayList<ArrayList<String>> fireCmds = new ArrayList<ArrayList<String>>();
   
   private static Board board;
   
   private static void resetBoardObjects(){
       gadgets = new ArrayList<Gadget>();
       balls = new ArrayList<Ball>();
   }
   
   public static Board getBoard(){
       //board.addGizmos(createTriggerActions());
       
       for(Gadget gadget: gadgets) board.addGadget(gadget);
       for(Ball ball: balls) board.addBall(ball);
       
       resetBoardObjects();
       return board;
   }
    
   private HashMap<String, List<String>> createTriggerActions(){
       HashMap<String, List<String>> gizmos = new HashMap<String, List<String>>();
       for(int x = 0; x < fireCmds.size(); x ++){
           String trigger = fireCmds.get(x).get(0);
           String action = fireCmds.get(x).get(1);
           if(gizmos.containsKey(trigger)){
               List<String> curList = gizmos.get(trigger);
               curList.add(action);
               gizmos.put(trigger, curList);
           }else{
               List<String> curList = new ArrayList<String>();
               curList.add(action);
               gizmos.put(trigger, curList);
           }
       }
       
       return gizmos;
   }
   
    public void exitBoard(GrammarParser.BoardContext ctx) {
//        String ObjectType = ctx.getChild(0).toString();
        String ObjectName = ctx.getChild(1).getChild(2).toString();
        String gravity = ctx.getChild(2).getChild(2).toString();
        if(ctx.getChildCount() == 4){ //if has 4 children, then friction was given
            String friction1 = ctx.getChild(3).getChild(2).toString();
            String friction2 = ctx.getChild(4).getChild(2).toString();
            board = FileParser.CreateBoard(ObjectName, Double.parseDouble(gravity), Double.parseDouble(friction1), Double.parseDouble(friction2));
        }else{
            //No friction was given in the file, so friction1 = friction2 = 0.0
            board = FileParser.CreateBoard(ObjectName, Double.parseDouble(gravity), 0.0, 0.0);

        }
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

    public void enterFire(GrammarParser.FireContext ctx) { 
        
        String trigger = ctx.getChild(3).getChild(0).toString();
        String action = ctx.getChild(6).getChild(0).toString();
        
        ArrayList<String> gizmo = new ArrayList<String>();
        gizmo.add(trigger);
        gizmo.add(action);
        
        fireCmds.add(gizmo);
    }
    
}

    