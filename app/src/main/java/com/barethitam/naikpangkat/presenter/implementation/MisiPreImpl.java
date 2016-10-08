package com.barethitam.naikpangkat.presenter.implementation;

import com.barethitam.naikpangkat.api.BaseResponse;
import com.barethitam.naikpangkat.api.MisiAPI;
import com.barethitam.naikpangkat.base.NetworkManager;
import com.barethitam.naikpangkat.model.JalankanMisiModel;
import com.barethitam.naikpangkat.model.MisiDetailModel;
import com.barethitam.naikpangkat.model.MisiModel;
import com.barethitam.naikpangkat.model.MisiSayaModel;
import com.barethitam.naikpangkat.presenter.MisiPresenter;
import com.barethitam.naikpangkat.utils.Constant;
import com.barethitam.naikpangkat.view.interfaces.MisiInterface;

import java.util.HashMap;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by LTE on 10/6/2016.
 */
public class MisiPreImpl {

    protected static NetworkManager<MisiAPI> networkManager;

    protected static NetworkManager<MisiAPI> getNetworkManager() {
        if (networkManager == null) {
            networkManager = new NetworkManager<>(MisiAPI.class);
        }
        return networkManager;
    }

    //LOGIN PART=======================
    public static class MisiListPresenterImplementation implements MisiPresenter.MisiListPresenter {
        private MisiInterface.MisiView misiView;
        private Subscription subscription;
        private final String TAG = ProfilImpl.ProfilPresenterImplementation.class.getSimpleName();

        @Override
        public void onAttachView(MisiInterface.MisiView view) {
            this.misiView = view;
        }

        @Override
        public void onDetachView() {
            misiAPI = null;
            if (subscription != null && !subscription.isUnsubscribed()) {
                subscription.unsubscribe();
            }

        }

        @Override
        public void misiList() {
            subscription = getMisiAPI()
                    .getMisiList()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new BaseResponse<MisiModel>() {
                        @Override
                        public void onError() {
                            //Utils.d(TAG, "onError");
                            misiView.onFailed(Constant.REQUEST_FAILED);
                        }

                        @Override
                        public void doOnNext(MisiModel misiModel) {

                            misiView.getMisi(misiModel);

                        }

                        @Override
                        public void onCompleted() {

                        }
                    });
        }
    }
    //END OF LOGIN PART=======================

    //LOGIN PART=======================
    public static class MisiDetailPresenterImplementation implements MisiPresenter.MisiDetailPresenter {
        private MisiInterface.MisiDetailView misiDetailView;
        private Subscription subscription;
        private final String TAG = MisiPreImpl.MisiDetailPresenterImplementation.class.getSimpleName();

        @Override
        public void onAttachView(MisiInterface.MisiDetailView view) {
            this.misiDetailView = view;
        }

        @Override
        public void onDetachView() {
            misiAPI = null;
            if (subscription != null && !subscription.isUnsubscribed()) {
                subscription.unsubscribe();
            }

        }

        @Override
        public void misiDetail(String url, HashMap<String, Object> postLikeModel) {
            subscription = getMisiAPI()
                    .postMisiDetail(url, postLikeModel)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new BaseResponse<MisiDetailModel>() {
                        @Override
                        public void onError() {
                            //Utils.d(TAG, "onError");
                            misiDetailView.onFailed(Constant.REQUEST_FAILED);
                        }

                        @Override
                        public void doOnNext(MisiDetailModel misiDetailModel) {

                            misiDetailView.getMisiDetail(misiDetailModel);

                        }

                        @Override
                        public void onCompleted() {

                        }
                    });
        }
    }
    //END OF LOGIN PART=======================

    //LOGIN PART=======================
    public static class MisiSayaPresenterImplementation implements MisiPresenter.MisiSayaPresenter {
        private MisiInterface.MisiSayaView misiSayaView;
        private Subscription subscription;
        private final String TAG = MisiPreImpl.MisiListPresenterImplementation.class.getSimpleName();

        @Override
        public void onAttachView(MisiInterface.MisiSayaView view) {
            this.misiSayaView = view;
        }

        @Override
        public void onDetachView() {
            misiAPI = null;
            if (subscription != null && !subscription.isUnsubscribed()) {
                subscription.unsubscribe();
            }

        }

        @Override
        public void misiSaya(String url, HashMap<String, Object> postLikeModel) {
            subscription = getMisiAPI()
                    .postMisiSaya(url, postLikeModel)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new BaseResponse<MisiSayaModel>() {
                        @Override
                        public void onError() {
                            //Utils.d(TAG, "onError");
                            misiSayaView.onFailed(Constant.REQUEST_FAILED);
                        }

                        @Override
                        public void doOnNext(MisiSayaModel misiSayaModel) {

                            misiSayaView.getMisiSaya(misiSayaModel);

                        }

                        @Override
                        public void onCompleted() {

                        }
                    });
        }
    }
    //END OF LOGIN PART=======================

    //LOGIN PART=======================
    public static class JalankanMisiPresenterImplementation implements MisiPresenter.JalankanMisiPresenter {
        private MisiInterface.JalankanMisiView jalankanMisiView;
        private Subscription subscription;
        private final String TAG = MisiPreImpl.JalankanMisiPresenterImplementation.class.getSimpleName();

        @Override
        public void onAttachView(MisiInterface.JalankanMisiView view) {
            this.jalankanMisiView = view;
        }

        @Override
        public void onDetachView() {
            misiAPI = null;
            if (subscription != null && !subscription.isUnsubscribed()) {
                subscription.unsubscribe();
            }

        }

        @Override
        public void jalankanMisi(String url, HashMap<String, Object> postLikeModel) {
            subscription = getMisiAPI()
                    .postJalankanMisi(url, postLikeModel)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new BaseResponse<JalankanMisiModel>() {
                        @Override
                        public void onError() {
                            //Utils.d(TAG, "onError");
                            jalankanMisiView.onFailed(Constant.REQUEST_FAILED);
                        }

                        @Override
                        public void doOnNext(JalankanMisiModel misiModel) {

                            jalankanMisiView.postJalankanMisi(misiModel);

                        }

                        @Override
                        public void onCompleted() {

                        }
                    });
        }
    }
    //END OF LOGIN PART=======================

    private static MisiAPI misiAPI;

    private static MisiAPI getMisiAPI() {
        if (misiAPI == null)
            misiAPI = getNetworkManager().getInstance();
        return misiAPI;
    }

}
