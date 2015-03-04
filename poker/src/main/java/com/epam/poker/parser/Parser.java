package com.epam.poker.parser;

import java.util.List;

import com.epam.poker.Card;
import com.epam.poker.Deal;
import com.google.common.base.Function;

public class Parser implements Function<String, Deal> {

    public Deal apply(String str) {
        Splitter splitter = new Splitter(str);
        List<Card> playerOne = CodeListParser.parse(splitter.getCodeListOne());
        List<Card> playerTwo = CodeListParser.parse(splitter.getCodeListTwo());
        Deal deal = new Deal(playerOne, playerTwo);
        return deal;
    }

}
