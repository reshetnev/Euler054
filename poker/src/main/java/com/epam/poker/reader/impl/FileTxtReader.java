package com.epam.poker.reader.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.epam.poker.reader.Reader;

public class FileTxtReader implements Reader {
    private String file;

    public FileTxtReader(String file) {
        this.file = file;
    }

    @Override
    public List<String> getStrings() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));        
        List<String> strList = new ArrayList<String>();
        String str = bufferedReader.readLine();

        while (str != null) {
            strList.add(str);
            str = bufferedReader.readLine();
        }
        
        if (bufferedReader != null) {
            bufferedReader.close();
        } 
        return strList;
    }

}
