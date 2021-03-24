package com.example.notificationtest.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class AppGlobal {
    public static String token = "";
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    public AppGlobal() {
        
    }

    public void saveUserInfo(Context context, String token){
        this.token = token;
        pref = PreferenceManager.getDefaultSharedPreferences(context);
        editor = pref.edit();
        editor.putString("token",token);
        editor.apply();
    }

    public String getToken() {
        token = pref.getString("token","");
        return token;
    }
}
