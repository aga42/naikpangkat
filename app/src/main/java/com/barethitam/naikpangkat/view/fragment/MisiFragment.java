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

import com.barethitam.naikpangkat.R;
import com.barethitam.naikpangkat.model.MisiModel;
import com.barethitam.naikpangkat.presenter.implementation.MisiPreImpl;
import com.barethitam.naikpangkat.utils.Constant;
import com.barethitam.naikpangkat.view.activity.MisiDetailActivity;
import com.barethitam.naikpangkat.view.adapter.MisiAdapter;
import com.barethitam.naikpangkat.view.interfaces.MisiInterface;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LTE on 10/6/2016.
 */
public class MisiFragment extends Fragment implements MisiAdapter.ItemSelectedListener, MisiInterface.MisiView{

    private static MisiFragment instance;
    MisiAdapter adapter;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;

    MisiPreImpl.MisiListPresenterImplementation misiListPresenterImplementation;

    public static MisiFragment getInstance(Bundle bundle) {
        if (null == instance) {
            instance = new MisiFragment();
            instance.setArguments(bundle);
        } else {
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

    private void initView() {

        misiListPresenterImplementation = new MisiPreImpl.MisiListPresenterImplementation();
        misiListPresenterImplementation.onAttachView(this);
        misiListPresenterImplementation.misiList();

    }

    @Override
    public void onItemSelected(MisiModel.Data data) {

        Intent i = new Intent(getActivity(), MisiDetailActivity.class);
        i.putExtra(Constant.MISI_ID, String.valueOf(data.getId_misi()));
        i.putExtra(Constant.IS_FROM_MISI, true);
        getActivity().startActivityForResult(i, 0);
    }

    @Override
    public void getMisi(MisiModel misiModel) {
        adapter = new MisiAdapter(getContext(), misiModel.getData(), this);
        recycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycleView.setAdapter(adapter);
    }

    @Override
    public void onFailed(String message) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(null==misiListPresenterImplementation){
            //do nothing
        }else{
            misiListPresenterImplementation.onDetachView();
        }
    }

    public void refreshData(){
        initView();
    }
}
