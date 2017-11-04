package fr.delcey.blackjack;

import java.util.ArrayList;

/**
 * Created by Anthony "Nino" DELCEY on 04/11/2017.
 */

public class DealerHand extends Hand {
    public DealerHand(Card dealerCard) {
        mCards = new ArrayList<>();

        mCards.add(dealerCard);
    }

    public int getFirstCardValue() {
        return mCards.get(0).getValue();
    }

    public boolean isFirstCardAnAce() {
        return mCards.get(0).isAce();
    }

    public boolean isFirstCardATenner() {
        return mCards.get(0).isTener();
    }

    @Override
    public String toString() {
        String result = "DealerHand : [";

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


}
