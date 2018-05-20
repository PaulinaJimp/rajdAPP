package wrss.donotgetlost;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Finish extends AppCompatActivity {


    private TextView clockText;
    private TextView livesText;
    private Globals g = Globals.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        //PREVENTS ROTATION
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        clockText = (TextView) findViewById(R.id.clock);
        clockText.setText(g.getCzas_gry());
        livesText = (TextView) findViewById(R.id.lives);
        livesText.setText(("-"+String.valueOf(g.getSkips())+"HP"));
    }

    @Override
    public void onBackPressed() { }
}
