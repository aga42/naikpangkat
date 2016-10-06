package com.barethitam.naikpangkat.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.barethitam.naikpangkat.MainActivity;
import com.barethitam.naikpangkat.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.img_pass, R.id.rel_masuk})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_pass:
                break;
            case R.id.rel_masuk:
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                break;
        }
    }
}
