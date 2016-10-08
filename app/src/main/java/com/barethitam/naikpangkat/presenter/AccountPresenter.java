package com.barethitam.naikpangkat.presenter;

import com.barethitam.naikpangkat.view.interfaces.AccountInterface;

import java.util.HashMap;

/**
 * Created by LTE on 10/6/2016.
 */
public class AccountPresenter {

    public interface LoginPresenter extends BasePresenter<AccountInterface.LoginView>{
        void login(String url, HashMap<String, Object> postLoginModel);
    }

}
