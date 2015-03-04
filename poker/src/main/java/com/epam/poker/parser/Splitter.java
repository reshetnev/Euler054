package com.epam.poker.parser;

import java.util.ArrayList;
import java.util.List;

public class Splitter {
    private List<String> codeOne;
    private List<String> codeTwo;

    public Splitter(String str) {
        codeOne = new ArrayList<String>();
        codeTwo = new ArrayList<String>();
        String[] s = str.split("\\s");

        for (int i = 0; i < (s.length/2); i++) {
            codeOne.add(s[i]);
            codeTwo.add(s[i + s.length/2]);
        }        
    }

    public List<String> getCodeListOne() {
        return codeOne;
    }

    public List<String> getCodeListTwo() {
        return codeTwo;
    }
    
}
