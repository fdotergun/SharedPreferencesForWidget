package com.example.ferhat.parklotist;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;


/**
 * Created by ferhat on 5/19/2017.
 */

public class WidgetPref {

    public static final String PREFS_NAME = "PARKLOT";

    public final static String KEY_TWO="com.example.ferhat.parklotist.key_two";
    public final static String KEY_ONE="com.example.ferhat.parklotist.key_one";

    public static SharedPreferences WidgetPref(Context context) {
        SharedPreferences pref = context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);
        return pref;
    }

    //setters doing the Counting
    public static void setPrefFirstCount(Context context,String key, int value){
        value++;
        value=value%4;
        if(value==0){
            value=1;
        }
        if(key!=null){
            SharedPreferences.Editor editor= WidgetPref(context).edit();
            editor.remove(key);
            editor.putInt(key,value);
            editor.commit();
        }
    }

    //setters doing the Counting
    public static void setPrefSecondCount(Context context,String key,int value){
        value++;
        value=value%10;
        if(value==0){
            value=1;
        }
        if(key!=null){
            SharedPreferences.Editor editor= WidgetPref(context).edit();
            editor.remove(key);
            editor.putInt(key,value);
            editor.commit();
        }
    }

    //getters contains data
    public static int getPrefFirstCount(Context context,String key){
        SharedPreferences pref= WidgetPref(context);
        int value=1;
            if(pref.contains(key)){
                value=pref.getInt(key,0);
            }else{
                value=1;
            }
        return value;
    }

    //getters contains data
    public static int getPrefSecondCount(Context context,String key){
        SharedPreferences pref= WidgetPref(context);
        int value=1;
        if(pref.contains(key)){
            value=pref.getInt(key,0);
        }else{
            value=1;
        }
        return value;
    }
    
}
