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

import com.barethitam.naikpangkat.App;
import com.barethitam.naikpangkat.R;
import com.barethitam.naikpangkat.model.ProfilModel;
import com.barethitam.naikpangkat.presenter.implementation.ProfilImpl;
import com.barethitam.naikpangkat.utils.Constant;
import com.barethitam.naikpangkat.utils.Utils;
import com.barethitam.naikpangkat.view.interfaces.ProfilInterface;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by LTE on 10/6/2016.
 */
public class ProfilFragment extends Fragment implements ProfilInterface.ProfilPersonilView{


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

    ProfilImpl.ProfilPresenterImplementation profilPresenterImplementation;

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

        profilPresenterImplementation = new ProfilImpl.ProfilPresenterImplementation();
        profilPresenterImplementation.onAttachView(this);

        HashMap<String, Object> postProfilModel = new HashMap<>();
        postProfilModel.put("id_personel", App.getFromPreference(Constant.NO_ID_ANGGOTA));


        profilPresenterImplementation.profilPersonil(Constant.URL_PROFIL, postProfilModel);
    }

    @OnClick(R.id.txt_keluar)
    public void onClick() {
        Utils.initDialogInfo(getActivity(), "Apakah anda ingin keluar dari akun ini?", Constant.ACTION_LOGOUT);
    }

    @Override
    public void getProfilPersonil(ProfilModel profilModel) {
        ProfilModel.Data data = profilModel.getData().get(0);
        txtName.setText(data.getNama_personel());
        txtNamePers.setText(data.getPangkat_personel()+", "+data.getJabatan_personel());
        txtExp.setText(String.valueOf(data.getExp_personel())+" / "+String.valueOf(data.getMax_exp()+" Exp"));
        try {
            //Date past = Constant.CREATED_AT.parse(data.getTgl_lahir());
            txtTtl.setText(data.getProvinsi_lahir()+", "+getSimpleDate(data.getTgl_lahir()));
        }catch (Exception e){

        }

        progBar.setMax((int)data.getMax_exp());
        progBar.setProgress((int)data.getExp_personel());

        cekPangkat(data.getPangkat_personel());
    }

    @Override
    public void onFailed(String message) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(null==profilPresenterImplementation){
            //do nothing
        }else{
            profilPresenterImplementation.onDetachView();
        }
    }

    public String getSimpleDate(String createdAt) throws ParseException {
        String simpleDate = Constant.BLANK;
        final Date date = Constant.CREATED_AT.parse(createdAt);
        simpleDate = Constant.SHORT_DATE_FORMAT.format(date);
        return simpleDate;
    }

    private void cekPangkat(String pangkat){
        if(pangkat.equals(Constant.PANGKAT_PRADA)){
            imgPangkat.setImageResource(R.drawable.ic_pangkat_prajurit_2);
        }else if(pangkat.equals(Constant.PANGKAT_PRATU)){
            imgPangkat.setImageResource(R.drawable.ic_pangkat_prajurit_1);
        }else if(pangkat.equals(Constant.PANGKAT_PRAKA)){
            imgPangkat.setImageResource(R.drawable.ic_pangkat_prajurit_kepala);
        }else if(pangkat.equals(Constant.PANGKAT_KOPDA)){
            imgPangkat.setImageResource(R.drawable.ic_pangkat_kopral_2);
        }else if(pangkat.equals(Constant.PANGKAT_KOPTU)){
            imgPangkat.setImageResource(R.drawable.ic_pangkat_kopral_1);
        }else if(pangkat.equals(Constant.PANGKAT_KOPKA)){
            imgPangkat.setImageResource(R.drawable.ic_pangkat_kopral_kepala);
        }else if(pangkat.equals(Constant.PANGKAT_SERDA)){
            imgPangkat.setImageResource(R.drawable.ic_pangkat_sersan_2);
        }else if(pangkat.equals(Constant.PANGKAT_SERTU)){
            imgPangkat.setImageResource(R.drawable.ic_pangkat_sersan_1);
        }else if(pangkat.equals(Constant.PANGKAT_SERKA)){
            imgPangkat.setImageResource(R.drawable.ic_pangkat_sersan_kepala);
        }else if(pangkat.equals(Constant.PANGKAT_SERMA)){
            imgPangkat.setImageResource(R.drawable.ic_pangkat_sersan_mayor);
        }else if(pangkat.equals(Constant.PANGKAT_PELDA)){
            imgPangkat.setImageResource(R.drawable.ic_pangkat_pembantu_letnan_2);
        }else if(pangkat.equals(Constant.PANGKAT_PELTU)){
            imgPangkat.setImageResource(R.drawable.ic_pangkat_pembantu_letnan_1);
        }else if(pangkat.equals(Constant.PANGKAT_LETDA)){
            imgPangkat.setImageResource(R.drawable.ic_pangkat_letnan_2);
        }else if(pangkat.equals(Constant.PANGKAT_LETTU)){
            imgPangkat.setImageResource(R.drawable.ic_pangkat_letnan_1);
        }else if(pangkat.equals(Constant.PANGKAT_KAPTEN)){
            imgPangkat.setImageResource(R.drawable.ic_pangkat_kapten);
        }else if(pangkat.equals(Constant.PANGKAT_MAYOR)){
            imgPangkat.setImageResource(R.drawable.ic_pangkat_mayor);
        }else if(pangkat.equals(Constant.PANGKAT_LETKOL)){
            imgPangkat.setImageResource(R.drawable.ic_pangkat_letnan_kolonel);
        }else if(pangkat.equals(Constant.PANGKAT_KOLONEL)){
            imgPangkat.setImageResource(R.drawable.ic_pangkat_kolonel);
        }else if(pangkat.equals(Constant.PANGKAT_BRIGJEN)){
            imgPangkat.setImageResource(R.drawable.ic_pangkat_brigjen);
        }else if(pangkat.equals(Constant.PANGKAT_MAYJEN)){
            imgPangkat.setImageResource(R.drawable.ic_pangkat_mayor_jenderal);
        }else if(pangkat.equals(Constant.PANGKAT_LETJEN)){
            imgPangkat.setImageResource(R.drawable.ic_pangkat_letnan_jenderal);
        }else if(pangkat.equals(Constant.PANGKAT_JENDRAL)){
            imgPangkat.setImageResource(R.drawable.ic_pangkat_jenderal);
        }
    }
}
