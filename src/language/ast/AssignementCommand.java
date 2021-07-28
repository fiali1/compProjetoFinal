package language.ast;

public class AssignementCommand extends AbstractCommand {
    private String id;
    private String expression;

    public AssignementCommand(String id, String expression) {
        this.id         = id;
        this.expression = expression;
    }

    @Override
    public String generateJavaCode() {
        return id + " " + expression + ";";
    }

    @Override
    public String toString() {
        return "AssignementCommand{" +
                "id='" + id + '\'' +
                ", expression='" + expression + '\'' +
                '}';
    }
}
