package com.epam.poker;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.epam.poker.Card;
import com.epam.poker.Hand;
import com.epam.poker.enums.KindCard;
import com.epam.poker.enums.SuitCard;
import com.epam.poker.winner.impl.PatternHand;

public class HandTest {
    private List<Card> player;

    @Before
    public void before() {
        player = new ArrayList<Card>();
    }

    @Test
    public void getHighCardTest() {
        // 5D 8C 9S JS AC
        player.add(new Card(KindCard.FIVE, SuitCard.DIAMONDS));
        player.add(new Card(KindCard.EIGHT, SuitCard.CLUBS));
        player.add(new Card(KindCard.NINE, SuitCard.SPADES));
        player.add(new Card(KindCard.JACK, SuitCard.SPADES));
        player.add(new Card(KindCard.ACE, SuitCard.CLUBS));
        Hand hand = new Hand(player);
        Assert.assertEquals(PatternHand.HIGH_CARD, hand.getPatternHand());
    }

    @Test
    public void getOnePairTest() {
        // 2C 3S 8S 8D TD
        player.add(new Card(KindCard.TWO, SuitCard.CLUBS));
        player.add(new Card(KindCard.THREE, SuitCard.SPADES));
        player.add(new Card(KindCard.EIGHT, SuitCard.SPADES));
        player.add(new Card(KindCard.EIGHT, SuitCard.DIAMONDS));
        player.add(new Card(KindCard.TEN, SuitCard.DIAMONDS));
        Hand hand = new Hand(player);
        Assert.assertEquals(PatternHand.ONE_PAIR, hand.getPatternHand());
    }

    @Test
    public void getTwoPairTest() {
        // 7C AD 6S AC 6H
        player.add(new Card(KindCard.SEVEN, SuitCard.CLUBS));
        player.add(new Card(KindCard.ACE, SuitCard.DIAMONDS));
        player.add(new Card(KindCard.SIX, SuitCard.SPADES));
        player.add(new Card(KindCard.ACE, SuitCard.CLUBS));
        player.add(new Card(KindCard.SIX, SuitCard.HEARTS));
        Hand hand = new Hand(player);
        Assert.assertEquals(PatternHand.TWO_PAIRS, hand.getPatternHand());
    }

    @Test
    public void getThreeKindTest() {
        // 7D AH 7C QH 7S
        player.add(new Card(KindCard.SEVEN, SuitCard.DIAMONDS));
        player.add(new Card(KindCard.ACE, SuitCard.HEARTS));
        player.add(new Card(KindCard.SEVEN, SuitCard.CLUBS));
        player.add(new Card(KindCard.QUEEN, SuitCard.HEARTS));
        player.add(new Card(KindCard.SEVEN, SuitCard.SPADES));
        Hand hand = new Hand(player);
        Assert.assertEquals(PatternHand.THREE_OF_A_KIND, hand.getPatternHand());
    }

    @Test
    public void getStraightTest() {
        // 4D 3H 2C 6H 5S
        player.add(new Card(KindCard.FOUR, SuitCard.DIAMONDS));
        player.add(new Card(KindCard.THREE, SuitCard.HEARTS));
        player.add(new Card(KindCard.TWO, SuitCard.CLUBS));
        player.add(new Card(KindCard.SIX, SuitCard.HEARTS));
        player.add(new Card(KindCard.FIVE, SuitCard.SPADES));
        Hand hand = new Hand(player);
        Assert.assertEquals(PatternHand.STRAIGHT, hand.getPatternHand());
    }

    @Test
    public void getFlushTest() {
        // 5H 2H 6H 4H 7H
        player.add(new Card(KindCard.FIVE, SuitCard.HEARTS));
        player.add(new Card(KindCard.TWO, SuitCard.HEARTS));
        player.add(new Card(KindCard.SIX, SuitCard.HEARTS));
        player.add(new Card(KindCard.FOUR, SuitCard.HEARTS));
        player.add(new Card(KindCard.SEVEN, SuitCard.HEARTS));
        Hand hand = new Hand(player);
        Assert.assertEquals(PatternHand.FLUSH, hand.getPatternHand());
    }

    @Test
    public void getFullHouseTest() {
        // AD 7S 7C AH 7H
        player.add(new Card(KindCard.ACE, SuitCard.DIAMONDS));
        player.add(new Card(KindCard.SEVEN, SuitCard.SPADES));
        player.add(new Card(KindCard.SEVEN, SuitCard.CLUBS));
        player.add(new Card(KindCard.ACE, SuitCard.HEARTS));
        player.add(new Card(KindCard.SEVEN, SuitCard.HEARTS));
        Hand hand = new Hand(player);
        Assert.assertEquals(PatternHand.FULL_HOUSE, hand.getPatternHand());
    }

    @Test
    public void getFourKindTest() {
        // 7D 7S 7C AH 7H
        player.add(new Card(KindCard.SEVEN, SuitCard.DIAMONDS));
        player.add(new Card(KindCard.SEVEN, SuitCard.SPADES));
        player.add(new Card(KindCard.SEVEN, SuitCard.CLUBS));
        player.add(new Card(KindCard.ACE, SuitCard.HEARTS));
        player.add(new Card(KindCard.SEVEN, SuitCard.HEARTS));
        Hand hand = new Hand(player);
        Assert.assertEquals(PatternHand.FOUR_OF_A_KIND, hand.getPatternHand());
    }

    @Test
    public void getStraightFlushTest() {
        // 8H 9H 6H TH 7H
        player.add(new Card(KindCard.EIGHT, SuitCard.HEARTS));
        player.add(new Card(KindCard.NINE, SuitCard.HEARTS));
        player.add(new Card(KindCard.SIX, SuitCard.HEARTS));
        player.add(new Card(KindCard.TEN, SuitCard.HEARTS));
        player.add(new Card(KindCard.SEVEN, SuitCard.HEARTS));
        Hand hand = new Hand(player);
        Assert.assertEquals(PatternHand.STRAIGHT_FLUSH, hand.getPatternHand());
    }

    @Test
    public void getRoyalFlushTest() {
        // AH QH JH TH KH
        player.add(new Card(KindCard.ACE, SuitCard.HEARTS));
        player.add(new Card(KindCard.QUEEN, SuitCard.HEARTS));
        player.add(new Card(KindCard.JACK, SuitCard.HEARTS));
        player.add(new Card(KindCard.TEN, SuitCard.HEARTS));
        player.add(new Card(KindCard.KING, SuitCard.HEARTS));
        Hand hand = new Hand(player);
        Assert.assertEquals(PatternHand.ROYAL_FLUSH, hand.getPatternHand());
    }

    @After
    public void after() {
        player = null;
    }

}
