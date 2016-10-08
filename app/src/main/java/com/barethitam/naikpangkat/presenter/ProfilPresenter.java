package com.barethitam.naikpangkat.presenter;

import com.barethitam.naikpangkat.view.interfaces.ProfilInterface;

import java.util.HashMap;

/**
 * Created by LTE on 10/8/2016.
 */
public class ProfilPresenter {

    public interface ProfilPersonilPresenter extends BasePresenter<ProfilInterface.ProfilPersonilView>{
        void profilPersonil(String url, HashMap<String, Object> postProfilModel);
    }

}
