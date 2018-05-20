package wrss.donotgetlost;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Rules extends AppCompatActivity {

    private Button button;

    private EditText answer;
    private Globals g = Globals.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //idź do następnej strony
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer = (EditText) findViewById(R.id.input);
                g.setTeamName(String.valueOf(answer));
                openActvity2();

            }
        });

    }


    public void openActvity2() {
        Intent intent = new Intent(this, Start.class);
        startActivity(intent);
    }


    @Override
    public void onBackPressed() {
    }
}
