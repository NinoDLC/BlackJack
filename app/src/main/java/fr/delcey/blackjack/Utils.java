package fr.delcey.blackjack;

import static fr.delcey.blackjack.Utils.BlackJackAction.BLACKJACK;
import static fr.delcey.blackjack.Utils.BlackJackAction.DOUBLE;
import static fr.delcey.blackjack.Utils.BlackJackAction.DRAW;
import static fr.delcey.blackjack.Utils.BlackJackAction.NAN;
import static fr.delcey.blackjack.Utils.BlackJackAction.SPLIT;
import static fr.delcey.blackjack.Utils.BlackJackAction.STAND;

/**
 * Created by Anthony "Nino" DELCEY on 04/11/2017.
 */

public class Utils {
    /**
     * First (most general) array is the hand of the dealer. This is the most important one. Second & third array are
     * the cards of the player (10 value is the max, as jack, queens and kings count as 10). As arrays start at 0 and
     * player card value start at 1, there's a bunch of 'index' values that will never be used. They are just here for
     * the construction of the array
     */
    public static final Utils.BlackJackAction[][][] firstActions = {
            {       // 0 X X
                    {NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN}, // 0 0 x
                    {NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN}, // 0 1 x
                    {NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN}, // 0 2 x
                    {NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN}, // 0 3 x
                    {NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN}, // 0 4 x
                    {NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN}, // 0 5 x
                    {NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN}, // 0 6 x
                    {NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN}, // 0 7 x
                    {NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN}, // 0 8 x
                    {NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN}, // 0 9 x
                    {NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN} // 0 10 x
            },
            {       // ACE X X
                    {NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN}, // ACE 0 x
                    {NAN, SPLIT, DRAW, DRAW, DRAW, DRAW, DRAW, DRAW, STAND, STAND, BLACKJACK}, // ACE 1 x
                    {NAN, DRAW, DRAW, DRAW, DRAW, DRAW, DRAW, DRAW, DRAW, DOUBLE, DRAW}, // ACE 2 x
                    {NAN, DRAW, DRAW, DRAW, DRAW, DRAW, DRAW, DRAW, DOUBLE, DRAW, DRAW}, // ACE 3 x
                    {NAN, DRAW, DRAW, DRAW, DRAW, DRAW, DRAW, DOUBLE, DRAW, DRAW, DRAW}, // ACE 4 x
                    {NAN, DRAW, DRAW, DRAW, DRAW, DRAW, DOUBLE, DRAW, DRAW, DRAW, DRAW}, // ACE 5 x
                    {NAN, DRAW, DRAW, DRAW, DRAW, DOUBLE, DRAW, DRAW, DRAW, DRAW, DRAW}, // ACE 6 x
                    {NAN, DRAW, DRAW, DRAW, DOUBLE, DRAW, DRAW, DRAW, DRAW, DRAW, STAND}, // ACE 7 x
                    {NAN, STAND, DRAW, DOUBLE, DRAW, DRAW, DRAW, DRAW, SPLIT, STAND, STAND}, // ACE 8 x
                    {NAN, STAND, DOUBLE, DRAW, DRAW, DRAW, DRAW, DRAW, STAND, DRAW, STAND}, // ACE 9 x
                    {NAN, BLACKJACK, DRAW, DRAW, DRAW, DRAW, DRAW, STAND, STAND, STAND, STAND} // ACE 10 x
            },
            {        // 2 X X
                    {NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN}, // 2 0 x
                    {NAN, SPLIT, DRAW, DRAW, DRAW, DRAW, DRAW, DOUBLE, STAND, STAND, BLACKJACK}, // 2 1 x
                    {NAN, DRAW, SPLIT, DRAW, DRAW, DRAW, DRAW, DRAW, DOUBLE, DOUBLE, STAND}, // 2 2 x
                    {NAN, DRAW, DRAW, SPLIT, DRAW, DRAW, DRAW, DOUBLE, DOUBLE, STAND, STAND}, // 2 3 x
                    {NAN, DRAW, DRAW, DRAW, DRAW, DRAW, DOUBLE, DOUBLE, STAND, STAND, STAND}, // 2 4 x
                    {NAN, DRAW, DRAW, DRAW, DRAW, DOUBLE, DOUBLE, STAND, STAND, STAND, STAND}, // 2 5 x
                    {NAN, DRAW, DRAW, DRAW, DOUBLE, DOUBLE, SPLIT, STAND, STAND, STAND, STAND}, // 2 6 x
                    {NAN, DOUBLE, DRAW, DOUBLE, DOUBLE, STAND, STAND, SPLIT, STAND, STAND, STAND}, // 2 7 x
                    {NAN, STAND, DOUBLE, DOUBLE, STAND, STAND, STAND, STAND, SPLIT, STAND, STAND}, // 2 8 x
                    {NAN, STAND, DOUBLE, STAND, STAND, STAND, STAND, STAND, STAND, SPLIT, STAND}, // 2 9 x
                    {NAN, BLACKJACK, STAND, STAND, STAND, STAND, STAND, STAND, STAND, STAND, STAND} // 2 10 x
            },
            {       // 3 X X
                    {NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN}, // 3 0 x
                    {NAN, SPLIT, DRAW, DRAW, DRAW, DRAW, DOUBLE, DOUBLE, STAND, STAND, BLACKJACK}, // 3 1 x
                    {NAN, DRAW, SPLIT, DRAW, DRAW, DRAW, DRAW, DOUBLE, DOUBLE, DOUBLE, STAND}, // 3 2 x
                    {NAN, DRAW, DRAW, SPLIT, DRAW, DRAW, DOUBLE, DOUBLE, DOUBLE, STAND, STAND}, // 3 3 x
                    {NAN, DRAW, DRAW, DRAW, DRAW, DOUBLE, DOUBLE, DOUBLE, STAND, STAND, STAND}, // 3 4 x
                    {NAN, DRAW, DRAW, DRAW, DOUBLE, DOUBLE, DOUBLE, STAND, STAND, STAND, STAND}, // 3 5 x
                    {NAN, DOUBLE, DRAW, DOUBLE, DOUBLE, DOUBLE, SPLIT, STAND, STAND, STAND, STAND}, // 3 6 x
                    {NAN, DOUBLE, DOUBLE, DOUBLE, DOUBLE, STAND, STAND, SPLIT, STAND, STAND, STAND}, // 3 7 x
                    {NAN, STAND, DOUBLE, DOUBLE, STAND, STAND, STAND, STAND, SPLIT, STAND, STAND}, // 3 8 x
                    {NAN, STAND, DOUBLE, STAND, STAND, STAND, STAND, STAND, STAND, SPLIT, STAND}, // 3 9 x
                    {NAN, BLACKJACK, STAND, STAND, STAND, STAND, STAND, STAND, STAND, STAND, STAND} // 3 10 x
            },
            {       // 4 X X
                    {NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN}, // 4 0 x
                    {NAN, SPLIT, DRAW, DRAW, DOUBLE, DOUBLE, DOUBLE, DOUBLE, STAND, STAND, BLACKJACK}, // 4 1 x
                    {NAN, DRAW, SPLIT, STAND, DRAW, DRAW, DRAW, DOUBLE, DOUBLE, DOUBLE, STAND}, // 4 2 x
                    {NAN, DRAW, DRAW, SPLIT, DRAW, DRAW, DOUBLE, DOUBLE, DOUBLE, STAND, STAND}, // 4 3 x
                    {NAN, DOUBLE, DRAW, DRAW, DRAW, DOUBLE, DOUBLE, DOUBLE, STAND, STAND, STAND}, // 4 4 x
                    {NAN, DOUBLE, DRAW, DRAW, DOUBLE, DOUBLE, DOUBLE, STAND, STAND, STAND, STAND}, // 4 5 x
                    {NAN, DOUBLE, DRAW, DOUBLE, DOUBLE, DOUBLE, SPLIT, STAND, STAND, STAND, STAND}, // 4 6 x
                    {NAN, DOUBLE, DOUBLE, DOUBLE, DOUBLE, STAND, STAND, SPLIT, STAND, STAND, STAND}, // 4 7 x
                    {NAN, STAND, DOUBLE, DOUBLE, STAND, STAND, STAND, STAND, SPLIT, STAND, STAND}, // 4 8 x
                    {NAN, STAND, DOUBLE, STAND, STAND, STAND, STAND, STAND, STAND, SPLIT, STAND}, // 4 9 x
                    {NAN, BLACKJACK, STAND, STAND, STAND, STAND, STAND, STAND, STAND, STAND, STAND} // 4 10 x
            },
            {       // 5 X X
                    {NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN}, // 5 0 x
                    {NAN, SPLIT, DOUBLE, DOUBLE, DOUBLE, DOUBLE, DOUBLE, DOUBLE, STAND, STAND, BLACKJACK}, // 5 1 x
                    {NAN, DOUBLE, SPLIT, DRAW, DRAW, DRAW, DRAW, DOUBLE, DOUBLE, DOUBLE, STAND}, // 5 2 x
                    {NAN, DOUBLE, DRAW, SPLIT, DRAW, DRAW, DOUBLE, DOUBLE, DOUBLE, STAND, STAND}, // 5 3 x
                    {NAN, DOUBLE, DRAW, DRAW, SPLIT, DOUBLE, DOUBLE, DOUBLE, STAND, STAND, STAND}, // 5 4 x
                    {NAN, DOUBLE, DRAW, DRAW, DOUBLE, DOUBLE, DOUBLE, STAND, STAND, STAND, STAND}, // 5 5 x
                    {NAN, DOUBLE, DRAW, DOUBLE, DOUBLE, DOUBLE, SPLIT, STAND, STAND, STAND, STAND}, // 5 6 x
                    {NAN, DOUBLE, DOUBLE, DOUBLE, DOUBLE, STAND, STAND, SPLIT, STAND, STAND, STAND}, // 5 7 x
                    {NAN, STAND, DOUBLE, DOUBLE, STAND, STAND, STAND, STAND, SPLIT, STAND, STAND}, // 5 8 x
                    {NAN, STAND, DOUBLE, STAND, STAND, STAND, STAND, STAND, STAND, SPLIT, STAND}, // 5 9 x
                    {NAN, BLACKJACK, STAND, STAND, STAND, STAND, STAND, STAND, STAND, STAND, STAND} // 5 10 x
            },
            {       // 6 X X
                    {NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN}, // 6 0 x
                    {NAN, SPLIT, DOUBLE, DOUBLE, DOUBLE, DOUBLE, DOUBLE, DOUBLE, DOUBLE, STAND, BLACKJACK}, // 6 1 x
                    {NAN, DOUBLE, SPLIT, DRAW, DRAW, DRAW, DRAW, DOUBLE, DOUBLE, DOUBLE, STAND}, // 6 2 x
                    {NAN, DOUBLE, DRAW, SPLIT, DRAW, DRAW, DOUBLE, DOUBLE, DOUBLE, STAND, STAND}, // 6 3 x
                    {NAN, DOUBLE, DRAW, DRAW, SPLIT, DOUBLE, DOUBLE, DOUBLE, STAND, STAND, STAND}, // 6 4 x
                    {NAN, DOUBLE, DRAW, DRAW, DOUBLE, DOUBLE, DOUBLE, STAND, STAND, STAND, STAND}, // 6 5 x
                    {NAN, DOUBLE, DRAW, DOUBLE, DOUBLE, DOUBLE, SPLIT, STAND, STAND, STAND, STAND}, // 6 6 x
                    {NAN, DOUBLE, DOUBLE, DOUBLE, DOUBLE, STAND, STAND, SPLIT, STAND, STAND, STAND}, // 6 7 x
                    {NAN, DOUBLE, DOUBLE, DOUBLE, STAND, STAND, STAND, STAND, SPLIT, STAND, STAND}, // 6 8 x
                    {NAN, STAND, DOUBLE, STAND, STAND, STAND, STAND, STAND, STAND, SPLIT, STAND}, // 6 9 x
                    {NAN, BLACKJACK, STAND, STAND, STAND, STAND, STAND, STAND, STAND, STAND, STAND} // 6 10 x
            },
            {       // 7 X X
                    {NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN}, // 7 0 x
                    {NAN, SPLIT, DRAW, DRAW, DRAW, DRAW, DRAW, STAND, STAND, STAND, BLACKJACK}, // 7 1 x
                    {NAN, DRAW, SPLIT, DRAW, DRAW, DRAW, DRAW, DRAW, DOUBLE, DOUBLE, DRAW}, // 7 2 x
                    {NAN, DRAW, DRAW, SPLIT, DRAW, DRAW, DRAW, DOUBLE, DOUBLE, DRAW, DRAW}, // 7 3 x
                    {NAN, DRAW, DRAW, DRAW, DRAW, DRAW, DOUBLE, DOUBLE, DRAW, DRAW, DRAW}, // 7 4 x
                    {NAN, DRAW, DRAW, DRAW, DRAW, DOUBLE, DOUBLE, DRAW, DRAW, DRAW, DRAW}, // 7 5 x
                    {NAN, DRAW, DRAW, DRAW, DOUBLE, DOUBLE, DRAW, DRAW, DRAW, DRAW, DRAW}, // 7 6 x
                    {NAN, STAND, DRAW, DOUBLE, DOUBLE, DRAW, DRAW, DRAW, DRAW, DRAW, STAND}, // 7 7 x
                    {NAN, STAND, DOUBLE, DOUBLE, DRAW, DRAW, DRAW, DRAW, SPLIT, STAND, STAND}, // 7 8 x
                    {NAN, STAND, DOUBLE, DRAW, DRAW, DRAW, DRAW, DRAW, STAND, STAND, STAND}, // 7 9 x
                    {NAN, BLACKJACK, DRAW, DRAW, DRAW, DRAW, DRAW, STAND, STAND, STAND, STAND} // 7 10 x
            },
            {       // 8 X X
                    {NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN}, // 8 0 x
                    {NAN, SPLIT, DRAW, DRAW, DRAW, DRAW, DRAW, STAND, STAND, STAND, BLACKJACK}, // 8 1 x
                    {NAN, DRAW, DRAW, DRAW, DRAW, DRAW, DRAW, DRAW, DOUBLE, DOUBLE, DRAW}, // 8 2 x
                    {NAN, DRAW, DRAW, DRAW, DRAW, DRAW, DRAW, DOUBLE, DOUBLE, DRAW, DRAW}, // 8 3 x
                    {NAN, DRAW, DRAW, DRAW, DRAW, DRAW, DOUBLE, DOUBLE, DRAW, DRAW, DRAW}, // 8 4 x
                    {NAN, DRAW, DRAW, DRAW, DRAW, DOUBLE, DOUBLE, DRAW, DRAW, DRAW, DRAW}, // 8 5 x
                    {NAN, DRAW, DRAW, DRAW, DOUBLE, DOUBLE, DRAW, DRAW, DRAW, DRAW, DRAW}, // 8 6 x
                    {NAN, STAND, DRAW, DOUBLE, DOUBLE, DRAW, DRAW, DRAW, DRAW, DRAW, STAND}, // 8 7 x
                    {NAN, STAND, DOUBLE, DOUBLE, DRAW, DRAW, DRAW, DRAW, SPLIT, STAND, STAND}, // 8 8 x
                    {NAN, STAND, DOUBLE, DRAW, DRAW, DRAW, DRAW, DRAW, STAND, SPLIT, STAND}, // 8 9 x
                    {NAN, BLACKJACK, DRAW, DRAW, DRAW, DRAW, DRAW, STAND, STAND, STAND, STAND} // 8 10 x
            },
            {       // 9 X X
                    {NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN}, // 9 0 x
                    {NAN, SPLIT, DRAW, DRAW, DRAW, DRAW, DRAW, DRAW, STAND, STAND, BLACKJACK}, // 9 1 x
                    {NAN, DRAW, DRAW, DRAW, DRAW, DRAW, DRAW, DRAW, DOUBLE, DOUBLE, DRAW}, // 9 2 x
                    {NAN, DRAW, DRAW, DRAW, DRAW, DRAW, DRAW, DOUBLE, DOUBLE, DRAW, DRAW}, // 9 3 x
                    {NAN, DRAW, DRAW, DRAW, DRAW, DRAW, DOUBLE, DOUBLE, DRAW, DRAW, DRAW}, // 9 4 x
                    {NAN, DRAW, DRAW, DRAW, DRAW, DOUBLE, DOUBLE, DRAW, DRAW, DRAW, DRAW}, // 9 5 x
                    {NAN, DRAW, DRAW, DRAW, DOUBLE, DOUBLE, DRAW, DRAW, DRAW, DRAW, DRAW}, // 9 6 x
                    {NAN, DRAW, DRAW, DOUBLE, DOUBLE, DRAW, DRAW, DRAW, DRAW, DRAW, STAND}, // 9 7 x
                    {NAN, STAND, DOUBLE, DOUBLE, DRAW, DRAW, DRAW, DRAW, SPLIT, STAND, STAND}, // 9 8 x
                    {NAN, STAND, DOUBLE, DRAW, DRAW, DRAW, DRAW, DRAW, STAND, SPLIT, STAND}, // 9 9 x
                    {NAN, BLACKJACK, DRAW, DRAW, DRAW, DRAW, DRAW, STAND, STAND, STAND, STAND} // 9 10 x
            },
            {       // 10 X X
                    {NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN}, // 10 0 x
                    {NAN, SPLIT, DRAW, DRAW, DRAW, DRAW, DRAW, DRAW, STAND, STAND, BLACKJACK}, // 10 1 x
                    {NAN, DRAW, DRAW, DRAW, DRAW, DRAW, DRAW, DRAW, DRAW, DOUBLE, DRAW}, // 10 2 x
                    {NAN, DRAW, DRAW, DRAW, DRAW, DRAW, DRAW, DRAW, DOUBLE, DRAW, DRAW}, // 10 3 x
                    {NAN, DRAW, DRAW, DRAW, DRAW, DRAW, DRAW, DOUBLE, DRAW, DRAW, DRAW}, // 10 4 x
                    {NAN, DRAW, DRAW, DRAW, DRAW, DRAW, DOUBLE, DRAW, DRAW, DRAW, DRAW}, // 10 5 x
                    {NAN, DRAW, DRAW, DRAW, DRAW, DOUBLE, DRAW, DRAW, DRAW, DRAW, DRAW}, // 10 6 x
                    {NAN, DRAW, DRAW, DRAW, DOUBLE, DRAW, DRAW, DRAW, DRAW, DRAW, STAND}, // 10 7 x
                    {NAN, STAND, DRAW, DOUBLE, DRAW, DRAW, DRAW, DRAW, SPLIT, STAND, STAND}, // 10 8 x
                    {NAN, STAND, DOUBLE, DRAW, DRAW, DRAW, DRAW, DRAW, STAND, STAND, STAND}, // 10 9 x
                    {NAN, BLACKJACK, DRAW, DRAW, DRAW, DRAW, DRAW, STAND, STAND, STAND, STAND} // 10 10 x
            }};

    /**
     * First array is the hand of the dealer. Second array is the **HARD** card value of the player. As arrays start at
     * 0 and player card value start at 1, there's a bunch of 'index' values that will never be used. They are just here
     * for the construction of the array
     */
    public static BlackJackAction[][] hardActions = {
            {NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN}, // 0
            {NAN, NAN, NAN, NAN, NAN, DRAW, DRAW, DRAW, DRAW, DRAW, DRAW, DOUBLE, DRAW, DRAW, DRAW, DRAW, DRAW, STAND, STAND, STAND, STAND}, // 1
            {NAN, NAN, NAN, NAN, NAN, DRAW, DRAW, DRAW, DRAW, DRAW, DOUBLE, DOUBLE, DRAW, STAND, STAND, STAND, STAND, STAND, STAND, STAND, STAND}, // 2
            {NAN, NAN, NAN, NAN, NAN, DRAW, DRAW, DRAW, DRAW, DOUBLE, DOUBLE, DOUBLE, DRAW, STAND, STAND, STAND, STAND, STAND, STAND, STAND, STAND}, // 3
            {NAN, NAN, NAN, NAN, NAN, DRAW, DRAW, DRAW, DRAW, DOUBLE, DOUBLE, DOUBLE, STAND, STAND, STAND, STAND, STAND, STAND, STAND, STAND, STAND}, // 4
            {NAN, NAN, NAN, NAN, NAN, DRAW, DRAW, DRAW, DRAW, DOUBLE, DOUBLE, DOUBLE, STAND, STAND, STAND, STAND, STAND, STAND, STAND, STAND, STAND}, // 5
            {NAN, NAN, NAN, NAN, NAN, DRAW, DRAW, DRAW, DRAW, DOUBLE, DOUBLE, DOUBLE, STAND, STAND, STAND, STAND, STAND, STAND, STAND, STAND, STAND}, // 6
            {NAN, NAN, NAN, NAN, NAN, DRAW, DRAW, DRAW, DRAW, DRAW, DOUBLE, DOUBLE, DRAW, DRAW, DRAW, DRAW, DRAW, STAND, STAND, STAND, STAND}, // 7
            {NAN, NAN, NAN, NAN, NAN, DRAW, DRAW, DRAW, DRAW, DRAW, DOUBLE, DOUBLE, DRAW, DRAW, DRAW, DRAW, DRAW, STAND, STAND, STAND, STAND}, // 8
            {NAN, NAN, NAN, NAN, NAN, DRAW, DRAW, DRAW, DRAW, DRAW, DOUBLE, DOUBLE, DRAW, DRAW, DRAW, DRAW, DRAW, STAND, STAND, STAND, STAND}, // 9
            {NAN, NAN, NAN, NAN, NAN, DRAW, DRAW, DRAW, DRAW, DRAW, DRAW, DOUBLE, DRAW, DRAW, DRAW, DRAW, DRAW, STAND, STAND, STAND, STAND} // 10
    };

    /**
     * First array is the hand of the dealer. Second array is the **SOFT** card value of the player. As arrays start at
     * 0 and player card value start at 1, there's a bunch of 'index' values that will never be used. They are just here
     * for the construction of the array
     */
    public static BlackJackAction[][] softActions = {
            {NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN}, // 0
            {NAN, NAN, NAN, DRAW, DRAW, DRAW, DRAW, DRAW, DRAW, STAND, STAND}, // 1
            {NAN, NAN, NAN, DRAW, DRAW, DRAW, DRAW, DRAW, STAND, STAND, STAND}, // 2
            {NAN, NAN, NAN, DRAW, DRAW, DRAW, DRAW, DRAW, STAND, STAND, STAND}, // 3
            {NAN, NAN, NAN, DRAW, DRAW, DRAW, DRAW, DRAW, STAND, STAND, STAND}, // 4
            {NAN, NAN, NAN, DRAW, DRAW, DRAW, DRAW, DRAW, STAND, STAND, STAND}, // 5
            {NAN, NAN, NAN, DRAW, DRAW, DRAW, DRAW, DRAW, STAND, STAND, STAND}, // 6
            {NAN, NAN, NAN, DRAW, DRAW, DRAW, DRAW, DRAW, STAND, STAND, STAND}, // 7
            {NAN, NAN, NAN, DRAW, DRAW, DRAW, DRAW, DRAW, STAND, STAND, STAND}, // 8
            {NAN, NAN, NAN, DRAW, DRAW, DRAW, DRAW, DRAW, DRAW, STAND, STAND}, // 9
            {NAN, NAN, NAN, DRAW, DRAW, DRAW, DRAW, DRAW, DRAW, STAND, STAND} // 10
    };

    enum BlackJackAction {
        DRAW,
        SPLIT,
        DOUBLE,
        STAND,
        BLACKJACK,
        NAN
    }
}
