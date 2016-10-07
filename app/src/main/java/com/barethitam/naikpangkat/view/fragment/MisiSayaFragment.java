package com.barethitam.naikpangkat.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.barethitam.naikpangkat.R;
import com.barethitam.naikpangkat.view.adapter.MisiSayaAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LTE on 10/6/2016.
 */
public class MisiSayaFragment extends Fragment implements MisiSayaAdapter.ItemSelectedListener {

    private static MisiSayaFragment instance;
    MisiSayaAdapter adapter;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;

    public static MisiSayaFragment getInstance(Bundle bundle) {
        if (null == instance) {
            instance = new MisiSayaFragment();
            instance.setArguments(bundle);
        } else {
            instance.getArguments().putAll(bundle);
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_misi_saya, null);
        ButterKnife.bind(this, v);

        initView();

        return v;
    }

    private void initView() {
        adapter = new MisiSayaAdapter(getContext(), this);
        recycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycleView.setAdapter(adapter);
    }

    @Override
    public void onItemSelected() {

    }
}
