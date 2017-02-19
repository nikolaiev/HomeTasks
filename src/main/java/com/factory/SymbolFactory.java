package com.factory;

import com.domain.LetterSymbol;
import com.domain.PunctuationSymbol;
import com.domain.Symbol;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vlad on 19.02.17.
 */
public class SymbolFactory {
    private static SymbolFactory instance=new SymbolFactory();
    public static SymbolFactory getInstance(){return instance;};

    private static List<Symbol> symbolsDB=new ArrayList<>();

    private SymbolFactory(){};


    public static Symbol getSymbol(char ch){
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
            if(ch!='.'&&ch!=','&&ch!='!'&&ch!='?')
                newSymbol=new LetterSymbol(ch);
            else
                newSymbol=new PunctuationSymbol(ch);

            //adding to DB
            symbolsDB.add(newSymbol);
            return newSymbol;
        }
        else {
            return symbol;
        }

    }
}
