package com.epam.poker;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.epam.poker.Deal;
import com.epam.poker.Play;
import com.epam.poker.parser.Parser;

public class PlayTest {
    private Play play;
    
    @Before
    public void before() {
        play = new  Play();
    }
    
    @Test
    public void increaseCountPlayerTwoTest() {
        // (HIGH_CARD) vs (ONE_PAIR)
        String str = "5D 8C 9S JS AC 2C 3S 8S 8D TD";
        Deal deal = new Parser().apply(str);
        play.count(deal);
        Assert.assertEquals(new Integer(1),
                new Integer(play.getCountPlayerTwo()));
    }

    @Test
    public void increaseCountPlayerOneTest() {
        //  (TWO_PAIRS) vs  (ONE_PAIR)
        String str = "7C AD 6S AC 6H 2C 3S 8S 8D TD";
        Deal deal = new Parser().apply(str);
        play.count(deal);
        Assert.assertEquals(new Integer(1),
                new Integer(play.getCountPlayerOne()));        
    }

    @Test
    public void increaseCountNoBodyTest() {
        //  (ROYAL_FLUSH)   vs  (ROYAL_FLUSH)
        String str = "TS JS KS QS AS TC JC KC QC AC";
        Deal deal = new Parser().apply(str);
        play.count(deal);
        Assert.assertEquals(new Integer(1),
                new Integer(play.getCountNoBody()));        
    }
     
    @After
    public void after() {
        play = null;
    }

}
