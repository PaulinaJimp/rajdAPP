package wrss.donotgetlost;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.os.SystemClock.sleep;
import static java.lang.Long.MAX_VALUE;

public class Start extends AppCompatActivity {

    private Button button;
    //private Button clockButton;
   // private TextView clockText;

    private String password;
    private EditText answer;

    private Globals g=Globals.getInstance();

    private CountDownTimer timer;
    private long timeInMili = MAX_VALUE;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        password = getString(R.string.start_password);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        g.setCzas_gry(String.valueOf(BuildConfig.VERSION_CODE));
        g.setSkips(0);
        //idź do następnej strony
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer = (EditText) findViewById(R.id.input);

                if(answer.getText().toString().trim().equalsIgnoreCase(password))
                {
                    startTimer();
                    openActvity2();
                }
                else
                {
                    Toast toast = new Toast(getApplicationContext());
                    toast.setGravity(Gravity.TOP,0,0);
                    toast.makeText(Start.this, " zla opwiedź ",toast.LENGTH_SHORT).show();
                    answer.setText("");
                }
            }
        });

        //zegar
//        clockButton = (Button) findViewById(R.id.clockButton);
//        clockButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                startTimer();
//            }
//        });

        //clockText = (TextView) findViewById(R.id.clock);





    }


    public void openActvity2() {
        Intent intent = new Intent(this, Riddle2.class);
        startActivity(intent);
    }

    public void startTimer() {
        timer = new CountDownTimer(timeInMili, 1000) {
            @Override
            public void onTick(long l) {
                timeInMili += 1000;
                updateTimer();
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }

    public void updateTimer() {
        int hour = (int) timeInMili / 3600000;
        int min = (int) timeInMili % 3600000 / 60000;
        int sec = (int) timeInMili % 3600000 % 60000 / 1000;

        String timeNowText;
        timeNowText = "" + hour + ":";

        if (min < 10) timeNowText += "0";
        timeNowText += min + ":";
        if (sec < 10) timeNowText += "0";
        timeNowText += sec;


        g.setCzas_gry(timeNowText);
        g.setMili(timeInMili);
        //clockText.setText(g.getCzas_gry());


    }

    @Override
    public void onBackPressed() { }
}
