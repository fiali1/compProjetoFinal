grammar Language;

@header {
    import language.dataStructures.Symbol;
    import language.dataStructures.SymbolTable;
    import language.dataStructures.Variable;
    import language.exceptions.SemanticException;
    import java.util.ArrayList;
}

@members {
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
}

programa        : 'inicio' declaracoes conteudo 'fim;';

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

conteudo        : (instrucao)+;

instrucao       : iAttribuicao
                | iLeitura
                | iEscrita;

iLeitura        : 'ler' P1 Id {
                    _varNome = _input.LT(-1).getText();
                    verificaId(_varNome);
                  } P2 PV;

iEscrita        : 'escrever' P1 Id {
                    _varNome = _input.LT(-1).getText();
                    verificaId(_varNome);
                  } P2 PV;

iAttribuicao    : Id {
                    _varNome = _input.LT(-1).getText();
                    verificaId(_varNome);
                  } Atributo expressao PV;

expressao       : termo ( Operador termo )*;

termo           : Id {
                    _varNome = _input.LT(-1).getText();
                    verificaId(_varNome);
                  }
                | Valor;

/* Tokens */

P1              : '(';

P2              : ')';

V               : ',';

PV              : ';';

Esp             : (' ' | '\n' | '\r' | '\t') -> skip;

Operador        : '+' | '-' | '/' | '*';

Atributo        : '=';

Id              : [a-z] ([a-z] | [A-Z] | [0-9])*;

Valor           : [0-9]+ ('.' [0-9]+)?;