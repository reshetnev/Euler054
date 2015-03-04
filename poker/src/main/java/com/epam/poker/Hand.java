package com.epam.poker;

import java.util.Collections;
import java.util.List;

import com.epam.poker.enums.KindCard;
import com.epam.poker.enums.SuitCard;
import com.epam.poker.winner.impl.PatternHand;

public class Hand {
    private List<Card> cards;
    
    public Hand(List<Card> cardList) {
        Collections.sort(cardList);        
        this.cards = cardList;
    }

    public PatternHand getPatternHand() {

        if (isRoyalFlush()) {
            return PatternHand.ROYAL_FLUSH;
        }

        if (isStraightFlush()) {
            return PatternHand.STRAIGHT_FLUSH;
        }

        if (isFourOfKind()) {
            return PatternHand.FOUR_OF_A_KIND;
        }

        if (isFullHouse()) {
            return PatternHand.FULL_HOUSE;
        }

        if (isFlush()) {
            return PatternHand.FLUSH;
        }

        if (isStraight()) {
            return PatternHand.STRAIGHT;
        }

        if (isThreeOfKind()) {
            return PatternHand.THREE_OF_A_KIND;
        }

        if (isTwoPairs()) {
            return PatternHand.TWO_PAIRS;
        }

        if (isOnePair()) {
            return PatternHand.ONE_PAIR;
        }
        return PatternHand.HIGH_CARD;
    }

    private boolean isThreeOfKind() {
        boolean three = false;

        if (isEqualKind(0, 1) && isEqualKind(1, 2)) {
            three = true;
        }

        if (isEqualKind(1, 2) && isEqualKind(2, 3)) {
            three = true;
        }

        if (isEqualKind(2, 3) && isEqualKind(3, 4)) {
            three = true;
        }
        return three;
    }

    private boolean isStraight() {
        int count = 0;

        for (int i = 0; i < cards.size()-1 ; i++) {
            Card current = cards.get(i);
            Card next = cards.get(i+1);
            if (next.compareTo(current) == 1) {
                count++;
            }
        }
        return (count == 4);
    }

    private boolean isFlush() {
        int count = 0;

        for (int i = 0; i < cards.size() - 1; i++) {
            SuitCard current = cards.get(i).getSuitCard();
            SuitCard next = cards.get(i+1).getSuitCard();
            if (current.equals(next)) {
                count++;
            }
        }
        return (count == 4);
    }

    private boolean isFullHouse() {
        boolean fullHouse = false;

        if (isEqualKind(0, 1) && isEqualKind(1, 2)
                && isEqualKind(3, 4)) {
            fullHouse = true;
        }

        if (isEqualKind(0, 1) && isEqualKind(2, 3)
                && isEqualKind(3, 4)) {
            fullHouse = true;
        }
        return fullHouse;
    }

    private boolean isFourOfKind() {
        boolean four = false;

        if (isEqualKind(0, 1) && isEqualKind(1, 2)
                && isEqualKind(2, 3)) {
            four = true;
        }

        if (isEqualKind(1, 2) && isEqualKind(2, 3)
                && isEqualKind(3, 4)) {
            four = true;
        }
        return four;
    }

    private boolean isStraightFlush() {
        boolean straightFlush = false;
        
        if (isStraight() && isFlush()) {
            straightFlush = true;
        }
        
        return straightFlush;
    }

    private boolean isRoyalFlush() {
        boolean royalFlush = false;

        if (isStraight() && isFlush()
                && (cards.get(0).getKindCard().equals(KindCard.TEN))) {
            royalFlush = true;
        }
        return royalFlush;
    }

    private boolean isTwoPairs() {
        return (getCountPair() == 2);
    }

    private boolean isOnePair() {
        return (getCountPair() == 1);
    }

    private boolean isEqualKind(int i, int j) {
        Card iCard = cards.get(i);
        Card jCard = cards.get(j);

        if (iCard.compareTo(jCard) == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    private int getCountPair() {
        int count = 0;

        for (int i = 0; i < cards.size() - 1; i++) {
            if (isEqualKind(i, i + 1)) {
                count++;
            }
        }
        return count;
    }    

}
