package com.epam.poker.winner.impl;

import java.util.List;
import java.util.logging.Logger;

import com.epam.poker.Card;
import com.epam.poker.Deal;
import com.epam.poker.winner.Winner;

public enum PatternHand implements Winner {
    HIGH_CARD {
        
        @Override
        public int getWinner(Deal deal) {
            List<Card> playerOne = deal.getPlayerOne();
            List<Card> playerTwo = deal.getPlayerTwo();            
            for (int i = playerOne.size() - 1; i >= 0; i--) {
                if (playerOne.get(i).compareTo(playerTwo.get(i)) != 0) {
                    return playerOne.get(i).compareTo(playerTwo.get(i));
                }
            }
            return 0;
        }
    },
    ONE_PAIR {
        
        @Override
        public int getWinner(Deal deal) {
            Card cardPlayerOne = getLowPair(deal.getPlayerOne());
            Card cardPlayerTwo = getLowPair(deal.getPlayerTwo());

            if (cardPlayerOne.compareTo(cardPlayerTwo) != 0) {
                return cardPlayerOne.compareTo(cardPlayerTwo);
            } else {
                return  HIGH_CARD.getWinner(deal);
            }

        }
    },
    TWO_PAIRS {

        @Override
        public int getWinner(Deal deal) {
            Card cardPlayerOne = getHighPair(deal.getPlayerOne());
            Card cardPlayerTwo = getHighPair(deal.getPlayerTwo());

            if (cardPlayerOne.compareTo(cardPlayerTwo) != 0) {
                return cardPlayerOne.compareTo(cardPlayerTwo);
            } else {
                if (ONE_PAIR.getWinner(deal) != 0) {
                    return ONE_PAIR.getWinner(deal);
                } else {
                    return HIGH_CARD.getWinner(deal);
                }
            }
        }
    },
    THREE_OF_A_KIND {

        @Override
        public int getWinner(Deal deal) {
            return ONE_PAIR.getWinner(deal);
        }
    },
    STRAIGHT {

        @Override
        public int getWinner(Deal deal) {
            return HIGH_CARD.getWinner(deal);
        }
    },
    FLUSH {

        @Override
        public int getWinner(Deal deal) {
            return HIGH_CARD.getWinner(deal);
        }
    },
    FULL_HOUSE {

        @Override
        public int getWinner(Deal deal) {
            List<Card> playerOne = deal.getPlayerOne();
            List<Card> playerTwo = deal.getPlayerTwo();
            
            Card cardPlayerOne = playerOne.get(0);
            Card cardPlayerTwo = playerTwo.get(0);

            if (isEqualKind(playerOne, 2, 3)
                    && isEqualKind(playerOne, 3, 4)) {
                cardPlayerOne = playerOne.get(4);
            }

            if (isEqualKind(playerTwo, 2, 3)
                    && isEqualKind(playerTwo, 3, 4)) {
                cardPlayerTwo = playerTwo.get(4);
            }
            return cardPlayerOne.compareTo(cardPlayerTwo);
        }
    },
    FOUR_OF_A_KIND {

        @Override
        public int getWinner(Deal deal) {
            return ONE_PAIR.getWinner(deal);
        }
    },
    STRAIGHT_FLUSH {

        @Override
        public int getWinner(Deal deal) {
            return HIGH_CARD.getWinner(deal);
        }
    },
    ROYAL_FLUSH {

        @Override
        public int getWinner(Deal deal) {
            return 0;
        }
    };
    
    private static Logger log = Logger.getLogger(PatternHand.class.getName());
    
    public Card getLowPair(List<Card> player) {
        int j = -1;
        for (int i = 0; i < player.size() - 1; i++) {
            if (player.get(i).compareTo(player.get(i + 1)) == 0) {
                j = i;
                break;
            }
        }
        
        if (j == -1) {
            log.info("Low Pair not found");
        }
        return player.get(j);
    }
    
    public Card getHighPair(List<Card> player) {
        int j = -1;
        for (int i = 0; i < player.size() - 1; i++) {
            if (player.get(i).compareTo(player.get(i + 1)) == 0) {
                j = i;
            }
        }
        
        if (j == -1) {
            log.info("High Pair not found");
        }
        return player.get(j);
    }

    public boolean isEqualKind(List<Card> cardList, int i, int j) {
        Card iCard = cardList.get(i);
        Card jCard = cardList.get(j);

        if (iCard.compareTo(jCard) == 0) {
            return true;
        } else {
            return false;
        }
    }

}
