package com.example.tugasutsgenap2022akbif_110119011;

import android.content.Context;
import android.content.SharedPreferences;
//Identitas
//Nama  : Reihan Wiyanda
//Nim   : 10119011
//Kelas : IF-1
public class LauncherManager {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    private static String PREF_NAME="LauncherManager";
    private static String IS_FIRST_TIME = "isFirst";

    public LauncherManager(Context context) {

        sharedPreferences = context.getSharedPreferences(PREF_NAME, 0);
        editor = sharedPreferences.edit();
    }

    public LauncherManager(SharedPreferences.Editor editor) {
        this.editor = editor;
    }

    public void setFirstLunch(boolean isFirst){
        editor.putBoolean(IS_FIRST_TIME,isFirst);
        editor.commit();
    }

    public boolean isFirstTime(){
        return sharedPreferences.getBoolean(IS_FIRST_TIME,true);
    }
}
