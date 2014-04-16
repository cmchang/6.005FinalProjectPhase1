// Generated from Grammar.g4 by ANTLR 4.0

package pingball;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__18=1, T__17=2, T__16=3, T__15=4, T__14=5, T__13=6, T__12=7, T__11=8, 
		T__10=9, T__9=10, T__8=11, T__7=12, T__6=13, T__5=14, T__4=15, T__3=16, 
		T__2=17, T__1=18, T__0=19, COMMENT=20, NUM=21, ID=22, WS=23;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'orientation='", "'x='", "'friction2='", "'board'", "'ball'", "'xVelocity='", 
		"'friction1='", "'name='", "'triangleBumper'", "'gravity='", "'width='", 
		"'y='", "'absorber'", "'squareBumper'", "'yVelocity='", "'leftFlipper'", 
		"'circleBumper'", "'rightFlipper'", "'height='", "COMMENT", "NUM", "ID", 
		"WS"
	};
	public static final String[] ruleNames = {
		"T__18", "T__17", "T__16", "T__15", "T__14", "T__13", "T__12", "T__11", 
		"T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", 
		"T__1", "T__0", "COMMENT", "NUM", "ID", "WS"
	};


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


	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 19: COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 22: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: skip();  break;
		}
	}
	private void COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\2\4\31\u0112\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b"+
		"\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3"+
		"\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\7\25\u00e7"+
		"\n\25\f\25\16\25\u00ea\13\25\3\25\3\25\3\26\5\26\u00ef\n\26\3\26\6\26"+
		"\u00f2\n\26\r\26\16\26\u00f3\3\26\3\26\7\26\u00f8\n\26\f\26\16\26\u00fb"+
		"\13\26\3\26\5\26\u00fe\n\26\3\26\6\26\u0101\n\26\r\26\16\26\u0102\5\26"+
		"\u0105\n\26\3\27\6\27\u0108\n\27\r\27\16\27\u0109\3\30\6\30\u010d\n\30"+
		"\r\30\16\30\u010e\3\30\3\30\2\31\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1"+
		"\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!"+
		"\22\1#\23\1%\24\1\'\25\1)\26\2+\27\1-\30\1/\31\3\3\2\b\4\f\f\17\17\3\62"+
		";\3\62;\3\62;\6\62;C\\aac|\5\13\f\17\17\"\"\u011a\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\3\61\3\2\2\2\5>\3\2"+
		"\2\2\7A\3\2\2\2\tL\3\2\2\2\13R\3\2\2\2\rW\3\2\2\2\17b\3\2\2\2\21m\3\2"+
		"\2\2\23s\3\2\2\2\25\u0082\3\2\2\2\27\u008b\3\2\2\2\31\u0092\3\2\2\2\33"+
		"\u0095\3\2\2\2\35\u009e\3\2\2\2\37\u00ab\3\2\2\2!\u00b6\3\2\2\2#\u00c2"+
		"\3\2\2\2%\u00cf\3\2\2\2\'\u00dc\3\2\2\2)\u00e4\3\2\2\2+\u00ee\3\2\2\2"+
		"-\u0107\3\2\2\2/\u010c\3\2\2\2\61\62\7q\2\2\62\63\7t\2\2\63\64\7k\2\2"+
		"\64\65\7g\2\2\65\66\7p\2\2\66\67\7v\2\2\678\7c\2\289\7v\2\29:\7k\2\2:"+
		";\7q\2\2;<\7p\2\2<=\7?\2\2=\4\3\2\2\2>?\7z\2\2?@\7?\2\2@\6\3\2\2\2AB\7"+
		"h\2\2BC\7t\2\2CD\7k\2\2DE\7e\2\2EF\7v\2\2FG\7k\2\2GH\7q\2\2HI\7p\2\2I"+
		"J\7\64\2\2JK\7?\2\2K\b\3\2\2\2LM\7d\2\2MN\7q\2\2NO\7c\2\2OP\7t\2\2PQ\7"+
		"f\2\2Q\n\3\2\2\2RS\7d\2\2ST\7c\2\2TU\7n\2\2UV\7n\2\2V\f\3\2\2\2WX\7z\2"+
		"\2XY\7X\2\2YZ\7g\2\2Z[\7n\2\2[\\\7q\2\2\\]\7e\2\2]^\7k\2\2^_\7v\2\2_`"+
		"\7{\2\2`a\7?\2\2a\16\3\2\2\2bc\7h\2\2cd\7t\2\2de\7k\2\2ef\7e\2\2fg\7v"+
		"\2\2gh\7k\2\2hi\7q\2\2ij\7p\2\2jk\7\63\2\2kl\7?\2\2l\20\3\2\2\2mn\7p\2"+
		"\2no\7c\2\2op\7o\2\2pq\7g\2\2qr\7?\2\2r\22\3\2\2\2st\7v\2\2tu\7t\2\2u"+
		"v\7k\2\2vw\7c\2\2wx\7p\2\2xy\7i\2\2yz\7n\2\2z{\7g\2\2{|\7D\2\2|}\7w\2"+
		"\2}~\7o\2\2~\177\7r\2\2\177\u0080\7g\2\2\u0080\u0081\7t\2\2\u0081\24\3"+
		"\2\2\2\u0082\u0083\7i\2\2\u0083\u0084\7t\2\2\u0084\u0085\7c\2\2\u0085"+
		"\u0086\7x\2\2\u0086\u0087\7k\2\2\u0087\u0088\7v\2\2\u0088\u0089\7{\2\2"+
		"\u0089\u008a\7?\2\2\u008a\26\3\2\2\2\u008b\u008c\7y\2\2\u008c\u008d\7"+
		"k\2\2\u008d\u008e\7f\2\2\u008e\u008f\7v\2\2\u008f\u0090\7j\2\2\u0090\u0091"+
		"\7?\2\2\u0091\30\3\2\2\2\u0092\u0093\7{\2\2\u0093\u0094\7?\2\2\u0094\32"+
		"\3\2\2\2\u0095\u0096\7c\2\2\u0096\u0097\7d\2\2\u0097\u0098\7u\2\2\u0098"+
		"\u0099\7q\2\2\u0099\u009a\7t\2\2\u009a\u009b\7d\2\2\u009b\u009c\7g\2\2"+
		"\u009c\u009d\7t\2\2\u009d\34\3\2\2\2\u009e\u009f\7u\2\2\u009f\u00a0\7"+
		"s\2\2\u00a0\u00a1\7w\2\2\u00a1\u00a2\7c\2\2\u00a2\u00a3\7t\2\2\u00a3\u00a4"+
		"\7g\2\2\u00a4\u00a5\7D\2\2\u00a5\u00a6\7w\2\2\u00a6\u00a7\7o\2\2\u00a7"+
		"\u00a8\7r\2\2\u00a8\u00a9\7g\2\2\u00a9\u00aa\7t\2\2\u00aa\36\3\2\2\2\u00ab"+
		"\u00ac\7{\2\2\u00ac\u00ad\7X\2\2\u00ad\u00ae\7g\2\2\u00ae\u00af\7n\2\2"+
		"\u00af\u00b0\7q\2\2\u00b0\u00b1\7e\2\2\u00b1\u00b2\7k\2\2\u00b2\u00b3"+
		"\7v\2\2\u00b3\u00b4\7{\2\2\u00b4\u00b5\7?\2\2\u00b5 \3\2\2\2\u00b6\u00b7"+
		"\7n\2\2\u00b7\u00b8\7g\2\2\u00b8\u00b9\7h\2\2\u00b9\u00ba\7v\2\2\u00ba"+
		"\u00bb\7H\2\2\u00bb\u00bc\7n\2\2\u00bc\u00bd\7k\2\2\u00bd\u00be\7r\2\2"+
		"\u00be\u00bf\7r\2\2\u00bf\u00c0\7g\2\2\u00c0\u00c1\7t\2\2\u00c1\"\3\2"+
		"\2\2\u00c2\u00c3\7e\2\2\u00c3\u00c4\7k\2\2\u00c4\u00c5\7t\2\2\u00c5\u00c6"+
		"\7e\2\2\u00c6\u00c7\7n\2\2\u00c7\u00c8\7g\2\2\u00c8\u00c9\7D\2\2\u00c9"+
		"\u00ca\7w\2\2\u00ca\u00cb\7o\2\2\u00cb\u00cc\7r\2\2\u00cc\u00cd\7g\2\2"+
		"\u00cd\u00ce\7t\2\2\u00ce$\3\2\2\2\u00cf\u00d0\7t\2\2\u00d0\u00d1\7k\2"+
		"\2\u00d1\u00d2\7i\2\2\u00d2\u00d3\7j\2\2\u00d3\u00d4\7v\2\2\u00d4\u00d5"+
		"\7H\2\2\u00d5\u00d6\7n\2\2\u00d6\u00d7\7k\2\2\u00d7\u00d8\7r\2\2\u00d8"+
		"\u00d9\7r\2\2\u00d9\u00da\7g\2\2\u00da\u00db\7t\2\2\u00db&\3\2\2\2\u00dc"+
		"\u00dd\7j\2\2\u00dd\u00de\7g\2\2\u00de\u00df\7k\2\2\u00df\u00e0\7i\2\2"+
		"\u00e0\u00e1\7j\2\2\u00e1\u00e2\7v\2\2\u00e2\u00e3\7?\2\2\u00e3(\3\2\2"+
		"\2\u00e4\u00e8\7%\2\2\u00e5\u00e7\n\2\2\2\u00e6\u00e5\3\2\2\2\u00e7\u00ea"+
		"\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00eb\3\2\2\2\u00ea"+
		"\u00e8\3\2\2\2\u00eb\u00ec\b\25\2\2\u00ec*\3\2\2\2\u00ed\u00ef\7/\2\2"+
		"\u00ee\u00ed\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u0104\3\2\2\2\u00f0\u00f2"+
		"\t\3\2\2\u00f1\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3"+
		"\u00f4\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f9\7\60\2\2\u00f6\u00f8\t"+
		"\4\2\2\u00f7\u00f6\3\2\2\2\u00f8\u00fb\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9"+
		"\u00fa\3\2\2\2\u00fa\u0105\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fc\u00fe\7\60"+
		"\2\2\u00fd\u00fc\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u0100\3\2\2\2\u00ff"+
		"\u0101\t\5\2\2\u0100\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0100\3\2"+
		"\2\2\u0102\u0103\3\2\2\2\u0103\u0105\3\2\2\2\u0104\u00f1\3\2\2\2\u0104"+
		"\u00fd\3\2\2\2\u0105,\3\2\2\2\u0106\u0108\t\6\2\2\u0107\u0106\3\2\2\2"+
		"\u0108\u0109\3\2\2\2\u0109\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010a.\3"+
		"\2\2\2\u010b\u010d\t\7\2\2\u010c\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e"+
		"\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0111\b\30"+
		"\3\2\u0111\60\3\2\2\2\r\2\u00e8\u00ee\u00f3\u00f9\u00fd\u0102\u0104\u0107"+
		"\u0109\u010e";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}