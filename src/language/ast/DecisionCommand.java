package language.ast;

import java.util.ArrayList;

public class DecisionCommand extends AbstractCommand {
    private String condition;
    private ArrayList<AbstractCommand> listTrue;
    private ArrayList<AbstractCommand> listFalse;

    public DecisionCommand(String condition, ArrayList<AbstractCommand> listTrue,
                           ArrayList<AbstractCommand> listFalse) {
        this.condition  = condition;
        this.listTrue   = listTrue;
        this.listFalse  = listFalse;
    }

    @Override
    public String generateJavaCode() {
        StringBuilder str = new StringBuilder();
        str.append("if (" + condition + ") {\n");
        for (AbstractCommand cmd: listTrue) {
            str.append(cmd.generateJavaCode() + "\n");
        }
        str.append("}");
        if (listFalse.size() > 0) {
            str.append(" else {\n");
            for (AbstractCommand cmd: listFalse) {
                str.append(cmd.generateJavaCode() + "\n");
            }
            str.append("}");
        }
        return str.toString();
    }

    @Override
    public String toString() {
        return "DecisionCommand{" +
                "condition='" + condition + '\'' +
                ", listTrue=" + listTrue +
                ", listFalse=" + listFalse +
                '}';
    }
}
