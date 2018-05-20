package wrss.donotgetlost;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class FirstActivity extends AppCompatActivity {

    private Button button;

    private String password;
    private EditText answer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        password = getString(R.string.kod_poczatkowy);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //idź do następnej strony
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer = (EditText) findViewById(R.id.input);

                if (answer.getText().toString().trim().equalsIgnoreCase(password)) {
                    openActvity2();
                } else {
                    Toast toast = new Toast(getApplicationContext());
                    toast.setGravity(Gravity.TOP, 0, 0);
                    toast.makeText(FirstActivity.this, " zla opwiedź ", toast.LENGTH_SHORT).show();
                    answer.setText("");
                }
            }
        });

    }


    public void openActvity2() {
        Intent intent = new Intent(this, Rules.class);
        startActivity(intent);
    }


    @Override
    public void onBackPressed() {
    }
}
