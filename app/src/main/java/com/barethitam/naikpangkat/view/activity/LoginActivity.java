package com.barethitam.naikpangkat.view.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.content.IntentCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.barethitam.naikpangkat.App;
import com.barethitam.naikpangkat.MainActivity;
import com.barethitam.naikpangkat.R;
import com.barethitam.naikpangkat.model.LoginModel;
import com.barethitam.naikpangkat.presenter.implementation.AccountImpl;
import com.barethitam.naikpangkat.utils.Constant;
import com.barethitam.naikpangkat.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import com.barethitam.naikpangkat.view.interfaces.AccountInterface;
import com.crashlytics.android.Crashlytics;

import java.util.HashMap;

import io.fabric.sdk.android.Fabric;

/**
 * Created by LTE on 10/6/2016.
 */
public class LoginActivity extends AppCompatActivity implements AccountInterface.LoginView {

    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.edt_id)
    TextInputEditText edtId;
    @BindView(R.id.edt_pass)
    TextInputEditText edtPass;
    @BindView(R.id.img_pass)
    ImageView imgPass;
    @BindView(R.id.txt_help)
    TextView txtHelp;
    @BindView(R.id.rel_masuk)
    RelativeLayout relMasuk;
    @BindView(R.id.txt_masuk)
    TextView txtMasuk;

    AccountImpl.LoginPresenterImplementation loginPresenterImplementation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        initView();
    }

    private void initView(){
        txtMasuk.setTypeface(Utils.getMyTypeface(LoginActivity.this));
        txtHelp.setTypeface(Utils.getMyTypeface(LoginActivity.this));
        edtId.setTypeface(Utils.getMyTypeface(LoginActivity.this));
        edtPass.setTypeface(Utils.getMyTypeface(LoginActivity.this));

        if(null!=App.getFromPreference(Constant.NO_PERS)&&!App.getFromPreference(Constant.NO_PERS).equals(Constant.BLANK)){
            Intent i = new Intent(LoginActivity.this, MainActivity.class);
            ComponentName cn = i.getComponent();
            Intent mainIntent = IntentCompat.makeRestartActivityTask(cn);
            startActivity(mainIntent);
            finish();
        }
    }

    @OnClick({R.id.img_pass, R.id.rel_masuk, R.id.txt_help})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_pass:
                if (imgPass.isSelected()) {
                    imgPass.setSelected(false);
                    edtPass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                } else {
                    imgPass.setSelected(true);
                    edtPass.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                }
                break;
            case R.id.rel_masuk:
                //startActivity(new Intent(LoginActivity.this, MainActivity.class));

                String noID = edtId.getText().toString();
                String pass = edtPass.getText().toString();

                if(noID.length()>0&&pass.length()>0){
                    HashMap<String, Object> postLoginModel = new HashMap<>();
                    postLoginModel.put("no_pers", noID);
                    postLoginModel.put("password", pass);

                    loginPresenterImplementation = new AccountImpl.LoginPresenterImplementation();
                    loginPresenterImplementation.onAttachView(this);
                    loginPresenterImplementation.login(Constant.URL_LOGIN, postLoginModel);

                }else{
                    Utils.showToast(LoginActivity.this, "Masukkan No ID Anggota dan Password..");
                }


                break;
            case R.id.txt_help:
                String number = "0213456838";
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" +number));
                startActivity(intent);
                break;
        }
    }

    @Override
    public void login(LoginModel loginModel) {
        Intent i = new Intent(LoginActivity.this, MainActivity.class);
        ComponentName cn = i.getComponent();
        Intent mainIntent = IntentCompat.makeRestartActivityTask(cn);
        App.saveToPreference(Constant.NO_ID_ANGGOTA, String.valueOf(loginModel.getData().getId_personel()));
        App.saveToPreference(Constant.NO_PERS, loginModel.getData().getNo_pers());
        startActivity(mainIntent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(null==loginPresenterImplementation){
            //do nothing
        }else{
            loginPresenterImplementation.onDetachView();
        }
    }

    @Override
    public void onFailed(String message) {
        Utils.showToast(LoginActivity.this, message);
    }
}
