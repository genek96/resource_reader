package com.company;

import com.sun.istack.internal.NotNull;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Gather text and count words in this text
 */
public class Counter {

    private CountStrategy counter;
    private Outputer outputer;

    public Counter(Outputer out, CountStrategy strategy) {
        counter = strategy;
        outputer = out;
    }

    /**
     * Add new words to existing list
     *
     * @param row List of text rows, which words we should to count
     * @see Counter#addRow(String)
     */
    public void addRow(String row) throws IOException {
        boolean existResult = false;
        row = clearRow(row);
        for (String word : row.split(" ")) {
            existResult = counter.addWord(word) || existResult;
        }
        if (existResult) {
            countWords();
        }
    }

    /**
     * Count number of each uniq word
     *
     * @return Map with String key - uniq word, Integer value - number of this words
     * @see Counter#countWords()
     */
    public void countWords() throws IOException {
        outputer.printResult(counter.countWords());
    }

    /**
     * Delete replace non  leteral
     *
     * @param row source string
     * @return row without non literal
     * @see Counter#clearRow(String)
     */
    private String clearRow(@NotNull String row) {
        row = row.toLowerCase();
        char[] nonLiters = {',', '.', '<', '>', '/', '&', '?', '!', '(', ')', '[', ']', '{', '}', '"'};
        for (char symbol : nonLiters) {
            row = row.replace(symbol, ' ');
        }
        return row;
    }
}
