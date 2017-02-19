package com.domain;

import java.io.ObjectInputStream;
import java.util.List;

/**
 * Created by vlad on 19.02.17.
 */
public class Sentence {
    List<SentenceItem> items;

    public Sentence(List<SentenceItem> items ){
        this.items=items;
    }

    /**
     * Method to get word iterations amount in simple sentence
     * @param word Word to check
     * @return iteration count
     */

    public int getWordIteration(Word word){
        int iteration=0;

        for(SentenceItem item:items){
            if(item.equals(word))
                iteration++;
        }
        return iteration;
    }
    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
        for(SentenceItem si : items){
            sb.append(si.toString());
            sb.append(' ');
        }
        return sb.toString();
    }
}
