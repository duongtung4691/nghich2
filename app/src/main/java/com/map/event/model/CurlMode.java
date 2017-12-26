package com.map.event.model;

import android.util.Log;

/**
 * Created by MacBookPro on 12/13/16.
 */

public class CurlMode {
    static {
        System.loadLibrary("native-lib");
    }

    private static CurlMode instanceCurl;

    public static CurlMode getCurl() {
        if (instanceCurl == null)
            instanceCurl = new CurlMode();
        return instanceCurl;
    }

    //    private static native byte[] stringFromJNI(String url);
    private native String connectFacebook();

    private native String login(String[] keys, String[] values);

    private native String getEvent(String[] keys, String[] values);

    private native void setToken(String token);

    private native String getCategories();

    public String connectFacebookAPI() {
        String[] keys = new String[]{"code"};
        String response = connectFacebook();
        Log.i("", "connectFacebookAPI: " + response);
        String contentString = response == null ? null : response;
        return contentString;
    }

    public String login(String[] values) {
        String[] keys = new String[]{"email", "password"};
        String response = login(keys, values);
        String contentString = response == null ? null : response;
        return contentString;
    }

    public String listEvent(String[] values) {
        String[] keys = new String[]{"location", "distance"};
        String response = getEvent(keys,values);
        String contentString = response == null ? null : response;
        return contentString;
    }

    public CurlMode setTokenMode(String token) {
        setToken(token);
        return this;
    }

    public String getCategoriesApi() {
        return getCategories();
    }
}
