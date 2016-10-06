package com.barethitam.naikpangkat.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.barethitam.naikpangkat.R;

import butterknife.ButterKnife;

/**
 * Created by LTE on 10/6/2016.
 */
public class MisiFragment extends Fragment {

    private static MisiFragment instance;

    public static MisiFragment getInstance(Bundle bundle) {
        if (null == instance) {
            instance = new MisiFragment();
            instance.setArguments(bundle);
        }else{
            instance.getArguments().putAll(bundle);
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_misi, null);
        ButterKnife.bind(this, v);

        initView();

        return v;
    }

    private void initView(){

    }
}
