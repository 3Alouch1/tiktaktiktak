package com.dinosoftlabs.tictic;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.dinosoftlabs.tictic.Main_Menu.MainMenuActivity;
import com.dinosoftlabs.tictic.SimpleClasses.Variables;

public class Splash_A extends AppCompatActivity {


    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);

        Variables.sharedPreferences=getSharedPreferences(Variables.pref_name,MODE_PRIVATE);

        countDownTimer= new CountDownTimer(2500, 500) {

            public void onTick(long millisUntilFinished) {

            }
            public void onFinish() {

                    startActivity(new Intent(Splash_A.this, MainMenuActivity.class));
                    overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                    finish();

            }
        }.start();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        countDownTimer.cancel();
    }

}
