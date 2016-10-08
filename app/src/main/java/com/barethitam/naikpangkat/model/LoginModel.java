package com.barethitam.naikpangkat.model;

/**
 * Created by LTE on 10/8/2016.
 */
public final class LoginModel {
    public final long res;
    public final String msg;
    public final Data data;

    public LoginModel(long res, String msg, Data data){
        this.res = res;
        this.msg = msg;
        this.data = data;
    }

    public long getRes() {
        return res;
    }

    public String getMsg() {
        return msg;
    }

    public Data getData() {
        return data;
    }

    public static final class Data {
        public final long id_personel;
        public final String no_pers;

        public Data(long id_personel, String no_pers){
            this.id_personel = id_personel;
            this.no_pers = no_pers;
        }

        public long getId_personel() {
            return id_personel;
        }

        public String getNo_pers() {
            return no_pers;
        }
    }
}