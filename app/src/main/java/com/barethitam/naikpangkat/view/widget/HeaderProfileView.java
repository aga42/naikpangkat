package com.barethitam.naikpangkat.view.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

import com.barethitam.naikpangkat.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LTE on 10/8/2016.
 */
public class HeaderProfileView extends HeaderView {

    @BindView(R.id.txt_misi)
    TextView name;

    public HeaderProfileView(Context context) {
        super(context);
    }

    public HeaderProfileView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HeaderProfileView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public HeaderProfileView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override
    public void bindView() {
        ButterKnife.bind(HeaderProfileView.this);
    }

    public void bindTo(String userName) {
        this.name.setText(userName);
    }

    public void setTextSize(float size) {
        name.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
    }
}
