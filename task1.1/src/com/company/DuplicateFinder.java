package com.company;

import java.util.HashMap;
import java.util.Map;

public class DuplicateFinder implements CountStrategy{

    private Map<String, Integer> mapWords;
    private String duplicate;

    public DuplicateFinder(){
        mapWords = new HashMap<>();
        duplicate = "";
    }

    @Override
    public boolean addWord(String word){
        if (word.equals(""))
            return false;
        if (mapWords.containsKey(word)){
            mapWords.put(word, mapWords.get(word) + 1);
            duplicate = word;
            return  true;
        } else {
            mapWords.put(word, 1);
            return  false;
        }
    }

    @Override
    public Map<String, Integer> countWords(){
        Map<String, Integer> result = new HashMap<String, Integer>();
        if (duplicate.equals("")){
            result.put("Duplicates not founded", 0);
        } else {
            result.put(duplicate, mapWords.get(duplicate));
        }
        return result;
    }
}
