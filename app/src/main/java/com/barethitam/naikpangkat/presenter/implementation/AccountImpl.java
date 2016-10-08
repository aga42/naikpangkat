package com.barethitam.naikpangkat.presenter.implementation;

import com.barethitam.naikpangkat.api.AccountAPI;
import com.barethitam.naikpangkat.api.BaseResponse;
import com.barethitam.naikpangkat.base.NetworkManager;
import com.barethitam.naikpangkat.model.LoginModel;
import com.barethitam.naikpangkat.presenter.AccountPresenter;
import com.barethitam.naikpangkat.utils.Constant;
import com.barethitam.naikpangkat.view.interfaces.AccountInterface;

import java.util.HashMap;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by LTE on 10/6/2016.
 */
public class AccountImpl {

    protected static NetworkManager<AccountAPI> networkManager;

    protected static NetworkManager<AccountAPI> getNetworkManager() {
        if (networkManager == null) {
            networkManager = new NetworkManager<>(AccountAPI.class);
        }
        return networkManager;
    }

    //LOGIN PART=======================
    public static class LoginPresenterImplementation implements AccountPresenter.LoginPresenter {
        private AccountInterface.LoginView loginView;
        private Subscription subscription;
        private final String TAG = AccountImpl.LoginPresenterImplementation.class.getSimpleName();

        @Override
        public void onAttachView(AccountInterface.LoginView view) {
            this.loginView = view;
        }

        @Override
        public void onDetachView() {
            accountAPI = null;
            if (subscription != null && !subscription.isUnsubscribed()) {
                subscription.unsubscribe();
            }

        }

        @Override
        public void login(String url, HashMap<String, Object> postLoginModel) {
            subscription = getAccountApi()
                    .postLogin(url, postLoginModel)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new BaseResponse<LoginModel>() {
                        @Override
                        public void onError() {
                            //Utils.d(TAG, "onError");
                            loginView.onFailed(Constant.REQUEST_FAILED);
                        }

                        @Override
                        public void doOnNext(LoginModel loginModel) {

                            loginView.login(loginModel);

                        }

                        @Override
                        public void onCompleted() {

                        }
                    });
        }
    }
    //END OF LOGIN PART=======================

    private static AccountAPI accountAPI;

    private static AccountAPI getAccountApi() {
        if (accountAPI == null)
            accountAPI = getNetworkManager().getInstance();
        return accountAPI;
    }

}
