package pingball;

import pingball.Grammar;
import pingball.GrammarFactory;

public class Main {
    
    /**
     * Main Function that exposes functionality to command line usage
     * @param args
     */
    public static void main(String[] args) {
        Grammar expr = GrammarFactory.parse("board name=sampleBoard2_1 gravity=20.0 friction1=0.020 friction2=0.020\n"
                + "#This is a comment\n"
                + "ball name=Ball x=0.5 y=0.5 xVelocity=2.5 yVelocity=2.5\n"
                + "#This is a comment\n");
//        System.out.println(expr + " = " + expr.evaluate());
    }
    
}
