package com.epam.poker;

import org.junit.Assert;
import org.junit.Test;

import com.epam.poker.Deal;
import com.epam.poker.parser.Parser;
import com.epam.poker.winner.WinnerDecider;

public class WinnerDeciderTest {
    
    @Test
    public void getWinnerHighCardVsOnePairTest() {
        // (HIGH_CARD) vs (ONE_PAIR)
        Deal deal = new Parser().apply("5D 8C 9S JS AC 2C 3S 8S 8D TD");
        int expected = WinnerDecider.defineWinner(deal);
        Assert.assertTrue(expected < 0);
    }

    @Test
    public void getWinnerTwoPairVsOnePairTest() {
        // (TWO_PAIRS) vs (ONE_PAIR)
        Deal deal = new Parser().apply("7C AD 6S AC 6H 2C 3S 8S 8D TD");
        int expected = WinnerDecider.defineWinner(deal);
        Assert.assertTrue(expected > 0);
    }
    
    @Test
    public void getWinnerOnePairVsOnePairTest() {
        //  (ONE_PAIR)   vs    (ONE_PAIR)
        Deal deal = new Parser().apply("5H 5C 6S 7S KD 2C 3S 8S 8D TD");
        int expected = WinnerDecider.defineWinner(deal);
        Assert.assertTrue(expected < 0);        
    }
    
    @Test
    public void getWinnerTwoPairVsTwoPairTest() {
        //  (TWO_PAIRS)    vs  (TWO_PAIRS)
        Deal deal = new Parser().apply("7C AD 5S AC 5H 7C KD 6S KC 6H");
        int expected = WinnerDecider.defineWinner(deal);
        Assert.assertTrue(expected > 0);        
    }
    
    @Test
    public void getWinnerTwoPairVsTwoPairSecondPairTest() {
        //  (TWO_PAIRS)   vs  (TWO_PAIRS)
        Deal deal = new Parser().apply("8C AD 5S AC 5H 7C AD 6S AC 6H");
        int expected = WinnerDecider.defineWinner(deal);
        Assert.assertTrue(expected < 0);        
    }

    @Test
    public void getWinnerRoyalFlushVsRoyalFlushTest() {
        //  (ROYAL_FLUSH)   vs  (ROYAL_FLUSH)
        Deal deal = new Parser().apply("TS JS KS QS AS TC JC KC QC AC");
        int expected = WinnerDecider.defineWinner(deal);
        Assert.assertTrue(expected == 0);        
    }
    
    @Test
    public void getWinnerThreeKindVsThreeKindTest() {
        //  (THREE_OF_A_KIND)  vs  (THREE_OF_A_KIND)
        Deal deal = new Parser().apply("7D AH 7C QH 7S 8D AH 8C QH 8S");
        int expected = WinnerDecider.defineWinner(deal);
        Assert.assertTrue(expected < 0);        
    }
    
    @Test
    public void getWinnerHighCardVsHighCardTest() {
        //  (HIGH_CARD)    vs  (HIGH_CARD)
        Deal deal = new Parser().apply("5D 8C 9S JS AC 2C 3S KS 8D TD");
        int expected = WinnerDecider.defineWinner(deal);
        Assert.assertTrue(expected > 0);        
    }
    
    @Test
    public void getWinnerFourKindVsFourKindTest() {
        //  (FOUR_OF_A_KIND)  vs  (FOUR_OF_A_KIND)
        Deal deal = new Parser().apply("7D AH 7C 7H 7S 8D 8H 8C QH 8S");
        int expected = WinnerDecider.defineWinner(deal);
        Assert.assertTrue(expected < 0);        
    }
    
    @Test
    public void getWinnerStraightVsStraightTest() {
        //  (STRAIGHT)   vs  (STRAIGHT)
        Deal deal = new Parser().apply("2D 6H 4C 3H 5S 7D 6H 8C TH 9S");
        int expected = WinnerDecider.defineWinner(deal);
        Assert.assertTrue(expected < 0);        
    }
    
    @Test
    public void getWinnerStraightFlushVsStraightFlushTest() {
        //  (STRAIGHT_FLUSH) vs  (STRAIGHT_FLUSH)
        Deal deal = new Parser().apply("2D 6D 4D 3D 5D 7H 6H 8H TH 9H");
        int expected = WinnerDecider.defineWinner(deal);
        Assert.assertTrue(expected < 0);        
    }
    
    @Test
    public void getWinnerFlushVsFlushTest() {
        //  (FLUSH) vs  (FLUSH)
        Deal deal = new Parser().apply("2D 6D 4D AD 5D 7H 6H 8H 2H 9H");
        int expected = WinnerDecider.defineWinner(deal);
        Assert.assertTrue(expected > 0);        
    }
    
    @Test
    public void getWinnerFullHouseVsFullHouseTest() {
        //  (FULL_HOUSE)  vs  (FULL_HOUSE)
        Deal deal = new Parser().apply("7D AH 7C AD 7S 8D QD QC QH 8S");
        int expected = WinnerDecider.defineWinner(deal);
        Assert.assertTrue(expected < 0);        
    }

}
