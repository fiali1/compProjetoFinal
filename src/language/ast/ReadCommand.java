package language.ast;

import language.dataStructures.Variable;

public class ReadCommand extends AbstractCommand {

    private String id;
    private Variable var;

    public ReadCommand(String id, Variable var) {
        this.id     = id;
        this.var    = var;
    }

    @Override
    public String generateJavaCode() {
        return id + " = _key." + (var.getType() == Variable.NUMBER ? "nextDouble();\n_key.nextLine();" : "nextLine()" +
                ";");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ReadCommand{" +
                "id='" + id + '\'' +
                '}';
    }
}
