package com.factory;

import com.domain.PunctuationSymbol;
import com.domain.Symbol;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by vlad on 19.02.17.
 */
public class SymbolFactoryTest {
    SymbolFactory symbolFactory=SymbolFactory.getInstance();

    /*punctuation symbol*/
    @Test
    public void getSymbolPunc() throws Exception {
        Symbol symbol=symbolFactory.getSymbol('.');
        assert(symbol instanceof PunctuationSymbol);
    }

    /*Simple Symbol*/
    @Test
    public void getSymbolSimple() throws Exception {
        Symbol symbol=symbolFactory.getSymbol('A');
        assert(!(symbol instanceof PunctuationSymbol));
    }

    @Test
    public void getSymbolLinks() throws Exception {
        Random r = new Random();
        for(int i=0;i<1000;i++) {
            char c = (char) (r.nextInt(Character.MAX_VALUE));
            Symbol symbol=symbolFactory.getSymbol(c);
            Symbol symbol2=symbolFactory.getSymbol(c);
            assert (symbol == symbol2);
        }
    }

}