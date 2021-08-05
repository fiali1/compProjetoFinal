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

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LanguageParser}.
 */
public interface LanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LanguageParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(LanguageParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(LanguageParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#declaracoes}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracoes(LanguageParser.DeclaracoesContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#declaracoes}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracoes(LanguageParser.DeclaracoesContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#declaracao}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao(LanguageParser.DeclaracaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#declaracao}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao(LanguageParser.DeclaracaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(LanguageParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(LanguageParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#conteudo}.
	 * @param ctx the parse tree
	 */
	void enterConteudo(LanguageParser.ConteudoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#conteudo}.
	 * @param ctx the parse tree
	 */
	void exitConteudo(LanguageParser.ConteudoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#instrucao}.
	 * @param ctx the parse tree
	 */
	void enterInstrucao(LanguageParser.InstrucaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#instrucao}.
	 * @param ctx the parse tree
	 */
	void exitInstrucao(LanguageParser.InstrucaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#iLeitura}.
	 * @param ctx the parse tree
	 */
	void enterILeitura(LanguageParser.ILeituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#iLeitura}.
	 * @param ctx the parse tree
	 */
	void exitILeitura(LanguageParser.ILeituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#iEscrita}.
	 * @param ctx the parse tree
	 */
	void enterIEscrita(LanguageParser.IEscritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#iEscrita}.
	 * @param ctx the parse tree
	 */
	void exitIEscrita(LanguageParser.IEscritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#iAttribuicao}.
	 * @param ctx the parse tree
	 */
	void enterIAttribuicao(LanguageParser.IAttribuicaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#iAttribuicao}.
	 * @param ctx the parse tree
	 */
	void exitIAttribuicao(LanguageParser.IAttribuicaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterExpressao(LanguageParser.ExpressaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitExpressao(LanguageParser.ExpressaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(LanguageParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(LanguageParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#iSelecao}.
	 * @param ctx the parse tree
	 */
	void enterISelecao(LanguageParser.ISelecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#iSelecao}.
	 * @param ctx the parse tree
	 */
	void exitISelecao(LanguageParser.ISelecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#valor}.
	 * @param ctx the parse tree
	 */
	void enterValor(LanguageParser.ValorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#valor}.
	 * @param ctx the parse tree
	 */
	void exitValor(LanguageParser.ValorContext ctx);
}