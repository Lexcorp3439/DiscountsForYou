package com.handtruth.discounts.simpleRequest;

import android.os.AsyncTask;
import android.util.JsonReader;

public class Access extends AsyncTask<Void, Void, Boolean> {
    private String request;
    private final String email;
    private final String pass;

    public Access(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        StringBuilder str = new StringBuilder();
        str.append(request).append(email).append(pass);
        JsonReader jsonReader = Request.request(str.toString());
        onPostExecute(true);
        return null;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
    }
}
