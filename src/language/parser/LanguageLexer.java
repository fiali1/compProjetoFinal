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
    import language.ast.LoopCommand;
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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, P1=13, P2=14, C1=15, C2=16, V=17, PV=18, 
		Esp=19, Operador=20, OperadorAttribuicao=21, Relacional=22, Atributo=23, 
		Id=24, Fracionado=25, Inteiro=26, Texto=27, Caractere=28;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "P1", "P2", "C1", "C2", "V", "PV", "Esp", "Operador", 
		"OperadorAttribuicao", "Relacional", "Atributo", "Id", "Fracionado", "Inteiro", 
		"Texto", "Caractere"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'inicio'", "'fim;'", "'Caractere'", "'Texto'", "'Inteiro'", "'Fracionado'", 
		"'ler'", "'escrever'", "'se'", "'senao'", "'faca'", "'enquanto'", "'('", 
		"')'", "'{'", "'}'", "','", "';'", null, null, null, null, "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "P1", "P2", "C1", "C2", "V", "PV", "Esp", "Operador", "OperadorAttribuicao", 
		"Relacional", "Atributo", "Id", "Fracionado", "Inteiro", "Texto", "Caractere"
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
	    private String _expressaoLaco;
	    private String _expressaoDecisaoId;
	    private String _expressaoLacoId;
	    private ArrayList<AbstractCommand> listaVerdadeiro;
	    private ArrayList<AbstractCommand> listaFalso;
	    private ArrayList<AbstractCommand> listaLaco;
	    private ArrayList<Integer> listaTipos;

	    public String retornaNomeDoTipo (int type) {
	        if (type == Variable.CARACTERE)
	            return "Caractere";
	        else if (type == Variable.TEXTO)
	            return "Texto";
	        else if (type == Variable.INTEIRO)
	            return "Inteiro";
	        else if (type == Variable.FRACIONADO)
	            return "Fracionado";
	        else
	            return "";
	    }

	    public int retornaTipo(String termo) {
	        Variable variable = (Variable) tabela.getSymbol(termo);
	        return variable.getType();
	    }

	    public void verificaValor(String termo) {
	        Variable variable = (Variable) tabela.getSymbol(termo);
	        if (variable.getValue() == null && variable.isRead() == false) {
	            throw new SemanticException("Variable " + termo + " doesn't have an attributed value.");
	        }
	    }

	    public void verificaId(String id) {
	        if (!tabela.exists(id)) {
	            throw new SemanticException("Symbol (" + id + ") doesn't exist.");
	        }
	    };

	    public void verificacaoDeTipos(String nome, ArrayList<Integer> listaTipos){
	        int type = retornaTipo(nome);
	        for(int tipo : listaTipos) {
	            if(type != tipo) {
	                throw new SemanticException("Variable " + nome + " (type: "+ retornaNomeDoTipo(type)
	                     + ") does not match with type " + retornaNomeDoTipo(tipo));
	            }
	        }
	    }

	    public void exibeComandos() {
	        for (AbstractCommand c: programa.getCommands()) {
	            System.out.println(c);
	        }

	    }

	    public void exibeTabela() {
	        ArrayList<Symbol> lista = tabela.getAllSymbols();
	        for (Symbol s : lista) {
	            System.out.println(s);
	        }
	    }

	    public void exibeTabelaComVariaveisNull() {
	        ArrayList<Symbol> lista = tabela.getAllSymbols();
	        Variable variable;
	        for (Symbol s : lista) {
	           variable = (Variable) s;
	            if(variable.getValue() == null && variable.isRead() == false) {
	                System.out.println("Warning: Variable " + s.getName() + " is declared but its value is never read.");
	            }
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\36\u00de\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21"+
		"\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\5\26\u00a9\n\26\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\5\27\u00b5\n\27\3\30\3\30\3\31\3\31\7\31\u00bb\n"+
		"\31\f\31\16\31\u00be\13\31\3\32\6\32\u00c1\n\32\r\32\16\32\u00c2\3\32"+
		"\3\32\6\32\u00c7\n\32\r\32\16\32\u00c8\3\33\6\33\u00cc\n\33\r\33\16\33"+
		"\u00cd\3\34\3\34\7\34\u00d2\n\34\f\34\16\34\u00d5\13\34\3\34\3\34\3\35"+
		"\3\35\5\35\u00db\n\35\3\35\3\35\2\2\36\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36\3\2\7\5\2\13\f\17\17\"\"\5\2,-//\61\61"+
		"\3\2c|\5\2\62;C\\c|\3\2\62;\2\u00ea\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2"+
		"\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3"+
		"\2\2\2\2\67\3\2\2\2\29\3\2\2\2\3;\3\2\2\2\5B\3\2\2\2\7G\3\2\2\2\tQ\3\2"+
		"\2\2\13W\3\2\2\2\r_\3\2\2\2\17j\3\2\2\2\21n\3\2\2\2\23w\3\2\2\2\25z\3"+
		"\2\2\2\27\u0080\3\2\2\2\31\u0085\3\2\2\2\33\u008e\3\2\2\2\35\u0090\3\2"+
		"\2\2\37\u0092\3\2\2\2!\u0094\3\2\2\2#\u0096\3\2\2\2%\u0098\3\2\2\2\'\u009a"+
		"\3\2\2\2)\u009e\3\2\2\2+\u00a8\3\2\2\2-\u00b4\3\2\2\2/\u00b6\3\2\2\2\61"+
		"\u00b8\3\2\2\2\63\u00c0\3\2\2\2\65\u00cb\3\2\2\2\67\u00cf\3\2\2\29\u00d8"+
		"\3\2\2\2;<\7k\2\2<=\7p\2\2=>\7k\2\2>?\7e\2\2?@\7k\2\2@A\7q\2\2A\4\3\2"+
		"\2\2BC\7h\2\2CD\7k\2\2DE\7o\2\2EF\7=\2\2F\6\3\2\2\2GH\7E\2\2HI\7c\2\2"+
		"IJ\7t\2\2JK\7c\2\2KL\7e\2\2LM\7v\2\2MN\7g\2\2NO\7t\2\2OP\7g\2\2P\b\3\2"+
		"\2\2QR\7V\2\2RS\7g\2\2ST\7z\2\2TU\7v\2\2UV\7q\2\2V\n\3\2\2\2WX\7K\2\2"+
		"XY\7p\2\2YZ\7v\2\2Z[\7g\2\2[\\\7k\2\2\\]\7t\2\2]^\7q\2\2^\f\3\2\2\2_`"+
		"\7H\2\2`a\7t\2\2ab\7c\2\2bc\7e\2\2cd\7k\2\2de\7q\2\2ef\7p\2\2fg\7c\2\2"+
		"gh\7f\2\2hi\7q\2\2i\16\3\2\2\2jk\7n\2\2kl\7g\2\2lm\7t\2\2m\20\3\2\2\2"+
		"no\7g\2\2op\7u\2\2pq\7e\2\2qr\7t\2\2rs\7g\2\2st\7x\2\2tu\7g\2\2uv\7t\2"+
		"\2v\22\3\2\2\2wx\7u\2\2xy\7g\2\2y\24\3\2\2\2z{\7u\2\2{|\7g\2\2|}\7p\2"+
		"\2}~\7c\2\2~\177\7q\2\2\177\26\3\2\2\2\u0080\u0081\7h\2\2\u0081\u0082"+
		"\7c\2\2\u0082\u0083\7e\2\2\u0083\u0084\7c\2\2\u0084\30\3\2\2\2\u0085\u0086"+
		"\7g\2\2\u0086\u0087\7p\2\2\u0087\u0088\7s\2\2\u0088\u0089\7w\2\2\u0089"+
		"\u008a\7c\2\2\u008a\u008b\7p\2\2\u008b\u008c\7v\2\2\u008c\u008d\7q\2\2"+
		"\u008d\32\3\2\2\2\u008e\u008f\7*\2\2\u008f\34\3\2\2\2\u0090\u0091\7+\2"+
		"\2\u0091\36\3\2\2\2\u0092\u0093\7}\2\2\u0093 \3\2\2\2\u0094\u0095\7\177"+
		"\2\2\u0095\"\3\2\2\2\u0096\u0097\7.\2\2\u0097$\3\2\2\2\u0098\u0099\7="+
		"\2\2\u0099&\3\2\2\2\u009a\u009b\t\2\2\2\u009b\u009c\3\2\2\2\u009c\u009d"+
		"\b\24\2\2\u009d(\3\2\2\2\u009e\u009f\t\3\2\2\u009f*\3\2\2\2\u00a0\u00a1"+
		"\7-\2\2\u00a1\u00a9\7?\2\2\u00a2\u00a3\7/\2\2\u00a3\u00a9\7?\2\2\u00a4"+
		"\u00a5\7\61\2\2\u00a5\u00a9\7?\2\2\u00a6\u00a7\7,\2\2\u00a7\u00a9\7?\2"+
		"\2\u00a8\u00a0\3\2\2\2\u00a8\u00a2\3\2\2\2\u00a8\u00a4\3\2\2\2\u00a8\u00a6"+
		"\3\2\2\2\u00a9,\3\2\2\2\u00aa\u00b5\7@\2\2\u00ab\u00ac\7@\2\2\u00ac\u00b5"+
		"\7?\2\2\u00ad\u00b5\7>\2\2\u00ae\u00af\7>\2\2\u00af\u00b5\7?\2\2\u00b0"+
		"\u00b1\7?\2\2\u00b1\u00b5\7?\2\2\u00b2\u00b3\7#\2\2\u00b3\u00b5\7?\2\2"+
		"\u00b4\u00aa\3\2\2\2\u00b4\u00ab\3\2\2\2\u00b4\u00ad\3\2\2\2\u00b4\u00ae"+
		"\3\2\2\2\u00b4\u00b0\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5.\3\2\2\2\u00b6"+
		"\u00b7\7?\2\2\u00b7\60\3\2\2\2\u00b8\u00bc\t\4\2\2\u00b9\u00bb\t\5\2\2"+
		"\u00ba\u00b9\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd"+
		"\3\2\2\2\u00bd\62\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf\u00c1\t\6\2\2\u00c0"+
		"\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2"+
		"\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c6\7\60\2\2\u00c5\u00c7\t\6\2\2\u00c6"+
		"\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2"+
		"\2\2\u00c9\64\3\2\2\2\u00ca\u00cc\t\6\2\2\u00cb\u00ca\3\2\2\2\u00cc\u00cd"+
		"\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\66\3\2\2\2\u00cf"+
		"\u00d3\7$\2\2\u00d0\u00d2\t\5\2\2\u00d1\u00d0\3\2\2\2\u00d2\u00d5\3\2"+
		"\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d6\3\2\2\2\u00d5"+
		"\u00d3\3\2\2\2\u00d6\u00d7\7$\2\2\u00d78\3\2\2\2\u00d8\u00da\7)\2\2\u00d9"+
		"\u00db\t\5\2\2\u00da\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00dd\7)"+
		"\2\2\u00dd:\3\2\2\2\r\2\u00a8\u00b4\u00ba\u00bc\u00c2\u00c8\u00cd\u00d1"+
		"\u00d3\u00da\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}