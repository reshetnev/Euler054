package com.epam.poker.enums;

import java.util.logging.Logger;

public enum KindCard {
    TWO('2'), THREE('3'), FOUR('4'), FIVE('5'), SIX('6'), SEVEN('7'), EIGHT('8'), NINE(
            '9'), TEN('T'), JACK('J'), QUEEN('Q'), KING('K'), ACE('A');
    
    private static Logger log = Logger.getLogger(KindCard.class.getName());
    private char kind;

    private KindCard(char kind) {
        this.kind = kind;
    }

    public char getKind() {
        return kind;
    }
    
    public static KindCard getKindCard(char kind) {
        KindCard kindCard = null;
        for (KindCard valueKind : KindCard.values()) {
            if (valueKind.getKind() == kind) {
                kindCard = valueKind;
            }
        }
        if (kindCard == null) {
            log.info("Invalid code of kind card");
        }
        return kindCard;
    }

}
