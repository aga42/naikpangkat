package com.barethitam.naikpangkat;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;

/**
 * Created by LTE on 10/8/2016.
 */
public class App extends Application {

    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        instance = this;
    }

    public static void saveToPreference(final String key, final String value) {
        getSharedPreferences().edit()
                .putString(key, value)
                .commit();
    }

    public static SharedPreferences getSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(instance);
    }

    public static String getFromPreference(final String key) {
        return PreferenceManager.getDefaultSharedPreferences(instance).getString(key, "");
    }
}
