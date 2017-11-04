package fr.delcey.blackjack;

import java.util.List;

/**
 * Created by Anthony "Nino" DELCEY on 04/11/2017.
 */

class Hand {
    protected List<Card> mCards;

    protected Hand() {
        // Don't allow empty hand
    }

    public void addCard(Card card) {
        mCards.add(card);
    }

    public int getCardsValue() {
        int total = 0;
        boolean hasAce = false;

        for (Card card : mCards) {
            total += card.getValue();

            if (card.isAce()) {
                hasAce = true;
            }
        }

        if (hasAce && total + 10 <= 21) {
            return total + 10;
        } else {
            return total;
        }
    }

    public boolean isHand2Cards() {
        return mCards.size() == 2;
    }

    public boolean isBlackJack() {
        return isHand2Cards() && getCardsValue() == 21;
    }

    public boolean isSoft() {
        int total = 0;
        boolean isAce = false;

        for (Card card : mCards) {
            total += card.getValue();

            if (card.isAce()) {
                isAce = true;
            }
        }

        return total <= 10 && isAce;
    }

    public int getSoftCardsValue() {
        int total = 0;

        for (Card card : mCards) {
            total += card.getValue();
        }

        return total;
    }
}
