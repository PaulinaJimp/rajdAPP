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
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;


public class Riddle extends AppCompatActivity {

    private Globals g=Globals.getInstance();
    private Button button;
    private Button skipButton;

    private String password1;
    private String password2;
    private String password3;
    private EditText answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        password1 = getString(R.string.bocian_password1);
        password2 = getString(R.string.bocian_password2);
        password3 = getString(R.string.bocian_password3);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riddle);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer = (EditText) findViewById(R.id.input);

                if(answer.getText().toString().trim().equalsIgnoreCase(password1) ||answer.getText().toString().trim().equalsIgnoreCase(password2)||answer.getText().toString().trim().equalsIgnoreCase(password3))
                {
                    openActvity2();
                }
                else
                {
                    Toast toast = new Toast(getApplicationContext());
                    toast.setGravity(Gravity.TOP,0,0);
                    toast.makeText(Riddle.this, " zla opwiedź ",toast.LENGTH_SHORT).show();
                    answer.setText("");
                }
            }
        });

        skipButton=(Button)findViewById(R.id.skipButton);
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), PopActivity.class);
                startActivity(i);
            }
        });

    }


    public void openActvity2() {
        Intent intent = new Intent(this, Finish.class);
        startActivity(intent);
    }




    @Override
    public void onBackPressed() { }
}
