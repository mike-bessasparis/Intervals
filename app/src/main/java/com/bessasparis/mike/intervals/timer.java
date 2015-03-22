package com.bessasparis.mike.intervals;

import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


public class timer extends ActionBarActivity {

    int fastCountdown = 21;
    int slowCountdown = 8;
    private SlowCountDownTimer mySlowTimer;
    private FastCountDownTimer myFastTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        mySlowTimer = new SlowCountDownTimer(slowCountdown * 1000, 1000);
        myFastTimer = new FastCountDownTimer(fastCountdown * 1000, 1000);

        myFastTimer.start();

    }

    public class FastCountDownTimer extends CountDownTimer {

        TextView mTextField = (TextView) findViewById(R.id.countdown_text);
        private boolean done = false;

        FastCountDownTimer(long startTime, long interval) {
            super(startTime, interval);
        }

        @Override
        public void onFinish() {
            mySlowTimer.start();
        }

        @Override
        public void onTick(long millisUntilFinished) {
            mTextField.setText(" " + millisUntilFinished / 1000);
        }
    }

    public class SlowCountDownTimer extends CountDownTimer {

        TextView mTextField = (TextView) findViewById(R.id.countdown_text);
        private boolean done = false;

        SlowCountDownTimer(long startTime, long interval) {
            super(startTime, interval);
        }

        @Override
        public void onFinish() {
            myFastTimer.start();
        }

        @Override
        public void onTick(long millisUntilFinished) {
            mTextField.setText(" " + millisUntilFinished / 1000);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_timer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
