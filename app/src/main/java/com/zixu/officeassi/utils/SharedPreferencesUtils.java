package com.zixu.officeassi.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * sp存储工具类
 */
public class SharedPreferencesUtils {
    private static String CONFIG = "config"; //sp存储的名字
    private static SharedPreferences sharedPreferences;//sp对象
    private SharedPreferences.Editor editor;// editor

    public SharedPreferencesUtils(Context context, String name, int mode) {
        sharedPreferences = context.getSharedPreferences(name, mode);
        editor = sharedPreferences.edit();
    }

    public void putData(String name, String value) {
        editor.putString(name, value);
        editor.commit();
    }

    public void putData(String name, boolean value) {
        editor.putBoolean(name, value);
        editor.commit();
    }


    public static void saveStringData(Context context, String key, String value) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(CONFIG, Context.MODE_PRIVATE);
        }
        sharedPreferences.edit().putString(key, value).commit();
    }

    public static String getStringData(Context context, String key, String defValue) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(CONFIG, Context.MODE_PRIVATE);
        }
        return sharedPreferences.getString(key, defValue);
    }

    /**
     *
     * @param context
     * @param key
     */
    public static boolean getLoadCovering(Context context, String key, boolean value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("tokenSharedPref", Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, value);
    }

    /**
     *
     * @param context
     * @param key
     */


    public static void setLoadCovering(Context context, String key, boolean value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("tokenSharedPref", Context.MODE_PRIVATE);
        sharedPreferences.edit().putBoolean(key, value).commit();
    }

    public static void setPage(Context context, String key, int value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("tokenSharedPref", Context.MODE_PRIVATE);
        sharedPreferences.edit().putInt(key, value).commit();
    }

    public static int getPage(Context context, String key, int value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("tokenSharedPref", Context.MODE_PRIVATE);
        return sharedPreferences.getInt(key, value);
    }

    public static void setTime(Context context, String key, long value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("tokenSharedPref", Context.MODE_PRIVATE);
        sharedPreferences.edit().putLong(key, value).commit();
    }

    public static long getTime(Context context, String key, long value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("tokenSharedPref", Context.MODE_PRIVATE);
        return sharedPreferences.getLong(key, value);
    }

    public static void saveBooleanData(Context context, String key, Boolean value) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(CONFIG, Context.MODE_PRIVATE);
        }
        sharedPreferences.edit().putBoolean(key, value).commit();
    }

    public static Boolean getBooleanData(Context context, String key, Boolean defValue) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(CONFIG, Context.MODE_PRIVATE);
        }
        return sharedPreferences.getBoolean(key, defValue);
    }

    /**
     * 移出指定的sp
     * @param context
     * @param key
     */
    public static void clearSp(Context context,String key){
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(CONFIG, Context.MODE_PRIVATE);
        }
        sharedPreferences.edit().remove(key).commit();
    }
}
