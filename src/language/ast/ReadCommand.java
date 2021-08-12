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
        int type = var.getType();

        String reader = "";

        if (type == Variable.CARACTERE)
            reader = "next().charAt(0);\n_key.nextLine();";
        else if (type == Variable.TEXTO)
            reader = "nextLine();";
        else if (type == Variable.INTEIRO)
            reader = "nextInt();\n_key.nextLine();";
        else if (type == Variable.FRACIONADO)
            reader = "nextDouble();\n_key.nextLine();";
        else
            reader = "";

        return id + " = _key." + reader;
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
