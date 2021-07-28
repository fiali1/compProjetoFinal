package language.dataStructures;

public abstract class Symbol {
    protected String name;

    public Symbol(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Symbol [name=" + this.name + "]";
    }
}
