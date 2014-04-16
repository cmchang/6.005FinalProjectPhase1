grammar Grammar;

// This puts a Java package statement at the top of the output Java files.
@header {
package pingball;
}

// This adds code to the generated lexer and parser.
@members {
    /**
     * Call this method to have the lexer or parser throw a RuntimeException if
     * it encounters an error.
     */
    public void reportErrorsAsExceptions() {
        addErrorListener(new ExceptionThrowingErrorListener());
    }
    
    private static class ExceptionThrowingErrorListener extends BaseErrorListener {
        @Override
        public void syntaxError(Recognizer<?, ?> recognizer,
                Object offendingSymbol, int line, int charPositionInLine,
                String msg, RecognitionException e) {
            throw new RuntimeException(msg);
        }
    }
}

/*
 * These are the parser rules. They define the structures used by the parser.
 * *** ANTLR requires grammar nonterminals to be lowercase, like html, normal, and italic.
 */

boardInfo : board (object | COMMENT)* EOF; 

board : 'board' objectName gravity friction;
gravity : 'gravity=' NUM;
friction: 'friction1=' NUM 'friction2=' NUM;

object  : objectType objectName xLoc yLoc (xVelocity yVelocity | orientation | width height)*;         // match keyword hello followed by an identifier
objectType: 'ball' | 'squareBumper' | 'circleBumper' | 'triangleBumper' | 'leftFlipper' | 'rightFlipper' | 'absorber';
objectName: 'name=' ID+;
xLoc: 'x=' NUM;
yLoc: 'y=' NUM;
xVelocity: 'xVelocity=' NUM;
yVelocity: 'yVelocity=' NUM;
orientation: 'orientation=' NUM;
width: 'width=' NUM;
height: 'height=' NUM;

COMMENT: '#' ~('\r' | '\n')* -> skip;

NUM: '-'?([0-9]+'.'[0-9]*|'.'?[0-9]+);

ID : ([a-z] | [A-Z] | [0-9] | '_')+; //any combination of lower or uppercase letters and numbers

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines