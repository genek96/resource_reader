package com.company;

import java.util.Map;

public interface CountStrategy {

    Map<String, Integer> countWords();
    boolean addWord(String word);
}
