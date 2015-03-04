package com.epam.poker;

import org.junit.Assert;
import org.junit.Test;

import com.epam.poker.Card;
import com.epam.poker.enums.KindCard;
import com.epam.poker.enums.SuitCard;



public class CardTest {
    
    @Test
    public void hashCodeCardTest() {
        Card cardOne = new Card(KindCard.ACE, SuitCard.CLUBS);
        Card cardTwo = new Card(KindCard.ACE, SuitCard.CLUBS);
        int hashCodeOne = cardOne.hashCode();
        int hashCodeTwo = cardTwo.hashCode();
        Assert.assertEquals(new Integer(hashCodeOne), new Integer(hashCodeTwo));
    }

}
