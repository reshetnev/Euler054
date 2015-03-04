package com.epam.poker;

import java.io.IOException;
import java.util.List;

import com.epam.poker.parser.Parser;
import com.epam.poker.reader.Reader;
import com.epam.poker.reader.impl.FileTxtReader;

public class PokerGame {
    
    public static void main(String[] args) throws IOException {
        String file = "poker.txt";
        Reader reader = new FileTxtReader(file);
        List<String> strList = reader.getStrings();
        Play play = new Play();
        for (String str : strList) {
            Deal deal = new Parser().apply(str);
            play.count(deal);
        }
        System.out.println("Player 1 = " + play.getCountPlayerOne());
        System.out.println("Player 2 = " + play.getCountPlayerTwo());
        System.out.println("Nobody = " + play.getCountNoBody());        
    }

}
