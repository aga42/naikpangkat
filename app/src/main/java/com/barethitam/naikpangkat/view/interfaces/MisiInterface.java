package com.barethitam.naikpangkat.view.interfaces;

import com.barethitam.naikpangkat.model.JalankanMisiModel;
import com.barethitam.naikpangkat.model.MisiDetailModel;
import com.barethitam.naikpangkat.model.MisiModel;
import com.barethitam.naikpangkat.model.MisiSayaModel;

/**
 * Created by LTE on 10/6/2016.
 */
public class MisiInterface {

    public interface MisiView{
        void getMisi(MisiModel misiModel);
        void onFailed(String message);
    }

    public interface MisiDetailView{
        void getMisiDetail(MisiDetailModel misiDetailModel);
        void onFailed(String message);
    }

    public interface MisiSayaView{
        void getMisiSaya(MisiSayaModel misiSayaModel);
        void onFailed(String message);
    }

    public interface JalankanMisiView{
        void postJalankanMisi(JalankanMisiModel jalankanMisiModel);
        void onFailed(String message);
    }

}
