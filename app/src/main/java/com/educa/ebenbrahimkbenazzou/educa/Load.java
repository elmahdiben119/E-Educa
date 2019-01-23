package com.educa.ebenbrahimkbenazzou.educa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Load extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageView img;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        img = findViewById(R.id.load);
        img.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.load));
        //Loading
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        Thread welcomeThread = new Thread() {
            @Override
            public void run() {
                try {
                    super.run();
                    sleep(3000);  //Delay of 3 seconds
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    startActivity(new Intent(Load.this, Login.class));
                    finish();
                }
            }
        };
        welcomeThread.start();
    }
}
