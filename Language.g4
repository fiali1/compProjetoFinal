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
                        System.out.println("Symbolo adicionado: " + simbolo);
                        tabela.addSymbol(simbolo);
                    } else throw new SemanticException("Symbol (" + _varNome + ") already declared");
                } (V Id {
                    _varNome    = _input.LT(-1).getText();
                    _varValor   = null;
                    simbolo     = new Variable(_varNome, _tipo, _varValor);

                    if (!tabela.exists(_varNome)) {
                        System.out.println("Symbolo adicionado: " + simbolo);
                        tabela.addSymbol(simbolo);
                    } else throw new SemanticException("Symbol (" + _varNome + ") already declared");
                })* PV;

tipo            : 'Numero'      { _tipo = Variable.NUMBER; }
                | 'Texto'       { _tipo = Variable.TEXT;   };

conteudo        : {
                    threadAtual = new ArrayList<AbstractCommand>();
                    pilha.push(threadAtual);
                } (instrucao)+;

instrucao       : iAttribuicao
                | iLeitura
                | iEscrita
                | iSelecao;

iLeitura        : 'ler' P1 Id {
                    verificaId(_input.LT(-1).getText());
                    _lerId = _input.LT(-1).getText();
                } P2 PV {
                    Variable var = (Variable) tabela.getSymbol(_lerId);
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
                    verificaId(_input.LT(-1).getText());
                    _expressaoId = _input.LT(-1).getText();
                } Atributo {
                    _expressaoConteudo = "";
                } expressao PV {
                    AssignementCommand cmd = new AssignementCommand(_expressaoId, _expressaoConteudo);
                    pilha.peek().add(cmd);
                };

expressao       : termo ( Operador {
                    _expressaoConteudo += _input.LT(-1).getText();
                  } termo )*;

termo           : Id {
                    verificaId(_input.LT(-1).getText());
                    _expressaoConteudo += _input.LT(-1).getText();
                  }
                | valor {
                   _expressaoConteudo += _input.LT(-1).getText();
                };

iSelecao        : 'se' {
                    // Limpa entradas anteriores
                    listaVerdadeiro = new ArrayList<AbstractCommand>();
                    listaFalso = new ArrayList<AbstractCommand>();
                } P1 Id {
                    verificaId(_input.LT(-1).getText());
                    _expressaoDecisao = _input.LT(-1).getText();
                } Relacional {
                    _expressaoDecisao += _input.LT(-1).getText();
                } (Id {
                    verificaId(_input.LT(-1).getText());
                } | valor) {
                    _expressaoDecisao += _input.LT(-1).getText();
                } P2 C1 {
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

valor           : Numero | Texto;

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

Numero              : [0-9]+ ('.' [0-9]+)?;

Texto               : '"' ([a-z] | [A-Z] | [0-9])* '"';