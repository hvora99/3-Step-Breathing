package mymed.itionmu.sic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;

import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;

import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Locale;
import java.util.Objects;

public class MadaNewTimer extends AppCompatActivity {


    private long mTimeLeftInMillis;
    private long getmTimeLeftInMillisinOnemala;

    private boolean mTimerRunning;

    private ImageView mButtonStartPause;
    private ImageView mButtonReset;

    private ProgressBar progressBarCircle1,progressBarCircle12;

    TextView Currentmala,totalTimer,oneMalaTimer;

    int totalSecsinonemada;
    int TotalSadhnatimeinsec;
    int numberofmada;

    private   long START_TIME_IN_MILLIS;
    private   long START_TIME_IN_MILLIS_oneMala ;

    int Coutter = 0,gap;


    MediaPlayer mp;
    MediaPlayer mp1,mp2;

    CountDownTimer cntr_aCounter,mCountDownTimer;
    CheckBox chkbx,chkbx2;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_mada_new_timer);


        mp = MediaPlayer.create(MadaNewTimer.this, R.raw.iphonnoti);
        mp1 = MediaPlayer.create(MadaNewTimer.this, R.raw.noti);
        mp2=MediaPlayer.create(MadaNewTimer.this,R.raw.n20);


        Currentmala = (TextView)findViewById(R.id.currentmala);
        totalTimer = (TextView)findViewById(R.id.txtTotaltimer);
        oneMalaTimer = (TextView)findViewById(R.id.txtonemadaTimer);

        mButtonStartPause = findViewById(R.id.button_start_pause);
        mButtonReset = findViewById(R.id.button_reset);


        progressBarCircle1 = (ProgressBar) findViewById(R.id.progressBarCircle11);
        progressBarCircle12 = (ProgressBar) findViewById(R.id.progressBarCircle12);

        Intent mIntent = getIntent();
        TotalSadhnatimeinsec = mIntent.getIntExtra("TotalSadhnatimeinsec", 0);
        totalSecsinonemada = mIntent.getIntExtra("TotalsecinOneMada", 0);
        gap = mIntent.getIntExtra("Gapbetmada", 0);
        gap= gap*1000;
        numberofmada = mIntent.getIntExtra("madadigit",0);

        mTimeLeftInMillis=TotalSadhnatimeinsec*1000;
        START_TIME_IN_MILLIS=mTimeLeftInMillis;

        getmTimeLeftInMillisinOnemala=totalSecsinonemada*1000;
        START_TIME_IN_MILLIS_oneMala=getmTimeLeftInMillisinOnemala;

        updateCountDownText();
        setProgressBarValues();

        mButtonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTimerRunning) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });
        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });

        chkbx2 = (CheckBox) findViewById(R.id.checkbx1);
        chkbx2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b)
                {
                    mp2.start();
                }

            }
        });

        mp2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                chkbx2.setChecked(false);
            }
        });

        chkbx = (CheckBox)findViewById(R.id.checkbx);
        chkbx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                             @Override
                                             public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {

                                                 if(isChecked)
                                                 {
                                                     getWindow().addFlags(
                                                             WindowManager.LayoutParams.FLAG_FULLSCREEN
                                                                     | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
                                                 }

                                                 else
                                                 {
                                                     getWindow().clearFlags(android.view.WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
                                                 }
                                             }
                                         }
        );

    }

    public void onemadatimer() {


      if(getmTimeLeftInMillisinOnemala<999 || getmTimeLeftInMillisinOnemala==totalSecsinonemada*1000) {
            getmTimeLeftInMillisinOnemala = totalSecsinonemada * 1000;
            Coutter++;
        }


        if (--Coutter != numberofmada) {
            Coutter++;
            final int gap1;
            gap1=gap-1500;

            cntr_aCounter = new CountDownTimer(getmTimeLeftInMillisinOnemala, 1000) {
                public void onTick(long millisUntilFinished) {

                    getmTimeLeftInMillisinOnemala = millisUntilFinished;
                    progressBarCircle12.setProgress((int) (millisUntilFinished / 1000));

                    totalTimer.setText(String.format(Locale.getDefault(), "%02d:%02d", (int) (mTimeLeftInMillis / 1000) / 60, (int) (mTimeLeftInMillis / 1000) % 60));

                    if(millisUntilFinished <= gap && millisUntilFinished >= gap1)
                    {

                       mp1.start();


                    }

                }


                @SuppressLint("SetTextI18n")
                public void onFinish() {

                    Repeatbeep();
                    Currentmala.setText(Integer.toString(Coutter));
                    cntr_aCounter.cancel();
                    onemadatimer();

                }
            };
            cntr_aCounter.start();
        }
        else
        {
            if(chkbx.isChecked())
            {
                chkbx.setChecked(false);
            }
            if(chkbx2.isChecked())
                chkbx2.setChecked(false);

        }


    }

    public  void  Repeatbeep()
    {
        mp.start();;
    }





    private void startTimer() {

        onemadatimer();
        // mEndTime = System.currentTimeMillis() + mTimeLeftInMillis;
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                progressBarCircle1.setProgress((int) (millisUntilFinished/ 1000));

                oneMalaTimer.setText(String.format(Locale.getDefault(), "%02d:%02d", (int) (getmTimeLeftInMillisinOnemala/1000 ) / 60, (int) (getmTimeLeftInMillisinOnemala/1000 ) % 60));
            }
            @Override
            public void onFinish() {
                mTimerRunning = false;
                updateButtons();
            }
        }.start();
        mTimerRunning = true;
        updateButtons();
    }
    private void pauseTimer() {
        mCountDownTimer.cancel();
        cntr_aCounter.cancel();
        mTimerRunning = false;
        updateButtons();
    }
    private void resetTimer() {
        int time = 0;

        time = TotalSadhnatimeinsec;

        mTimeLeftInMillis = time*1000;
        getmTimeLeftInMillisinOnemala= totalSecsinonemada*1000;
        updateCountDownText();
        setProgressBarValues();
        updateButtons();
        Coutter=0;
    }
    private void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        int minutes1 = (int) (getmTimeLeftInMillisinOnemala/1000 ) / 60;
        int seconds1 = (int) (getmTimeLeftInMillisinOnemala/1000 ) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        totalTimer.setText(timeLeftFormatted);


        String timeLeftFormatted1 = String.format(Locale.getDefault(), "%02d:%02d", minutes1, seconds1);
        oneMalaTimer.setText(timeLeftFormatted1);

    }
    private void updateButtons() {
        if (mTimerRunning) {
            mButtonReset.setVisibility(View.INVISIBLE);
            mButtonStartPause.setBackground(getResources().getDrawable( R.drawable.ic_pause));
        } else {
            mButtonStartPause.setBackground(getResources().getDrawable( R.drawable.ic_start));
            if (mTimeLeftInMillis < 1000) {
                mButtonStartPause.setVisibility(View.INVISIBLE);
            } else {
                mButtonStartPause.setVisibility(View.VISIBLE);
            }
            if (mTimeLeftInMillis < START_TIME_IN_MILLIS) {
                mButtonReset.setVisibility(View.VISIBLE);
            } else {
                mButtonReset.setVisibility(View.INVISIBLE);
            }
        }
    }

    /**
     @Override
     protected void onSaveInstanceState(Bundle outState) {
     super.onSaveInstanceState(outState);
     outState.putLong("millisLeft", mTimeLeftInMillis);
     outState.putLong("millisLeft1", getmTimeLeftInMillisinOnemala);
     outState.putBoolean("timerRunning", mTimerRunning);

     outState.putLong("endTime", mEndTime);
     outState.putLong("endTime1", mEndTime1);
     }
     @Override
     protected void onRestoreInstanceState(Bundle savedInstanceState) {
     super.onRestoreInstanceState(savedInstanceState);
     mTimeLeftInMillis = savedInstanceState.getLong("millisLeft");
     mTimerRunning = savedInstanceState.getBoolean("timerRunning");
     updateCountDownText();
     updateButtons();
     if (mTimerRunning) {
     mEndTime = savedInstanceState.getLong("endTime");
     mEndTime1 = savedInstanceState.getLong("endTime1");
     mTimeLeftInMillis = mEndTime - System.currentTimeMillis();
     getmTimeLeftInMillisinOnemala = mEndTime1 - System.currentTimeMillis();
     startTimer();

     }
     } */

    private void setProgressBarValues() {

        progressBarCircle1.setMax((int) mTimeLeftInMillis / 1000);
        progressBarCircle1.setProgress((int) mTimeLeftInMillis / 1000);

        progressBarCircle12.setMax((totalSecsinonemada));
        progressBarCircle12.setProgress ((totalSecsinonemada));
    }

    @Override
    public void onBackPressed() {
        if(mp.isPlaying())
        {
            mp.stop();
        }
        if(mp1.isPlaying())
        {
            mp1.stop();
        }
        if(mp2.isPlaying())
        {
            mp2.stop();
        }
        super.onBackPressed();
    }
}