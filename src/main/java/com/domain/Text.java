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
    List<Sentence> sentences;

    public Text(String fileName) throws IOException {
        sentences=new LinkedList<>();
        List<List<SentenceItem>> temp;

        //collecting SentenceItem list from file
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            temp= stream
                    .map(str->
                            Arrays.stream(str.replaceAll("([^а-яА-Яa-zA-Z0-9-])", " $1 ")
                                    .split("[\\s\r\t\n]+"))
                            .map(item->{
                                if(item.matches("[^а-яА-Яa-zA-Z0-9-]")) {
                                    return (PunctuationSymbol) SymbolFactory.getSymbol(item.toCharArray()[0]);
                                }
                                //else
                                return WordFactory.getWord(item);
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
        if(sentenceItems.size()!=0){
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

    private Set<String> findUniqueWords(){
        //TODO implement pattern FlyWeight!
        Set<String> wordsSet=new TreeSet<>();
        return wordsSet;
    }

}
