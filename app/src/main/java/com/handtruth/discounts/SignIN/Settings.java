package com.handtruth.discounts.SignIN;

import android.content.SharedPreferences;

class Settings {

    static final String APP_PREFERENCES = "settings";
    static final String APP_PREFERENCES_LOGIN = "email";
    static final String APP_PREFERENCES_PASS = "password";
    static final String APP_PREFERENCES_ACCESSTOKEN = "accesstoken";

    static SharedPreferences settings;
}
