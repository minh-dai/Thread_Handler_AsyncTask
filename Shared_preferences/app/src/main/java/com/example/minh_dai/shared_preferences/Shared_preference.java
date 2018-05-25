package com.example.minh_dai.shared_preferences;

import android.content.Context;
import android.content.SharedPreferences;

public class Shared_preference {

    private static final String Shared_pre_name = "share_pre";
    public static Shared_preference mInstance;
    private SharedPreferences mSharedPreference;
    private static Context mContext;

    private Shared_preference() {

        //mSharedPreference = App.self().getSharedPreferences(Shared_pre_name, Context.MODE_PRIVATE);
        mSharedPreference = mContext.getSharedPreferences(Shared_pre_name, Context.MODE_PRIVATE);
    }

    public static Shared_preference getInstance(Context context){
        mContext = context;
        if (mInstance == null)
            mInstance = new Shared_preference();
        return mInstance;
    }


    public <T> T get(String key, Class<T> content){
        if (content == Integer.class){
            return (T) Integer.valueOf(mSharedPreference.getInt(key,0));
        }else if (content == Double.class){
            return (T) Float.valueOf(mSharedPreference.getFloat(key, 0.0f));
        }else if (content == Boolean.class){
            return (T) Boolean.valueOf(mSharedPreference.getBoolean(key, false));
        }else if (content == Long.class){
            return (T) Long.valueOf(mSharedPreference.getLong(key , 0));
        }else if (content == String.class){
            return (T) mSharedPreference.getString(key, "");
        }

        return null;
    }

    public <T> void put(String key, T content){

        SharedPreferences.Editor mEditor = mSharedPreference.edit();

        if (content instanceof Integer){
            mEditor.putInt(key, (Integer) content);
        }else if (content instanceof Float){
            mEditor.putFloat(key, (Float)content);
        }else if (content instanceof Boolean){
            mEditor.putBoolean(key,(Boolean) content);
        }else if (content instanceof Long){
            mEditor.putLong(key, (Long) content);
        }else if (content instanceof String){
            mEditor.putString(key, (String)content );
        }

        mEditor.apply();
    }


    public void clear(){
        mSharedPreference.edit().clear();
    }

    public void remove(String key){
        mSharedPreference.edit().remove(key);
    }
}
