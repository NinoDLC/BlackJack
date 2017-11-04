package fr.delcey.blackjack;

/**
 * Created by Anthony "Nino" DELCEY on 04/11/2017.
 */
class Card {
    private int mValue;

    public Card(int value) {
        mValue = value;
    }

    public int getValue() {
        return Math.min(mValue, 10);
    }

    public String getHumanValue() {
        switch (mValue) {
            case 1 :
                return "A";
            case 2 :
            case 3 :
            case 4 :
            case 5 :
            case 6 :
            case 7 :
            case 8 :
            case 9 :
            case 10 :
                return "" + mValue;
            case 11 :
                return "J";
            case 12 :
                return "Q";
            case 13 :
                return "K";
        }

        return "??";
    }

    @Override
    public String toString() {
        return getHumanValue();
    }

    public boolean isAce() {
        return mValue == 1;
    }

    public boolean isTener() {
        return mValue >= 10 && mValue <= 13;
    }
}
