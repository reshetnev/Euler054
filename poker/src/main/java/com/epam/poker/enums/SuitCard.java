package com.epam.poker.enums;

import java.util.logging.Logger;

public enum SuitCard {
    CLUBS('C'), DIAMONDS('D'), HEARTS('H'), SPADES('S');
    
    private static Logger log = Logger.getLogger(SuitCard.class.getName());
    private char suit;

    private SuitCard(char suit) {
        this.suit = suit;
    }

    public char getSuit() {
        return suit;
    }
    
    public static SuitCard getSuitCard(char suit) {
        SuitCard suitCard = null;
        for (SuitCard valueSuit : SuitCard.values()) {
            if (valueSuit.getSuit() == suit) {
                suitCard = valueSuit;
            }
        }
        if (suitCard == null) {
            log.info("Invalid code of suit card");
        }
        return suitCard;
    }

}
