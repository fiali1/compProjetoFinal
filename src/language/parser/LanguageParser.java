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
		P2=10, C1=11, C2=12, V=13, PV=14, Esp=15, Operador=16, OperadorAttribuicao=17, 
		Relacional=18, Atributo=19, Id=20, Numero=21, Texto=22;
	public static final int
		RULE_programa = 0, RULE_declaracoes = 1, RULE_declaracao = 2, RULE_tipo = 3, 
		RULE_conteudo = 4, RULE_instrucao = 5, RULE_iLeitura = 6, RULE_iEscrita = 7, 
		RULE_iAttribuicao = 8, RULE_expressao = 9, RULE_termo = 10, RULE_iSelecao = 11, 
		RULE_valor = 12;
	public static final String[] ruleNames = {
		"programa", "declaracoes", "declaracao", "tipo", "conteudo", "instrucao", 
		"iLeitura", "iEscrita", "iAttribuicao", "expressao", "termo", "iSelecao", 
		"valor"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'inicio'", "'fim;'", "'Numero'", "'Texto'", "'ler'", "'escrever'", 
		"'se'", "'senao'", "'('", "')'", "'{'", "'}'", "','", "';'", null, null, 
		null, null, "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, "P1", "P2", "C1", 
		"C2", "V", "PV", "Esp", "Operador", "OperadorAttribuicao", "Relacional", 
		"Atributo", "Id", "Numero", "Texto"
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
	    private String _expressaoLaco;
	    private ArrayList<AbstractCommand> listaVerdadeiro;
	    private ArrayList<AbstractCommand> listaFalso;
	    private ArrayList<AbstractCommand> listaLaco;

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
			setState(26);
			match(T__0);
			setState(27);
			declaracoes();
			setState(28);
			conteudo();
			setState(29);
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
			setState(33); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(32);
				declaracao();
				}
				}
				setState(35); 
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
			setState(37);
			tipo();
			setState(38);
			match(Id);

			                    _varNome    = _input.LT(-1).getText();
			                    _varValor   = null;
			                    simbolo     = new Variable(_varNome, _tipo, _varValor);

			                    if (!tabela.exists(_varNome)) {
			                        System.out.println("Symbolo adicionado: " + simbolo);
			                        tabela.addSymbol(simbolo);
			                    } else throw new SemanticException("Symbol (" + _varNome + ") already declared");
			                
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==V) {
				{
				{
				setState(40);
				match(V);
				setState(41);
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
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(48);
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
			setState(54);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(50);
				match(T__2);
				 _tipo = Variable.NUMBER; 
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
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
			                
			setState(58); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(57);
				instrucao();
				}
				}
				setState(60); 
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
			setState(66);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Id:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				iAttribuicao();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				iLeitura();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 3);
				{
				setState(64);
				iEscrita();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 4);
				{
				setState(65);
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
			setState(68);
			match(T__4);
			setState(69);
			match(P1);
			setState(70);
			match(Id);

			                    verificaId(_input.LT(-1).getText());
			                    _lerId = _input.LT(-1).getText();
			                
			setState(72);
			match(P2);
			setState(73);
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
			setState(76);
			match(T__5);
			setState(77);
			match(P1);
			setState(78);
			match(Id);

			                    verificaId(_input.LT(-1).getText());
			                    _escreverId = _input.LT(-1).getText();
			                
			setState(80);
			match(P2);
			setState(81);
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
			setState(84);
			match(Id);

			                    verificaId(_input.LT(-1).getText());
			                    _expressaoId = _input.LT(-1).getText();
			                
			setState(86);
			match(Atributo);

			                    _expressaoConteudo = "";
			                
			setState(88);
			expressao();
			setState(89);
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
			setState(92);
			termo();
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Operador) {
				{
				{
				setState(93);
				match(Operador);

				                    _expressaoConteudo += _input.LT(-1).getText();
				                  
				setState(95);
				termo();
				}
				}
				setState(100);
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
		public ValorContext valor() {
			return getRuleContext(ValorContext.class,0);
		}
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
			setState(106);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Id:
				enterOuterAlt(_localctx, 1);
				{
				setState(101);
				match(Id);

				                    verificaId(_input.LT(-1).getText());
				                    _expressaoConteudo += _input.LT(-1).getText();
				                  
				}
				break;
			case Numero:
			case Texto:
				enterOuterAlt(_localctx, 2);
				{
				setState(103);
				valor();

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
		public ValorContext valor() {
			return getRuleContext(ValorContext.class,0);
		}
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
			setState(108);
			match(T__6);

			                    // Limpa entradas anteriores
			                    listaVerdadeiro = new ArrayList<AbstractCommand>();
			                    listaFalso = new ArrayList<AbstractCommand>();
			                
			setState(110);
			match(P1);
			setState(111);
			match(Id);

			                    verificaId(_input.LT(-1).getText());
			                    _expressaoDecisao = _input.LT(-1).getText();
			                
			setState(113);
			match(Relacional);

			                    _expressaoDecisao += _input.LT(-1).getText();
			                
			setState(118);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Id:
				{
				setState(115);
				match(Id);

				                    verificaId(_input.LT(-1).getText());
				                
				}
				break;
			case Numero:
			case Texto:
				{
				setState(117);
				valor();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}

			                    _expressaoDecisao += _input.LT(-1).getText();
			                
			setState(121);
			match(P2);
			setState(122);
			match(C1);

			                    threadAtual = new ArrayList<AbstractCommand>();
			                    pilha.push(threadAtual);
			                
			setState(125); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(124);
				instrucao();
				}
				}
				setState(127); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << Id))) != 0) );
			setState(129);
			match(C2);

			                    listaVerdadeiro = pilha.pop();
			                
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(131);
				match(T__7);
				setState(132);
				match(C1);

				                    threadAtual = new ArrayList<AbstractCommand>();
				                    pilha.push(threadAtual);
				                
				setState(135); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(134);
					instrucao();
					}
					}
					setState(137); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << Id))) != 0) );
				setState(139);
				match(C2);

				                    listaFalso = pilha.pop();
				                
				}
			}


			                    DecisionCommand cmd = new DecisionCommand(_expressaoDecisao, listaVerdadeiro, listaFalso);
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

	public static class ValorContext extends ParserRuleContext {
		public TerminalNode Numero() { return getToken(LanguageParser.Numero, 0); }
		public TerminalNode Texto() { return getToken(LanguageParser.Texto, 0); }
		public ValorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterValor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitValor(this);
		}
	}

	public final ValorContext valor() throws RecognitionException {
		ValorContext _localctx = new ValorContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_valor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			_la = _input.LA(1);
			if ( !(_la==Numero || _la==Texto) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\30\u0097\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\3\2\3\2\3\3\6\3$\n\3\r"+
		"\3\16\3%\3\4\3\4\3\4\3\4\3\4\3\4\7\4.\n\4\f\4\16\4\61\13\4\3\4\3\4\3\5"+
		"\3\5\3\5\3\5\5\59\n\5\3\6\3\6\6\6=\n\6\r\6\16\6>\3\7\3\7\3\7\3\7\5\7E"+
		"\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\7\13c\n\13\f\13\16"+
		"\13f\13\13\3\f\3\f\3\f\3\f\3\f\5\fm\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\5\ry\n\r\3\r\3\r\3\r\3\r\3\r\6\r\u0080\n\r\r\r\16\r\u0081\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\6\r\u008a\n\r\r\r\16\r\u008b\3\r\3\r\3\r\5\r\u0091"+
		"\n\r\3\r\3\r\3\16\3\16\3\16\2\2\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2"+
		"\3\3\2\27\30\2\u0096\2\34\3\2\2\2\4#\3\2\2\2\6\'\3\2\2\2\b8\3\2\2\2\n"+
		":\3\2\2\2\fD\3\2\2\2\16F\3\2\2\2\20N\3\2\2\2\22V\3\2\2\2\24^\3\2\2\2\26"+
		"l\3\2\2\2\30n\3\2\2\2\32\u0094\3\2\2\2\34\35\7\3\2\2\35\36\5\4\3\2\36"+
		"\37\5\n\6\2\37 \7\4\2\2 !\b\2\1\2!\3\3\2\2\2\"$\5\6\4\2#\"\3\2\2\2$%\3"+
		"\2\2\2%#\3\2\2\2%&\3\2\2\2&\5\3\2\2\2\'(\5\b\5\2()\7\26\2\2)/\b\4\1\2"+
		"*+\7\17\2\2+,\7\26\2\2,.\b\4\1\2-*\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60\3"+
		"\2\2\2\60\62\3\2\2\2\61/\3\2\2\2\62\63\7\20\2\2\63\7\3\2\2\2\64\65\7\5"+
		"\2\2\659\b\5\1\2\66\67\7\6\2\2\679\b\5\1\28\64\3\2\2\28\66\3\2\2\29\t"+
		"\3\2\2\2:<\b\6\1\2;=\5\f\7\2<;\3\2\2\2=>\3\2\2\2><\3\2\2\2>?\3\2\2\2?"+
		"\13\3\2\2\2@E\5\22\n\2AE\5\16\b\2BE\5\20\t\2CE\5\30\r\2D@\3\2\2\2DA\3"+
		"\2\2\2DB\3\2\2\2DC\3\2\2\2E\r\3\2\2\2FG\7\7\2\2GH\7\13\2\2HI\7\26\2\2"+
		"IJ\b\b\1\2JK\7\f\2\2KL\7\20\2\2LM\b\b\1\2M\17\3\2\2\2NO\7\b\2\2OP\7\13"+
		"\2\2PQ\7\26\2\2QR\b\t\1\2RS\7\f\2\2ST\7\20\2\2TU\b\t\1\2U\21\3\2\2\2V"+
		"W\7\26\2\2WX\b\n\1\2XY\7\25\2\2YZ\b\n\1\2Z[\5\24\13\2[\\\7\20\2\2\\]\b"+
		"\n\1\2]\23\3\2\2\2^d\5\26\f\2_`\7\22\2\2`a\b\13\1\2ac\5\26\f\2b_\3\2\2"+
		"\2cf\3\2\2\2db\3\2\2\2de\3\2\2\2e\25\3\2\2\2fd\3\2\2\2gh\7\26\2\2hm\b"+
		"\f\1\2ij\5\32\16\2jk\b\f\1\2km\3\2\2\2lg\3\2\2\2li\3\2\2\2m\27\3\2\2\2"+
		"no\7\t\2\2op\b\r\1\2pq\7\13\2\2qr\7\26\2\2rs\b\r\1\2st\7\24\2\2tx\b\r"+
		"\1\2uv\7\26\2\2vy\b\r\1\2wy\5\32\16\2xu\3\2\2\2xw\3\2\2\2yz\3\2\2\2z{"+
		"\b\r\1\2{|\7\f\2\2|}\7\r\2\2}\177\b\r\1\2~\u0080\5\f\7\2\177~\3\2\2\2"+
		"\u0080\u0081\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0083"+
		"\3\2\2\2\u0083\u0084\7\16\2\2\u0084\u0090\b\r\1\2\u0085\u0086\7\n\2\2"+
		"\u0086\u0087\7\r\2\2\u0087\u0089\b\r\1\2\u0088\u008a\5\f\7\2\u0089\u0088"+
		"\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c"+
		"\u008d\3\2\2\2\u008d\u008e\7\16\2\2\u008e\u008f\b\r\1\2\u008f\u0091\3"+
		"\2\2\2\u0090\u0085\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\3\2\2\2\u0092"+
		"\u0093\b\r\1\2\u0093\31\3\2\2\2\u0094\u0095\t\2\2\2\u0095\33\3\2\2\2\r"+
		"%/8>Ddlx\u0081\u008b\u0090";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}