// Generated from Grammar.g4 by ANTLR 4.0

package pingball;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__18=1, T__17=2, T__16=3, T__15=4, T__14=5, T__13=6, T__12=7, T__11=8, 
		T__10=9, T__9=10, T__8=11, T__7=12, T__6=13, T__5=14, T__4=15, T__3=16, 
		T__2=17, T__1=18, T__0=19, COMMENT=20, NUM=21, ID=22, WS=23;
	public static final String[] tokenNames = {
		"<INVALID>", "'orientation='", "'x='", "'friction2='", "'board'", "'ball'", 
		"'xVelocity='", "'friction1='", "'name='", "'triangleBumper'", "'gravity='", 
		"'width='", "'y='", "'absorber'", "'squareBumper'", "'yVelocity='", "'leftFlipper'", 
		"'circleBumper'", "'rightFlipper'", "'height='", "COMMENT", "NUM", "ID", 
		"WS"
	};
	public static final int
		RULE_boardInfo = 0, RULE_board = 1, RULE_gravity = 2, RULE_friction = 3, 
		RULE_object = 4, RULE_objectType = 5, RULE_objectName = 6, RULE_xLoc = 7, 
		RULE_yLoc = 8, RULE_velocity = 9, RULE_xVelocity = 10, RULE_yVelocity = 11, 
		RULE_orientation = 12, RULE_width = 13, RULE_height = 14;
	public static final String[] ruleNames = {
		"boardInfo", "board", "gravity", "friction", "object", "objectType", "objectName", 
		"xLoc", "yLoc", "velocity", "xVelocity", "yVelocity", "orientation", "width", 
		"height"
	};

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }


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

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class BoardInfoContext extends ParserRuleContext {
		public ObjectContext object(int i) {
			return getRuleContext(ObjectContext.class,i);
		}
		public List<TerminalNode> COMMENT() { return getTokens(GrammarParser.COMMENT); }
		public TerminalNode EOF() { return getToken(GrammarParser.EOF, 0); }
		public List<ObjectContext> object() {
			return getRuleContexts(ObjectContext.class);
		}
		public TerminalNode COMMENT(int i) {
			return getToken(GrammarParser.COMMENT, i);
		}
		public BoardContext board() {
			return getRuleContext(BoardContext.class,0);
		}
		public BoardInfoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boardInfo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterBoardInfo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitBoardInfo(this);
		}
	}

	public final BoardInfoContext boardInfo() throws RecognitionException {
		BoardInfoContext _localctx = new BoardInfoContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_boardInfo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30); board();
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 5) | (1L << 9) | (1L << 13) | (1L << 14) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << COMMENT))) != 0)) {
				{
				setState(33);
				switch (_input.LA(1)) {
				case 5:
				case 9:
				case 13:
				case 14:
				case 16:
				case 17:
				case 18:
					{
					setState(31); object();
					}
					break;
				case COMMENT:
					{
					setState(32); match(COMMENT);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(38); match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoardContext extends ParserRuleContext {
		public ObjectNameContext objectName() {
			return getRuleContext(ObjectNameContext.class,0);
		}
		public FrictionContext friction() {
			return getRuleContext(FrictionContext.class,0);
		}
		public GravityContext gravity() {
			return getRuleContext(GravityContext.class,0);
		}
		public BoardContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_board; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterBoard(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitBoard(this);
		}
	}

	public final BoardContext board() throws RecognitionException {
		BoardContext _localctx = new BoardContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_board);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40); match(4);
			setState(41); objectName();
			setState(42); gravity();
			setState(43); friction();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GravityContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(GrammarParser.NUM, 0); }
		public GravityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gravity; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterGravity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitGravity(this);
		}
	}

	public final GravityContext gravity() throws RecognitionException {
		GravityContext _localctx = new GravityContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_gravity);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45); match(10);
			setState(46); match(NUM);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FrictionContext extends ParserRuleContext {
		public TerminalNode NUM(int i) {
			return getToken(GrammarParser.NUM, i);
		}
		public List<TerminalNode> NUM() { return getTokens(GrammarParser.NUM); }
		public FrictionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_friction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterFriction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitFriction(this);
		}
	}

	public final FrictionContext friction() throws RecognitionException {
		FrictionContext _localctx = new FrictionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_friction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48); match(7);
			setState(49); match(NUM);
			setState(50); match(3);
			setState(51); match(NUM);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjectContext extends ParserRuleContext {
		public List<OrientationContext> orientation() {
			return getRuleContexts(OrientationContext.class);
		}
		public YLocContext yLoc() {
			return getRuleContext(YLocContext.class,0);
		}
		public List<HeightContext> height() {
			return getRuleContexts(HeightContext.class);
		}
		public XLocContext xLoc() {
			return getRuleContext(XLocContext.class,0);
		}
		public ObjectNameContext objectName() {
			return getRuleContext(ObjectNameContext.class,0);
		}
		public VelocityContext velocity(int i) {
			return getRuleContext(VelocityContext.class,i);
		}
		public List<WidthContext> width() {
			return getRuleContexts(WidthContext.class);
		}
		public HeightContext height(int i) {
			return getRuleContext(HeightContext.class,i);
		}
		public OrientationContext orientation(int i) {
			return getRuleContext(OrientationContext.class,i);
		}
		public List<VelocityContext> velocity() {
			return getRuleContexts(VelocityContext.class);
		}
		public WidthContext width(int i) {
			return getRuleContext(WidthContext.class,i);
		}
		public ObjectTypeContext objectType() {
			return getRuleContext(ObjectTypeContext.class,0);
		}
		public ObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_object; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterObject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitObject(this);
		}
	}

	public final ObjectContext object() throws RecognitionException {
		ObjectContext _localctx = new ObjectContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_object);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53); objectType();
			setState(54); objectName();
			setState(55); xLoc();
			setState(56); yLoc();
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 6) | (1L << 11))) != 0)) {
				{
				setState(62);
				switch (_input.LA(1)) {
				case 6:
					{
					setState(57); velocity();
					}
					break;
				case 1:
					{
					setState(58); orientation();
					}
					break;
				case 11:
					{
					setState(59); width();
					setState(60); height();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjectTypeContext extends ParserRuleContext {
		public ObjectTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterObjectType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitObjectType(this);
		}
	}

	public final ObjectTypeContext objectType() throws RecognitionException {
		ObjectTypeContext _localctx = new ObjectTypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_objectType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 5) | (1L << 9) | (1L << 13) | (1L << 14) | (1L << 16) | (1L << 17) | (1L << 18))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjectNameContext extends ParserRuleContext {
		public TerminalNode ID(int i) {
			return getToken(GrammarParser.ID, i);
		}
		public List<TerminalNode> ID() { return getTokens(GrammarParser.ID); }
		public ObjectNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterObjectName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitObjectName(this);
		}
	}

	public final ObjectNameContext objectName() throws RecognitionException {
		ObjectNameContext _localctx = new ObjectNameContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_objectName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69); match(8);
			setState(71); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(70); match(ID);
				}
				}
				setState(73); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class XLocContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(GrammarParser.NUM, 0); }
		public XLocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xLoc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterXLoc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitXLoc(this);
		}
	}

	public final XLocContext xLoc() throws RecognitionException {
		XLocContext _localctx = new XLocContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_xLoc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75); match(2);
			setState(76); match(NUM);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class YLocContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(GrammarParser.NUM, 0); }
		public YLocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yLoc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterYLoc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitYLoc(this);
		}
	}

	public final YLocContext yLoc() throws RecognitionException {
		YLocContext _localctx = new YLocContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_yLoc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78); match(12);
			setState(79); match(NUM);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VelocityContext extends ParserRuleContext {
		public YVelocityContext yVelocity() {
			return getRuleContext(YVelocityContext.class,0);
		}
		public XVelocityContext xVelocity() {
			return getRuleContext(XVelocityContext.class,0);
		}
		public VelocityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_velocity; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterVelocity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitVelocity(this);
		}
	}

	public final VelocityContext velocity() throws RecognitionException {
		VelocityContext _localctx = new VelocityContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_velocity);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81); xVelocity();
			setState(82); yVelocity();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class XVelocityContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(GrammarParser.NUM, 0); }
		public XVelocityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xVelocity; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterXVelocity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitXVelocity(this);
		}
	}

	public final XVelocityContext xVelocity() throws RecognitionException {
		XVelocityContext _localctx = new XVelocityContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_xVelocity);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84); match(6);
			setState(85); match(NUM);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class YVelocityContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(GrammarParser.NUM, 0); }
		public YVelocityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yVelocity; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterYVelocity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitYVelocity(this);
		}
	}

	public final YVelocityContext yVelocity() throws RecognitionException {
		YVelocityContext _localctx = new YVelocityContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_yVelocity);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87); match(15);
			setState(88); match(NUM);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrientationContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(GrammarParser.NUM, 0); }
		public OrientationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orientation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterOrientation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitOrientation(this);
		}
	}

	public final OrientationContext orientation() throws RecognitionException {
		OrientationContext _localctx = new OrientationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_orientation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90); match(1);
			setState(91); match(NUM);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WidthContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(GrammarParser.NUM, 0); }
		public WidthContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_width; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterWidth(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitWidth(this);
		}
	}

	public final WidthContext width() throws RecognitionException {
		WidthContext _localctx = new WidthContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_width);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93); match(11);
			setState(94); match(NUM);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HeightContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(GrammarParser.NUM, 0); }
		public HeightContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_height; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterHeight(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitHeight(this);
		}
	}

	public final HeightContext height() throws RecognitionException {
		HeightContext _localctx = new HeightContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_height);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96); match(19);
			setState(97); match(NUM);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\2\3\31f\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t"+
		"\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2"+
		"\3\2\3\2\7\2$\n\2\f\2\16\2\'\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4"+
		"\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6A\n\6"+
		"\f\6\16\6D\13\6\3\7\3\7\3\b\3\b\6\bJ\n\b\r\b\16\bK\3\t\3\t\3\t\3\n\3\n"+
		"\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3"+
		"\17\3\20\3\20\3\20\3\20\2\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2"+
		"\3\6\7\7\13\13\17\20\22\24\\\2 \3\2\2\2\4*\3\2\2\2\6/\3\2\2\2\b\62\3\2"+
		"\2\2\n\67\3\2\2\2\fE\3\2\2\2\16G\3\2\2\2\20M\3\2\2\2\22P\3\2\2\2\24S\3"+
		"\2\2\2\26V\3\2\2\2\30Y\3\2\2\2\32\\\3\2\2\2\34_\3\2\2\2\36b\3\2\2\2 %"+
		"\5\4\3\2!$\5\n\6\2\"$\7\26\2\2#!\3\2\2\2#\"\3\2\2\2$\'\3\2\2\2%#\3\2\2"+
		"\2%&\3\2\2\2&(\3\2\2\2\'%\3\2\2\2()\7\1\2\2)\3\3\2\2\2*+\7\6\2\2+,\5\16"+
		"\b\2,-\5\6\4\2-.\5\b\5\2.\5\3\2\2\2/\60\7\f\2\2\60\61\7\27\2\2\61\7\3"+
		"\2\2\2\62\63\7\t\2\2\63\64\7\27\2\2\64\65\7\5\2\2\65\66\7\27\2\2\66\t"+
		"\3\2\2\2\678\5\f\7\289\5\16\b\29:\5\20\t\2:B\5\22\n\2;A\5\24\13\2<A\5"+
		"\32\16\2=>\5\34\17\2>?\5\36\20\2?A\3\2\2\2@;\3\2\2\2@<\3\2\2\2@=\3\2\2"+
		"\2AD\3\2\2\2B@\3\2\2\2BC\3\2\2\2C\13\3\2\2\2DB\3\2\2\2EF\t\2\2\2F\r\3"+
		"\2\2\2GI\7\n\2\2HJ\7\30\2\2IH\3\2\2\2JK\3\2\2\2KI\3\2\2\2KL\3\2\2\2L\17"+
		"\3\2\2\2MN\7\4\2\2NO\7\27\2\2O\21\3\2\2\2PQ\7\16\2\2QR\7\27\2\2R\23\3"+
		"\2\2\2ST\5\26\f\2TU\5\30\r\2U\25\3\2\2\2VW\7\b\2\2WX\7\27\2\2X\27\3\2"+
		"\2\2YZ\7\21\2\2Z[\7\27\2\2[\31\3\2\2\2\\]\7\3\2\2]^\7\27\2\2^\33\3\2\2"+
		"\2_`\7\r\2\2`a\7\27\2\2a\35\3\2\2\2bc\7\25\2\2cd\7\27\2\2d\37\3\2\2\2"+
		"\7#%@BK";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}