package com.handtruth.discounts.simpleRequest;

import android.util.JsonReader;
import android.util.Log;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Request {
    public static JsonReader request(String url){
        HttpURLConnection connection = null;

        // этот циел нужен для того, чтоб в том случае, если ловится ошибка timeout
        // - программа не закрывается, а совершает повторное подключение
        while (true) {
            try {
                connection = (HttpURLConnection) new URL(url).openConnection();

                connection.setRequestMethod("GET");
                connection.setUseCaches(false);
                connection.setConnectTimeout(250);
                connection.setReadTimeout(250);
                connection.connect();


                if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                    return new JsonReader(new InputStreamReader(connection.getInputStream()));
                } else {
                    Log.d("Discount", "Fail: " + connection.getResponseCode() + ", " + connection.getResponseMessage());
                }
                break;
            } catch (Exception cause) {
                Log.d("Discount", cause.getMessage());
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
            }
        }
        return null;
    }
}
