package pingball;

import java.util.ArrayList;

import pingball.Bumper.Type;

public class BoardCreatorListener extends GrammarBaseListener{
   
    @Override
    public void exitBoard(GrammarParser.BoardContext ctx) {
    }
    
    @Override
    public void exitObject(GrammarParser.ObjectContext ctx) {
        ArrayList<Double> doubleContent = new ArrayList<Double>();
        String ObjectType = ctx.getChild(0).getChild(0).toString();
        System.out.println(ObjectType);
        String ObjectName = ctx.getChild(1).getChild(0).toString();
        
        for(int x = 2; x < ctx.getChildCount(); x++){
            int lastIndex = ctx.getChild(x).getChildCount() - 1;
            String content = ctx.getChild(x).getChild(lastIndex).toString();
            double value = Double.parseDouble(content);
            doubleContent.add(value);
        }
        
        switch(ObjectType){
        case "ball":
            FileParser.createBall(ObjectName, doubleContent.get(0), doubleContent.get(1), doubleContent.get(2), doubleContent.get(3));
            break;
        case "squareBumper":
            FileParser.createBumper(Type.SQUARE, ObjectName, doubleContent.get(0).intValue(), doubleContent.get(1).intValue(), 0);
            break;
        case "circleBumper":
            FileParser.createBumper(Type.CIRCLE, ObjectName, doubleContent.get(0).intValue(), doubleContent.get(1).intValue(), 0);
            break;
        case "triangleBumper":
            FileParser.createBumper(Type.TRIANGLE, ObjectName, doubleContent.get(0).intValue(), doubleContent.get(1).intValue(), doubleContent.get(2).intValue());
            break;
        case "leftFlipper":
            break;
        case "rightFlipper":
            break;
        case "absorber":
            break;
        }
        
        
        
        
    }

}

    