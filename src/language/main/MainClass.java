package language.main;

import language.exceptions.SemanticException;
import language.parser.LanguageLexer;
import language.parser.LanguageParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

// Arquivo fonte: extensão '.comp'
public class MainClass {
    public static void main(String[] args) {
        try {
            LanguageLexer lexer;
            LanguageParser parser;

            lexer = new LanguageLexer(CharStreams.fromFileName("entrada.comp"));
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            parser = new LanguageParser(tokenStream);

            parser.programa();

            System.out.println("File compiled successfully!");
        } catch (SemanticException err) {
            System.err.println("Error: " + err.getMessage());
        } catch (Exception err) {
            System.err.println("Error: " + err.getMessage());
        }
    }
}
