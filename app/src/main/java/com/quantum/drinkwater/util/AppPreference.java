package com.quantum.drinkwater.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.quantum.drinkwater.DashboardActivity;

import java.util.Calendar;

public class AppPreference {

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public static final String SELECTED_WEIGHT = "selected_weight";
    public static final String WATER_NEED = "water_need";
    private Context context;
    public AppPreference(Context context) {
        setPreferences(PreferenceManager.getDefaultSharedPreferences(context));
        editor = getPreferences().edit();
        this.context = context;
    }

    private SharedPreferences getPreferences() {
        return preferences;
    }

    private void setPreferences(SharedPreferences preferences) {
        this.preferences = preferences;
    }

    public int getSelectedWeight() {
        return getPreferences().getInt(SELECTED_WEIGHT, 0);
    }

    public void setSelectedWeight( int newValue) {
        editor.putInt(SELECTED_WEIGHT, newValue);
        editor.commit();
    }



    public int getWaterNeed() {
        return getPreferences().getInt(WATER_NEED, 200);
    }

    public void setWaterNeed( int newValue) {
        editor.putInt(WATER_NEED, newValue);
        editor.commit();
    }

}

