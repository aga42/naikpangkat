package com.barethitam.naikpangkat.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by LTE on 10/6/2016.
 */
public class MisiSayaFragment extends Fragment {

    private static MisiSayaFragment instance;

    public static MisiSayaFragment getInstance(Bundle bundle) {
        if (null == instance) {
            instance = new MisiSayaFragment();
            instance.setArguments(bundle);
        }else{
            instance.getArguments().putAll(bundle);
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
