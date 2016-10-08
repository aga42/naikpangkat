package com.barethitam.naikpangkat.api;

import android.util.Log;

import com.barethitam.naikpangkat.utils.Constant;
import com.google.gson.Gson;

import retrofit2.Response;
import rx.Subscriber;

/**
 * Created by LTE on 10/8/2016.
 */
public abstract class BaseResponse<T> extends Subscriber<Response<T>>{

    @Override
    public void onError(Throwable e) {
        //String sd = String.valueOf(e);
        onError();
    }

    @Override
    public void onNext(Response<T> response) {
        String sd = String.valueOf(new Gson().toJson(response.body()));
        Log.d("","");
        if (response.code() == Constant.CODE_OK) {
            doOnNext(response.body());
        }else {
            onError();
        }
    }

    /*@Override
    public void onNext(Response<T> response) {
        if (response.code() == Constant.CODE_EMPTY) {

        } else if (response.code() == Constant.CODE_OK) {
            doOnNext(response);
        } else if (response.code() == Constant.CODE_TOKEN_EXPIRED) {
            doRestart();
        }
    }*/

    //public abstract void doRestart();
    public abstract void onError();

    public abstract void doOnNext(T t);

    /*@Override
    public void getAccessToken(AccessToken accessToken) {
        //CLog.e("getAccessToken " + accessToken.token);
        PreferenceManager.getDefaultSharedPreferences(App.getInstance().getApplicationContext())
                .edit()
                .putString(Constant.ACCESS_TOKEN_PREF, accessToken.token)
                .apply();

        onExpire();
    }*/

}