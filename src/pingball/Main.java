package pingball;

import pingball.Grammar;
import pingball.GrammarFactory;

public class Main {
    
    /**
     * Main Function that exposes functionality to command line usage
     * @param args
     */
    public static void main(String[] args) {
        GrammarFactory.parse("board name=sampleBoard2_1 gravity=20.0 friction1=0.020 friction2=0.020\n"
                + "#This is a comment\n"
                + "ball name=Ball x=0.5 y=0.5 xVelocity=2.5 yVelocity=2.5\n"
                + "#This is a comment\n"
                + "squareBumper name=Square0 x=0 y=2\n"
                + "circleBumper name=Circle10 x=10 y=3\n"
                + "triangleBumper name=Tri1 x=17 y=10 orientation=270\n"
                + "leftFlipper name=FlipL1 x=16 y=2 orientation=0\n"
                + "absorber name=Abs x=0 y=19 width=20 height=1\n");
    }
    
}
