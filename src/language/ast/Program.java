package language.ast;

import language.dataStructures.Symbol;
import language.dataStructures.SymbolTable;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class Program {
    private SymbolTable varTable;
    private ArrayList<AbstractCommand> commands;
    private String programName;

    public void generateTarget() {
        StringBuilder str = new StringBuilder();
        str.append("import java.util.Scanner;\n");
        str.append("public class MainClass {\n");
        str.append("public static void main(String args[]) {\n");
        str.append("Scanner _key = new Scanner(System.in);\n");
        for (Symbol symbol: varTable.getAllSymbols()) {
            str.append(symbol.generateJavaCode() + "\n");
        }
        for (AbstractCommand command: commands) {
            str.append(command.generateJavaCode() + "\n");
        }
        str.append("}\n");
        str.append("}\n");

        try {
            FileWriter fr = new FileWriter(new File("MainClass.java"));
            fr.write(str.toString());
            fr.close();
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public SymbolTable getVarTable() {
        return varTable;
    }

    public void setVarTable(SymbolTable varTable) {
        this.varTable = varTable;
    }

    public ArrayList<AbstractCommand> getCommands() {
        return commands;
    }

    public void setCommands(ArrayList<AbstractCommand> commands) {
        this.commands = commands;
    }
}
