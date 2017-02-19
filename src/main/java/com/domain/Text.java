package com.domain;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.factory.*;

/**
 * Created by vlad on 19.02.17.
 */
public class Text {
    private List<Sentence> sentences;
    private SymbolFactory symbolFactory=SymbolFactory.getInstance();
    private WordFactory wordFactory=WordFactory.getInstance();

    /**
     * Constructs Text object from text file
     * @param fileName file's name
     * @throws IOException
     */
    public Text(String fileName) throws IOException {
        sentences=new LinkedList<>();
        List<List<SentenceItem>> temp;

        //collecting SentenceItem list from file
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            temp= stream
                    .map(str->
                            Arrays.stream(str.replaceAll("([^а-яА-Яa-zA-Z0-9-])", " $1 ")
                            .split("[\\s\r\t\n]+"))
                            .filter(e->!"".equals(e))
                            .map(item->{
                                if(item.matches("[^а-яА-Яa-zA-Z0-9-]")) {
                                    return (PunctuationSymbol) symbolFactory.getSymbol(item.toCharArray()[0]);
                                }
                                return wordFactory.getWord(item);

                            }).collect(Collectors.toList())

                    )//map
                    .collect(Collectors.toList());
        }//trye
        //temporary sentence elements
        List<SentenceItem> sentenceItems=new LinkedList<>();

        for(List<SentenceItem> strArr:temp){

            for(SentenceItem str:strArr){
                sentenceItems.add(str);

                if(str instanceof PunctuationSymbol){//if punctuation symbol
                    char punctSymbol=((PunctuationSymbol) str).getSymbol();

                    //check if end of sentence
                    if(punctSymbol=='.' || punctSymbol=='!' || punctSymbol=='?'){
                        //if it's a point (. - end of sentence)
                        sentences.add(new Sentence(sentenceItems));
                        sentenceItems=new LinkedList<>();
                    }
                }
            }
        }

        //if last sentence does not have end-symbol
        if(!sentenceItems.isEmpty()){
            sentences.add(new Sentence(sentenceItems));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        for(Sentence sent : sentences){
            sb.append("\n");
            sb.append(sent.toString());
        }
        return sb.toString();
    }

    public Map.Entry<Word,Integer> findMaxSentenceWords(){
        Map<Word,Integer> words=wordFactory.getSortedWords();
        return  findMaxSentenceWords(words);
    }

    /*divided method to enable testing*/
    private Map.Entry<Word,Integer> findMaxSentenceWords(Map<Word,Integer> words){
        Word prevWord=null;
        int prevCount=0;

        for(Map.Entry<Word,Integer> entry:words.entrySet()){
            /*how many times word was mentioned*/
            int countIteration=entry.getValue();

            Word word=entry.getKey();

            for(Sentence sent:sentences){
                int iteration=sent.getWordIteration(word);
                /*do not count first entry*/
                countIteration-=iteration>0?(iteration-1):0;
            }
            //System.out.println(word+" "+countIteration);

            if(prevWord!=null){
                if(prevCount>=countIteration)//compare with prev unique entry iterations
                    return new MyEntry<>(prevWord,prevCount);
            }
            else{
                if(entry.getValue()==countIteration)//all iterations are unique
                    return entry;
            }
            //else
            prevWord=word;
            prevCount=countIteration;
        }//words loop

        return new MyEntry<>(prevWord,prevCount);
    }

    /**
     * Helper class to create Map.Entry element
     * @param <K> Word
     * @param <V> IterationCount
     */
    private final static class MyEntry<K, V> implements Map.Entry<K, V> {
        private final K key;
        private V value;

        public MyEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V old = this.value;
            this.value = value;
            return old;
        }
    }
}


