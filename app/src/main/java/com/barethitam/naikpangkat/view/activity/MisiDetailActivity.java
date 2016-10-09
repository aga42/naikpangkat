package com.barethitam.naikpangkat.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.barethitam.naikpangkat.App;
import com.barethitam.naikpangkat.R;
import com.barethitam.naikpangkat.model.JalankanMisiModel;
import com.barethitam.naikpangkat.model.MisiDetailModel;
import com.barethitam.naikpangkat.presenter.implementation.MisiPreImpl;
import com.barethitam.naikpangkat.utils.Constant;
import com.barethitam.naikpangkat.utils.Utils;
import com.barethitam.naikpangkat.view.interfaces.MisiInterface;
import com.barethitam.naikpangkat.view.widget.HeaderView;
import com.barethitam.naikpangkat.view.widget.JustifyTextView;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by LTE on 10/6/2016.
 */
public class MisiDetailActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener, MisiInterface.MisiDetailView, MisiInterface.JalankanMisiView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_header_view)
    HeaderView toolbarHeaderView;

    @BindView(R.id.float_header_view)
    HeaderView floatHeaderView;
    @BindView(R.id.appBar)
    AppBarLayout appBar;
    @BindView(R.id.event_image)
    ImageView eventImage;
    @BindView(R.id.back_button)
    ImageButton backButton;
    @BindView(R.id.txt_exp)
    TextView txtExp;
    @BindView(R.id.txt_info)
    JustifyTextView txtInfo;
    @BindView(R.id.txt_jalankan)
    TextView txtJalankan;
    @BindView(R.id.txt_misi)
    TextView txtMisi;
    @BindView(R.id.btn_jalankanmisi)
    RelativeLayout btnJalankanmisi;
    private boolean isHideToolbarView = false;

    MisiPreImpl.MisiDetailPresenterImplementation misiDetailPresenterImplementation;
    MisiPreImpl.JalankanMisiPresenterImplementation jalankanMisiPresenterImplementation;
    String misiId = Constant.BLANK;
    boolean isFromMisi = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_misi_detail);
        ButterKnife.bind(this);

        initView();

    }

    private void initView() {
        appBar.addOnOffsetChangedListener(this);

        txtJalankan.setTypeface(Utils.getMyTypeface(MisiDetailActivity.this));
        txtExp.setTypeface(Utils.getMyTypeface(MisiDetailActivity.this));
        txtMisi.setTypeface(Utils.getMyTypeface(MisiDetailActivity.this));
        txtInfo.setTypeface(Utils.getMyTypeface(MisiDetailActivity.this));

        Intent a = getIntent();
        misiId = a.getStringExtra(Constant.MISI_ID);
        isFromMisi = a.getBooleanExtra(Constant.IS_FROM_MISI, false);

        if (!isFromMisi) {
            btnJalankanmisi.setVisibility(View.GONE);
        }

        HashMap<String, Object> postMisiDetailModel = new HashMap<>();
        postMisiDetailModel.put("id_misi", misiId);

        misiDetailPresenterImplementation = new MisiPreImpl.MisiDetailPresenterImplementation();
        misiDetailPresenterImplementation.onAttachView(this);
        misiDetailPresenterImplementation.misiDetail(Constant.URL_MISI_DETAIL, postMisiDetailModel);
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        int maxScroll = appBarLayout.getTotalScrollRange();
        float percentage = (float) Math.abs(verticalOffset) / (float) maxScroll;
        if (percentage == 1f && isHideToolbarView) {
            toolbarHeaderView.setVisibility(View.VISIBLE);
            isHideToolbarView = !isHideToolbarView;

        } else if (percentage < 1f && !isHideToolbarView) {
            toolbarHeaderView.setVisibility(View.GONE);
            isHideToolbarView = !isHideToolbarView;
        }
    }

    @OnClick({R.id.back_button, R.id.btn_jalankanmisi})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_button:
                finish();
                break;
            case R.id.btn_jalankanmisi:

                jalankanMisiPresenterImplementation = new MisiPreImpl.JalankanMisiPresenterImplementation();
                jalankanMisiPresenterImplementation.onAttachView(this);

                HashMap<String, Object> postProfilModel = new HashMap<>();
                postProfilModel.put("id_personel", App.getFromPreference(Constant.NO_ID_ANGGOTA));
                postProfilModel.put("id_misi", misiId);

                jalankanMisiPresenterImplementation.jalankanMisi(Constant.URL_JALANKAN_MISI, postProfilModel);

                break;
        }
    }

    @Override
    public void getMisiDetail(MisiDetailModel misiDetailModel) {
        toolbarHeaderView.bindTo(misiDetailModel.getData().getPam()
                , String.valueOf(misiDetailModel.getData().getExp()) + " Exp, " + misiDetailModel.getData().getTahun());
        floatHeaderView.bindTo(misiDetailModel.getData().getPam()
                , String.valueOf(misiDetailModel.getData().getExp()) + " Exp, " + misiDetailModel.getData().getTahun());

        //txtInfo.setText(misiDetailModel.getData().getDeskripsi());
    }

    @Override
    public void onFailed(String message) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null == misiDetailPresenterImplementation) {
            //do nothing
        } else {
            misiDetailPresenterImplementation.onDetachView();
        }

        if (null == jalankanMisiPresenterImplementation) {
            //do nothing
        } else {
            jalankanMisiPresenterImplementation.onDetachView();
        }
    }

    @Override
    public void postJalankanMisi(JalankanMisiModel jalankanMisiModel) {
        Utils.showToast(MisiDetailActivity.this, jalankanMisiModel.getMsg());

        finish();
    }
}
