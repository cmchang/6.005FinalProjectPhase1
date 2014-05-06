package pingball;

import java.io.File;

import pingball.GrammarFactory;

public class Main {
    
    /**
     * Main Function that exposes functionality to command line usage
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
        Board myBoard = GrammarFactory.parse(new File("src/../boards/board1.txt"));
        System.out.println(myBoard.toString());
    }
    
}