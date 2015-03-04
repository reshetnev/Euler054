package com.epam.poker;

import com.epam.poker.winner.WinnerDecider;

public class Play {
    private int countPlayerOne;
    private int countPlayerTwo;
    private int countNoBody;

    public Play() {

    }

    public int getCountPlayerOne() {
        return countPlayerOne;
    }

    public int getCountPlayerTwo() {
        return countPlayerTwo;
    }

    public int getCountNoBody() {
        return countNoBody;
    }

    public void count(Deal deal) {
        int answer = WinnerDecider.defineWinner(deal);
        
        if (answer > 0) {
            countPlayerOne++;
        } else if (answer < 0) {
            countPlayerTwo++;
        } else {
            countNoBody++;
        }
    }

}
