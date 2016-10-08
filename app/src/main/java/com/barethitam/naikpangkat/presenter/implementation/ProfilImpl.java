package com.barethitam.naikpangkat.presenter.implementation;

import com.barethitam.naikpangkat.api.BaseResponse;
import com.barethitam.naikpangkat.api.ProfilAPI;
import com.barethitam.naikpangkat.base.NetworkManager;
import com.barethitam.naikpangkat.model.ProfilModel;
import com.barethitam.naikpangkat.presenter.ProfilPresenter;
import com.barethitam.naikpangkat.utils.Constant;
import com.barethitam.naikpangkat.view.interfaces.ProfilInterface;

import java.util.HashMap;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by LTE on 10/8/2016.
 */
public class ProfilImpl {

    protected static NetworkManager<ProfilAPI> networkManager;

    protected static NetworkManager<ProfilAPI> getNetworkManager() {
        if (networkManager == null) {
            networkManager = new NetworkManager<>(ProfilAPI.class);
        }
        return networkManager;
    }

    //LOGIN PART=======================
    public static class ProfilPresenterImplementation implements ProfilPresenter.ProfilPersonilPresenter {
        private ProfilInterface.ProfilPersonilView profilPersonilView;
        private Subscription subscription;
        private final String TAG = ProfilImpl.ProfilPresenterImplementation.class.getSimpleName();

        @Override
        public void onAttachView(ProfilInterface.ProfilPersonilView view) {
            this.profilPersonilView = view;
        }

        @Override
        public void onDetachView() {
            profilAPI = null;
            if (subscription != null && !subscription.isUnsubscribed()) {
                subscription.unsubscribe();
            }

        }

        @Override
        public void profilPersonil() {
            /*subscription = getProfilAPI()
                    .postLogin()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new BaseResponse<ProfilModel>() {
                        @Override
                        public void onError() {
                            //Utils.d(TAG, "onError");
                            profilPersonilView.onFailed(Constant.REQUEST_FAILED);
                        }

                        @Override
                        public void doOnNext(ProfilModel profilModel) {

                            profilPersonilView.getProfilPersonil(profilModel);

                        }

                        @Override
                        public void onCompleted() {

                        }
                    });*/
        }
    }
    //END OF LOGIN PART=======================

    private static ProfilAPI profilAPI;

    private static ProfilAPI getProfilAPI() {
        if (profilAPI == null)
            profilAPI = getNetworkManager().getInstance();
        return profilAPI;
    }

}
