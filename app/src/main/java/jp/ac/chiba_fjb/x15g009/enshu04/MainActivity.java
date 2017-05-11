package jp.ac.chiba_fjb.x15g009.enshu04;

import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView mTextView;
    int mCount;
    Timer mTimer;
    Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.textView);
        Button Stert = (Button) findViewById(R.id.button);
        Button Stop = (Button) findViewById(R.id.button2);
        mCount = 0;

        mHandler = new Handler();

        Stert.setOnClickListener(this);
        Stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.button) {
            if(mTimer == null) {
                TimerTask timerTask = new TimerTask() {
                    @Override
                    public void run() {
                        mCount++;
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                mTextView.setText(String.valueOf(mCount));
                            }
                        });
                    }
                };
                //タイマー開始処理
                mTimer = new Timer();
                mTimer.schedule(timerTask, 0, 1000);
            }
        }else if(v.getId() == R.id.button2){
            if(mTimer != null){
                mTimer.cancel();
                mTimer = null;


            }
        }
    }


}
