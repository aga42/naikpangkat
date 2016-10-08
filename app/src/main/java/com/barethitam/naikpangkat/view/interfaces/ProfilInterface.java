package com.barethitam.naikpangkat.view.interfaces;

import com.barethitam.naikpangkat.model.ProfilModel;

/**
 * Created by LTE on 10/8/2016.
 */
public class ProfilInterface {

    public interface ProfilPersonilView{
        void getProfilPersonil(ProfilModel profilModel);
        void onFailed(String message);
    }

}
