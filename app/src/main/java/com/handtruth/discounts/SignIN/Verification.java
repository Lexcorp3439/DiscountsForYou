package com.handtruth.discounts.SignIN;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import com.handtruth.discounts.retrofit.RetrofitClient;
import com.handtruth.discounts.retrofit.ServiceAPI;
import com.handtruth.discounts.utils.InternetConnection;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;

import static com.handtruth.discounts.SignIN.Settings.APP_PREFERENCES_LOGIN;
import static com.handtruth.discounts.SignIN.Settings.APP_PREFERENCES_PASS;
import static com.handtruth.discounts.SignIN.Settings.APP_PREFERENCES_ACCESSTOKEN;
import static com.handtruth.discounts.SignIN.Settings.settings;

class Verification {
    static Response verification(String email, String pass, Context context) {
        if (InternetConnection.checkConnection(context)) {
            Map<String, String> data = new HashMap<>();
            data.put("login", email);
            data.put("password", pass);

            try {
                ServiceAPI serviceAPI = RetrofitClient.getServiceAPI();
                Call<Map<String, String>> call = serviceAPI.accountAccess(data);
                Map<String, String> message = call.execute().body();
                int code = Integer.valueOf(message.get("code"));
                if (code == 5) {
                    @SuppressLint("CommitPrefEdits")
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putString(APP_PREFERENCES_LOGIN, email);
                    editor.putString(APP_PREFERENCES_PASS, pass);
                    editor.putString(APP_PREFERENCES_ACCESSTOKEN, message.get("token"));
                }
                return new Response(code, message.get("message"));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new Response(0,"No internet connection");
    }

    static Response verification(){
        return new Response(0,"No internet connection");
    }
}
