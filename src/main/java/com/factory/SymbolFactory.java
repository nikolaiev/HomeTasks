package com.factory;

import com.domain.PunctuationSymbol;
import com.domain.Symbol;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by vlad on 19.02.17.
 * Implements FlyWeight pattern
 */
public class SymbolFactory {
    private static SymbolFactory instance=new SymbolFactory();
    private static List<Symbol> symbolsDB=new LinkedList<>();

    private SymbolFactory(){}

    public static SymbolFactory getInstance(){return instance;}


    public Symbol getSymbol(char ch){
        Symbol symbol=null;

        for(Symbol sym:symbolsDB){
            if(sym.getSymbol()==ch){
                symbol=sym;
                break;
            }
        }

        if(symbol==null){
            Symbol newSymbol;
            /*check if punctuation symbol*/
            if((Character.toString(ch)).matches("[^а-яА-Яa-zA-Z0-9-]"))
                newSymbol=new PunctuationSymbol(ch);
            else
                newSymbol=new Symbol(ch);

            //adding to DB
            symbolsDB.add(newSymbol);
            return newSymbol;
        }
        else {
            return symbol;
        }

    }
}
