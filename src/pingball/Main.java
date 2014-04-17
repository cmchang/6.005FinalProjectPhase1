package pingball;

import java.io.File;

import pingball.GrammarFactory;

public class Main {
    
    /**
     * Main Function that exposes functionality to command line usage
     * @param args
     */
    public static void main(String[] args) {
        Board myBoard = GrammarFactory.parse(new File("src/pingball/Boards/board1.txt"));
        System.out.println(myBoard.toString());
    }
    
}
