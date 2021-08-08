package language.ast;

import java.util.ArrayList;

public class LoopCommand extends AbstractCommand {
    private String condition;
    private ArrayList<AbstractCommand> listLoop;

    public LoopCommand(String condition, ArrayList<AbstractCommand> listLoop) {
        this.condition  = condition;
        this.listLoop   = listLoop;
    }

    @Override
    public String generateJavaCode() {
        StringBuilder str = new StringBuilder();
        str.append("for (" + condition + ") {\n");
        for (AbstractCommand cmd: listLoop) {
            str.append(cmd.generateJavaCode() + "\n");
        }
        str.append("}");

        return str.toString();
    }

    @Override
    public String toString() {
        return "LoopCommand{" +
                "condition='" + condition + '\'' +
                ", listLoop=" + listLoop +
                '}';
    }
}
