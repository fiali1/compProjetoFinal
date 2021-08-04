package language.ast;

public class WriteCommand extends AbstractCommand {
    private String id;

    public WriteCommand(String id) {
        this.id = id;
    }

    @Override
    public String generateJavaCode() {
        return "System.out.println(" + id + ");";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "WriteCommand{" +
                "id='" + id + '\'' +
                '}';
    }
}
