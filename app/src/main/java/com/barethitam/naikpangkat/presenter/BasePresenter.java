package com.barethitam.naikpangkat.presenter;

/**
 * Created by LTE on 10/8/2016.
 */
public interface BasePresenter<V> {

    void onAttachView(V view);

    void onDetachView();

}