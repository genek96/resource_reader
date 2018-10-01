package com.company;

import java.util.HashMap;
import java.util.Map;

public class WordCounter implements CountStrategy {

    private Map<String, Integer> mapWords;

    public WordCounter() {
        mapWords = new HashMap<>();
    }

    @Override
    public boolean addWord(String word) {
        if (word.equals("") || word.equals(" "))
            return false;
        if (mapWords.containsKey(word)) {
            mapWords.put(word, mapWords.get(word) + 1);
        } else {
            mapWords.put(word, 1);
        }
        return true;
    }

    @Override
    public Map<String, Integer> countWords() {
        return mapWords;
    }
}
