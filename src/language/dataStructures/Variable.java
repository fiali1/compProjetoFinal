package language.dataStructures;

public class Variable extends Symbol {

    public static final int FRACIONADO = 0;
    public static final int TEXT = 1;
    public static final int INTEIRO = 2;

    private int type;
    private String value;

    public Variable(String name, int type, String value) {
        super(name);
        this.type   = type;
        this.value  = value;
    }

    @Override
    public String generateJavaCode() {
        String str;
        if (type == FRACIONADO)
            str = "double";
        else if (type == TEXT)
            str = "String";
        else {
            str = "int";
        }

        return str + " " + super.name + ";";
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Variable [name = " + this.name + ", type = " + this.type + ", value = " + value + "]";
    }
}
