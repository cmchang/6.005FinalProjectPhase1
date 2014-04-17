package pingball;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

/**
 * Testing reading in a file and outputting a board
 * 
 * Testing Strategy:
 * (A) Varying formatted files
 *      (A1) Contains a comment 
 *      (A2) Comment in file contains a keyword (i.e. 'ball', 'bumper', etc)
 *      (A2) Doesn't contain a comment
 *      (A3) Additional spaces added randomly
 *      (A4) An object in the field doesn't contain all the correct fields
 *      (A5) Objects declared in the file over lap each other
 * (B) Objects in the board
 *      (B1) Empty board
 *      (B2) Contains one ball
 *      (B3) Contains multiple balls
 *      (B4) Contains no ball but contains at least one gadget
 *      (B5) Contains at least one gadget
 *      (B6) Contains every possible gadget
 * (C) The given sample boards supplied by the staff
 *      (C1) sampleBoard1.pb
 *      (C2) sampleBoard2-1.pb  
 *      (C3) sampleBoard2-2.pb 
 *      (C4) sampleBoard3.pb  
 *      (C5) sampleBoard4.pb 
 */

public class FileParsingTest {

    @Test
    public void testC1(){
        Board myBoard = GrammarFactory.parse(new File("src/pingball/Boards/board1.txt"));
        String ExpectedAnswer = "......................\n"
                + ".*                   .\n"
                + ".########----########.\n"
                + ".    0          0    .\n"
                + ".     0        0     .\n"
                + ".      0      0      .\n"
                + ".       0    0       .\n"
                + ".        ----        .\n"
                + ".                    .\n"
                + ".        \\  /        .\n"
                + ".                    .\n"
                + ".                    .\n"
                + ".                    .\n"
                + ".                    .\n"
                + ".                    .\n"
                + ".                    .\n"
                + ".                    .\n"
                + ".                    .\n"
                + ".                    .\n"
                + ".====================.\n"
                + ".                    .\n"
                + "......................\n";
//        System.out.println(myBoard.toString());
        assertEquals(ExpectedAnswer, myBoard.toString());
    }
    
    @Test
    public void testC2(){
        Board myBoard = GrammarFactory.parse(new File("src/pingball/Boards/board2.txt"));
        String ExpectedAnswer = "......................\n"
                + ".*                   .\n"
                + ".################--  .\n"
                + ".          0         .\n"
                + ".           0        .\n"
                + ".            0       .\n"
                + ".             0      .\n"
                + ".              0     .\n"
                + ".               0    .\n"
                + ".                --  .\n"
                + ".                    .\n"
                + ".                 \\  .\n"
                + ".                  \\ .\n"
                + ".                    .\n"
                + ".                    .\n"
                + ".                    .\n"
                + ".                    .\n"
                + ".                    .\n"
                + ".                    .\n"
                + ".====================.\n"
                + ".                    .\n"
                + "......................\n";

//        System.out.println(myBoard.toString());
        assertEquals(ExpectedAnswer, myBoard.toString());
    }
    
    @Test
    public void testC3(){
        Board myBoard = GrammarFactory.parse(new File("src/pingball/Boards/board3.txt"));
        String ExpectedAnswer = "......................\n"
                + ".                    .\n"
                + ".  --################.\n"
                + ".         0          .\n"
                + ".        0           .\n"
                + ".       0            .\n"
                + ".      0             .\n"
                + ".     0              .\n"
                + ".    0               .\n"
                + ".  --                .\n"
                + ".                    .\n"
                + ".  /                 .\n"
                + ". /                  .\n"
                + ".                    .\n"
                + ".                    .\n"
                + ".                    .\n"
                + ".                    .\n"
                + ".                    .\n"
                + ".                    .\n"
                + ".====================.\n"
                + ".                    .\n"
                + "......................\n";

        System.out.println(myBoard.toString());
        assertEquals(ExpectedAnswer, myBoard.toString());
    }
    
    @Test
    public void testC4(){
        Board myBoard = GrammarFactory.parse(new File("src/pingball/Boards/board4.txt"));
        String ExpectedAnswer = "......................\n"
                + ".                    .\n"
                + ".  --################.\n"
                + ".         0          .\n"
                + ".        0           .\n"
                + ".       0            .\n"
                + ".      0             .\n"
                + ".     0              .\n"
                + ".    0               .\n"
                + ".  --                .\n"
                + ".                    .\n"
                + ".  /                 .\n"
                + ". /                  .\n"
                + ".                    .\n"
                + ".                    .\n"
                + ".                    .\n"
                + ".                    .\n"
                + ".                    .\n"
                + ".                    .\n"
                + ".====================.\n"
                + ".                    .\n"
                + "......................\n";

        System.out.println(myBoard.toString());
        assertEquals(ExpectedAnswer, myBoard.toString());
    }
}
