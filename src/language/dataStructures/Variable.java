package language.dataStructures;

public class Variable extends Symbol {

    public static final int CARACTERE  = 0;
    public static final int TEXTO      = 1;
    public static final int INTEIRO    = 2;
    public static final int FRACIONADO = 3;

    private int type;
    private String value;
    private boolean read;

    public Variable(String name, int type, String value) {
        super(name);
        this.type   = type;
        this.value  = value;
        this.read   = false;
    }

    @Override
    public String generateJavaCode() {
        String str;
        if (type == CARACTERE)
            str = "char";
        else if (type == TEXTO)
            str = "String";
        else if (type == INTEIRO)
            str = "int";
        else if (type == FRACIONADO)
            str = "double";
        else
            str = "";

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

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }
}
