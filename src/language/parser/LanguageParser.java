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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, P1=12, P2=13, C1=14, C2=15, V=16, PV=17, Esp=18, Operador=19, 
		OperadorAttribuicao=20, Relacional=21, Atributo=22, Id=23, Fracionado=24, 
		Inteiro=25, Texto=26;
	public static final int
		RULE_programa = 0, RULE_declaracoes = 1, RULE_declaracao = 2, RULE_tipo = 3, 
		RULE_conteudo = 4, RULE_instrucao = 5, RULE_iLeitura = 6, RULE_iEscrita = 7, 
		RULE_iAttribuicao = 8, RULE_expressao = 9, RULE_termo = 10, RULE_iSelecao = 11, 
		RULE_iLaco = 12, RULE_valor = 13;
	public static final String[] ruleNames = {
		"programa", "declaracoes", "declaracao", "tipo", "conteudo", "instrucao", 
		"iLeitura", "iEscrita", "iAttribuicao", "expressao", "termo", "iSelecao", 
		"iLaco", "valor"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'inicio'", "'fim;'", "'Fracionado'", "'Texto'", "'Inteiro'", "'ler'", 
		"'escrever'", "'se'", "'senao'", "'faca'", "'enquanto'", "'('", "')'", 
		"'{'", "'}'", "','", "';'", null, null, null, null, "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"P1", "P2", "C1", "C2", "V", "PV", "Esp", "Operador", "OperadorAttribuicao", 
		"Relacional", "Atributo", "Id", "Fracionado", "Inteiro", "Texto"
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
	    private String _expressaoDecisaoId;
	    private String _expressaoLacoId;
	    private ArrayList<AbstractCommand> listaVerdadeiro;
	    private ArrayList<AbstractCommand> listaFalso;
	    private ArrayList<AbstractCommand> listaLaco;
	    private ArrayList<Integer> listaTipos;

	    public int retornaTipo(String termo) {
	        Variable variable = (Variable) tabela.getSymbol(termo);
	        return variable.getType();
	    }

	    public void verificaValor(String termo) {
	        Variable variable = (Variable) tabela.getSymbol(termo);
	        if (variable.getValue() == null) {
	            throw new SemanticException("Id " + termo + " doesn't have a value");
	        }
	    }

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

	    public void exibeTabela() {
	        ArrayList<Symbol> lista = tabela.getAllSymbols();
	        for (Symbol s : lista) {
	            System.out.println(s);
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
			setState(28);
			match(T__0);
			setState(29);
			declaracoes();
			setState(30);
			conteudo();
			setState(31);
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
			setState(35); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(34);
				declaracao();
				}
				}
				setState(37); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4))) != 0) );
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
			setState(39);
			tipo();
			setState(40);
			match(Id);

			                    _varNome    = _input.LT(-1).getText();
			                    _varValor   = null;
			                    simbolo     = new Variable(_varNome, _tipo, _varValor);

			                    if (!tabela.exists(_varNome)) {
			                        System.out.println("Symbolo adicionado: " + simbolo);
			                        tabela.addSymbol(simbolo);
			                    } else throw new SemanticException("Symbol (" + _varNome + ") already declared");
			                
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==V) {
				{
				{
				setState(42);
				match(V);
				setState(43);
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
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(50);
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
			setState(58);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				match(T__2);
				 _tipo = Variable.FRACIONADO; 
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				match(T__3);
				 _tipo = Variable.TEXT;   
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(56);
				match(T__4);
				 _tipo = Variable.INTEIRO;   
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
			                
			setState(62); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(61);
				instrucao();
				}
				}
				setState(64); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << Id))) != 0) );
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
		public ILacoContext iLaco() {
			return getRuleContext(ILacoContext.class,0);
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
			setState(71);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Id:
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				iAttribuicao();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				iLeitura();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 3);
				{
				setState(68);
				iEscrita();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 4);
				{
				setState(69);
				iSelecao();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 5);
				{
				setState(70);
				iLaco();
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
			setState(73);
			match(T__5);
			setState(74);
			match(P1);
			setState(75);
			match(Id);

			                    verificaId(_input.LT(-1).getText());
			                    _lerId = _input.LT(-1).getText();
			                
			setState(77);
			match(P2);
			setState(78);
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
			setState(81);
			match(T__6);
			setState(82);
			match(P1);
			setState(83);
			match(Id);

			                    verificaId(_input.LT(-1).getText());
			                    _escreverId = _input.LT(-1).getText();
			                
			setState(85);
			match(P2);
			setState(86);
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
			setState(89);
			match(Id);

			                    listaTipos = new ArrayList<Integer>();
			                    verificaId(_input.LT(-1).getText());
			                    _expressaoId = _input.LT(-1).getText();
			                
			setState(91);
			match(Atributo);

			                    _expressaoConteudo = "";
			                
			setState(93);
			expressao();
			setState(94);
			match(PV);

			                    // Associa os novos valores à variável e atualiza ela na tabela

			                    int type = retornaTipo(_expressaoId);
			                    for(int tipo : listaTipos) {
			                        if(type != tipo) {
			                            throw new SemanticException("type " + type + " is different from " + tipo);
			                        }
			                    }

			                    _varNome    = _expressaoId;
			                    _varValor   = _expressaoConteudo;
			                    simbolo     = new Variable(_varNome, retornaTipo(_varNome), _varValor);
			                    tabela.setSymbol(_varNome, simbolo);

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
			setState(97);
			termo();
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Operador) {
				{
				{
				setState(98);
				match(Operador);

				                    _expressaoConteudo += _input.LT(-1).getText();
				                  
				setState(100);
				termo();
				}
				}
				setState(105);
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
			setState(111);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Id:
				enterOuterAlt(_localctx, 1);
				{
				setState(106);
				match(Id);

				                    String nomeTermo = _input.LT(-1).getText();
				                    verificaId(nomeTermo);
				                    verificaValor(nomeTermo);
				                    _expressaoConteudo += _input.LT(-1).getText();
				                    listaTipos.add(retornaTipo(nomeTermo));
				                  
				}
				break;
			case Fracionado:
			case Inteiro:
			case Texto:
				enterOuterAlt(_localctx, 2);
				{
				setState(108);
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
			setState(113);
			match(T__7);

			                    // Limpa entradas anteriores
			                    listaVerdadeiro = new ArrayList<AbstractCommand>();
			                    listaFalso = new ArrayList<AbstractCommand>();
			                    listaTipos = new ArrayList<Integer>();
			                
			setState(115);
			match(P1);
			setState(116);
			match(Id);

			                    verificaId(_input.LT(-1).getText());
			                    verificaValor(_input.LT(-1).getText());
			                    _expressaoDecisao = _input.LT(-1).getText();
			                    _expressaoDecisaoId = _input.LT(-1).getText();
			                    listaTipos.add(retornaTipo(_expressaoDecisaoId));
			                
			setState(118);
			match(Relacional);

			                    _expressaoDecisao += _input.LT(-1).getText();
			                
			setState(123);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Id:
				{
				setState(120);
				match(Id);

				                    verificaId(_input.LT(-1).getText());
				                    verificaValor(_input.LT(-1).getText());
				                    String _expressaoDecisao2 = _input.LT(-1).getText();
				                    listaTipos.add(retornaTipo(_expressaoDecisao2));
				                
				}
				break;
			case Fracionado:
			case Inteiro:
			case Texto:
				{
				setState(122);
				valor();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}

			                    _expressaoDecisao += _input.LT(-1).getText();
			                
			setState(126);
			match(P2);
			setState(127);
			match(C1);

			                    int type = retornaTipo(_expressaoDecisaoId);
			                    for(int tipo : listaTipos) {
			                      if(type != tipo) {
			                          throw new SemanticException("type " + type + " is different from " + tipo);
			                      }
			                    }

			                    threadAtual = new ArrayList<AbstractCommand>();
			                    pilha.push(threadAtual);
			                
			setState(130); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(129);
				instrucao();
				}
				}
				setState(132); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << Id))) != 0) );
			setState(134);
			match(C2);

			                    listaVerdadeiro = pilha.pop();
			                
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(136);
				match(T__8);
				setState(137);
				match(C1);

				                    threadAtual = new ArrayList<AbstractCommand>();
				                    pilha.push(threadAtual);
				                
				setState(140); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(139);
					instrucao();
					}
					}
					setState(142); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << Id))) != 0) );
				setState(144);
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

	public static class ILacoContext extends ParserRuleContext {
		public TerminalNode C1() { return getToken(LanguageParser.C1, 0); }
		public TerminalNode C2() { return getToken(LanguageParser.C2, 0); }
		public TerminalNode P1() { return getToken(LanguageParser.P1, 0); }
		public List<TerminalNode> Id() { return getTokens(LanguageParser.Id); }
		public TerminalNode Id(int i) {
			return getToken(LanguageParser.Id, i);
		}
		public TerminalNode Relacional() { return getToken(LanguageParser.Relacional, 0); }
		public TerminalNode P2() { return getToken(LanguageParser.P2, 0); }
		public TerminalNode PV() { return getToken(LanguageParser.PV, 0); }
		public ValorContext valor() {
			return getRuleContext(ValorContext.class,0);
		}
		public List<InstrucaoContext> instrucao() {
			return getRuleContexts(InstrucaoContext.class);
		}
		public InstrucaoContext instrucao(int i) {
			return getRuleContext(InstrucaoContext.class,i);
		}
		public ILacoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iLaco; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterILaco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitILaco(this);
		}
	}

	public final ILacoContext iLaco() throws RecognitionException {
		ILacoContext _localctx = new ILacoContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_iLaco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(T__9);

			                    // Limpa conteúdo anterior
			                    listaLaco = new ArrayList<AbstractCommand>();
			                    listaTipos = new ArrayList<Integer>();
			                
			setState(153);
			match(C1);

			                    // Cria nova lista de comandos
			                    threadAtual = new ArrayList<AbstractCommand>();
			                    pilha.push(threadAtual);
			                
			setState(156); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(155);
				instrucao();
				}
				}
				setState(158); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << Id))) != 0) );
			setState(160);
			match(C2);

			                    // Armazena e limpa último item da pilha
			                    listaLaco = pilha.pop();
			                
			setState(162);
			match(T__10);
			setState(163);
			match(P1);
			setState(164);
			match(Id);

			                    verificaId(_input.LT(-1).getText());
			                    verificaValor(_input.LT(-1).getText());
			                    _expressaoLacoId = _input.LT(-1).getText();
			                    _expressaoLaco = _input.LT(-1).getText();

			                
			setState(166);
			match(Relacional);

			                    _expressaoLaco += _input.LT(-1).getText();
			                
			setState(171);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Id:
				{
				setState(168);
				match(Id);

				                    verificaId(_input.LT(-1).getText());
				                    verificaValor(_input.LT(-1).getText());
				                    listaTipos.add(retornaTipo(_input.LT(-1).getText()));
				                
				}
				break;
			case Fracionado:
			case Inteiro:
			case Texto:
				{
				setState(170);
				valor();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}

			                    _expressaoLaco += _input.LT(-1).getText();
			                
			setState(174);
			match(P2);
			setState(175);
			match(PV);

			                    int type = retornaTipo(_expressaoLacoId);
			                    for(int tipo : listaTipos) {
			                       if(type != tipo) {
			                          throw new SemanticException("type " + type + " is different from " + tipo);
			                       }
			                    }
			                    LoopCommand cmd = new LoopCommand(_expressaoLaco, listaLaco);
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
		public TerminalNode Fracionado() { return getToken(LanguageParser.Fracionado, 0); }
		public TerminalNode Inteiro() { return getToken(LanguageParser.Inteiro, 0); }
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
		enterRule(_localctx, 26, RULE_valor);
		try {
			setState(184);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Fracionado:
				enterOuterAlt(_localctx, 1);
				{
				setState(178);
				match(Fracionado);
				 listaTipos.add(Variable.FRACIONADO); 
				}
				break;
			case Inteiro:
				enterOuterAlt(_localctx, 2);
				{
				setState(180);
				match(Inteiro);
				 listaTipos.add(Variable.INTEIRO); 
				}
				break;
			case Texto:
				enterOuterAlt(_localctx, 3);
				{
				setState(182);
				match(Texto);
				 listaTipos.add(Variable.TEXT); 
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\34\u00bd\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\3\2\3\2\3\3"+
		"\6\3&\n\3\r\3\16\3\'\3\4\3\4\3\4\3\4\3\4\3\4\7\4\60\n\4\f\4\16\4\63\13"+
		"\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\5\5=\n\5\3\6\3\6\6\6A\n\6\r\6\16\6"+
		"B\3\7\3\7\3\7\3\7\3\7\5\7J\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\7\13h\n\13\f\13\16\13k\13\13\3\f\3\f\3\f\3\f\3\f\5\fr\n\f\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r~\n\r\3\r\3\r\3\r\3\r\3\r\6\r\u0085"+
		"\n\r\r\r\16\r\u0086\3\r\3\r\3\r\3\r\3\r\3\r\6\r\u008f\n\r\r\r\16\r\u0090"+
		"\3\r\3\r\3\r\5\r\u0096\n\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\6\16\u009f"+
		"\n\16\r\16\16\16\u00a0\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\5\16\u00ae\n\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\5\17\u00bb\n\17\3\17\2\2\20\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\2\2\2\u00c1\2\36\3\2\2\2\4%\3\2\2\2\6)\3\2\2\2\b<\3\2\2\2\n>\3\2\2"+
		"\2\fI\3\2\2\2\16K\3\2\2\2\20S\3\2\2\2\22[\3\2\2\2\24c\3\2\2\2\26q\3\2"+
		"\2\2\30s\3\2\2\2\32\u0099\3\2\2\2\34\u00ba\3\2\2\2\36\37\7\3\2\2\37 \5"+
		"\4\3\2 !\5\n\6\2!\"\7\4\2\2\"#\b\2\1\2#\3\3\2\2\2$&\5\6\4\2%$\3\2\2\2"+
		"&\'\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(\5\3\2\2\2)*\5\b\5\2*+\7\31\2\2+\61"+
		"\b\4\1\2,-\7\22\2\2-.\7\31\2\2.\60\b\4\1\2/,\3\2\2\2\60\63\3\2\2\2\61"+
		"/\3\2\2\2\61\62\3\2\2\2\62\64\3\2\2\2\63\61\3\2\2\2\64\65\7\23\2\2\65"+
		"\7\3\2\2\2\66\67\7\5\2\2\67=\b\5\1\289\7\6\2\29=\b\5\1\2:;\7\7\2\2;=\b"+
		"\5\1\2<\66\3\2\2\2<8\3\2\2\2<:\3\2\2\2=\t\3\2\2\2>@\b\6\1\2?A\5\f\7\2"+
		"@?\3\2\2\2AB\3\2\2\2B@\3\2\2\2BC\3\2\2\2C\13\3\2\2\2DJ\5\22\n\2EJ\5\16"+
		"\b\2FJ\5\20\t\2GJ\5\30\r\2HJ\5\32\16\2ID\3\2\2\2IE\3\2\2\2IF\3\2\2\2I"+
		"G\3\2\2\2IH\3\2\2\2J\r\3\2\2\2KL\7\b\2\2LM\7\16\2\2MN\7\31\2\2NO\b\b\1"+
		"\2OP\7\17\2\2PQ\7\23\2\2QR\b\b\1\2R\17\3\2\2\2ST\7\t\2\2TU\7\16\2\2UV"+
		"\7\31\2\2VW\b\t\1\2WX\7\17\2\2XY\7\23\2\2YZ\b\t\1\2Z\21\3\2\2\2[\\\7\31"+
		"\2\2\\]\b\n\1\2]^\7\30\2\2^_\b\n\1\2_`\5\24\13\2`a\7\23\2\2ab\b\n\1\2"+
		"b\23\3\2\2\2ci\5\26\f\2de\7\25\2\2ef\b\13\1\2fh\5\26\f\2gd\3\2\2\2hk\3"+
		"\2\2\2ig\3\2\2\2ij\3\2\2\2j\25\3\2\2\2ki\3\2\2\2lm\7\31\2\2mr\b\f\1\2"+
		"no\5\34\17\2op\b\f\1\2pr\3\2\2\2ql\3\2\2\2qn\3\2\2\2r\27\3\2\2\2st\7\n"+
		"\2\2tu\b\r\1\2uv\7\16\2\2vw\7\31\2\2wx\b\r\1\2xy\7\27\2\2y}\b\r\1\2z{"+
		"\7\31\2\2{~\b\r\1\2|~\5\34\17\2}z\3\2\2\2}|\3\2\2\2~\177\3\2\2\2\177\u0080"+
		"\b\r\1\2\u0080\u0081\7\17\2\2\u0081\u0082\7\20\2\2\u0082\u0084\b\r\1\2"+
		"\u0083\u0085\5\f\7\2\u0084\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0084"+
		"\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0089\7\21\2\2"+
		"\u0089\u0095\b\r\1\2\u008a\u008b\7\13\2\2\u008b\u008c\7\20\2\2\u008c\u008e"+
		"\b\r\1\2\u008d\u008f\5\f\7\2\u008e\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090"+
		"\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093\7\21"+
		"\2\2\u0093\u0094\b\r\1\2\u0094\u0096\3\2\2\2\u0095\u008a\3\2\2\2\u0095"+
		"\u0096\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098\b\r\1\2\u0098\31\3\2\2"+
		"\2\u0099\u009a\7\f\2\2\u009a\u009b\b\16\1\2\u009b\u009c\7\20\2\2\u009c"+
		"\u009e\b\16\1\2\u009d\u009f\5\f\7\2\u009e\u009d\3\2\2\2\u009f\u00a0\3"+
		"\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2"+
		"\u00a3\7\21\2\2\u00a3\u00a4\b\16\1\2\u00a4\u00a5\7\r\2\2\u00a5\u00a6\7"+
		"\16\2\2\u00a6\u00a7\7\31\2\2\u00a7\u00a8\b\16\1\2\u00a8\u00a9\7\27\2\2"+
		"\u00a9\u00ad\b\16\1\2\u00aa\u00ab\7\31\2\2\u00ab\u00ae\b\16\1\2\u00ac"+
		"\u00ae\5\34\17\2\u00ad\u00aa\3\2\2\2\u00ad\u00ac\3\2\2\2\u00ae\u00af\3"+
		"\2\2\2\u00af\u00b0\b\16\1\2\u00b0\u00b1\7\17\2\2\u00b1\u00b2\7\23\2\2"+
		"\u00b2\u00b3\b\16\1\2\u00b3\33\3\2\2\2\u00b4\u00b5\7\32\2\2\u00b5\u00bb"+
		"\b\17\1\2\u00b6\u00b7\7\33\2\2\u00b7\u00bb\b\17\1\2\u00b8\u00b9\7\34\2"+
		"\2\u00b9\u00bb\b\17\1\2\u00ba\u00b4\3\2\2\2\u00ba\u00b6\3\2\2\2\u00ba"+
		"\u00b8\3\2\2\2\u00bb\35\3\2\2\2\20\'\61<BIiq}\u0086\u0090\u0095\u00a0"+
		"\u00ad\u00ba";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}