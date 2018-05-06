package wrss.donotgetlost;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.lang.Long.MAX_VALUE;

public class Riddle extends AppCompatActivity {
    //private TextView clockText;
    private Globals g=Globals.getInstance();
    private Button button;

    private CountDownTimer timer;
    private long timeInMili;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riddle);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //g.setCzas_gry(String.valueOf(BuildConfig.VERSION_CODE));
        //idź do następnej strony
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActvity2();
            }
        });

        timeInMili = g.getMili();
        //zegar
        //clockButton = (Button) findViewById(R.id.clockButton);
        //clockButton.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //        startTimer();
        //    }
        //});

        //clockText = (TextView) findViewById(R.id.clock);
        //clockText.setText(g.getCzas_gry());
        //startTimer();
    }


    public void openActvity2() {
        Intent intent = new Intent(this, Finish.class);
        startActivity(intent);
    }

//    public void startTimer() {
//
//
//
//
//        timer = new CountDownTimer(timeInMili, 1000) {
//            @Override
//            public void onTick(long l) {
//                timeInMili += 1000;
//                updateTimer();
//            }
//
//            @Override
//            public void onFinish() {
//
//            }
//        }.start();
//    }
//
//    public void updateTimer() {
//        int hour = (int) timeInMili / 3600000;
//        int min = (int) timeInMili % 3600000 / 60000;
//        int sec = (int) timeInMili % 3600000 % 60000 / 1000;
//
//        String timeNowText;
//        timeNowText = "" + hour + ":";
//
//        if (min < 10) timeNowText += "0";
//        timeNowText += min + ":";
//        if (sec < 10) timeNowText += "0";
//        timeNowText += sec;
//
//
//        g.setCzas_gry(timeNowText);
//        g.setMili(timeInMili);
//        clockText.setText(g.getCzas_gry());
//    }


    @Override
    public void onBackPressed() { }
}
