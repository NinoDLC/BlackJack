package fr.delcey.blackjack;

import android.util.Log;

/**
 * Created by Anthony "Nino" DELCEY on 04/11/2017.
 */
public class BlackJackManager implements BlackJack.Listener {
    // Semi-constants
    private int mMinimumBet;
    private int mMaximumBet;
    private int mSlotsPlayedWhenHot;
    private int mDeckHotnessForMaximumBet;

    private int mMoney;
    private int mHotness;

    private int mTurn;

    private BlackJack mBlackJack = new BlackJack(this);

    public void setup(int cashIn, int minimumBet, int maximumBet, int slotsPlayedWhenHot, int deckHotnessForMaximumBet) {
        mMinimumBet = minimumBet;
        mMaximumBet = maximumBet;
        mSlotsPlayedWhenHot = slotsPlayedWhenHot;
        mDeckHotnessForMaximumBet = deckHotnessForMaximumBet;

        mMoney = cashIn;
        mHotness = 0;
        mTurn = 0;
    }

    public BlackJackManager.HandResult playGame() {
        HandResult result = new HandResult(mMoney, mHotness, mTurn);

        boolean deckHot = isDeckHot();

        if (deckHot) {
            mMoney -= mSlotsPlayedWhenHot * mMaximumBet;

            mBlackJack.dealNewHand(mSlotsPlayedWhenHot, mMaximumBet);
        } else {
            mMoney -= mMinimumBet;

            mBlackJack.dealNewHand(1, mMinimumBet);
        }

        DealerHand dealerHand = mBlackJack.getDealerHand();
        Log.d(BlackJackManager.class.getName(), "" + dealerHand);

        while (mBlackJack.hasGames()) {

            PlayerHand hand = mBlackJack.getCurrentHand();
            Log.d(BlackJackManager.class.getName(), "" + hand);

            Utils.BlackJackAction action = getActionFromPlay(dealerHand, hand);

            Log.d(BlackJackManager.class.getName(), "action = " + action);

            switch (getActionFromPlay(dealerHand, hand)) {
                case DRAW:
                    PlayerHand newHand = mBlackJack.drawForCurrentPlayerHand(false);

                    log(newHand);
                    break;
                case SPLIT:
                    if (deckHot) {
                        mMoney -= mMaximumBet;
                    } else {
                        mMoney -= mMinimumBet;
                    }
                    mBlackJack.splitCurrentPlayerHand();
                    Log.d(BlackJackManager.class.getName(), "------------");
                    break;
                case DOUBLE:
                    if (deckHot) {
                        mMoney -= mMaximumBet;
                    } else {
                        mMoney -= mMinimumBet;
                    }
                    newHand = mBlackJack.doubleCurrentPlayerHand();

                    log(newHand);

                    break;
                case NAN:
                    throw new RuntimeException("For " + hand + " and " + dealerHand + ", the returned result" +
                            " is 'NAN', which is an incorrect state. The Action tri-dimensionnal array must be wrong. " +
                            "We use 'NAN' because cards starts at 1 while arrays starts at 1");
                case BLACKJACK:
                case STAND:
                    mBlackJack.finishCurrentHand();
                    Log.d(BlackJackManager.class.getName(), "------------");
                    break;
            }
        }

        // Players finished drawing cards, let's do the dealer's cards
        if (mBlackJack.hasValidGames()) {
            mBlackJack.finishGame();
        }

        Log.w(BlackJackManager.class.getName(), "End of game.");

        mTurn++;
        return result.with(mMoney, mHotness);
    }

    private void log(PlayerHand newHand) {
        Log.d(BlackJackManager.class.getName(), "" + newHand);
        Log.d(BlackJackManager.class.getName(), "------------");
    }

    private Utils.BlackJackAction getActionFromPlay(DealerHand dealerHand, PlayerHand hand) {
        if (hand.isHand2Cards()) {
            // First card we draw, we can double or split !
            return Utils.firstActions
                    [dealerHand.getFirstCardValue()]
                    [hand.getFirstCardValue()]
                    [hand.getSecondCardValue()];
        } else {
            // Only the value of the card is important now
            if (hand.isSoft()) {
                return (Utils.softActions
                        [dealerHand.getFirstCardValue()]
                        [hand.getSoftCardsValue()]);
            } else {
                return (Utils.hardActions
                        [dealerHand.getFirstCardValue()]
                        [hand.getCardsValue()]);
            }
        }
    }

    private boolean isDeckHot() {
        return mHotness >= mDeckHotnessForMaximumBet;
    }

    @Override
    public void onNewGame() {
        mTurn = 0;
        mHotness = 0;
    }

    @Override
    public void onCardDrawn(Card card) {
        switch (card.getValue()) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                mHotness++;
                break;

            case 1:
            case 10:
            case 11:
            case 12:
            case 13:
                mHotness--;
                break;
        }
    }

    @Override
    public void onBlackJack(int gain) {
        mMoney += gain;
    }

    @Override
    public void onGain(int gain) {
        mMoney += gain;
    }

    public class HandResult {
        private final int mInitialMoney;
        private final int mInitialHotness;
        private final int mTurn;

        private int mDeltaMoney;
        private int mDeltaHotness;

        private int mMoney;
        private int mHotness;

        public HandResult(int money, int hotness, int turn) {
            mInitialMoney = money;
            mInitialHotness = hotness;
            mTurn = turn;
        }

        public HandResult with(int newMoney, int newHotness) {
            mMoney = newMoney;
            mHotness = newHotness;

            mDeltaMoney = newMoney - mInitialMoney;
            mDeltaHotness = newHotness - mInitialHotness;

            return this;
        }

        public int getInitialMoney() {
            return mInitialMoney;
        }

        public int getInitialHotness() {
            return mInitialHotness;
        }

        public int getTurn() {
            return mTurn;
        }

        public int getDeltaMoney() {
            return mDeltaMoney;
        }

        public int getDeltaHotness() {
            return mDeltaHotness;
        }

        public int getMoney() {
            return mMoney;
        }

        public int getHotness() {
            return mHotness;
        }
    }
}
