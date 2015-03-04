package com.epam.poker;

import java.util.List;

public class Deal {
    private List<Card> playerOne;
    private List<Card> playerTwo;
    
    public Deal(List<Card> playerOne, List<Card> playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public List<Card> getPlayerOne() {
        return playerOne;
    }

    public List<Card> getPlayerTwo() {
        return playerTwo;
    }
    
}
