// Generated from Grammar.g4 by ANTLR 4.0

package pingball;

import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface GrammarListener extends ParseTreeListener {
	void enterOrientation(GrammarParser.OrientationContext ctx);
	void exitOrientation(GrammarParser.OrientationContext ctx);

	void enterYLoc(GrammarParser.YLocContext ctx);
	void exitYLoc(GrammarParser.YLocContext ctx);

	void enterBoardInfo(GrammarParser.BoardInfoContext ctx);
	void exitBoardInfo(GrammarParser.BoardInfoContext ctx);

	void enterObjectName(GrammarParser.ObjectNameContext ctx);
	void exitObjectName(GrammarParser.ObjectNameContext ctx);

	void enterWidth(GrammarParser.WidthContext ctx);
	void exitWidth(GrammarParser.WidthContext ctx);

	void enterYVelocity(GrammarParser.YVelocityContext ctx);
	void exitYVelocity(GrammarParser.YVelocityContext ctx);

	void enterFriction(GrammarParser.FrictionContext ctx);
	void exitFriction(GrammarParser.FrictionContext ctx);

	void enterObject(GrammarParser.ObjectContext ctx);
	void exitObject(GrammarParser.ObjectContext ctx);

	void enterXVelocity(GrammarParser.XVelocityContext ctx);
	void exitXVelocity(GrammarParser.XVelocityContext ctx);

	void enterBoard(GrammarParser.BoardContext ctx);
	void exitBoard(GrammarParser.BoardContext ctx);

	void enterHeight(GrammarParser.HeightContext ctx);
	void exitHeight(GrammarParser.HeightContext ctx);

	void enterXLoc(GrammarParser.XLocContext ctx);
	void exitXLoc(GrammarParser.XLocContext ctx);

	void enterVelocity(GrammarParser.VelocityContext ctx);
	void exitVelocity(GrammarParser.VelocityContext ctx);

	void enterObjectType(GrammarParser.ObjectTypeContext ctx);
	void exitObjectType(GrammarParser.ObjectTypeContext ctx);

	void enterGravity(GrammarParser.GravityContext ctx);
	void exitGravity(GrammarParser.GravityContext ctx);
}