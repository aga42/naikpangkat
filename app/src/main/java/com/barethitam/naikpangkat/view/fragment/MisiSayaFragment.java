package com.barethitam.naikpangkat.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.barethitam.naikpangkat.App;
import com.barethitam.naikpangkat.R;
import com.barethitam.naikpangkat.model.MisiSayaModel;
import com.barethitam.naikpangkat.presenter.implementation.MisiPreImpl;
import com.barethitam.naikpangkat.utils.Constant;
import com.barethitam.naikpangkat.view.activity.MisiDetailActivity;
import com.barethitam.naikpangkat.view.adapter.MisiSayaAdapter;
import com.barethitam.naikpangkat.view.interfaces.MisiInterface;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LTE on 10/6/2016.
 */
public class MisiSayaFragment extends Fragment implements MisiSayaAdapter.ItemSelectedListener, MisiInterface.MisiSayaView {

    private static MisiSayaFragment instance;
    MisiSayaAdapter adapter;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    MisiPreImpl.MisiSayaPresenterImplementation misiSayaPresenterImplementation;

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
        misiSayaPresenterImplementation = new MisiPreImpl.MisiSayaPresenterImplementation();
        misiSayaPresenterImplementation.onAttachView(this);
        HashMap<String, Object> postProfilModel = new HashMap<>();
        postProfilModel.put("id_personel", App.getFromPreference(Constant.NO_ID_ANGGOTA));
        misiSayaPresenterImplementation.misiSaya(Constant.URL_MISI_SAYA, postProfilModel);
    }

    @Override
    public void onItemSelected(MisiSayaModel.Data data) {
        startActivity(new Intent(getActivity(), MisiDetailActivity.class)
                .putExtra(Constant.MISI_ID, String.valueOf(data.getId_misi())).putExtra(Constant.IS_FROM_MISI, false));
    }

    @Override
    public void getMisiSaya(MisiSayaModel misiSayaModel) {
        adapter = new MisiSayaAdapter(getContext(), misiSayaModel.getData(), this);
        recycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycleView.setAdapter(adapter);
    }

    @Override
    public void onFailed(String message) {

    }

    public void refreshData(){
        initView();
    }
}
