package com.epam.poker;

import com.epam.poker.enums.KindCard;
import com.epam.poker.enums.SuitCard;

public class Card implements Comparable<Card> {
    private KindCard kindCard;
    private SuitCard suitCard;

    public Card(KindCard kindCard, SuitCard suitCard) {
        this.kindCard = kindCard;
        this.suitCard = suitCard;
    }    

    public KindCard getKindCard() {
        return kindCard;
    }

    public SuitCard getSuitCard() {
        return suitCard;
    }

    @Override
    public int compareTo(Card that) {
        return this.kindCard.compareTo(that.kindCard);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((kindCard == null) ? 0 : kindCard.hashCode());
        result = prime * result
                + ((suitCard == null) ? 0 : suitCard.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Card other = (Card) obj;
        if (kindCard != other.kindCard)
            return false;
        if (suitCard != other.suitCard)
            return false;
        return true;
    }

}
