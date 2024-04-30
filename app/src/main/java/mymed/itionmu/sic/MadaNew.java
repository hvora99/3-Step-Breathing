package mymed.itionmu.sic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MadaNew extends AppCompatActivity {

    EditText edtnumberoffmada,edtonemada,edtgap;
    TextView txtonemadatime,txttotalmadatime;
    CardView startbtnn112,clearbtn;




    int totalSecsinonemada;
    int TotalSadhnatimeinsec;
    int numberofmada;
    int gap;

    float onemadatime;

    float x = 0;
    float y=0;
    float a=0;

    int hours  ;
    int minutes  ;
    int seconds  ;
    int hours1  ;
    int minutes1  ;
    int seconds1  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_mada_new);

        edtonemada = (EditText)findViewById(R.id.edt_numberofmantra);
        edtnumberoffmada = (EditText)findViewById(R.id.edt_numberofmala);
        edtgap = (EditText)findViewById(R.id.edt_gapbetmala);

        txtonemadatime = (TextView)findViewById(R.id.txt_numberofmantra);
        txttotalmadatime = (TextView)findViewById(R.id.txt_numberofmala);

        clearbtn = (CardView) findViewById(R.id.clearbtn);
        startbtnn112 = (CardView) findViewById(R.id.startsadhna);



        //--------------------------------------------------------------------------------------------------------



         gap = Integer.parseInt(edtgap.getText().toString().trim());
          x = Float.parseFloat(edtonemada.getText().toString().trim());
          numberofmada = Integer.parseInt(edtnumberoffmada.getText().toString().trim());

          y = x * 12;
          a = 108;
          onemadatime = a / y;

          totalSecsinonemada = (int) (onemadatime * 60);
          totalSecsinonemada=totalSecsinonemada+gap;

            hours = totalSecsinonemada / 3600;
            minutes = (totalSecsinonemada % 3600) / 60;
            seconds = totalSecsinonemada % 60;

          @SuppressLint("DefaultLocale") String textt = String.format("%02d: %02d:  %02d", hours, minutes, seconds);
          txtonemadatime.setText(textt);

          TotalSadhnatimeinsec = numberofmada * totalSecsinonemada;


          hours1 = TotalSadhnatimeinsec / 3600;
          minutes1 = (TotalSadhnatimeinsec % 3600) / 60;
          seconds1 = TotalSadhnatimeinsec % 60;

          @SuppressLint("DefaultLocale") String textt1 = String.format("%02d: %02d:  %02d", hours1, minutes1, seconds1);
          txttotalmadatime.setText(textt1);


          //-----------------------------------------------------------------------------------------------


        edtgap.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!edtgap.getText().toString().isEmpty()) {
                    // fetching value from edit text and type cast to integer
                    gap = Integer.parseInt(edtgap.getText().toString().trim());

                }


                totalSecsinonemada = (int) (onemadatime * 60);
                totalSecsinonemada=totalSecsinonemada+gap;

                  hours = totalSecsinonemada / 3600;
                  minutes = (totalSecsinonemada % 3600) / 60;
                  seconds = totalSecsinonemada % 60;

                @SuppressLint("DefaultLocale") String textt = String.format("%02d: %02d:  %02d", hours, minutes, seconds);
                txtonemadatime.setText(textt);

                TotalSadhnatimeinsec = numberofmada * totalSecsinonemada;

                hours1 = TotalSadhnatimeinsec / 3600;
                minutes1 = (TotalSadhnatimeinsec % 3600) / 60;
                seconds1 = TotalSadhnatimeinsec % 60;

                @SuppressLint("DefaultLocale") String textt1 = String.format("%02d: %02d:  %02d", hours1, minutes1, seconds1);
                txttotalmadatime.setText(textt1);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        edtonemada.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {



                if (!edtonemada.getText().toString().isEmpty()) {
                    // fetching value from edit text and type cast to integer
                    x = Float.parseFloat(edtonemada.getText().toString().trim());

                } else {
                    // toast message to fill edit text
                    Toast.makeText(getApplicationContext(), getString(R.string.message_minutes), Toast.LENGTH_LONG).show();
                }

                  y = x * 12;
                  a = 108;
                onemadatime = a / y;

                totalSecsinonemada = (int) (onemadatime * 60);
                totalSecsinonemada=totalSecsinonemada+gap;

                int hours = totalSecsinonemada / 3600;
                int minutes = (totalSecsinonemada % 3600) / 60;
                int seconds = totalSecsinonemada % 60;

                @SuppressLint("DefaultLocale") String textt = String.format("%02d: %02d:  %02d", hours, minutes, seconds);
                txtonemadatime.setText(textt);


                TotalSadhnatimeinsec = numberofmada * totalSecsinonemada;

                hours1 = TotalSadhnatimeinsec / 3600;
                minutes1 = (TotalSadhnatimeinsec % 3600) / 60;
                seconds1 = TotalSadhnatimeinsec % 60;

                @SuppressLint("DefaultLocale") String textt1 = String.format("%02d: %02d:  %02d", hours1, minutes1, seconds1);
                txttotalmadatime.setText(textt1);




            }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

        edtnumberoffmada.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!edtnumberoffmada.getText().toString().isEmpty()) {
                    // fetching value from edit text and type cast to integer
                    numberofmada = Integer.parseInt(edtnumberoffmada.getText().toString().trim());
                } else {
                    // toast message to fill edit text
                    Toast.makeText(getApplicationContext(), getString(R.string.message_minutes), Toast.LENGTH_LONG).show();
                }

                TotalSadhnatimeinsec = numberofmada * totalSecsinonemada;


                  hours1 = TotalSadhnatimeinsec / 3600;
                  minutes1 = (TotalSadhnatimeinsec % 3600) / 60;
                  seconds1 = TotalSadhnatimeinsec % 60;

                @SuppressLint("DefaultLocale") String textt = String.format("%02d: %02d:  %02d", hours1, minutes1, seconds1);
                txttotalmadatime.setText(textt);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        startbtnn112.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MadaNew.this, MadaNewTimer.class);
                myIntent.putExtra("TotalSadhnatimeinsec", TotalSadhnatimeinsec);
                myIntent.putExtra("TotalsecinOneMada", totalSecsinonemada);
                myIntent.putExtra("Gapbetmada", gap);
                myIntent.putExtra("madadigit", numberofmada);

         

                startActivity(myIntent);

            }
        });

    }



}