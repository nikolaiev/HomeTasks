package com.service;

import com.domain.Text;
import com.domain.Word;

import java.io.IOException;
import java.util.Map;


/**
 * Created by vlad on 19.02.17.
 */
public class Analizer {
    public static void main(String[] args) throws IOException {
        Text text=new Text("test2.txt");

        Map.Entry<Word,Integer> result=text.findMaxSentenceWords();
        System.out.println("Word : "+result.getKey());
        System.out.println("In sentences : "+result.getValue()+" times");

    }
}
