package fr.delcey.blackjack;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private BlackJackManager mBlackJackManager = new BlackJackManager();

    private TextView mTvMoney;
    private TextView mTvTurn;
    private TextView mTvHotness;
    private TextView mTvHotnessReached;

    private int mMoney = 500;

    private boolean mSetup;
    private int mTurn = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button play = findViewById(R.id.btn_play);

        mTvMoney = findViewById(R.id.tv_money);
        mTvTurn = findViewById(R.id.tv_turns);
        mTvHotness = findViewById(R.id.tv_hotness);
        mTvHotnessReached = findViewById(R.id.tv_hotness_reached);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onPlayButtonClicked();
            }
        });
    }

    private void onPlayButtonClicked() {
        if (!mSetup) {
            mSetup = true;
            mBlackJackManager.setup(mMoney, 2, 10, 8, 20);
        }

        boolean hit20Hotness = false;

        BlackJackManager.HandResult lastResult = null;

        for (int i = 0; i < 10; i++) {
            if (mMoney > 0) {
                lastResult = mBlackJackManager.playGame();

                mMoney = lastResult.getMoney();
                mTurn++;

                if (lastResult.getHotness() >= 20) {
                    hit20Hotness = true;
                }

                Log.d(MainActivity.class.getName(), "HOTNESS: " + lastResult.getHotness());
            }
        }

        updateUI(lastResult);

        if (hit20Hotness) {
            mTvHotnessReached.setText("20 HOTNESS REACHED BOIS !");
        } else {
            mTvHotnessReached.setText("");
        }
    }

    private void updateUI(BlackJackManager.HandResult result) {
        mTvMoney.setText(getString(R.string.money, mMoney));
        mTvTurn.setText(getString(R.string.turn, mTurn));
        mTvHotness.setText(getString(R.string.hotness, result.getHotness()));
    }
}
