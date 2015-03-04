package com.epam.poker.parser;

import java.util.ArrayList;
import java.util.List;

import com.epam.poker.Card;
import com.epam.poker.enums.KindCard;
import com.epam.poker.enums.SuitCard;
import com.google.common.base.Function;
import com.google.common.collect.Lists;

public class CodeListParser {
    
    private static final Function<String, Card> CODE_TO_CARD = new Function<String, Card>() {
        public Card apply(String code) {
            KindCard kindCard = KindCard.getKindCard(code.charAt(0));
            SuitCard suitCard = SuitCard.getSuitCard(code.charAt(1));
            Card card = new Card(kindCard, suitCard);
            return card;
        }
    };    

    public static List<Card> parse(List<String> codeList) {
        return new ArrayList<Card>(Lists.transform(codeList, CODE_TO_CARD));
    }

}
