package fr.delcey.blackjack;

import java.util.ArrayList;

/**
 * Created by Anthony "Nino" DELCEY on 04/11/2017.
 */

public class PlayerHand extends Hand {
    private int mBet;
    private boolean mIsDoubledUp;

    public PlayerHand(Card card1, Card card2, int bet) {
        mCards = new ArrayList<>();

        mCards.add(card1);
        mCards.add(card2);

        mBet = bet;
    }

    public PlayerHand split(Deck deck) {
        PlayerHand secondHand = new PlayerHand(mCards.remove(1), deck.draw(), mBet);

        mCards.add(deck.draw());

        return secondHand;
    }

    public int getFirstCardValue() {
        return mCards.get(0).getValue();
    }

    public int getSecondCardValue() {
        return mCards.get(1).getValue();
    }

    public void doubleUp() {
        mIsDoubledUp = true;
        mBet *= 2;
    }

    public boolean isDoubledUp() {
        return mIsDoubledUp;
    }

    @Override
    public String toString() {
        String result = "PlayerHand ";

        if (mIsDoubledUp) {
            result += " (doubled up) ";
        }

        result += ": [";

        for (int i = 0; i < mCards.size(); i++) {
            if (i + 1 >= mCards.size()) {
                result += mCards.get(i).toString() + "]";
            } else {
                result += mCards.get(i).toString() + ", ";
            }
        }

        result += " = " + getCardsValue();

        if (getCardsValue() > 21) {
            result += " BUSTED !";
        }

        return result;
    }

    public int getBet() {
        return mBet;
    }
}
