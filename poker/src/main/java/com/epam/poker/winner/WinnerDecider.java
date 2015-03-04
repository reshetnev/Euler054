package com.epam.poker.winner;

import com.epam.poker.Deal;
import com.epam.poker.Hand;
import com.epam.poker.winner.impl.PatternHand;

public class WinnerDecider {

    public static int defineWinner(Deal deal) {
        PatternHand handOne = new Hand(deal.getPlayerOne()).getPatternHand();
        PatternHand handTwo = new Hand(deal.getPlayerTwo()).getPatternHand();
        
        if (handOne.compareTo(handTwo) != 0) {
            return handOne.compareTo(handTwo);
        } else {
            Winner winner = handOne;            
            return winner.getWinner(deal);
        }

    }

}
