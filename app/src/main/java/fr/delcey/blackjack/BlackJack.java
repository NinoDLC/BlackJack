package fr.delcey.blackjack;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Anthony "Nino" DELCEY on 04/11/2017.
 */

class BlackJack {
    private Listener mListener;

    private Deck mDeck;

    private DealerHand mDealerHand;
    private List<PlayerHand> mPlayerHands;
    private int mFinishedHandsIndex;

    private BlackJack() {
        // You have to count the card with the callback listener :p
    }

    public BlackJack(Listener listener) {
        mListener = listener;

        initDeck();
    }

    public void initDeck() {
        // Shami-Shuffle
        mDeck = new Deck(
                Constants.NUMBER_OF_DECKS_USED,
                Constants.NUMBER_OF_CARDS_IN_A_DECK,
                Constants.NUMBER_OF_VALUES_IN_A_DECK);
    }

    public void dealNewHand(int numberOfBoxes, int bet) {
        // Reshuffle if needed
        if (mDeck.isLastRound()) {
            Log.d(BlackJack.class.getName(), "dealNewHand() : this was the last round, reshuffling...");
            initDeck();

            mListener.onNewGame();
        }

        mFinishedHandsIndex = 0;
        mPlayerHands = new ArrayList<>();

        // Give hands
        mDealerHand = new DealerHand(drawCard());

        for (int i = 0; i < numberOfBoxes; i++) {
            mPlayerHands.add(new PlayerHand(drawCard(), drawCard(), bet));
        }

        // Pay blackjacks
        if (!mDealerHand.isFirstCardAnAce()
                && !mDealerHand.isFirstCardATenner()) {
            payBlackJacks(bet);
        }
    }

    private void payBlackJacks(int bet) {
        ListIterator<PlayerHand> iterator = mPlayerHands.listIterator();

        while (iterator.hasNext()) {
            Hand hand = iterator.next();

            if (hand.isBlackJack()) {
                iterator.remove();

                Log.d(BlackJack.class.getName(), "payBlackJacks() BLACKJACK !! " + hand);

                mListener.onBlackJack((int) (bet * 2.5));
            }
        }
    }

    public PlayerHand drawForCurrentPlayerHand(boolean finishHandAnyway) {
        PlayerHand hand = getCurrentHand();

        hand.addCard(drawCard());

        if (getCurrentHand().getCardsValue() > 21) {
            mPlayerHands.remove(hand);
        } else if (getCurrentHand().getCardsValue() == 21 || finishHandAnyway) {
            mFinishedHandsIndex++;
        }

        return hand;
    }

    public void finishCurrentHand() {
        mFinishedHandsIndex++;
    }

    private Card drawCard() {
        Card card = mDeck.draw();

        mListener.onCardDrawn(card);

        return card;
    }

    public void splitCurrentPlayerHand() {
        mPlayerHands.add(mFinishedHandsIndex + 1, getCurrentHand().split(mDeck));
    }

    public PlayerHand doubleCurrentPlayerHand() {
        getCurrentHand().doubleUp();

        return drawForCurrentPlayerHand(true);
    }

    public void finishGame() {
        Log.d(BlackJack.class.getName(), "Dealer's turn...");
        while (mDealerHand.getCardsValue() < 17) {
            mDealerHand.addCard(drawCard());
            Log.d(BlackJack.class.getName(), "" + mDealerHand);
        }

        if (mDealerHand.getCardsValue() > 21) {
            Log.d(BlackJack.class.getName(), "Dealer's busted !!");

            // Busted !!
            for (PlayerHand playerHand : mPlayerHands) {
                Log.d(BlackJack.class.getName(), "Paying player with " + playerHand + " for " + playerHand.getBet() + "$");
                mListener.onGain(playerHand.getBet() * 2);
            }
        } else if (mDealerHand.isBlackJack()) {
            Log.d(BlackJack.class.getName(), "Dealer's made a BlackJack !!");

            // They won't like it...
            for (PlayerHand playerHand : mPlayerHands) {
                if (playerHand.isBlackJack()) {
                    Log.d(BlackJack.class.getName(), "Player with " + playerHand + " still gets their bet back : " + playerHand.getBet() + "$");

                    mListener.onGain(playerHand.getBet());
                }
            }
        } else {
            // Compare scores
            for (PlayerHand playerHand : mPlayerHands) {
                if (playerHand.getCardsValue() > mDealerHand.getCardsValue()) {
                    Log.d(BlackJack.class.getName(), "Player with " + playerHand + " win " + playerHand.getBet() + "$ !");

                    mListener.onGain(playerHand.getBet() * 2);
                } else if (playerHand.getCardsValue() == mDealerHand.getCardsValue()) {
                    Log.d(BlackJack.class.getName(), "Player with " + playerHand + " gets their bet back : " + playerHand.getBet() + "$");

                    mListener.onGain(playerHand.getBet());
                } else {
                    Log.d(BlackJack.class.getName(), "Player with " + playerHand + " loses... to bad.");
                }
            }
        }
    }

    public DealerHand getDealerHand() {
        return mDealerHand;
    }

    public boolean hasGames() {
        return mFinishedHandsIndex < mPlayerHands.size();
    }

    public boolean hasValidGames() {
        return mPlayerHands.size() > 0;
    }

    public PlayerHand getCurrentHand() {
        return mPlayerHands.get(mFinishedHandsIndex);
    }

    interface Listener {
        void onNewGame();

        void onCardDrawn(Card card);

        void onBlackJack(int gain);

        void onGain(int gain);
    }
}
