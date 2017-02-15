package com.example.capsula.sharedpreferencesexample;

import android.content.Context;
import android.content.SharedPreferences;



/**
 * Created by miguel on 06/02/17.
 */

public class SessionManager {

    static final String PREFERENCE_NAME = "NamePreference";

    static int PRIVATE_MODE = 0;

    private static final String TOKEN = "token";

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private Context context;

    public SessionManager(Context context) {
        this.context = context;
        preferences = this.context.getSharedPreferences(PREFERENCE_NAME, PRIVATE_MODE);
        editor = preferences.edit();
    }

    public  void saveToken(String token){
        editor.putString(TOKEN,token);
        editor.commit();
    }

    public String getToken(){
        return preferences.getString(TOKEN , null);
    }

    public void closeSession(){
        editor.putString(TOKEN, null);
        editor.commit();
    }



}
