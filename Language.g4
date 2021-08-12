grammar Language;

@header {
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
}

@members {
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
}

programa        : 'inicio' declaracoes conteudo 'fim;' {
                    programa.setVarTable(tabela);
                    programa.setCommands(pilha.pop());
                };

declaracoes     : (declaracao)+;

declaracao      : tipo Id {
                    _varNome    = _input.LT(-1).getText();
                    _varValor   = null;
                    simbolo     = new Variable(_varNome, _tipo, _varValor);

                    if (!tabela.exists(_varNome)) {
//                        System.out.println("Symbolo adicionado: " + simbolo);
                        tabela.addSymbol(simbolo);
                    } else throw new SemanticException("Symbol (" + _varNome + ") already declared");
                } (V Id {
                    _varNome    = _input.LT(-1).getText();
                    _varValor   = null;
                    simbolo     = new Variable(_varNome, _tipo, _varValor);

                    if (!tabela.exists(_varNome)) {
//                        System.out.println("Symbolo adicionado: " + simbolo);
                        tabela.addSymbol(simbolo);
                    } else throw new SemanticException("Symbol (" + _varNome + ") already declared");
                })* PV;

tipo            : 'Caractere'   { _tipo = Variable.CARACTERE; }
                | 'Texto'       { _tipo = Variable.TEXTO; }
                | 'Inteiro'     { _tipo = Variable.INTEIRO; }
                | 'Fracionado'  { _tipo = Variable.FRACIONADO; };

conteudo        : {
                    threadAtual = new ArrayList<AbstractCommand>();
                    pilha.push(threadAtual);
                } (instrucao)+;

instrucao       : iAttribuicao
                | iLeitura
                | iEscrita
                | iSelecao
                | iLaco;

iLeitura        : 'ler' P1 Id {
                    verificaId(_input.LT(-1).getText());
                    _lerId = _input.LT(-1).getText();
                } P2 PV {
                    Variable var = (Variable) tabela.getSymbol(_lerId);
                    var.setRead(true);

                    // Marca a variável como lida
                    tabela.setSymbol(_lerId, var);

                    ReadCommand cmd = new ReadCommand(_lerId, var);
                    pilha.peek().add(cmd);
                };

iEscrita        : 'escrever' P1 Id {
                    verificaId(_input.LT(-1).getText());
                    _escreverId = _input.LT(-1).getText();
                } P2 PV {
                    WriteCommand cmd = new WriteCommand(_escreverId);
                    pilha.peek().add(cmd);
                };


iAttribuicao    : Id {
                    listaTipos = new ArrayList<Integer>();
                    verificaId(_input.LT(-1).getText());
                    _expressaoId = _input.LT(-1).getText();
                } Atributo {
                    _expressaoConteudo = "";
                } expressao PV {
                    // Associa os novos valores à variável e atualiza ela na tabela

                    verificacaoDeTipos(_expressaoId, listaTipos);

                    _varNome    = _expressaoId;
                    _varValor   = _expressaoConteudo;
                    simbolo     = new Variable(_varNome, retornaTipo(_varNome), _varValor);
                    tabela.setSymbol(_varNome, simbolo);

                    AssignementCommand cmd = new AssignementCommand(_expressaoId, _expressaoConteudo);
                    pilha.peek().add(cmd);
                };

expressao       : termo ( Operador {
                    _expressaoConteudo += _input.LT(-1).getText();
                  } termo)*;

termo          : Id {
                    String nomeTermo = _input.LT(-1).getText();
                    verificaId(nomeTermo);
                    verificaValor(nomeTermo);
                    _expressaoConteudo += _input.LT(-1).getText();
                    listaTipos.add(retornaTipo(nomeTermo));
                  }
                | valor {
                   _expressaoConteudo += _input.LT(-1).getText();

                };


iSelecao        : 'se' {
                    // Limpa entradas anteriores
                    listaVerdadeiro = new ArrayList<AbstractCommand>();
                    listaFalso = new ArrayList<AbstractCommand>();
                    listaTipos = new ArrayList<Integer>();
                } P1 Id {
                    verificaId(_input.LT(-1).getText());
                    verificaValor(_input.LT(-1).getText());
                    _expressaoDecisao = _input.LT(-1).getText();
                    _expressaoDecisaoId = _input.LT(-1).getText();
                    listaTipos.add(retornaTipo(_expressaoDecisaoId));
                } Relacional {
                    _expressaoDecisao += _input.LT(-1).getText();
                } (Id {
                    verificaId(_input.LT(-1).getText());
                    verificaValor(_input.LT(-1).getText());
                    String _expressaoDecisao2 = _input.LT(-1).getText();
                    listaTipos.add(retornaTipo(_expressaoDecisao2));
                } | valor) {
                    _expressaoDecisao += _input.LT(-1).getText();
                } P2 C1 {
                    verificacaoDeTipos(_expressaoDecisaoId, listaTipos);
                    threadAtual = new ArrayList<AbstractCommand>();
                    pilha.push(threadAtual);
                } (instrucao)+ C2 {
                    listaVerdadeiro = pilha.pop();
                } ('senao' C1 {
                    threadAtual = new ArrayList<AbstractCommand>();
                    pilha.push(threadAtual);
                } (instrucao)+ C2 {
                    listaFalso = pilha.pop();
                })? {
                    DecisionCommand cmd = new DecisionCommand(_expressaoDecisao, listaVerdadeiro, listaFalso);
                    pilha.peek().add(cmd);
                };

iLaco               : facaEnquanto | enquanto;

facaEnquanto    : 'faca' {
                    // Limpa conteúdo anterior
                    listaLaco = new ArrayList<AbstractCommand>();
                    listaTipos = new ArrayList<Integer>();
                } C1 {
                    // Cria nova lista de comandos
                    threadAtual = new ArrayList<AbstractCommand>();
                    pilha.push(threadAtual);
                } (instrucao)+ C2 {
                    // Armazena e limpa último item da pilha
                    listaLaco = pilha.pop();
                } 'enquanto' P1 Id {
                    verificaId(_input.LT(-1).getText());
                    verificaValor(_input.LT(-1).getText());
                    _expressaoLacoId = _input.LT(-1).getText();
                    _expressaoLaco = _input.LT(-1).getText();

                } Relacional {
                    _expressaoLaco += _input.LT(-1).getText();
                } (Id {
                    verificaId(_input.LT(-1).getText());
                    verificaValor(_input.LT(-1).getText());
                    listaTipos.add(retornaTipo(_input.LT(-1).getText()));
                } | valor) {
                    _expressaoLaco += _input.LT(-1).getText();
                } P2 PV {
                    verificacaoDeTipos(_expressaoLacoId, listaTipos);
                    LoopCommand cmd = new LoopCommand(_expressaoLaco, listaLaco, 0);
                    pilha.peek().add(cmd);
                };

enquanto        : 'enquanto' P1 Id {
                    // Limpa conteúdo anterior
                    listaLaco = new ArrayList<AbstractCommand>();
                    listaTipos = new ArrayList<Integer>();

                    verificaId(_input.LT(-1).getText());
                    verificaValor(_input.LT(-1).getText());
                    _expressaoLacoId = _input.LT(-1).getText();
                    _expressaoLaco = _input.LT(-1).getText();
                } Relacional {
                    _expressaoLaco += _input.LT(-1).getText();
                } (Id {
                    verificaId(_input.LT(-1).getText());
                    verificaValor(_input.LT(-1).getText());
                    listaTipos.add(retornaTipo(_input.LT(-1).getText()));
                } | valor) {
                    _expressaoLaco += _input.LT(-1).getText();
                } P2 {
                    verificacaoDeTipos(_expressaoLacoId, listaTipos);
                } C1 {
                    // Cria nova lista de comandos
                    threadAtual = new ArrayList<AbstractCommand>();
                    pilha.push(threadAtual);
                } (instrucao)+ C2 {
                    // Armazena e limpa último item da pilha
                    listaLaco = pilha.pop();
                    LoopCommand cmd = new LoopCommand(_expressaoLaco, listaLaco, 1);
                    pilha.peek().add(cmd);
                };

valor           : Caractere     { listaTipos.add(Variable.CARACTERE); }
                | Texto         { listaTipos.add(Variable.TEXTO); }
                | Inteiro       { listaTipos.add(Variable.INTEIRO); }
                | Fracionado    { listaTipos.add(Variable.FRACIONADO); };

/* Tokens */

P1                  : '(';

P2                  : ')';

C1                  : '{';

C2                  : '}';

V                   : ',';

PV                  : ';';

Esp                 : (' ' | '\n' | '\r' | '\t') -> skip;

Operador            : '+' | '-' | '/' | '*';

OperadorAttribuicao : '+=' | '-=' | '/=' | '*=';

Relacional          : '>' | '>=' | '<' | '<=' | '==' | '!=';

Atributo            : '=';

Id                  : [a-z] ([a-z] | [A-Z] | [0-9])*;

Fracionado          : [0-9]+ '.' [0-9]+;

Inteiro             : [0-9]+;

Texto               : '"' ([a-z] | [A-Z] | [0-9])* '"';

Caractere           : '\'' ([a-z] | [A-Z] | [0-9]) '\'';