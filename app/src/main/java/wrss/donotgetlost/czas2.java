package wrss.donotgetlost;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class czas2 extends AppCompatActivity {
    private Globals g = Globals.getInstance();
    private Button button;
    private Button skipButton;

    private String password1;
    private String password2;
    private String password3;
    private String password4;
    private String password5;
    private String password6;
    private EditText answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        password1 = getString(R.string.pietnascie);
        password2 = getString(R.string.liczba15);
        password3 = getString(R.string.pietnasciemin);
        password4 = getString(R.string.liczba15min);
        password5 = getString(R.string.pietnascieminut);
        password6 = getString(R.string.liczba15minut);
        g.setCurrId(444);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_czas2);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer = (EditText) findViewById(R.id.input);

                if (answer.getText().toString().trim().equalsIgnoreCase(password1) ||
                        answer.getText().toString().trim().equalsIgnoreCase(password2)||
                        answer.getText().toString().trim().equalsIgnoreCase(password3)||
                        answer.getText().toString().trim().equalsIgnoreCase(password5)||
                        answer.getText().toString().trim().equalsIgnoreCase(password6) ||
                        answer.getText().toString().trim().equalsIgnoreCase(password4)) {
                    openActvity2();
                } else {
                    Toast toast = new Toast(getApplicationContext());
                    toast.setGravity(Gravity.TOP, 0, 0);
                    toast.makeText(czas2.this, " zla opwiedź ", toast.LENGTH_SHORT).show();
                    answer.setText("");
                }
            }
        });

        skipButton = (Button) findViewById(R.id.skipButton);
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), podpowiedz.class);
                startActivity(i);
            }
        });

    }


    public void openActvity2() {
        Intent intent = new Intent(this, jezdziec.class);
        startActivity(intent);
    }


    @Override
    public void onBackPressed() {
    }
}
