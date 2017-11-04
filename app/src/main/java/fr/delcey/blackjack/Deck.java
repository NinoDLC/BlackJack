package fr.delcey.blackjack;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anthony "Nino" DELCEY on 04/11/2017.
 */

class Deck {
    private final int mNumberOfCards;
    private final int mNumberOfValues;

    private List<Card> mCards;

    public Deck(int numberOfNumber, int numberOfCards, int numberOfValues) {
        if (numberOfCards % numberOfValues != 0) {
            throw new IllegalArgumentException("Number of values in the deck is not a multiple of the total of cards in the deck... There's some cards missing in your deck !");
        }

        mNumberOfCards = numberOfCards;
        mNumberOfValues = numberOfValues;

        mCards = new ArrayList<>(mNumberOfCards);

        for (int i = 0; i < numberOfNumber; i++) {
            for (int j = 0; j < mNumberOfCards; j++) {
                mCards.add(new Card((j % mNumberOfValues) + 1));
            }
        }

        Log.d(Deck.class.getName(), "Deck() generated ! cards = [" + mCards.size() + "]");
    }

    public boolean isLastRound() {
        return mCards.size() < Constants.CUTTED_CARD_NUMBER;
    }

    public Card draw() {
        int size = mCards.size();

        if (size == 0) {
            // End of deck. It shouldn't happen, but still...
            return new Card((int) (Math.random() * 13) + 1);
        } else {
            int random = (int) (Math.random() * mCards.size());

            return mCards.remove(random);
        }
    }
}
