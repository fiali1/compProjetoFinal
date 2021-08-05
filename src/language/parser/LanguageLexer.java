// Generated from Language.g4 by ANTLR 4.7.1
package language.parser;

    import language.dataStructures.Symbol;
    import language.dataStructures.SymbolTable;
    import language.dataStructures.Variable;
    import language.exceptions.SemanticException;
    import language.ast.Program;
    import language.ast.AbstractCommand;
    import language.ast.ReadCommand;
    import language.ast.WriteCommand;
    import language.ast.AssignementCommand;
    import language.ast.DecisionCommand;
    import java.util.ArrayList;
    import java.util.Stack;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LanguageLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, P1=9, 
		P2=10, C1=11, C2=12, V=13, PV=14, Esp=15, Operador=16, Relacional=17, 
		Atributo=18, Id=19, Numero=20, Texto=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "P1", 
		"P2", "C1", "C2", "V", "PV", "Esp", "Operador", "Relacional", "Atributo", 
		"Id", "Numero", "Texto"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'inicio'", "'fim;'", "'Numero'", "'Texto'", "'ler'", "'escrever'", 
		"'se'", "'senao'", "'('", "')'", "'{'", "'}'", "','", "';'", null, null, 
		null, "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, "P1", "P2", "C1", 
		"C2", "V", "PV", "Esp", "Operador", "Relacional", "Atributo", "Id", "Numero", 
		"Texto"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	    private int _tipo;
	    private String _varNome;
	    private String _varValor;
	    private Symbol simbolo;
	    private SymbolTable tabela                      = new SymbolTable();
	    private Program programa                        = new Program();
	    private ArrayList<AbstractCommand> threadAtual;
	    private Stack<ArrayList<AbstractCommand>> pilha = new Stack<ArrayList<AbstractCommand>>();

	    private String _lerId;
	    private String _escreverId;
	    private String _expressaoId;
	    private String _expressaoConteudo;
	    private String _expressaoDecisao;
	    private ArrayList<AbstractCommand> listaVerdadeiro;
	    private ArrayList<AbstractCommand> listaFalso;

	    public void verificaId(String id) {
	        if (!tabela.exists(id)) {
	            throw new SemanticException("Symbol (" + id + ") doesn't exist");
	        }
	    };

	    public void exibeComandos() {
	        for (AbstractCommand c: programa.getCommands()) {
	            System.out.println(c);
	        }

	    }

	    public void gerarCodigo() {
	        programa.generateTarget();
	    }


	public LanguageLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Language.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\27\u0099\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3"+
		"\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\5\22y\n\22\3\23\3\23\3\24\3\24\7\24\177\n\24\f\24\16"+
		"\24\u0082\13\24\3\25\6\25\u0085\n\25\r\25\16\25\u0086\3\25\3\25\6\25\u008b"+
		"\n\25\r\25\16\25\u008c\5\25\u008f\n\25\3\26\3\26\7\26\u0093\n\26\f\26"+
		"\16\26\u0096\13\26\3\26\3\26\2\2\27\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27\3\2"+
		"\7\5\2\13\f\17\17\"\"\5\2,-//\61\61\3\2c|\5\2\62;C\\c|\3\2\62;\2\u00a2"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\3-\3\2\2\2\5\64\3\2"+
		"\2\2\79\3\2\2\2\t@\3\2\2\2\13F\3\2\2\2\rJ\3\2\2\2\17S\3\2\2\2\21V\3\2"+
		"\2\2\23\\\3\2\2\2\25^\3\2\2\2\27`\3\2\2\2\31b\3\2\2\2\33d\3\2\2\2\35f"+
		"\3\2\2\2\37h\3\2\2\2!l\3\2\2\2#x\3\2\2\2%z\3\2\2\2\'|\3\2\2\2)\u0084\3"+
		"\2\2\2+\u0090\3\2\2\2-.\7k\2\2./\7p\2\2/\60\7k\2\2\60\61\7e\2\2\61\62"+
		"\7k\2\2\62\63\7q\2\2\63\4\3\2\2\2\64\65\7h\2\2\65\66\7k\2\2\66\67\7o\2"+
		"\2\678\7=\2\28\6\3\2\2\29:\7P\2\2:;\7w\2\2;<\7o\2\2<=\7g\2\2=>\7t\2\2"+
		">?\7q\2\2?\b\3\2\2\2@A\7V\2\2AB\7g\2\2BC\7z\2\2CD\7v\2\2DE\7q\2\2E\n\3"+
		"\2\2\2FG\7n\2\2GH\7g\2\2HI\7t\2\2I\f\3\2\2\2JK\7g\2\2KL\7u\2\2LM\7e\2"+
		"\2MN\7t\2\2NO\7g\2\2OP\7x\2\2PQ\7g\2\2QR\7t\2\2R\16\3\2\2\2ST\7u\2\2T"+
		"U\7g\2\2U\20\3\2\2\2VW\7u\2\2WX\7g\2\2XY\7p\2\2YZ\7c\2\2Z[\7q\2\2[\22"+
		"\3\2\2\2\\]\7*\2\2]\24\3\2\2\2^_\7+\2\2_\26\3\2\2\2`a\7}\2\2a\30\3\2\2"+
		"\2bc\7\177\2\2c\32\3\2\2\2de\7.\2\2e\34\3\2\2\2fg\7=\2\2g\36\3\2\2\2h"+
		"i\t\2\2\2ij\3\2\2\2jk\b\20\2\2k \3\2\2\2lm\t\3\2\2m\"\3\2\2\2ny\7@\2\2"+
		"op\7@\2\2py\7?\2\2qy\7>\2\2rs\7>\2\2sy\7?\2\2tu\7?\2\2uy\7?\2\2vw\7#\2"+
		"\2wy\7?\2\2xn\3\2\2\2xo\3\2\2\2xq\3\2\2\2xr\3\2\2\2xt\3\2\2\2xv\3\2\2"+
		"\2y$\3\2\2\2z{\7?\2\2{&\3\2\2\2|\u0080\t\4\2\2}\177\t\5\2\2~}\3\2\2\2"+
		"\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081(\3\2\2\2\u0082"+
		"\u0080\3\2\2\2\u0083\u0085\t\6\2\2\u0084\u0083\3\2\2\2\u0085\u0086\3\2"+
		"\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u008e\3\2\2\2\u0088"+
		"\u008a\7\60\2\2\u0089\u008b\t\6\2\2\u008a\u0089\3\2\2\2\u008b\u008c\3"+
		"\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008f\3\2\2\2\u008e"+
		"\u0088\3\2\2\2\u008e\u008f\3\2\2\2\u008f*\3\2\2\2\u0090\u0094\7$\2\2\u0091"+
		"\u0093\t\5\2\2\u0092\u0091\3\2\2\2\u0093\u0096\3\2\2\2\u0094\u0092\3\2"+
		"\2\2\u0094\u0095\3\2\2\2\u0095\u0097\3\2\2\2\u0096\u0094\3\2\2\2\u0097"+
		"\u0098\7$\2\2\u0098,\3\2\2\2\13\2x~\u0080\u0086\u008c\u008e\u0092\u0094"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}