package language.main;

import language.exceptions.SemanticException;
import language.parser.LanguageLexer;
import language.parser.LanguageParser;
import org.antlr.v4.runtime.*;

// Arquivo fonte: extensão '.comp'
public class MainClass {
    public static void main(String[] args) {
        try {
            LanguageLexer lexer;
            LanguageParser parser;

            lexer = new LanguageLexer(CharStreams.fromFileName("entrada.comp"));
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            parser = new LanguageParser(tokenStream);

            // Checagem de erros mais estrita - https://stackoverflow.com/questions/51683104/how-to-catch-minor-errors
            parser.removeErrorListeners();
            parser.addErrorListener (new BaseErrorListener()
            {
                @Override
                public void syntaxError (final Recognizer<?,?> recognizer, Object sym, int line, int pos, String msg, RecognitionException e)
                {
                    throw new AssertionError ("ANTLR - syntax-error - line: " + line + ", position: " + pos + ", message: " + msg);
                }
            });

            parser.programa();

//            parser.exibeComandos();

            parser.gerarCodigo();

//            parser.exibeTabela();

            parser.exibeTabelaComVariaveisNull();

            System.out.println("File compiled successfully!");
        } catch (SemanticException err) {
            System.err.println("Error: " + err.getMessage());
        } catch (Exception err) {
            System.err.println("Error: " + err.getMessage());
        }
    }
}
