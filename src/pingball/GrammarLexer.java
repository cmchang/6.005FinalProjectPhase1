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
		T__21=1, T__20=2, T__19=3, T__18=4, T__17=5, T__16=6, T__15=7, T__14=8, 
		T__13=9, T__12=10, T__11=11, T__10=12, T__9=13, T__8=14, T__7=15, T__6=16, 
		T__5=17, T__4=18, T__3=19, T__2=20, T__1=21, T__0=22, COMMENT=23, NUM=24, 
		ID=25, WS=26;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'orientation='", "'trigger='", "'x='", "'friction2='", "'board'", "'ball'", 
		"'xVelocity='", "'action='", "'friction1='", "'name='", "'triangleBumper'", 
		"'fire'", "'gravity='", "'width='", "'y='", "'absorber'", "'squareBumper'", 
		"'yVelocity='", "'leftFlipper'", "'circleBumper'", "'rightFlipper'", "'height='", 
		"COMMENT", "NUM", "ID", "WS"
	};
	public static final String[] ruleNames = {
		"T__21", "T__20", "T__19", "T__18", "T__17", "T__16", "T__15", "T__14", 
		"T__13", "T__12", "T__11", "T__10", "T__9", "T__8", "T__7", "T__6", "T__5", 
		"T__4", "T__3", "T__2", "T__1", "T__0", "COMMENT", "NUM", "ID", "WS"
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
		case 22: COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 25: WS_action((RuleContext)_localctx, actionIndex); break;
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
		"\2\4\34\u012e\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b"+
		"\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\7\30\u0103\n\30"+
		"\f\30\16\30\u0106\13\30\3\30\3\30\3\31\5\31\u010b\n\31\3\31\6\31\u010e"+
		"\n\31\r\31\16\31\u010f\3\31\3\31\7\31\u0114\n\31\f\31\16\31\u0117\13\31"+
		"\3\31\5\31\u011a\n\31\3\31\6\31\u011d\n\31\r\31\16\31\u011e\5\31\u0121"+
		"\n\31\3\32\6\32\u0124\n\32\r\32\16\32\u0125\3\33\6\33\u0129\n\33\r\33"+
		"\16\33\u012a\3\33\3\33\2\34\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t"+
		"\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1"+
		"#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\2\61\32\1\63\33\1\65\34\3\3"+
		"\2\b\4\f\f\17\17\3\62;\3\62;\3\62;\6\62;C\\aac|\5\13\f\17\17\"\"\u0136"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\3\67\3\2\2\2\5D\3\2\2\2\7M\3"+
		"\2\2\2\tP\3\2\2\2\13[\3\2\2\2\ra\3\2\2\2\17f\3\2\2\2\21q\3\2\2\2\23y\3"+
		"\2\2\2\25\u0084\3\2\2\2\27\u008a\3\2\2\2\31\u0099\3\2\2\2\33\u009e\3\2"+
		"\2\2\35\u00a7\3\2\2\2\37\u00ae\3\2\2\2!\u00b1\3\2\2\2#\u00ba\3\2\2\2%"+
		"\u00c7\3\2\2\2\'\u00d2\3\2\2\2)\u00de\3\2\2\2+\u00eb\3\2\2\2-\u00f8\3"+
		"\2\2\2/\u0100\3\2\2\2\61\u010a\3\2\2\2\63\u0123\3\2\2\2\65\u0128\3\2\2"+
		"\2\678\7q\2\289\7t\2\29:\7k\2\2:;\7g\2\2;<\7p\2\2<=\7v\2\2=>\7c\2\2>?"+
		"\7v\2\2?@\7k\2\2@A\7q\2\2AB\7p\2\2BC\7?\2\2C\4\3\2\2\2DE\7v\2\2EF\7t\2"+
		"\2FG\7k\2\2GH\7i\2\2HI\7i\2\2IJ\7g\2\2JK\7t\2\2KL\7?\2\2L\6\3\2\2\2MN"+
		"\7z\2\2NO\7?\2\2O\b\3\2\2\2PQ\7h\2\2QR\7t\2\2RS\7k\2\2ST\7e\2\2TU\7v\2"+
		"\2UV\7k\2\2VW\7q\2\2WX\7p\2\2XY\7\64\2\2YZ\7?\2\2Z\n\3\2\2\2[\\\7d\2\2"+
		"\\]\7q\2\2]^\7c\2\2^_\7t\2\2_`\7f\2\2`\f\3\2\2\2ab\7d\2\2bc\7c\2\2cd\7"+
		"n\2\2de\7n\2\2e\16\3\2\2\2fg\7z\2\2gh\7X\2\2hi\7g\2\2ij\7n\2\2jk\7q\2"+
		"\2kl\7e\2\2lm\7k\2\2mn\7v\2\2no\7{\2\2op\7?\2\2p\20\3\2\2\2qr\7c\2\2r"+
		"s\7e\2\2st\7v\2\2tu\7k\2\2uv\7q\2\2vw\7p\2\2wx\7?\2\2x\22\3\2\2\2yz\7"+
		"h\2\2z{\7t\2\2{|\7k\2\2|}\7e\2\2}~\7v\2\2~\177\7k\2\2\177\u0080\7q\2\2"+
		"\u0080\u0081\7p\2\2\u0081\u0082\7\63\2\2\u0082\u0083\7?\2\2\u0083\24\3"+
		"\2\2\2\u0084\u0085\7p\2\2\u0085\u0086\7c\2\2\u0086\u0087\7o\2\2\u0087"+
		"\u0088\7g\2\2\u0088\u0089\7?\2\2\u0089\26\3\2\2\2\u008a\u008b\7v\2\2\u008b"+
		"\u008c\7t\2\2\u008c\u008d\7k\2\2\u008d\u008e\7c\2\2\u008e\u008f\7p\2\2"+
		"\u008f\u0090\7i\2\2\u0090\u0091\7n\2\2\u0091\u0092\7g\2\2\u0092\u0093"+
		"\7D\2\2\u0093\u0094\7w\2\2\u0094\u0095\7o\2\2\u0095\u0096\7r\2\2\u0096"+
		"\u0097\7g\2\2\u0097\u0098\7t\2\2\u0098\30\3\2\2\2\u0099\u009a\7h\2\2\u009a"+
		"\u009b\7k\2\2\u009b\u009c\7t\2\2\u009c\u009d\7g\2\2\u009d\32\3\2\2\2\u009e"+
		"\u009f\7i\2\2\u009f\u00a0\7t\2\2\u00a0\u00a1\7c\2\2\u00a1\u00a2\7x\2\2"+
		"\u00a2\u00a3\7k\2\2\u00a3\u00a4\7v\2\2\u00a4\u00a5\7{\2\2\u00a5\u00a6"+
		"\7?\2\2\u00a6\34\3\2\2\2\u00a7\u00a8\7y\2\2\u00a8\u00a9\7k\2\2\u00a9\u00aa"+
		"\7f\2\2\u00aa\u00ab\7v\2\2\u00ab\u00ac\7j\2\2\u00ac\u00ad\7?\2\2\u00ad"+
		"\36\3\2\2\2\u00ae\u00af\7{\2\2\u00af\u00b0\7?\2\2\u00b0 \3\2\2\2\u00b1"+
		"\u00b2\7c\2\2\u00b2\u00b3\7d\2\2\u00b3\u00b4\7u\2\2\u00b4\u00b5\7q\2\2"+
		"\u00b5\u00b6\7t\2\2\u00b6\u00b7\7d\2\2\u00b7\u00b8\7g\2\2\u00b8\u00b9"+
		"\7t\2\2\u00b9\"\3\2\2\2\u00ba\u00bb\7u\2\2\u00bb\u00bc\7s\2\2\u00bc\u00bd"+
		"\7w\2\2\u00bd\u00be\7c\2\2\u00be\u00bf\7t\2\2\u00bf\u00c0\7g\2\2\u00c0"+
		"\u00c1\7D\2\2\u00c1\u00c2\7w\2\2\u00c2\u00c3\7o\2\2\u00c3\u00c4\7r\2\2"+
		"\u00c4\u00c5\7g\2\2\u00c5\u00c6\7t\2\2\u00c6$\3\2\2\2\u00c7\u00c8\7{\2"+
		"\2\u00c8\u00c9\7X\2\2\u00c9\u00ca\7g\2\2\u00ca\u00cb\7n\2\2\u00cb\u00cc"+
		"\7q\2\2\u00cc\u00cd\7e\2\2\u00cd\u00ce\7k\2\2\u00ce\u00cf\7v\2\2\u00cf"+
		"\u00d0\7{\2\2\u00d0\u00d1\7?\2\2\u00d1&\3\2\2\2\u00d2\u00d3\7n\2\2\u00d3"+
		"\u00d4\7g\2\2\u00d4\u00d5\7h\2\2\u00d5\u00d6\7v\2\2\u00d6\u00d7\7H\2\2"+
		"\u00d7\u00d8\7n\2\2\u00d8\u00d9\7k\2\2\u00d9\u00da\7r\2\2\u00da\u00db"+
		"\7r\2\2\u00db\u00dc\7g\2\2\u00dc\u00dd\7t\2\2\u00dd(\3\2\2\2\u00de\u00df"+
		"\7e\2\2\u00df\u00e0\7k\2\2\u00e0\u00e1\7t\2\2\u00e1\u00e2\7e\2\2\u00e2"+
		"\u00e3\7n\2\2\u00e3\u00e4\7g\2\2\u00e4\u00e5\7D\2\2\u00e5\u00e6\7w\2\2"+
		"\u00e6\u00e7\7o\2\2\u00e7\u00e8\7r\2\2\u00e8\u00e9\7g\2\2\u00e9\u00ea"+
		"\7t\2\2\u00ea*\3\2\2\2\u00eb\u00ec\7t\2\2\u00ec\u00ed\7k\2\2\u00ed\u00ee"+
		"\7i\2\2\u00ee\u00ef\7j\2\2\u00ef\u00f0\7v\2\2\u00f0\u00f1\7H\2\2\u00f1"+
		"\u00f2\7n\2\2\u00f2\u00f3\7k\2\2\u00f3\u00f4\7r\2\2\u00f4\u00f5\7r\2\2"+
		"\u00f5\u00f6\7g\2\2\u00f6\u00f7\7t\2\2\u00f7,\3\2\2\2\u00f8\u00f9\7j\2"+
		"\2\u00f9\u00fa\7g\2\2\u00fa\u00fb\7k\2\2\u00fb\u00fc\7i\2\2\u00fc\u00fd"+
		"\7j\2\2\u00fd\u00fe\7v\2\2\u00fe\u00ff\7?\2\2\u00ff.\3\2\2\2\u0100\u0104"+
		"\7%\2\2\u0101\u0103\n\2\2\2\u0102\u0101\3\2\2\2\u0103\u0106\3\2\2\2\u0104"+
		"\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0107\3\2\2\2\u0106\u0104\3\2"+
		"\2\2\u0107\u0108\b\30\2\2\u0108\60\3\2\2\2\u0109\u010b\7/\2\2\u010a\u0109"+
		"\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u0120\3\2\2\2\u010c\u010e\t\3\2\2\u010d"+
		"\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2"+
		"\2\2\u0110\u0111\3\2\2\2\u0111\u0115\7\60\2\2\u0112\u0114\t\4\2\2\u0113"+
		"\u0112\3\2\2\2\u0114\u0117\3\2\2\2\u0115\u0113\3\2\2\2\u0115\u0116\3\2"+
		"\2\2\u0116\u0121\3\2\2\2\u0117\u0115\3\2\2\2\u0118\u011a\7\60\2\2\u0119"+
		"\u0118\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011c\3\2\2\2\u011b\u011d\t\5"+
		"\2\2\u011c\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u011c\3\2\2\2\u011e"+
		"\u011f\3\2\2\2\u011f\u0121\3\2\2\2\u0120\u010d\3\2\2\2\u0120\u0119\3\2"+
		"\2\2\u0121\62\3\2\2\2\u0122\u0124\t\6\2\2\u0123\u0122\3\2\2\2\u0124\u0125"+
		"\3\2\2\2\u0125\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126\64\3\2\2\2\u0127"+
		"\u0129\t\7\2\2\u0128\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u0128\3\2"+
		"\2\2\u012a\u012b\3\2\2\2\u012b\u012c\3\2\2\2\u012c\u012d\b\33\3\2\u012d"+
		"\66\3\2\2\2\r\2\u0104\u010a\u010f\u0115\u0119\u011e\u0120\u0123\u0125"+
		"\u012a";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}