package wrss.donotgetlost;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;


public class PopActivity extends Activity {


    private Button skip;
    private Button exit;

    private Globals g=Globals.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);
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
        Intent intent = new Intent(this, Riddle.class);
        startActivity(intent);
    }
}
