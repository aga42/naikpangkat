package com.barethitam.naikpangkat.view.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.barethitam.naikpangkat.R;
import com.barethitam.naikpangkat.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LTE on 10/8/2016.
 */
public class HeaderView extends LinearLayout {

    @Nullable
    @BindView(R.id.txt_misi)
    TextView name;

    @Nullable
    @BindView(R.id.txt_exp)
    TextView lblEventLocation;

    Context context;

    public HeaderView(Context context) {
        super(context);
        this.context = context;
    }

    public HeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public HeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public HeaderView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        bindView();
    }

    public void bindView()
    {
        ButterKnife.bind(this);
    }

    public void bindTo(String eventName) {
        this.name.setText(eventName);
    }

    public void bindTo(String eventName, String location) {
        this.name.setText(eventName);
        this.lblEventLocation.setText(location);
        this.lblEventLocation.setSelected(true);

        name.setTypeface(Utils.getMyTypeface(context));
        lblEventLocation.setTypeface(Utils.getMyTypeface(context));
    }

    public void setTextSize(float size) {
        name.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
    }
}
