package com.handtruth.discounts.SignIN;

public class Response {
    private int code;

    private String message;

    Response(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getError() {
        return message;
    }

}
