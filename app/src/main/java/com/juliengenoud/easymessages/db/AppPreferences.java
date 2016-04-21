package com.juliengenoud.easymessages.db;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Author : juliengenoud
 * 21/04/16
 **/
public class AppPreferences  {
    public static final String KEY_COLOR = "key_color";
    public static final String KEY_NAME = "key_name";
    public static final String KEY_SURNAME = "key_surname";

    private static final String APP_SHARED_PREFS = AppPreferences.class.getSimpleName(); //  Name of the file -.xml
    private SharedPreferences _sharedPrefs;
    private SharedPreferences.Editor _prefsEditor;

    public AppPreferences(Context context) {
        this._sharedPrefs = context.getSharedPreferences(APP_SHARED_PREFS, Activity.MODE_PRIVATE);
        this._prefsEditor = _sharedPrefs.edit();
    }

    public int getColor() {
        return _sharedPrefs.getInt(KEY_COLOR, -65409);
    }
    public String getName() {
        return _sharedPrefs.getString(KEY_NAME, "");
    }
    public String getSurname() {
        return _sharedPrefs.getString(KEY_SURNAME, "");
    }

    public void saveColor(int color) {
        _prefsEditor.putInt(KEY_COLOR, color);
        _prefsEditor.commit();
    }

    public void setName(String name) {
        _prefsEditor.putString(KEY_NAME, name);
        _prefsEditor.commit();
    }

    public void setSurname(String name) {
        _prefsEditor.putString(KEY_SURNAME, name);
        _prefsEditor.commit();
    }
}