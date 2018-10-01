package com.company;

public class Main {

    /**
     *
     * @param args [0] -d to find duplicates, -c to count words [1] - resource
     */
    public static void main(String[] args) {
        if (args.length < 2){
            System.err.println("Expected 2 parameters!");
            return;
        }
        CountStrategy strategy;
        if (args[0].equals("-d")){
            strategy = new DuplicateFinder();
        } else if (args[0].equals("-c")){
            strategy = new WordCounter();
        } else {
            System.err.println("First parameter must be -d or -c!");
            return;
        }
        Outputer outputer = new Outputer(System.out);
        Counter counter = new Counter(outputer, strategy);
        Reader reader = new Reader(args[1], counter);
        try {
            reader.readAllText();
        } catch (Throwable ex){
            System.err.println(ex.getMessage());
        }
    }
}
