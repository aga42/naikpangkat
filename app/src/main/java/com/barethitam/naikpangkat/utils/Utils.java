package com.barethitam.naikpangkat.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.content.IntentCompat;
import android.widget.Toast;

import com.barethitam.naikpangkat.App;
import com.barethitam.naikpangkat.MainActivity;
import com.barethitam.naikpangkat.R;
import com.barethitam.naikpangkat.view.activity.LoginActivity;

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

    private static ProgressDialog progressDialog;

    private static ProgressDialog getMyProgressDialog(Activity a) {
        //if(progressDialog==null){
        progressDialog = new ProgressDialog(a);
        progressDialog.setMessage("Menunggu..");
        //}

        return progressDialog;
    }

    public static void showMyProgressDialog(Activity a) {
        if (!getMyProgressDialog(a).isShowing())
            getMyProgressDialog(a).show();
    }

    public static void dismissMyProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing())
            progressDialog.dismiss();
    }

    static AlertDialog dialog;
    public static void initDialogInfo(final Activity activity, String message, final int action){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setCancelable(true).setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int is) {
                if(action==Constant.ACTION_LOGOUT){
                    Intent i = new Intent(activity, LoginActivity.class);
                    ComponentName cn = i.getComponent();
                    Intent mainIntent = IntentCompat.makeRestartActivityTask(cn);
                    App.getSharedPreferences().edit().clear();
                    activity.startActivity(mainIntent);
                    activity.finish();
                }else if(action==Constant.ACTION_EXIT){
                    activity.finish();
                }

                dialog.dismiss();
            }
        }).setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialog.dismiss();
            }
        }).setMessage(message);
        dialog = builder.create();
        dialog.show();
    }

}
