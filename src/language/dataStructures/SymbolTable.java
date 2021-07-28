package language.dataStructures;

import java.util.ArrayList;
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

    public ArrayList<Symbol> getAllSymbols() {
        ArrayList<Symbol> list = new ArrayList<Symbol>();
        for (Symbol symbol: map.values()) {
            list.add(symbol);
        }
        return list;
    }
}
