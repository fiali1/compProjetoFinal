package language.dataStructures;

import java.util.HashMap;

public class SymbolTable {
    private HashMap<String, Symbol> map;

    public SymbolTable() {
        map = new HashMap<String, Symbol>();
    }

    public void addSymbol(Symbol symbol) {
        this.map.put(symbol.getName(), symbol);
    }

    public boolean exists(String symbolName) {
        return this.map.get(symbolName) != null;
    }

    public Symbol getSymbol(String symbolName) {
        return this.map.get(symbolName);
    }
}
