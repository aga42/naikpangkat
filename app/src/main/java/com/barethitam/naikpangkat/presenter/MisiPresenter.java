package com.barethitam.naikpangkat.presenter;

import com.barethitam.naikpangkat.view.interfaces.MisiInterface;

import java.util.HashMap;

/**
 * Created by LTE on 10/6/2016.
 */
public class MisiPresenter {

    public interface MisiListPresenter extends BasePresenter<MisiInterface.MisiView>{
        void misiList();
    }

    public interface MisiDetailPresenter extends BasePresenter<MisiInterface.MisiDetailView>{
        void misiDetail(String url, HashMap<String, Object> postLikeModel);
    }

    public interface MisiSayaPresenter extends BasePresenter<MisiInterface.MisiSayaView>{
        void misiSaya(String type, String post_id, String user_id);
    }

    public interface JalankanMisiPresenter extends BasePresenter<MisiInterface.JalankanMisiView>{
        void likeFeed(String post_id, HashMap<String, Object> postLikeModel);
    }

}
