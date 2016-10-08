package com.barethitam.naikpangkat.view.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.barethitam.naikpangkat.R;
import com.barethitam.naikpangkat.utils.Utils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LTE on 10/6/2016.
 */
public class ProfilFragment extends Fragment {


    private static ProfilFragment instance;
    @BindView(R.id.img_profile)
    ImageView imgProfile;
    @BindView(R.id.img_pangkat)
    ImageView imgPangkat;
    @BindView(R.id.progBar)
    ProgressBar progBar;
    @BindView(R.id.txt_exp)
    TextView txtExp;
    @BindView(R.id.txt_name)
    TextView txtName;
    @BindView(R.id.txt_name_pers)
    TextView txtNamePers;
    @BindView(R.id.txt_ttl)
    TextView txtTtl;
    @BindView(R.id.txt_info)
    TextView txtInfo;

    public static ProfilFragment getInstance(Bundle bundle) {
        if (null == instance) {
            instance = new ProfilFragment();
            instance.setArguments(bundle);
        } else {
            instance.getArguments().putAll(bundle);
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profil, null);
        ButterKnife.bind(this, v);

        initView();

        return v;
    }

    private void initView() {
        Glide.with(getActivity()).load(R.drawable.img_dummy_profil).asBitmap().centerCrop().into(new BitmapImageViewTarget(imgProfile) {
            @Override
            protected void setResource(Bitmap resource) {
                final RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(getActivity().getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                super.getView().setImageDrawable(circularBitmapDrawable);
            }
        });

        txtName.setTypeface(Utils.getMyTypeface(getActivity()));
        txtNamePers.setTypeface(Utils.getMyTypeface(getActivity()));
        txtExp.setTypeface(Utils.getMyTypeface(getActivity()));
        txtTtl.setTypeface(Utils.getMyTypeface(getActivity()));
        txtInfo.setTypeface(Utils.getMyTypeface(getActivity()));
    }
}
