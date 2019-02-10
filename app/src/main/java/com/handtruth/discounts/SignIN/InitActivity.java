package com.handtruth.discounts.SignIN;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.handtruth.discounts.R;
import com.handtruth.discounts.activity.MainActivity;

import static com.handtruth.discounts.SignIN.Settings.APP_PREFERENCES;
import static com.handtruth.discounts.SignIN.Settings.APP_PREFERENCES_LOGIN;
import static com.handtruth.discounts.SignIN.Settings.APP_PREFERENCES_PASS;
import static com.handtruth.discounts.SignIN.Settings.settings;
import static com.handtruth.discounts.SignIN.Verification.verification;

public class InitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);

        settings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        if (settings.contains(APP_PREFERENCES_LOGIN)
                && settings.contains(APP_PREFERENCES_PASS)){
            int code = verification(settings.getString(APP_PREFERENCES_LOGIN, ""),
                    settings.getString(APP_PREFERENCES_PASS, ""), getApplicationContext()).getCode();

            if (code == 5){
                access();
            } else if (code == 0){
                noConnection();
            } else {
                notAccess();
            }
        } else {
            notAccess();
        }

    }

    private void notAccess(){
        Log.e("InitActivity", "Not Access");
        Intent intent = new Intent(InitActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void access(){
        Log.e("InitActivity", "Access");
        Intent intent = new Intent(InitActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void noConnection(){
        //TODO
        Log.e("InitActivity", "No internet connection");
        Intent intent = new Intent(InitActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
