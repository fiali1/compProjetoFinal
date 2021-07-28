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

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, P1=9, 
		P2=10, C1=11, C2=12, V=13, PV=14, Esp=15, Operador=16, Relacional=17, 
		Atributo=18, Id=19, Valor=20;
	public static final int
		RULE_programa = 0, RULE_declaracoes = 1, RULE_declaracao = 2, RULE_tipo = 3, 
		RULE_conteudo = 4, RULE_instrucao = 5, RULE_iLeitura = 6, RULE_iEscrita = 7, 
		RULE_iAttribuicao = 8, RULE_expressao = 9, RULE_termo = 10, RULE_iSelecao = 11;
	public static final String[] ruleNames = {
		"programa", "declaracoes", "declaracao", "tipo", "conteudo", "instrucao", 
		"iLeitura", "iEscrita", "iAttribuicao", "expressao", "termo", "iSelecao"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'inicio'", "'fim;'", "'Numero'", "'Texto'", "'ler'", "'escrever'", 
		"'se'", "'senao'", "'('", "')'", "'{'", "'}'", "','", "';'", null, null, 
		null, "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, "P1", "P2", "C1", 
		"C2", "V", "PV", "Esp", "Operador", "Relacional", "Atributo", "Id", "Valor"
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

	@Override
	public String getGrammarFileName() { return "Language.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


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

	public LanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramaContext extends ParserRuleContext {
		public DeclaracoesContext declaracoes() {
			return getRuleContext(DeclaracoesContext.class,0);
		}
		public ConteudoContext conteudo() {
			return getRuleContext(ConteudoContext.class,0);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitPrograma(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			match(T__0);
			setState(25);
			declaracoes();
			setState(26);
			conteudo();
			setState(27);
			match(T__1);

			                    programa.setVarTable(tabela);
			                    programa.setCommands(pilha.pop());
			                  
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

	public static class DeclaracoesContext extends ParserRuleContext {
		public List<DeclaracaoContext> declaracao() {
			return getRuleContexts(DeclaracaoContext.class);
		}
		public DeclaracaoContext declaracao(int i) {
			return getRuleContext(DeclaracaoContext.class,i);
		}
		public DeclaracoesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracoes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterDeclaracoes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitDeclaracoes(this);
		}
	}

	public final DeclaracoesContext declaracoes() throws RecognitionException {
		DeclaracoesContext _localctx = new DeclaracoesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaracoes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(30);
				declaracao();
				}
				}
				setState(33); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 || _la==T__3 );
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

	public static class DeclaracaoContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<TerminalNode> Id() { return getTokens(LanguageParser.Id); }
		public TerminalNode Id(int i) {
			return getToken(LanguageParser.Id, i);
		}
		public TerminalNode PV() { return getToken(LanguageParser.PV, 0); }
		public List<TerminalNode> V() { return getTokens(LanguageParser.V); }
		public TerminalNode V(int i) {
			return getToken(LanguageParser.V, i);
		}
		public DeclaracaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterDeclaracao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitDeclaracao(this);
		}
	}

	public final DeclaracaoContext declaracao() throws RecognitionException {
		DeclaracaoContext _localctx = new DeclaracaoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaracao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			tipo();
			setState(36);
			match(Id);

			                    _varNome    = _input.LT(-1).getText();
			                    _varValor   = null;
			                    simbolo     = new Variable(_varNome, _tipo, _varValor);

			                    if (!tabela.exists(_varNome)) {
			                        System.out.println("Symbolo adicionado: " + simbolo);
			                        tabela.addSymbol(simbolo);
			                    } else throw new SemanticException("Symbol (" + _varNome + ") already declared");
			                  
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==V) {
				{
				{
				setState(38);
				match(V);
				setState(39);
				match(Id);

				                    _varNome    = _input.LT(-1).getText();
				                    _varValor   = null;
				                    simbolo     = new Variable(_varNome, _tipo, _varValor);

				                    if (!tabela.exists(_varNome)) {
				                        System.out.println("Symbolo adicionado: " + simbolo);
				                        tabela.addSymbol(simbolo);
				                    } else throw new SemanticException("Symbol (" + _varNome + ") already declared");
				                  
				}
				}
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(46);
			match(PV);
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

	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitTipo(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tipo);
		try {
			setState(52);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				match(T__2);
				 _tipo = Variable.NUMBER; 
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(50);
				match(T__3);
				 _tipo = Variable.TEXT;   
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ConteudoContext extends ParserRuleContext {
		public List<InstrucaoContext> instrucao() {
			return getRuleContexts(InstrucaoContext.class);
		}
		public InstrucaoContext instrucao(int i) {
			return getRuleContext(InstrucaoContext.class,i);
		}
		public ConteudoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conteudo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterConteudo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitConteudo(this);
		}
	}

	public final ConteudoContext conteudo() throws RecognitionException {
		ConteudoContext _localctx = new ConteudoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_conteudo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

			                    threadAtual = new ArrayList<AbstractCommand>();
			                    pilha.push(threadAtual);
			                  
			setState(56); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(55);
				instrucao();
				}
				}
				setState(58); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << Id))) != 0) );
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

	public static class InstrucaoContext extends ParserRuleContext {
		public IAttribuicaoContext iAttribuicao() {
			return getRuleContext(IAttribuicaoContext.class,0);
		}
		public ILeituraContext iLeitura() {
			return getRuleContext(ILeituraContext.class,0);
		}
		public IEscritaContext iEscrita() {
			return getRuleContext(IEscritaContext.class,0);
		}
		public ISelecaoContext iSelecao() {
			return getRuleContext(ISelecaoContext.class,0);
		}
		public InstrucaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instrucao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterInstrucao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitInstrucao(this);
		}
	}

	public final InstrucaoContext instrucao() throws RecognitionException {
		InstrucaoContext _localctx = new InstrucaoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_instrucao);
		try {
			setState(64);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Id:
				enterOuterAlt(_localctx, 1);
				{
				setState(60);
				iAttribuicao();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(61);
				iLeitura();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 3);
				{
				setState(62);
				iEscrita();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 4);
				{
				setState(63);
				iSelecao();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ILeituraContext extends ParserRuleContext {
		public TerminalNode P1() { return getToken(LanguageParser.P1, 0); }
		public TerminalNode Id() { return getToken(LanguageParser.Id, 0); }
		public TerminalNode P2() { return getToken(LanguageParser.P2, 0); }
		public TerminalNode PV() { return getToken(LanguageParser.PV, 0); }
		public ILeituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iLeitura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterILeitura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitILeitura(this);
		}
	}

	public final ILeituraContext iLeitura() throws RecognitionException {
		ILeituraContext _localctx = new ILeituraContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_iLeitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(T__4);
			setState(67);
			match(P1);
			setState(68);
			match(Id);

			                    verificaId(_input.LT(-1).getText());
			                    _lerId = _input.LT(-1).getText();
			                  
			setState(70);
			match(P2);
			setState(71);
			match(PV);

			                    Variable var = (Variable) tabela.getSymbol(_lerId);
			                    ReadCommand cmd = new ReadCommand(_lerId, var);
			                    pilha.peek().add(cmd);
			                  
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

	public static class IEscritaContext extends ParserRuleContext {
		public TerminalNode P1() { return getToken(LanguageParser.P1, 0); }
		public TerminalNode Id() { return getToken(LanguageParser.Id, 0); }
		public TerminalNode P2() { return getToken(LanguageParser.P2, 0); }
		public TerminalNode PV() { return getToken(LanguageParser.PV, 0); }
		public IEscritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iEscrita; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterIEscrita(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitIEscrita(this);
		}
	}

	public final IEscritaContext iEscrita() throws RecognitionException {
		IEscritaContext _localctx = new IEscritaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_iEscrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(T__5);
			setState(75);
			match(P1);
			setState(76);
			match(Id);

			                    verificaId(_input.LT(-1).getText());
			                    _escreverId = _input.LT(-1).getText();
			                  
			setState(78);
			match(P2);
			setState(79);
			match(PV);

			                    WriteCommand cmd = new WriteCommand(_escreverId);
			                    pilha.peek().add(cmd);
			                  
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

	public static class IAttribuicaoContext extends ParserRuleContext {
		public TerminalNode Id() { return getToken(LanguageParser.Id, 0); }
		public TerminalNode Atributo() { return getToken(LanguageParser.Atributo, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode PV() { return getToken(LanguageParser.PV, 0); }
		public IAttribuicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iAttribuicao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterIAttribuicao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitIAttribuicao(this);
		}
	}

	public final IAttribuicaoContext iAttribuicao() throws RecognitionException {
		IAttribuicaoContext _localctx = new IAttribuicaoContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_iAttribuicao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(Id);

			                    verificaId(_input.LT(-1).getText());
			                    _expressaoId = _input.LT(-1).getText();
			                  
			setState(84);
			match(Atributo);

			                    _expressaoConteudo = "";
			                  
			setState(86);
			expressao();
			setState(87);
			match(PV);

			                    AssignementCommand cmd = new AssignementCommand(_expressaoId, _expressaoConteudo);
			                    pilha.peek().add(cmd);
			                  
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

	public static class ExpressaoContext extends ParserRuleContext {
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public List<TerminalNode> Operador() { return getTokens(LanguageParser.Operador); }
		public TerminalNode Operador(int i) {
			return getToken(LanguageParser.Operador, i);
		}
		public ExpressaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterExpressao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitExpressao(this);
		}
	}

	public final ExpressaoContext expressao() throws RecognitionException {
		ExpressaoContext _localctx = new ExpressaoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expressao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			termo();
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Operador) {
				{
				{
				setState(91);
				match(Operador);

				                    _expressaoConteudo += _input.LT(-1).getText();
				                  
				setState(93);
				termo();
				}
				}
				setState(98);
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

	public static class TermoContext extends ParserRuleContext {
		public TerminalNode Id() { return getToken(LanguageParser.Id, 0); }
		public TerminalNode Valor() { return getToken(LanguageParser.Valor, 0); }
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_termo);
		try {
			setState(103);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Id:
				enterOuterAlt(_localctx, 1);
				{
				setState(99);
				match(Id);

				                    verificaId(_input.LT(-1).getText());
				                    _expressaoConteudo += _input.LT(-1).getText();
				                  
				}
				break;
			case Valor:
				enterOuterAlt(_localctx, 2);
				{
				setState(101);
				match(Valor);

				                   _expressaoConteudo += _input.LT(-1).getText();
				                
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ISelecaoContext extends ParserRuleContext {
		public TerminalNode P1() { return getToken(LanguageParser.P1, 0); }
		public List<TerminalNode> Id() { return getTokens(LanguageParser.Id); }
		public TerminalNode Id(int i) {
			return getToken(LanguageParser.Id, i);
		}
		public TerminalNode Relacional() { return getToken(LanguageParser.Relacional, 0); }
		public TerminalNode P2() { return getToken(LanguageParser.P2, 0); }
		public List<TerminalNode> C1() { return getTokens(LanguageParser.C1); }
		public TerminalNode C1(int i) {
			return getToken(LanguageParser.C1, i);
		}
		public List<TerminalNode> C2() { return getTokens(LanguageParser.C2); }
		public TerminalNode C2(int i) {
			return getToken(LanguageParser.C2, i);
		}
		public TerminalNode Valor() { return getToken(LanguageParser.Valor, 0); }
		public List<InstrucaoContext> instrucao() {
			return getRuleContexts(InstrucaoContext.class);
		}
		public InstrucaoContext instrucao(int i) {
			return getRuleContext(InstrucaoContext.class,i);
		}
		public ISelecaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iSelecao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterISelecao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitISelecao(this);
		}
	}

	public final ISelecaoContext iSelecao() throws RecognitionException {
		ISelecaoContext _localctx = new ISelecaoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_iSelecao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(T__6);
			setState(106);
			match(P1);
			setState(107);
			match(Id);

			                    _expressaoDecisao = _input.LT(-1).getText();
			                  
			setState(109);
			match(Relacional);

			                    _expressaoDecisao += _input.LT(-1).getText();
			                  
			setState(111);
			_la = _input.LA(1);
			if ( !(_la==Id || _la==Valor) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}

			                    _expressaoDecisao += _input.LT(-1).getText();
			                  
			setState(113);
			match(P2);
			setState(114);
			match(C1);

			                    threadAtual = new ArrayList<AbstractCommand>();
			                    pilha.push(threadAtual);
			                  
			setState(117); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(116);
				instrucao();
				}
				}
				setState(119); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << Id))) != 0) );
			setState(121);
			match(C2);

			                    listaVerdadeiro = pilha.pop();
			                  
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(123);
				match(T__7);
				setState(124);
				match(C1);

				                    threadAtual = new ArrayList<AbstractCommand>();
				                    pilha.push(threadAtual);
				                  
				setState(127); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(126);
					instrucao();
					}
					}
					setState(129); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << Id))) != 0) );
				setState(131);
				match(C2);

				                    listaFalso = pilha.pop();
				                    DecisionCommand cmd = new DecisionCommand(_expressaoDecisao, listaVerdadeiro, listaFalso);
				                    pilha.peek().add(cmd);
				                  
				}
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\26\u008b\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\2\3\2\3\3\6\3\"\n\3\r\3\16\3#"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\7\4,\n\4\f\4\16\4/\13\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\5\5\67\n\5\3\6\3\6\6\6;\n\6\r\6\16\6<\3\7\3\7\3\7\3\7\5\7C\n\7\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\7\13a\n\13\f\13\16\13d\13\13"+
		"\3\f\3\f\3\f\3\f\5\fj\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\6\rx\n\r\r\r\16\ry\3\r\3\r\3\r\3\r\3\r\3\r\6\r\u0082\n\r\r\r\16\r"+
		"\u0083\3\r\3\r\3\r\5\r\u0089\n\r\3\r\2\2\16\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\2\3\3\2\25\26\2\u008a\2\32\3\2\2\2\4!\3\2\2\2\6%\3\2\2\2\b\66\3\2"+
		"\2\2\n8\3\2\2\2\fB\3\2\2\2\16D\3\2\2\2\20L\3\2\2\2\22T\3\2\2\2\24\\\3"+
		"\2\2\2\26i\3\2\2\2\30k\3\2\2\2\32\33\7\3\2\2\33\34\5\4\3\2\34\35\5\n\6"+
		"\2\35\36\7\4\2\2\36\37\b\2\1\2\37\3\3\2\2\2 \"\5\6\4\2! \3\2\2\2\"#\3"+
		"\2\2\2#!\3\2\2\2#$\3\2\2\2$\5\3\2\2\2%&\5\b\5\2&\'\7\25\2\2\'-\b\4\1\2"+
		"()\7\17\2\2)*\7\25\2\2*,\b\4\1\2+(\3\2\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2"+
		"\2.\60\3\2\2\2/-\3\2\2\2\60\61\7\20\2\2\61\7\3\2\2\2\62\63\7\5\2\2\63"+
		"\67\b\5\1\2\64\65\7\6\2\2\65\67\b\5\1\2\66\62\3\2\2\2\66\64\3\2\2\2\67"+
		"\t\3\2\2\28:\b\6\1\29;\5\f\7\2:9\3\2\2\2;<\3\2\2\2<:\3\2\2\2<=\3\2\2\2"+
		"=\13\3\2\2\2>C\5\22\n\2?C\5\16\b\2@C\5\20\t\2AC\5\30\r\2B>\3\2\2\2B?\3"+
		"\2\2\2B@\3\2\2\2BA\3\2\2\2C\r\3\2\2\2DE\7\7\2\2EF\7\13\2\2FG\7\25\2\2"+
		"GH\b\b\1\2HI\7\f\2\2IJ\7\20\2\2JK\b\b\1\2K\17\3\2\2\2LM\7\b\2\2MN\7\13"+
		"\2\2NO\7\25\2\2OP\b\t\1\2PQ\7\f\2\2QR\7\20\2\2RS\b\t\1\2S\21\3\2\2\2T"+
		"U\7\25\2\2UV\b\n\1\2VW\7\24\2\2WX\b\n\1\2XY\5\24\13\2YZ\7\20\2\2Z[\b\n"+
		"\1\2[\23\3\2\2\2\\b\5\26\f\2]^\7\22\2\2^_\b\13\1\2_a\5\26\f\2`]\3\2\2"+
		"\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2c\25\3\2\2\2db\3\2\2\2ef\7\25\2\2fj\b"+
		"\f\1\2gh\7\26\2\2hj\b\f\1\2ie\3\2\2\2ig\3\2\2\2j\27\3\2\2\2kl\7\t\2\2"+
		"lm\7\13\2\2mn\7\25\2\2no\b\r\1\2op\7\23\2\2pq\b\r\1\2qr\t\2\2\2rs\b\r"+
		"\1\2st\7\f\2\2tu\7\r\2\2uw\b\r\1\2vx\5\f\7\2wv\3\2\2\2xy\3\2\2\2yw\3\2"+
		"\2\2yz\3\2\2\2z{\3\2\2\2{|\7\16\2\2|\u0088\b\r\1\2}~\7\n\2\2~\177\7\r"+
		"\2\2\177\u0081\b\r\1\2\u0080\u0082\5\f\7\2\u0081\u0080\3\2\2\2\u0082\u0083"+
		"\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\3\2\2\2\u0085"+
		"\u0086\7\16\2\2\u0086\u0087\b\r\1\2\u0087\u0089\3\2\2\2\u0088}\3\2\2\2"+
		"\u0088\u0089\3\2\2\2\u0089\31\3\2\2\2\f#-\66<Bbiy\u0083\u0088";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}