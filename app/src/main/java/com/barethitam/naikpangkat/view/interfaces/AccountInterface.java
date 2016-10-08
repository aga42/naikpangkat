package com.barethitam.naikpangkat.view.interfaces;

import com.barethitam.naikpangkat.model.LoginModel;

/**
 * Created by LTE on 10/6/2016.
 */
public class AccountInterface{

    public interface LoginView{
        void login(LoginModel loginModel);
        void onFailed(String message);
    }

}
