package com.barethitam.naikpangkat.view.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.barethitam.naikpangkat.MainActivity;
import com.barethitam.naikpangkat.R;
import com.barethitam.naikpangkat.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

/**
 * Created by LTE on 10/6/2016.
 */
public class LoginActivity extends AppCompatActivity {

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
    }

    @OnClick({R.id.img_pass, R.id.rel_masuk, R.id.txt_help})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_pass:
                break;
            case R.id.rel_masuk:
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                break;
            case R.id.txt_help:
                String number = "0213456838";
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" +number));
                startActivity(intent);
                break;
        }
    }
}
