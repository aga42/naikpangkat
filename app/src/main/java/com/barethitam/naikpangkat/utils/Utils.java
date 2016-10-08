package com.barethitam.naikpangkat.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.widget.Toast;

/**
 * Created by LTE on 10/6/2016.
 */
public class Utils {

    public static Typeface typefaceFutura;

    public static Typeface getMyTypeface(Context c){
        if(null == typefaceFutura){
            typefaceFutura = Typeface.createFromAsset(c.getAssets(),
                    "fonts/FuturaStd-Medium_1.otf");
        }

        return typefaceFutura;
    }

    public static void showToast(Activity a, String message) {
        Toast.makeText(a, message, Toast.LENGTH_SHORT).show();
    }

}
