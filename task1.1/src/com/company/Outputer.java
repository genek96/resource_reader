package com.company;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

public class Outputer {

    private OutputStream outputStream;

    public Outputer (OutputStream outS){
        outputStream = outS;
    }

    public void printResult(Map<String, Integer> map) throws IOException {
        outputStream.write("/*********************/\n".getBytes());
        for (Map.Entry entry : map.entrySet()){
            outputStream.write(entry.getKey().toString().getBytes());
            outputStream.write(" -> ".getBytes());
            outputStream.write(entry.getValue().toString().getBytes());
            outputStream.write("\n".getBytes());
        }
    }
}
