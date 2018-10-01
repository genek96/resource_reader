package com.company;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    private URI path;
    private Counter counter;

    public Reader(String path, Counter counter){
        this.path = URI.create(path);
        this.counter = counter;
    }

    public int readAllText() throws Throwable{

        int numberOfLines = 0;

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        getStream(), StandardCharsets.UTF_8))){
            String line;
            while ((line = reader.readLine()) != null){
                counter.addRow(line);
                numberOfLines += 1;
            }
        }
        catch (Throwable ex){
            throw ex;
        }
        return numberOfLines;
    }

    private InputStream getStream() throws Throwable{
        InputStream stream;
        try {
            URL url = path.toURL();
            stream = url.openStream();
        } catch (Throwable ex) {
            try {
                stream = new FileInputStream(path.getPath());
            } catch (FileNotFoundException fileEx){
                throw (fileEx);
            }
        }
        return stream;
    }
}
