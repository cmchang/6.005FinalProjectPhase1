package pingball;

import java.util.ArrayList;

import pingball.Bumper.Type;
import pingball.Flipper.Side;

public class BoardCreatorListener extends GrammarBaseListener{
   
    @Override
    public void exitBoard(GrammarParser.BoardContext ctx) {
    }
    
    @Override
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
        
        switch(ObjectType){
        case "ball":
            if(doubleContent.size() != 4) System.err.println("error creating ball: file was parsed incorrectly or did not contain the correct amount of information");
            FileParser.createBall(ObjectName, doubleContent.get(0), doubleContent.get(1), doubleContent.get(2), doubleContent.get(3));
            break;
        case "squareBumper":
            if(doubleContent.size() != 2) System.err.println("error creating squareBumper: file was parsed incorrectly or did not contain the correct amount of information");
            FileParser.createBumper(Type.SQUARE, ObjectName, doubleContent.get(0).intValue(), doubleContent.get(1).intValue(), 0);
            break;
        case "circleBumper":
            if(doubleContent.size() != 2) System.err.println("error creating circleBumper: file was parsed incorrectly or did not contain the correct amount of information");
            FileParser.createBumper(Type.CIRCLE, ObjectName, doubleContent.get(0).intValue(), doubleContent.get(1).intValue(), 0);
            break;
        case "triangleBumper":
            if(doubleContent.size() != 3) System.err.println("error creating triangleBumper: file was parsed incorrectly or did not contain the correct amount of information");
            FileParser.createBumper(Type.TRIANGLE, ObjectName, doubleContent.get(0).intValue(), doubleContent.get(1).intValue(), doubleContent.get(2).intValue());
            break;
        case "leftFlipper":
            if(doubleContent.size() != 3) System.err.println("error creating leftFlipper: file was parsed incorrectly or did not contain the correct amount of information");
            FileParser.createFlipper(Side.LEFT, ObjectName, doubleContent.get(0).intValue(), doubleContent.get(1).intValue(), doubleContent.get(2).intValue());
            break;
        case "rightFlipper":
            if(doubleContent.size() != 3) System.err.println("error creating rightFlipper: file was parsed incorrectly or did not contain the correct amount of information");
            FileParser.createFlipper(Side.RIGHT, ObjectName, doubleContent.get(0).intValue(), doubleContent.get(1).intValue(), doubleContent.get(2).intValue());
            break;
        case "absorber":
            if(doubleContent.size() != 4) System.err.println("error creating absorber: file was parsed incorrectly or did not contain the correct amount of information");
            FileParser.createAbsorber(ObjectName, doubleContent.get(0).intValue(), doubleContent.get(1).intValue(), doubleContent.get(2).intValue(), doubleContent.get(3).intValue());
            break;
        }
        
        
        
        
    }

}

    