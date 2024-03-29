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
		T__19=1, T__18=2, T__17=3, T__16=4, T__15=5, T__14=6, T__13=7, T__12=8, 
		T__11=9, T__10=10, T__9=11, T__8=12, T__7=13, T__6=14, T__5=15, T__4=16, 
		T__3=17, T__2=18, T__1=19, T__0=20, FIRE=21, TRIGGER=22, ACTION=23, COMMENT=24, 
		NUM=25, ID=26, WS=27;
	public static final String[] tokenNames = {
		"<INVALID>", "'yVelocity'", "'name'", "'friction1'", "'gravity'", "'board'", 
		"'ball'", "'xVelocity'", "'orientation'", "'='", "'height'", "'x'", "'y'", 
		"'triangleBumper'", "'absorber'", "'squareBumper'", "'leftFlipper'", "'circleBumper'", 
		"'friction2'", "'width'", "'rightFlipper'", "'fire'", "'trigger'", "'action'", 
		"COMMENT", "NUM", "ID", "WS"
	};
	public static final int
		RULE_boardInfo = 0, RULE_board = 1, RULE_gravity = 2, RULE_friction1 = 3, 
		RULE_friction2 = 4, RULE_object = 5, RULE_objectType = 6, RULE_objectName = 7, 
		RULE_xLoc = 8, RULE_yLoc = 9, RULE_xVelocity = 10, RULE_yVelocity = 11, 
		RULE_orientation = 12, RULE_width = 13, RULE_height = 14, RULE_fire = 15, 
		RULE_trigger = 16, RULE_action = 17, RULE_equalSign = 18;
	public static final String[] ruleNames = {
		"boardInfo", "board", "gravity", "friction1", "friction2", "object", "objectType", 
		"objectName", "xLoc", "yLoc", "xVelocity", "yVelocity", "orientation", 
		"width", "height", "fire", "trigger", "action", "equalSign"
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
		public FireContext fire(int i) {
			return getRuleContext(FireContext.class,i);
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
		public List<FireContext> fire() {
			return getRuleContexts(FireContext.class);
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
			setState(38); board();
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 6) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 20) | (1L << FIRE) | (1L << COMMENT))) != 0)) {
				{
				setState(42);
				switch (_input.LA(1)) {
				case 6:
				case 13:
				case 14:
				case 15:
				case 16:
				case 17:
				case 20:
					{
					setState(39); object();
					}
					break;
				case COMMENT:
					{
					setState(40); match(COMMENT);
					}
					break;
				case FIRE:
					{
					setState(41); fire();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(47); match(EOF);
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
		public List<Friction1Context> friction1() {
			return getRuleContexts(Friction1Context.class);
		}
		public ObjectNameContext objectName() {
			return getRuleContext(ObjectNameContext.class,0);
		}
		public Friction2Context friction2(int i) {
			return getRuleContext(Friction2Context.class,i);
		}
		public Friction1Context friction1(int i) {
			return getRuleContext(Friction1Context.class,i);
		}
		public GravityContext gravity(int i) {
			return getRuleContext(GravityContext.class,i);
		}
		public List<Friction2Context> friction2() {
			return getRuleContexts(Friction2Context.class);
		}
		public List<GravityContext> gravity() {
			return getRuleContexts(GravityContext.class);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49); match(5);
			setState(50); objectName();
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==4) {
				{
				{
				setState(51); gravity();
				}
				}
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==3 || _la==18) {
				{
				setState(59);
				switch (_input.LA(1)) {
				case 3:
					{
					setState(57); friction1();
					}
					break;
				case 18:
					{
					setState(58); friction2();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(63);
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

	public static class GravityContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(GrammarParser.NUM, 0); }
		public EqualSignContext equalSign() {
			return getRuleContext(EqualSignContext.class,0);
		}
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
			setState(64); match(4);
			setState(65); equalSign();
			setState(66); match(NUM);
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

	public static class Friction1Context extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(GrammarParser.NUM, 0); }
		public EqualSignContext equalSign() {
			return getRuleContext(EqualSignContext.class,0);
		}
		public Friction1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_friction1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterFriction1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitFriction1(this);
		}
	}

	public final Friction1Context friction1() throws RecognitionException {
		Friction1Context _localctx = new Friction1Context(_ctx, getState());
		enterRule(_localctx, 6, RULE_friction1);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68); match(3);
			setState(69); equalSign();
			setState(70); match(NUM);
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

	public static class Friction2Context extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(GrammarParser.NUM, 0); }
		public EqualSignContext equalSign() {
			return getRuleContext(EqualSignContext.class,0);
		}
		public Friction2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_friction2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterFriction2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitFriction2(this);
		}
	}

	public final Friction2Context friction2() throws RecognitionException {
		Friction2Context _localctx = new Friction2Context(_ctx, getState());
		enterRule(_localctx, 8, RULE_friction2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72); match(18);
			setState(73); equalSign();
			setState(74); match(NUM);
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
		public List<WidthContext> width() {
			return getRuleContexts(WidthContext.class);
		}
		public List<YVelocityContext> yVelocity() {
			return getRuleContexts(YVelocityContext.class);
		}
		public XVelocityContext xVelocity(int i) {
			return getRuleContext(XVelocityContext.class,i);
		}
		public HeightContext height(int i) {
			return getRuleContext(HeightContext.class,i);
		}
		public OrientationContext orientation(int i) {
			return getRuleContext(OrientationContext.class,i);
		}
		public List<XVelocityContext> xVelocity() {
			return getRuleContexts(XVelocityContext.class);
		}
		public WidthContext width(int i) {
			return getRuleContext(WidthContext.class,i);
		}
		public YVelocityContext yVelocity(int i) {
			return getRuleContext(YVelocityContext.class,i);
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
		enterRule(_localctx, 10, RULE_object);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76); objectType();
			setState(77); objectName();
			setState(78); xLoc();
			setState(79); yLoc();
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 7) | (1L << 8) | (1L << 19))) != 0)) {
				{
				setState(87);
				switch (_input.LA(1)) {
				case 7:
					{
					setState(80); xVelocity();
					setState(81); yVelocity();
					}
					break;
				case 8:
					{
					setState(83); orientation();
					}
					break;
				case 19:
					{
					setState(84); width();
					setState(85); height();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(91);
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
		enterRule(_localctx, 12, RULE_objectType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 6) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 20))) != 0)) ) {
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
		public EqualSignContext equalSign() {
			return getRuleContext(EqualSignContext.class,0);
		}
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
		enterRule(_localctx, 14, RULE_objectName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94); match(2);
			setState(95); equalSign();
			setState(97); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(96); match(ID);
				}
				}
				setState(99); 
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
		public EqualSignContext equalSign() {
			return getRuleContext(EqualSignContext.class,0);
		}
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
		enterRule(_localctx, 16, RULE_xLoc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101); match(11);
			setState(102); equalSign();
			setState(103); match(NUM);
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
		public EqualSignContext equalSign() {
			return getRuleContext(EqualSignContext.class,0);
		}
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
		enterRule(_localctx, 18, RULE_yLoc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105); match(12);
			setState(106); equalSign();
			setState(107); match(NUM);
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
		public EqualSignContext equalSign() {
			return getRuleContext(EqualSignContext.class,0);
		}
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
			setState(109); match(7);
			setState(110); equalSign();
			setState(111); match(NUM);
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
		public EqualSignContext equalSign() {
			return getRuleContext(EqualSignContext.class,0);
		}
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
			setState(113); match(1);
			setState(114); equalSign();
			setState(115); match(NUM);
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
		public EqualSignContext equalSign() {
			return getRuleContext(EqualSignContext.class,0);
		}
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
			setState(117); match(8);
			setState(118); equalSign();
			setState(119); match(NUM);
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
		public EqualSignContext equalSign() {
			return getRuleContext(EqualSignContext.class,0);
		}
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
			setState(121); match(19);
			setState(122); equalSign();
			setState(123); match(NUM);
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
		public EqualSignContext equalSign() {
			return getRuleContext(EqualSignContext.class,0);
		}
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
			setState(125); match(10);
			setState(126); equalSign();
			setState(127); match(NUM);
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

	public static class FireContext extends ParserRuleContext {
		public TriggerContext trigger() {
			return getRuleContext(TriggerContext.class,0);
		}
		public TerminalNode FIRE() { return getToken(GrammarParser.FIRE, 0); }
		public ActionContext action() {
			return getRuleContext(ActionContext.class,0);
		}
		public EqualSignContext equalSign(int i) {
			return getRuleContext(EqualSignContext.class,i);
		}
		public TerminalNode ACTION() { return getToken(GrammarParser.ACTION, 0); }
		public List<EqualSignContext> equalSign() {
			return getRuleContexts(EqualSignContext.class);
		}
		public TerminalNode TRIGGER() { return getToken(GrammarParser.TRIGGER, 0); }
		public FireContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fire; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterFire(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitFire(this);
		}
	}

	public final FireContext fire() throws RecognitionException {
		FireContext _localctx = new FireContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_fire);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129); match(FIRE);
			setState(130); match(TRIGGER);
			setState(131); equalSign();
			setState(132); trigger();
			setState(133); match(ACTION);
			setState(134); equalSign();
			setState(135); action();
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

	public static class TriggerContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public TriggerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trigger; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterTrigger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitTrigger(this);
		}
	}

	public final TriggerContext trigger() throws RecognitionException {
		TriggerContext _localctx = new TriggerContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_trigger);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137); match(ID);
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

	public static class ActionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public ActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitAction(this);
		}
	}

	public final ActionContext action() throws RecognitionException {
		ActionContext _localctx = new ActionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_action);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139); match(ID);
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

	public static class EqualSignContext extends ParserRuleContext {
		public EqualSignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalSign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterEqualSign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitEqualSign(this);
		}
	}

	public final EqualSignContext equalSign() throws RecognitionException {
		EqualSignContext _localctx = new EqualSignContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_equalSign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141); match(9);
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
		"\2\3\35\u0092\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b"+
		"\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t"+
		"\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\7\2-\n\2\f"+
		"\2\16\2\60\13\2\3\2\3\2\3\3\3\3\3\3\7\3\67\n\3\f\3\16\3:\13\3\3\3\3\3"+
		"\7\3>\n\3\f\3\16\3A\13\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7Z\n\7\f\7\16\7]\13\7"+
		"\3\b\3\b\3\t\3\t\3\t\6\td\n\t\r\t\16\te\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3"+
		"\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\22\3\22\3\23\3\23\3\24\3\24\3\24\2\25\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&\2\3\5\b\b\17\23\26\26\u0088\2(\3\2\2\2\4\63\3\2\2\2\6B\3\2"+
		"\2\2\bF\3\2\2\2\nJ\3\2\2\2\fN\3\2\2\2\16^\3\2\2\2\20`\3\2\2\2\22g\3\2"+
		"\2\2\24k\3\2\2\2\26o\3\2\2\2\30s\3\2\2\2\32w\3\2\2\2\34{\3\2\2\2\36\177"+
		"\3\2\2\2 \u0083\3\2\2\2\"\u008b\3\2\2\2$\u008d\3\2\2\2&\u008f\3\2\2\2"+
		"(.\5\4\3\2)-\5\f\7\2*-\7\32\2\2+-\5 \21\2,)\3\2\2\2,*\3\2\2\2,+\3\2\2"+
		"\2-\60\3\2\2\2.,\3\2\2\2./\3\2\2\2/\61\3\2\2\2\60.\3\2\2\2\61\62\7\1\2"+
		"\2\62\3\3\2\2\2\63\64\7\7\2\2\648\5\20\t\2\65\67\5\6\4\2\66\65\3\2\2\2"+
		"\67:\3\2\2\28\66\3\2\2\289\3\2\2\29?\3\2\2\2:8\3\2\2\2;>\5\b\5\2<>\5\n"+
		"\6\2=;\3\2\2\2=<\3\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@\5\3\2\2\2A?\3"+
		"\2\2\2BC\7\6\2\2CD\5&\24\2DE\7\33\2\2E\7\3\2\2\2FG\7\5\2\2GH\5&\24\2H"+
		"I\7\33\2\2I\t\3\2\2\2JK\7\24\2\2KL\5&\24\2LM\7\33\2\2M\13\3\2\2\2NO\5"+
		"\16\b\2OP\5\20\t\2PQ\5\22\n\2Q[\5\24\13\2RS\5\26\f\2ST\5\30\r\2TZ\3\2"+
		"\2\2UZ\5\32\16\2VW\5\34\17\2WX\5\36\20\2XZ\3\2\2\2YR\3\2\2\2YU\3\2\2\2"+
		"YV\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\\r\3\2\2\2][\3\2\2\2^_\t\2"+
		"\2\2_\17\3\2\2\2`a\7\4\2\2ac\5&\24\2bd\7\34\2\2cb\3\2\2\2de\3\2\2\2ec"+
		"\3\2\2\2ef\3\2\2\2f\21\3\2\2\2gh\7\r\2\2hi\5&\24\2ij\7\33\2\2j\23\3\2"+
		"\2\2kl\7\16\2\2lm\5&\24\2mn\7\33\2\2n\25\3\2\2\2op\7\t\2\2pq\5&\24\2q"+
		"r\7\33\2\2r\27\3\2\2\2st\7\3\2\2tu\5&\24\2uv\7\33\2\2v\31\3\2\2\2wx\7"+
		"\n\2\2xy\5&\24\2yz\7\33\2\2z\33\3\2\2\2{|\7\25\2\2|}\5&\24\2}~\7\33\2"+
		"\2~\35\3\2\2\2\177\u0080\7\f\2\2\u0080\u0081\5&\24\2\u0081\u0082\7\33"+
		"\2\2\u0082\37\3\2\2\2\u0083\u0084\7\27\2\2\u0084\u0085\7\30\2\2\u0085"+
		"\u0086\5&\24\2\u0086\u0087\5\"\22\2\u0087\u0088\7\31\2\2\u0088\u0089\5"+
		"&\24\2\u0089\u008a\5$\23\2\u008a!\3\2\2\2\u008b\u008c\7\34\2\2\u008c#"+
		"\3\2\2\2\u008d\u008e\7\34\2\2\u008e%\3\2\2\2\u008f\u0090\7\13\2\2\u0090"+
		"\'\3\2\2\2\n,.8=?Y[e";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}