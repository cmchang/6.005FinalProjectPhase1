package pingball;

import java.util.Stack;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class GrammarFactory {
    
    /**
     * @param input string representing a conjunctive boolean expression
     * @return Expression corresponding to the input
     */
    public static Grammar parse(String input) {
        // Create a stream of tokens using the lexer.
        CharStream stream = new ANTLRInputStream(input);
        GrammarLexer lexer = new GrammarLexer(stream);
        lexer.reportErrorsAsExceptions();
        TokenStream tokens = new CommonTokenStream(lexer);
        
        // Feed the tokens into the parser.
        GrammarParser parser = new GrammarParser(tokens);
        parser.reportErrorsAsExceptions();
        
        // Generate the parse tree using the starter rule.
        ParseTree tree = parser.boardInfo(); // "expression" is the starter rule
        
        // debugging option #1: print the tree to the console
//        System.err.println(tree.toStringTree(parser));

        // debugging option #2: show the tree in a window
        ((RuleContext)tree).inspect(parser);

        // debugging option #3: walk the tree with a listener
//        new ParseTreeWalker().walk(new PrintEverythingListener(), tree);
        // Finally, construct an Expression value by walking over the parse tree.
//        ParseTreeWalker walker = new ParseTreeWalker();
//        GrammarCreatorListener listener = new GrammarCreatorListener();
//        walker.walk(listener, tree);

        // return the Expression value that the listener created
//        return listener.getGrammar();
        return null;
    }
    
//    private static class GrammarCreatorListener extends GrammarBaseListener {
//        private Stack<Grammar> stack = new Stack<>();
//        
//        @Override
//        public void exitBoard(GrammarParser.BoardContext ctx) {
////            Grammar literal; //= new BooleanLiteral(ctx.start.getType() == GrammarLexer.TRUE);
////            stack.push(literal);
//        }
//        
//        @Override
//        public void exitObject(GrammarParser.ObjectContext ctx) {
////            if (ctx.AND() != null) {
////                // we matched the AND rule
////                Grammar right = stack.pop();
////                Grammar left = stack.pop();
////                //Grammar and = new And(left, right);
////                stack.push(and);
////            } else {
////                // do nothing, because we just matched a literal and its BooleanLiteral is already on the stack
////            }
//        }
//        
//        @Override
//        public void exitComment(GrammarParser.CommentContext ctx) {
//            // do nothing, because the top of the stack should have the node already in it
////            assert stack.size() == 1;
//        }
//        
//        public Grammar getGrammar() {
//            return stack.get(0);
//        }
//    }
//    
//
//    static class PrintEverythingListener extends GrammarBaseListener {
//        public void enterBoard(GrammarParser.BoardContext ctx) { System.err.println("entering Board " + ctx.getText()); }
//        public void exitBoard(GrammarParser.BoardContext ctx) { System.err.println("exiting Board " + ctx.getText()); }
//
//        public void enterObject(GrammarParser.ObjectContext ctx) { System.err.println("entering an Object(ball/gadget) " + ctx.getText()); }
//        public void exitObject(GrammarParser.ObjectContext ctx) { System.err.println("exiting an Object(ball/gadget) " + ctx.getText()); }
//
//        public void enterComment(GrammarParser.CommentContext ctx) { System.err.println("entering comment " + ctx.getText()); }
//        public void exitComment(GrammarParser.CommentContext ctx) { System.err.println("exiting comment " + ctx.getText()); }
//    }

}
