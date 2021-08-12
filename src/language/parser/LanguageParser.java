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
		T__9=10, T__10=11, T__11=12, P1=13, P2=14, C1=15, C2=16, V=17, PV=18, 
		Esp=19, Operador=20, OperadorAttribuicao=21, Relacional=22, Atributo=23, 
		Id=24, Fracionado=25, Inteiro=26, Texto=27, Caractere=28;
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
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5))) != 0) );
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
			//                        System.out.println("Symbolo adicionado: " + simbolo);
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
				//                        System.out.println("Symbolo adicionado: " + simbolo);
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
			setState(64);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				match(T__2);
				 _tipo = Variable.CARACTERE; 
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(58);
				match(T__3);
				 _tipo = Variable.TEXTO; 
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
			case T__5:
				enterOuterAlt(_localctx, 4);
				{
				setState(62);
				match(T__5);
				 _tipo = Variable.FRACIONADO; 
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
			                
			setState(68); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(67);
				instrucao();
				}
				}
				setState(70); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << Id))) != 0) );
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
			setState(77);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Id:
				enterOuterAlt(_localctx, 1);
				{
				setState(72);
				iAttribuicao();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				iLeitura();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 3);
				{
				setState(74);
				iEscrita();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 4);
				{
				setState(75);
				iSelecao();
				}
				break;
			case T__10:
			case T__11:
				enterOuterAlt(_localctx, 5);
				{
				setState(76);
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
			setState(79);
			match(T__6);
			setState(80);
			match(P1);
			setState(81);
			match(Id);

			                    verificaId(_input.LT(-1).getText());
			                    _lerId = _input.LT(-1).getText();
			                
			setState(83);
			match(P2);
			setState(84);
			match(PV);

			                    Variable var = (Variable) tabela.getSymbol(_lerId);
			                    var.setRead(true);

			                    // Marca a variável como lida
			                    tabela.setSymbol(_lerId, var);

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
			setState(87);
			match(T__7);
			setState(88);
			match(P1);
			setState(89);
			match(Id);

			                    verificaId(_input.LT(-1).getText());
			                    _escreverId = _input.LT(-1).getText();
			                
			setState(91);
			match(P2);
			setState(92);
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
			setState(95);
			match(Id);

			                    listaTipos = new ArrayList<Integer>();
			                    verificaId(_input.LT(-1).getText());
			                    _expressaoId = _input.LT(-1).getText();
			                
			setState(97);
			match(Atributo);

			                    _expressaoConteudo = "";
			                
			setState(99);
			expressao();
			setState(100);
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
			setState(103);
			termo();
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Operador) {
				{
				{
				setState(104);
				match(Operador);

				                    _expressaoConteudo += _input.LT(-1).getText();
				                  
				setState(106);
				termo();
				}
				}
				setState(111);
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
			setState(117);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Id:
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
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
			case Caractere:
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
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
			setState(119);
			match(T__8);

			                    // Limpa entradas anteriores
			                    listaVerdadeiro = new ArrayList<AbstractCommand>();
			                    listaFalso = new ArrayList<AbstractCommand>();
			                    listaTipos = new ArrayList<Integer>();
			                
			setState(121);
			match(P1);
			setState(122);
			match(Id);

			                    verificaId(_input.LT(-1).getText());
			                    verificaValor(_input.LT(-1).getText());
			                    _expressaoDecisao = _input.LT(-1).getText();
			                    _expressaoDecisaoId = _input.LT(-1).getText();
			                    listaTipos.add(retornaTipo(_expressaoDecisaoId));
			                
			setState(124);
			match(Relacional);

			                    _expressaoDecisao += _input.LT(-1).getText();
			                
			setState(129);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Id:
				{
				setState(126);
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
			case Caractere:
				{
				setState(128);
				valor();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}

			                    _expressaoDecisao += _input.LT(-1).getText();
			                
			setState(132);
			match(P2);
			setState(133);
			match(C1);

			                    verificacaoDeTipos(_expressaoDecisaoId, listaTipos);
			                    threadAtual = new ArrayList<AbstractCommand>();
			                    pilha.push(threadAtual);
			                
			setState(136); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(135);
				instrucao();
				}
				}
				setState(138); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << Id))) != 0) );
			setState(140);
			match(C2);

			                    listaVerdadeiro = pilha.pop();
			                
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(142);
				match(T__9);
				setState(143);
				match(C1);

				                    threadAtual = new ArrayList<AbstractCommand>();
				                    pilha.push(threadAtual);
				                
				setState(146); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(145);
					instrucao();
					}
					}
					setState(148); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << Id))) != 0) );
				setState(150);
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
			setState(159);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				facaEnquanto();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
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
			setState(161);
			match(T__10);

			                    // Limpa conteúdo anterior
			                    listaLaco = new ArrayList<AbstractCommand>();
			                    listaTipos = new ArrayList<Integer>();
			                
			setState(163);
			match(C1);

			                    // Cria nova lista de comandos
			                    threadAtual = new ArrayList<AbstractCommand>();
			                    pilha.push(threadAtual);
			                
			setState(166); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(165);
				instrucao();
				}
				}
				setState(168); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << Id))) != 0) );
			setState(170);
			match(C2);

			                    // Armazena e limpa último item da pilha
			                    listaLaco = pilha.pop();
			                
			setState(172);
			match(T__11);
			setState(173);
			match(P1);
			setState(174);
			match(Id);

			                    verificaId(_input.LT(-1).getText());
			                    verificaValor(_input.LT(-1).getText());
			                    _expressaoLacoId = _input.LT(-1).getText();
			                    _expressaoLaco = _input.LT(-1).getText();

			                
			setState(176);
			match(Relacional);

			                    _expressaoLaco += _input.LT(-1).getText();
			                
			setState(181);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Id:
				{
				setState(178);
				match(Id);

				                    verificaId(_input.LT(-1).getText());
				                    verificaValor(_input.LT(-1).getText());
				                    listaTipos.add(retornaTipo(_input.LT(-1).getText()));
				                
				}
				break;
			case Fracionado:
			case Inteiro:
			case Texto:
			case Caractere:
				{
				setState(180);
				valor();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}

			                    _expressaoLaco += _input.LT(-1).getText();
			                
			setState(184);
			match(P2);
			setState(185);
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
			setState(188);
			match(T__11);
			setState(189);
			match(P1);
			setState(190);
			match(Id);

			                    // Limpa conteúdo anterior
			                    listaLaco = new ArrayList<AbstractCommand>();
			                    listaTipos = new ArrayList<Integer>();

			                    verificaId(_input.LT(-1).getText());
			                    verificaValor(_input.LT(-1).getText());
			                    _expressaoLacoId = _input.LT(-1).getText();
			                    _expressaoLaco = _input.LT(-1).getText();
			                
			setState(192);
			match(Relacional);

			                    _expressaoLaco += _input.LT(-1).getText();
			                
			setState(197);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Id:
				{
				setState(194);
				match(Id);

				                    verificaId(_input.LT(-1).getText());
				                    verificaValor(_input.LT(-1).getText());
				                    listaTipos.add(retornaTipo(_input.LT(-1).getText()));
				                
				}
				break;
			case Fracionado:
			case Inteiro:
			case Texto:
			case Caractere:
				{
				setState(196);
				valor();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}

			                    _expressaoLaco += _input.LT(-1).getText();
			                
			setState(200);
			match(P2);

			                    verificacaoDeTipos(_expressaoLacoId, listaTipos);
			                
			setState(202);
			match(C1);

			                    // Cria nova lista de comandos
			                    threadAtual = new ArrayList<AbstractCommand>();
			                    pilha.push(threadAtual);
			                
			setState(205); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(204);
				instrucao();
				}
				}
				setState(207); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << Id))) != 0) );
			setState(209);
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
		public TerminalNode Caractere() { return getToken(LanguageParser.Caractere, 0); }
		public TerminalNode Texto() { return getToken(LanguageParser.Texto, 0); }
		public TerminalNode Inteiro() { return getToken(LanguageParser.Inteiro, 0); }
		public TerminalNode Fracionado() { return getToken(LanguageParser.Fracionado, 0); }
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
			setState(220);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Caractere:
				enterOuterAlt(_localctx, 1);
				{
				setState(212);
				match(Caractere);
				 listaTipos.add(Variable.CARACTERE); 
				}
				break;
			case Texto:
				enterOuterAlt(_localctx, 2);
				{
				setState(214);
				match(Texto);
				 listaTipos.add(Variable.TEXTO); 
				}
				break;
			case Inteiro:
				enterOuterAlt(_localctx, 3);
				{
				setState(216);
				match(Inteiro);
				 listaTipos.add(Variable.INTEIRO); 
				}
				break;
			case Fracionado:
				enterOuterAlt(_localctx, 4);
				{
				setState(218);
				match(Fracionado);
				 listaTipos.add(Variable.FRACIONADO); 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\36\u00e1\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\3\6\3*\n\3\r\3\16\3+\3\4\3\4\3\4\3\4\3\4\3\4\7\4\64"+
		"\n\4\f\4\16\4\67\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5C\n\5"+
		"\3\6\3\6\6\6G\n\6\r\6\16\6H\3\7\3\7\3\7\3\7\3\7\5\7P\n\7\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\3\13\7\13n\n\13\f\13\16\13q\13\13\3\f\3\f"+
		"\3\f\3\f\3\f\5\fx\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0084"+
		"\n\r\3\r\3\r\3\r\3\r\3\r\6\r\u008b\n\r\r\r\16\r\u008c\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\6\r\u0095\n\r\r\r\16\r\u0096\3\r\3\r\3\r\5\r\u009c\n\r\3\r\3"+
		"\r\3\16\3\16\5\16\u00a2\n\16\3\17\3\17\3\17\3\17\3\17\6\17\u00a9\n\17"+
		"\r\17\16\17\u00aa\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\5\17\u00b8\n\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\5\20\u00c8\n\20\3\20\3\20\3\20\3\20\3\20\3\20\6\20"+
		"\u00d0\n\20\r\20\16\20\u00d1\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\5\21\u00df\n\21\3\21\2\2\22\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \2\2\2\u00e8\2\"\3\2\2\2\4)\3\2\2\2\6-\3\2\2\2\bB\3\2\2\2\n"+
		"D\3\2\2\2\fO\3\2\2\2\16Q\3\2\2\2\20Y\3\2\2\2\22a\3\2\2\2\24i\3\2\2\2\26"+
		"w\3\2\2\2\30y\3\2\2\2\32\u00a1\3\2\2\2\34\u00a3\3\2\2\2\36\u00be\3\2\2"+
		"\2 \u00de\3\2\2\2\"#\7\3\2\2#$\5\4\3\2$%\5\n\6\2%&\7\4\2\2&\'\b\2\1\2"+
		"\'\3\3\2\2\2(*\5\6\4\2)(\3\2\2\2*+\3\2\2\2+)\3\2\2\2+,\3\2\2\2,\5\3\2"+
		"\2\2-.\5\b\5\2./\7\32\2\2/\65\b\4\1\2\60\61\7\23\2\2\61\62\7\32\2\2\62"+
		"\64\b\4\1\2\63\60\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66"+
		"8\3\2\2\2\67\65\3\2\2\289\7\24\2\29\7\3\2\2\2:;\7\5\2\2;C\b\5\1\2<=\7"+
		"\6\2\2=C\b\5\1\2>?\7\7\2\2?C\b\5\1\2@A\7\b\2\2AC\b\5\1\2B:\3\2\2\2B<\3"+
		"\2\2\2B>\3\2\2\2B@\3\2\2\2C\t\3\2\2\2DF\b\6\1\2EG\5\f\7\2FE\3\2\2\2GH"+
		"\3\2\2\2HF\3\2\2\2HI\3\2\2\2I\13\3\2\2\2JP\5\22\n\2KP\5\16\b\2LP\5\20"+
		"\t\2MP\5\30\r\2NP\5\32\16\2OJ\3\2\2\2OK\3\2\2\2OL\3\2\2\2OM\3\2\2\2ON"+
		"\3\2\2\2P\r\3\2\2\2QR\7\t\2\2RS\7\17\2\2ST\7\32\2\2TU\b\b\1\2UV\7\20\2"+
		"\2VW\7\24\2\2WX\b\b\1\2X\17\3\2\2\2YZ\7\n\2\2Z[\7\17\2\2[\\\7\32\2\2\\"+
		"]\b\t\1\2]^\7\20\2\2^_\7\24\2\2_`\b\t\1\2`\21\3\2\2\2ab\7\32\2\2bc\b\n"+
		"\1\2cd\7\31\2\2de\b\n\1\2ef\5\24\13\2fg\7\24\2\2gh\b\n\1\2h\23\3\2\2\2"+
		"io\5\26\f\2jk\7\26\2\2kl\b\13\1\2ln\5\26\f\2mj\3\2\2\2nq\3\2\2\2om\3\2"+
		"\2\2op\3\2\2\2p\25\3\2\2\2qo\3\2\2\2rs\7\32\2\2sx\b\f\1\2tu\5 \21\2uv"+
		"\b\f\1\2vx\3\2\2\2wr\3\2\2\2wt\3\2\2\2x\27\3\2\2\2yz\7\13\2\2z{\b\r\1"+
		"\2{|\7\17\2\2|}\7\32\2\2}~\b\r\1\2~\177\7\30\2\2\177\u0083\b\r\1\2\u0080"+
		"\u0081\7\32\2\2\u0081\u0084\b\r\1\2\u0082\u0084\5 \21\2\u0083\u0080\3"+
		"\2\2\2\u0083\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0086\b\r\1\2\u0086"+
		"\u0087\7\20\2\2\u0087\u0088\7\21\2\2\u0088\u008a\b\r\1\2\u0089\u008b\5"+
		"\f\7\2\u008a\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008a\3\2\2\2\u008c"+
		"\u008d\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f\7\22\2\2\u008f\u009b\b"+
		"\r\1\2\u0090\u0091\7\f\2\2\u0091\u0092\7\21\2\2\u0092\u0094\b\r\1\2\u0093"+
		"\u0095\5\f\7\2\u0094\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0094\3\2"+
		"\2\2\u0096\u0097\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099\7\22\2\2\u0099"+
		"\u009a\b\r\1\2\u009a\u009c\3\2\2\2\u009b\u0090\3\2\2\2\u009b\u009c\3\2"+
		"\2\2\u009c\u009d\3\2\2\2\u009d\u009e\b\r\1\2\u009e\31\3\2\2\2\u009f\u00a2"+
		"\5\34\17\2\u00a0\u00a2\5\36\20\2\u00a1\u009f\3\2\2\2\u00a1\u00a0\3\2\2"+
		"\2\u00a2\33\3\2\2\2\u00a3\u00a4\7\r\2\2\u00a4\u00a5\b\17\1\2\u00a5\u00a6"+
		"\7\21\2\2\u00a6\u00a8\b\17\1\2\u00a7\u00a9\5\f\7\2\u00a8\u00a7\3\2\2\2"+
		"\u00a9\u00aa\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac"+
		"\3\2\2\2\u00ac\u00ad\7\22\2\2\u00ad\u00ae\b\17\1\2\u00ae\u00af\7\16\2"+
		"\2\u00af\u00b0\7\17\2\2\u00b0\u00b1\7\32\2\2\u00b1\u00b2\b\17\1\2\u00b2"+
		"\u00b3\7\30\2\2\u00b3\u00b7\b\17\1\2\u00b4\u00b5\7\32\2\2\u00b5\u00b8"+
		"\b\17\1\2\u00b6\u00b8\5 \21\2\u00b7\u00b4\3\2\2\2\u00b7\u00b6\3\2\2\2"+
		"\u00b8\u00b9\3\2\2\2\u00b9\u00ba\b\17\1\2\u00ba\u00bb\7\20\2\2\u00bb\u00bc"+
		"\7\24\2\2\u00bc\u00bd\b\17\1\2\u00bd\35\3\2\2\2\u00be\u00bf\7\16\2\2\u00bf"+
		"\u00c0\7\17\2\2\u00c0\u00c1\7\32\2\2\u00c1\u00c2\b\20\1\2\u00c2\u00c3"+
		"\7\30\2\2\u00c3\u00c7\b\20\1\2\u00c4\u00c5\7\32\2\2\u00c5\u00c8\b\20\1"+
		"\2\u00c6\u00c8\5 \21\2\u00c7\u00c4\3\2\2\2\u00c7\u00c6\3\2\2\2\u00c8\u00c9"+
		"\3\2\2\2\u00c9\u00ca\b\20\1\2\u00ca\u00cb\7\20\2\2\u00cb\u00cc\b\20\1"+
		"\2\u00cc\u00cd\7\21\2\2\u00cd\u00cf\b\20\1\2\u00ce\u00d0\5\f\7\2\u00cf"+
		"\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2"+
		"\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d4\7\22\2\2\u00d4\u00d5\b\20\1\2\u00d5"+
		"\37\3\2\2\2\u00d6\u00d7\7\36\2\2\u00d7\u00df\b\21\1\2\u00d8\u00d9\7\35"+
		"\2\2\u00d9\u00df\b\21\1\2\u00da\u00db\7\34\2\2\u00db\u00df\b\21\1\2\u00dc"+
		"\u00dd\7\33\2\2\u00dd\u00df\b\21\1\2\u00de\u00d6\3\2\2\2\u00de\u00d8\3"+
		"\2\2\2\u00de\u00da\3\2\2\2\u00de\u00dc\3\2\2\2\u00df!\3\2\2\2\23+\65B"+
		"HOow\u0083\u008c\u0096\u009b\u00a1\u00aa\u00b7\u00c7\u00d1\u00de";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}