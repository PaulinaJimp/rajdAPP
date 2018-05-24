package wrss.donotgetlost;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import static android.os.SystemClock.sleep;

public class podpowiedz extends AppCompatActivity {


    private Button skip;
    private Button exit;

    private Globals g=Globals.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_podpowiedz);
        //myDialog = new Dialog(this);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width),(int)(height*.4));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = 100;

        getWindow().setAttributes(params);
        skip = (Button) findViewById(R.id.pop_skipq_button);
        //exit = (Button) findViewById(R.id.pop_exit_button);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                g.setSkips();
                openActvity2();

            }
        });
//        @Override
//        public void onClick(View view) {
//
//        }
//    });
//        exit.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//
//        }
//    });     skip.setOnClickListener(new View.OnClickListener() {

    }
    public void openActvity2() {
        Intent intent = new Intent(this,Finish.class);
        int currPage= g.getCurrId();
        switch (currPage){

            case 1:
            {
                intent = new Intent(this,aragorn1.class);
                break;
            }
            case 11:
            {
                intent = new Intent(this,aragorn2.class);
                break;
            }
            case 111:
            {
                intent = new Intent(this,aragorn3.class);
                break;
            }
            case 2: {
                intent = new Intent(this,system1.class);
                break;
            }
            case 22: {
                intent = new Intent(this,system2.class);
                break;
            }
            case 222: {
                intent = new Intent(this, system3.class);
                break;
            }
            case 3: {
                intent = new Intent(this, koszulka1.class);
                break;
            }
            case 33: {
                intent = new Intent(this, koszulka2.class);
                break;
            }
            case 333: {
                intent = new Intent(this, koszulka3.class);
                break;
            }

            case 4: {
                intent = new Intent(this, czas1.class);
                break;
            }
            case 44: {
                intent = new Intent(this, czas2.class);
                break;
            }
            case 444: {
                intent = new Intent(this, czas3.class);
                break;
            }
            case 5: {
                intent = new Intent(this, jezdziec1.class);
                break;
            }
            case 55: {
                intent = new Intent(this, jezdziec2.class);
                break;
            }
            case 555: {
                intent = new Intent(this, jezdziec3.class);
                break;
            }
            case 6:
            {
                intent = new Intent(this,zapalki1.class);
                break;
            }
            case 66:
            {
                intent = new Intent(this,zapalki2.class);
                break;
            }
            case 661:
            {
                intent = new Intent(this,zapalki3.class);
                break;
            }
            case 7: {
                intent = new Intent(this, rebus1.class);
                break;
            }
            case 77: {
                intent = new Intent(this, rebus2.class);
                break;
            }

        }

        startActivity(intent);
    }
}