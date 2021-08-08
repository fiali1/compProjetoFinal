package language.ast;

import java.util.ArrayList;

public class LoopCommand extends AbstractCommand {
    private String condition;
    private ArrayList<AbstractCommand> listLoop;

    public LoopCommand(String condition, ArrayList<AbstractCommand> listLoop) {
        this.condition  = condition;
        this.listLoop   = listLoop;

//        System.out.println("Debug: (constructor) " + this.condition + ", " + this.listLoop);
    }

    @Override
    public String generateJavaCode() {
//        System.out.println("Debug: (code) " + this.condition + ", " + this.listLoop);

        StringBuilder str = new StringBuilder();
        str.append("do {\n");
        for (AbstractCommand cmd: listLoop) {
            str.append(cmd.generateJavaCode() + "\n");
        }
        str.append("} while (" + condition + ");");

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
