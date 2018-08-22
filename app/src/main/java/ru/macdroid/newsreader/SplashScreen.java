package ru.macdroid.newsreader;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SplashScreen extends AppCompatActivity {

    TextView splashSportsRu;
    private Typeface tf_light ,tf_bold, tf_semibold, tf_regular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        splashSportsRu = (TextView) findViewById(R.id.splashSportsRu);

        tf_light = Typeface.createFromAsset(getAssets(), "manrope-light.ttf");
        tf_bold = Typeface.createFromAsset(getAssets(), "manrope-bold.ttf");
        tf_semibold = Typeface.createFromAsset(getAssets(), "manrope-semibold.ttf");
        tf_regular = Typeface.createFromAsset(getAssets(), "manrope-regular.ttf");

        splashSportsRu.setTypeface(tf_light);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 5000);
    }
}
