// Generated from Language.g4 by ANTLR 4.7.1
package language.parser;

    import language.dataStructures.Symbol;
    import language.dataStructures.SymbolTable;
    import language.dataStructures.Variable;
    import language.exceptions.SemanticException;
    import java.util.ArrayList;

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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, P1=7, P2=8, V=9, PV=10, 
		Esp=11, Operador=12, Atributo=13, Id=14, Valor=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "P1", "P2", "V", "PV", 
		"Esp", "Operador", "Atributo", "Id", "Valor"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'inicio'", "'fim;'", "'Numero'", "'Texto'", "'ler'", "'escrever'", 
		"'('", "')'", "','", "';'", null, null, "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, "P1", "P2", "V", "PV", "Esp", 
		"Operador", "Atributo", "Id", "Valor"
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
	    private SymbolTable tabela  = new SymbolTable();

	    public void verificaId(String id) {
	        if (!tabela.exists(id)) {
	            throw new SemanticException("Symbol (" + id + ") doesn't exist");
	        }
	    };


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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\21k\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b"+
		"\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17"+
		"\7\17Z\n\17\f\17\16\17]\13\17\3\20\6\20`\n\20\r\20\16\20a\3\20\3\20\6"+
		"\20f\n\20\r\20\16\20g\5\20j\n\20\2\2\21\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21\3\2\7\5\2\13\f\17\17\"\""+
		"\5\2,-//\61\61\3\2c|\5\2\62;C\\c|\3\2\62;\2n\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\3!\3\2\2\2\5(\3\2\2\2\7-\3\2\2\2\t\64\3\2\2"+
		"\2\13:\3\2\2\2\r>\3\2\2\2\17G\3\2\2\2\21I\3\2\2\2\23K\3\2\2\2\25M\3\2"+
		"\2\2\27O\3\2\2\2\31S\3\2\2\2\33U\3\2\2\2\35W\3\2\2\2\37_\3\2\2\2!\"\7"+
		"k\2\2\"#\7p\2\2#$\7k\2\2$%\7e\2\2%&\7k\2\2&\'\7q\2\2\'\4\3\2\2\2()\7h"+
		"\2\2)*\7k\2\2*+\7o\2\2+,\7=\2\2,\6\3\2\2\2-.\7P\2\2./\7w\2\2/\60\7o\2"+
		"\2\60\61\7g\2\2\61\62\7t\2\2\62\63\7q\2\2\63\b\3\2\2\2\64\65\7V\2\2\65"+
		"\66\7g\2\2\66\67\7z\2\2\678\7v\2\289\7q\2\29\n\3\2\2\2:;\7n\2\2;<\7g\2"+
		"\2<=\7t\2\2=\f\3\2\2\2>?\7g\2\2?@\7u\2\2@A\7e\2\2AB\7t\2\2BC\7g\2\2CD"+
		"\7x\2\2DE\7g\2\2EF\7t\2\2F\16\3\2\2\2GH\7*\2\2H\20\3\2\2\2IJ\7+\2\2J\22"+
		"\3\2\2\2KL\7.\2\2L\24\3\2\2\2MN\7=\2\2N\26\3\2\2\2OP\t\2\2\2PQ\3\2\2\2"+
		"QR\b\f\2\2R\30\3\2\2\2ST\t\3\2\2T\32\3\2\2\2UV\7?\2\2V\34\3\2\2\2W[\t"+
		"\4\2\2XZ\t\5\2\2YX\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\\36\3\2\2\2"+
		"][\3\2\2\2^`\t\6\2\2_^\3\2\2\2`a\3\2\2\2a_\3\2\2\2ab\3\2\2\2bi\3\2\2\2"+
		"ce\7\60\2\2df\t\6\2\2ed\3\2\2\2fg\3\2\2\2ge\3\2\2\2gh\3\2\2\2hj\3\2\2"+
		"\2ic\3\2\2\2ij\3\2\2\2j \3\2\2\2\b\2Y[agi\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}