package com.barethitam.naikpangkat.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;

import com.barethitam.naikpangkat.R;
import com.barethitam.naikpangkat.view.widget.HeaderView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by LTE on 10/6/2016.
 */
public class MisiDetailActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.btn_jalankanmisi)
    RelativeLayout btnJalankanmisi;
    @BindView(R.id.toolbar_header_view)
    HeaderView toolbarHeaderView;

    @BindView(R.id.float_header_view)
    HeaderView floatHeaderView;
    @BindView(R.id.appBar)
    AppBarLayout appBar;
    private boolean isHideToolbarView = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_misi_detail);
        ButterKnife.bind(this);

        appBar.addOnOffsetChangedListener(this);

        toolbarHeaderView.bindTo("Misi Pertama"
                , "3000 Exp" + ", " + "21 Mei 2016");
        floatHeaderView.bindTo("Misi Pertama"
                , "3000 Exp" + "\n"
                        + "21 Mei 2016");

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

    @OnClick(R.id.btn_jalankanmisi)
    public void onClick() {
    }
}
