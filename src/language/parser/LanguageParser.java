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
		RULE_iLaco = 12, RULE_facaEnquanto = 13, RULE_enquanto = 14, RULE_valor = 15;
	public static final String[] ruleNames = {
		"programa", "declaracoes", "declaracao", "tipo", "conteudo", "instrucao", 
		"iLeitura", "iEscrita", "iAttribuicao", "expressao", "termo", "iSelecao", 
		"iLaco", "facaEnquanto", "enquanto", "valor"
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

	    public void verificacaoDeTipos(String nome, ArrayList<Integer> listaTipos){
	        int type = retornaTipo(nome);
	        for(int tipo : listaTipos) {
	            if(type != tipo) {
	                throw new SemanticException("Variable " + nome + " (type: "+ retornaNomeDoTipo(type)
	                     + ") does not match with the type " + retornaNomeDoTipo(tipo));
	            }
	        }
	    }

	    public String retornaNomeDoTipo (int type) {
	        if (type == 0) {
	            return "Fracionado";
	        } else if (type == 1) {
	            return "Texto";
	        } else {
	            return "Inteiro";
	        }
	    }

	    public int retornaTipo(String termo) {
	        Variable variable = (Variable) tabela.getSymbol(termo);
	        return variable.getType();
	    }

	    public void verificaValor(String termo) {
	        Variable variable = (Variable) tabela.getSymbol(termo);
	        if (variable.getValue() == null) {
	            throw new SemanticException("Id " +"'"+ termo + "'"+ " doesn't have an attributed value.");
	        }
	    }

	    public void verificaId(String id) {
	        if (!tabela.exists(id)) {
	            throw new SemanticException("Symbol (" + "'"+ id + "'" + ") doesn't exist.");
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

	    public void exibeTabelaComVariaveisNull() {
	        ArrayList<Symbol> lista = tabela.getAllSymbols();
	        Variable variable;
	        for (Symbol s : lista) {
	           variable = (Variable) s;
	            if(variable.getValue() == null ) {
	                System.out.println("Warning: " + s.getName() + " is not been used.");
	            }
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
			setState(32);
			match(T__0);
			setState(33);
			declaracoes();
			setState(34);
			conteudo();
			setState(35);
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
			setState(39); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(38);
				declaracao();
				}
				}
				setState(41); 
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
			setState(43);
			tipo();
			setState(44);
			match(Id);

			                    _varNome    = _input.LT(-1).getText();
			                    _varValor   = null;
			                    simbolo     = new Variable(_varNome, _tipo, _varValor);

			                    if (!tabela.exists(_varNome)) {
			                        System.out.println("Symbolo adicionado: " + simbolo);
			                        tabela.addSymbol(simbolo);
			                    } else throw new SemanticException("Symbol (" + _varNome + ") already declared");
			                
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==V) {
				{
				{
				setState(46);
				match(V);
				setState(47);
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
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(54);
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
			setState(62);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				match(T__2);
				 _tipo = Variable.FRACIONADO; 
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(58);
				match(T__3);
				 _tipo = Variable.TEXT;   
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(60);
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
			                
			setState(66); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(65);
				instrucao();
				}
				}
				setState(68); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << Id))) != 0) );
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
			setState(75);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Id:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				iAttribuicao();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				iLeitura();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 3);
				{
				setState(72);
				iEscrita();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 4);
				{
				setState(73);
				iSelecao();
				}
				break;
			case T__9:
			case T__10:
				enterOuterAlt(_localctx, 5);
				{
				setState(74);
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
			setState(77);
			match(T__5);
			setState(78);
			match(P1);
			setState(79);
			match(Id);

			                    verificaId(_input.LT(-1).getText());
			                    _lerId = _input.LT(-1).getText();
			                
			setState(81);
			match(P2);
			setState(82);
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
			setState(85);
			match(T__6);
			setState(86);
			match(P1);
			setState(87);
			match(Id);

			                    verificaId(_input.LT(-1).getText());
			                    _escreverId = _input.LT(-1).getText();
			                
			setState(89);
			match(P2);
			setState(90);
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
			setState(93);
			match(Id);

			                    listaTipos = new ArrayList<Integer>();
			                    verificaId(_input.LT(-1).getText());
			                    _expressaoId = _input.LT(-1).getText();
			                
			setState(95);
			match(Atributo);

			                    _expressaoConteudo = "";
			                
			setState(97);
			expressao();
			setState(98);
			match(PV);

			                    // Associa os novos valores à variável e atualiza ela na tabela

			                    verificacaoDeTipos(_expressaoId, listaTipos);

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
			setState(101);
			termo();
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Operador) {
				{
				{
				setState(102);
				match(Operador);

				                    _expressaoConteudo += _input.LT(-1).getText();
				                  
				setState(104);
				termo();
				}
				}
				setState(109);
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
			setState(115);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Id:
				enterOuterAlt(_localctx, 1);
				{
				setState(110);
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
				setState(112);
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
			setState(117);
			match(T__7);

			                    // Limpa entradas anteriores
			                    listaVerdadeiro = new ArrayList<AbstractCommand>();
			                    listaFalso = new ArrayList<AbstractCommand>();
			                    listaTipos = new ArrayList<Integer>();
			                
			setState(119);
			match(P1);
			setState(120);
			match(Id);

			                    verificaId(_input.LT(-1).getText());
			                    verificaValor(_input.LT(-1).getText());
			                    _expressaoDecisao = _input.LT(-1).getText();
			                    _expressaoDecisaoId = _input.LT(-1).getText();
			                    listaTipos.add(retornaTipo(_expressaoDecisaoId));
			                
			setState(122);
			match(Relacional);

			                    _expressaoDecisao += _input.LT(-1).getText();
			                
			setState(127);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Id:
				{
				setState(124);
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
				setState(126);
				valor();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}

			                    _expressaoDecisao += _input.LT(-1).getText();
			                
			setState(130);
			match(P2);
			setState(131);
			match(C1);

			                    verificacaoDeTipos(_expressaoDecisaoId, listaTipos);
			                    threadAtual = new ArrayList<AbstractCommand>();
			                    pilha.push(threadAtual);
			                
			setState(134); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(133);
				instrucao();
				}
				}
				setState(136); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << Id))) != 0) );
			setState(138);
			match(C2);

			                    listaVerdadeiro = pilha.pop();
			                
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(140);
				match(T__8);
				setState(141);
				match(C1);

				                    threadAtual = new ArrayList<AbstractCommand>();
				                    pilha.push(threadAtual);
				                
				setState(144); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(143);
					instrucao();
					}
					}
					setState(146); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << Id))) != 0) );
				setState(148);
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
		public FacaEnquantoContext facaEnquanto() {
			return getRuleContext(FacaEnquantoContext.class,0);
		}
		public EnquantoContext enquanto() {
			return getRuleContext(EnquantoContext.class,0);
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
		try {
			setState(157);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				facaEnquanto();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				setState(156);
				enquanto();
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

	public static class FacaEnquantoContext extends ParserRuleContext {
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
		public FacaEnquantoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_facaEnquanto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterFacaEnquanto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitFacaEnquanto(this);
		}
	}

	public final FacaEnquantoContext facaEnquanto() throws RecognitionException {
		FacaEnquantoContext _localctx = new FacaEnquantoContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_facaEnquanto);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(T__9);

			                    // Limpa conteúdo anterior
			                    listaLaco = new ArrayList<AbstractCommand>();
			                    listaTipos = new ArrayList<Integer>();
			                
			setState(161);
			match(C1);

			                    // Cria nova lista de comandos
			                    threadAtual = new ArrayList<AbstractCommand>();
			                    pilha.push(threadAtual);
			                
			setState(164); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(163);
				instrucao();
				}
				}
				setState(166); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << Id))) != 0) );
			setState(168);
			match(C2);

			                    // Armazena e limpa último item da pilha
			                    listaLaco = pilha.pop();
			                
			setState(170);
			match(T__10);
			setState(171);
			match(P1);
			setState(172);
			match(Id);

			                    verificaId(_input.LT(-1).getText());
			                    verificaValor(_input.LT(-1).getText());
			                    _expressaoLacoId = _input.LT(-1).getText();
			                    _expressaoLaco = _input.LT(-1).getText();

			                
			setState(174);
			match(Relacional);

			                    _expressaoLaco += _input.LT(-1).getText();
			                
			setState(179);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Id:
				{
				setState(176);
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
				setState(178);
				valor();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}

			                    _expressaoLaco += _input.LT(-1).getText();
			                
			setState(182);
			match(P2);
			setState(183);
			match(PV);

			                    verificacaoDeTipos(_expressaoLacoId, listaTipos);
			                    LoopCommand cmd = new LoopCommand(_expressaoLaco, listaLaco, 0);
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

	public static class EnquantoContext extends ParserRuleContext {
		public TerminalNode P1() { return getToken(LanguageParser.P1, 0); }
		public List<TerminalNode> Id() { return getTokens(LanguageParser.Id); }
		public TerminalNode Id(int i) {
			return getToken(LanguageParser.Id, i);
		}
		public TerminalNode Relacional() { return getToken(LanguageParser.Relacional, 0); }
		public TerminalNode P2() { return getToken(LanguageParser.P2, 0); }
		public TerminalNode C1() { return getToken(LanguageParser.C1, 0); }
		public TerminalNode C2() { return getToken(LanguageParser.C2, 0); }
		public ValorContext valor() {
			return getRuleContext(ValorContext.class,0);
		}
		public List<InstrucaoContext> instrucao() {
			return getRuleContexts(InstrucaoContext.class);
		}
		public InstrucaoContext instrucao(int i) {
			return getRuleContext(InstrucaoContext.class,i);
		}
		public EnquantoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enquanto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterEnquanto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitEnquanto(this);
		}
	}

	public final EnquantoContext enquanto() throws RecognitionException {
		EnquantoContext _localctx = new EnquantoContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_enquanto);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(T__10);
			setState(187);
			match(P1);
			setState(188);
			match(Id);

			                    // Limpa conteúdo anterior
			                    listaLaco = new ArrayList<AbstractCommand>();
			                    listaTipos = new ArrayList<Integer>();
			                    //
			                    verificaId(_input.LT(-1).getText());
			                    verificaValor(_input.LT(-1).getText());
			                    _expressaoLacoId = _input.LT(-1).getText();
			                    _expressaoLaco = _input.LT(-1).getText();

			                
			setState(190);
			match(Relacional);

			                    _expressaoLaco += _input.LT(-1).getText();
			                
			setState(195);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Id:
				{
				setState(192);
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
				setState(194);
				valor();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}

			                    _expressaoLaco += _input.LT(-1).getText();
			                
			setState(198);
			match(P2);

			                    verificacaoDeTipos(_expressaoLacoId, listaTipos);
			                
			setState(200);
			match(C1);

			                    // Cria nova lista de comandos
			                    threadAtual = new ArrayList<AbstractCommand>();
			                    pilha.push(threadAtual);
			                
			setState(203); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(202);
				instrucao();
				}
				}
				setState(205); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << Id))) != 0) );
			setState(207);
			match(C2);

			                    // Armazena e limpa último item da pilha
			                    listaLaco = pilha.pop();
			                    LoopCommand cmd = new LoopCommand(_expressaoLaco, listaLaco, 1);
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
		enterRule(_localctx, 30, RULE_valor);
		try {
			setState(216);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Fracionado:
				enterOuterAlt(_localctx, 1);
				{
				setState(210);
				match(Fracionado);
				 listaTipos.add(Variable.FRACIONADO); 
				}
				break;
			case Inteiro:
				enterOuterAlt(_localctx, 2);
				{
				setState(212);
				match(Inteiro);
				 listaTipos.add(Variable.INTEIRO); 
				}
				break;
			case Texto:
				enterOuterAlt(_localctx, 3);
				{
				setState(214);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\34\u00dd\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\3\6\3*\n\3\r\3\16\3+\3\4\3\4\3\4\3\4\3\4\3\4\7\4\64"+
		"\n\4\f\4\16\4\67\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\5\5A\n\5\3\6\3\6"+
		"\6\6E\n\6\r\6\16\6F\3\7\3\7\3\7\3\7\3\7\5\7N\n\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\13\3\13\3\13\3\13\7\13l\n\13\f\13\16\13o\13\13\3\f\3\f\3\f\3\f"+
		"\3\f\5\fv\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0082\n\r\3"+
		"\r\3\r\3\r\3\r\3\r\6\r\u0089\n\r\r\r\16\r\u008a\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\6\r\u0093\n\r\r\r\16\r\u0094\3\r\3\r\3\r\5\r\u009a\n\r\3\r\3\r\3\16"+
		"\3\16\5\16\u00a0\n\16\3\17\3\17\3\17\3\17\3\17\6\17\u00a7\n\17\r\17\16"+
		"\17\u00a8\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17"+
		"\u00b6\n\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\5\20\u00c6\n\20\3\20\3\20\3\20\3\20\3\20\3\20\6\20\u00ce\n"+
		"\20\r\20\16\20\u00cf\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\5\21"+
		"\u00db\n\21\3\21\2\2\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\2\2"+
		"\u00e2\2\"\3\2\2\2\4)\3\2\2\2\6-\3\2\2\2\b@\3\2\2\2\nB\3\2\2\2\fM\3\2"+
		"\2\2\16O\3\2\2\2\20W\3\2\2\2\22_\3\2\2\2\24g\3\2\2\2\26u\3\2\2\2\30w\3"+
		"\2\2\2\32\u009f\3\2\2\2\34\u00a1\3\2\2\2\36\u00bc\3\2\2\2 \u00da\3\2\2"+
		"\2\"#\7\3\2\2#$\5\4\3\2$%\5\n\6\2%&\7\4\2\2&\'\b\2\1\2\'\3\3\2\2\2(*\5"+
		"\6\4\2)(\3\2\2\2*+\3\2\2\2+)\3\2\2\2+,\3\2\2\2,\5\3\2\2\2-.\5\b\5\2./"+
		"\7\31\2\2/\65\b\4\1\2\60\61\7\22\2\2\61\62\7\31\2\2\62\64\b\4\1\2\63\60"+
		"\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\668\3\2\2\2\67\65\3"+
		"\2\2\289\7\23\2\29\7\3\2\2\2:;\7\5\2\2;A\b\5\1\2<=\7\6\2\2=A\b\5\1\2>"+
		"?\7\7\2\2?A\b\5\1\2@:\3\2\2\2@<\3\2\2\2@>\3\2\2\2A\t\3\2\2\2BD\b\6\1\2"+
		"CE\5\f\7\2DC\3\2\2\2EF\3\2\2\2FD\3\2\2\2FG\3\2\2\2G\13\3\2\2\2HN\5\22"+
		"\n\2IN\5\16\b\2JN\5\20\t\2KN\5\30\r\2LN\5\32\16\2MH\3\2\2\2MI\3\2\2\2"+
		"MJ\3\2\2\2MK\3\2\2\2ML\3\2\2\2N\r\3\2\2\2OP\7\b\2\2PQ\7\16\2\2QR\7\31"+
		"\2\2RS\b\b\1\2ST\7\17\2\2TU\7\23\2\2UV\b\b\1\2V\17\3\2\2\2WX\7\t\2\2X"+
		"Y\7\16\2\2YZ\7\31\2\2Z[\b\t\1\2[\\\7\17\2\2\\]\7\23\2\2]^\b\t\1\2^\21"+
		"\3\2\2\2_`\7\31\2\2`a\b\n\1\2ab\7\30\2\2bc\b\n\1\2cd\5\24\13\2de\7\23"+
		"\2\2ef\b\n\1\2f\23\3\2\2\2gm\5\26\f\2hi\7\25\2\2ij\b\13\1\2jl\5\26\f\2"+
		"kh\3\2\2\2lo\3\2\2\2mk\3\2\2\2mn\3\2\2\2n\25\3\2\2\2om\3\2\2\2pq\7\31"+
		"\2\2qv\b\f\1\2rs\5 \21\2st\b\f\1\2tv\3\2\2\2up\3\2\2\2ur\3\2\2\2v\27\3"+
		"\2\2\2wx\7\n\2\2xy\b\r\1\2yz\7\16\2\2z{\7\31\2\2{|\b\r\1\2|}\7\27\2\2"+
		"}\u0081\b\r\1\2~\177\7\31\2\2\177\u0082\b\r\1\2\u0080\u0082\5 \21\2\u0081"+
		"~\3\2\2\2\u0081\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084\b\r\1\2"+
		"\u0084\u0085\7\17\2\2\u0085\u0086\7\20\2\2\u0086\u0088\b\r\1\2\u0087\u0089"+
		"\5\f\7\2\u0088\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u0088\3\2\2\2\u008a"+
		"\u008b\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008d\7\21\2\2\u008d\u0099\b"+
		"\r\1\2\u008e\u008f\7\13\2\2\u008f\u0090\7\20\2\2\u0090\u0092\b\r\1\2\u0091"+
		"\u0093\5\f\7\2\u0092\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0092\3\2"+
		"\2\2\u0094\u0095\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0097\7\21\2\2\u0097"+
		"\u0098\b\r\1\2\u0098\u009a\3\2\2\2\u0099\u008e\3\2\2\2\u0099\u009a\3\2"+
		"\2\2\u009a\u009b\3\2\2\2\u009b\u009c\b\r\1\2\u009c\31\3\2\2\2\u009d\u00a0"+
		"\5\34\17\2\u009e\u00a0\5\36\20\2\u009f\u009d\3\2\2\2\u009f\u009e\3\2\2"+
		"\2\u00a0\33\3\2\2\2\u00a1\u00a2\7\f\2\2\u00a2\u00a3\b\17\1\2\u00a3\u00a4"+
		"\7\20\2\2\u00a4\u00a6\b\17\1\2\u00a5\u00a7\5\f\7\2\u00a6\u00a5\3\2\2\2"+
		"\u00a7\u00a8\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa"+
		"\3\2\2\2\u00aa\u00ab\7\21\2\2\u00ab\u00ac\b\17\1\2\u00ac\u00ad\7\r\2\2"+
		"\u00ad\u00ae\7\16\2\2\u00ae\u00af\7\31\2\2\u00af\u00b0\b\17\1\2\u00b0"+
		"\u00b1\7\27\2\2\u00b1\u00b5\b\17\1\2\u00b2\u00b3\7\31\2\2\u00b3\u00b6"+
		"\b\17\1\2\u00b4\u00b6\5 \21\2\u00b5\u00b2\3\2\2\2\u00b5\u00b4\3\2\2\2"+
		"\u00b6\u00b7\3\2\2\2\u00b7\u00b8\b\17\1\2\u00b8\u00b9\7\17\2\2\u00b9\u00ba"+
		"\7\23\2\2\u00ba\u00bb\b\17\1\2\u00bb\35\3\2\2\2\u00bc\u00bd\7\r\2\2\u00bd"+
		"\u00be\7\16\2\2\u00be\u00bf\7\31\2\2\u00bf\u00c0\b\20\1\2\u00c0\u00c1"+
		"\7\27\2\2\u00c1\u00c5\b\20\1\2\u00c2\u00c3\7\31\2\2\u00c3\u00c6\b\20\1"+
		"\2\u00c4\u00c6\5 \21\2\u00c5\u00c2\3\2\2\2\u00c5\u00c4\3\2\2\2\u00c6\u00c7"+
		"\3\2\2\2\u00c7\u00c8\b\20\1\2\u00c8\u00c9\7\17\2\2\u00c9\u00ca\b\20\1"+
		"\2\u00ca\u00cb\7\20\2\2\u00cb\u00cd\b\20\1\2\u00cc\u00ce\5\f\7\2\u00cd"+
		"\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2"+
		"\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2\7\21\2\2\u00d2\u00d3\b\20\1\2\u00d3"+
		"\37\3\2\2\2\u00d4\u00d5\7\32\2\2\u00d5\u00db\b\21\1\2\u00d6\u00d7\7\33"+
		"\2\2\u00d7\u00db\b\21\1\2\u00d8\u00d9\7\34\2\2\u00d9\u00db\b\21\1\2\u00da"+
		"\u00d4\3\2\2\2\u00da\u00d6\3\2\2\2\u00da\u00d8\3\2\2\2\u00db!\3\2\2\2"+
		"\23+\65@FMmu\u0081\u008a\u0094\u0099\u009f\u00a8\u00b5\u00c5\u00cf\u00da";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}