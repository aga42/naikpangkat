package com.barethitam.naikpangkat.model;

import java.util.ArrayList;

/**
 * Created by LTE on 10/6/2016.
 */
public final class MisiModel {
    public final long res;
    public final String msg;
    public final ArrayList<Data> data;

    public MisiModel(long res, String msg, ArrayList<Data> data){
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

    public ArrayList<Data> getData() {
        return data;
    }

    public static final class Data {
        public final long id_misi;
        public final String satuan;
        public final String pam;
        public final String tahun;
        public final long exp;
        public final String photo;

        public Data(long id_misi, String satuan, String pam, String tahun, long exp, String photo){
            this.id_misi = id_misi;
            this.satuan = satuan;
            this.pam = pam;
            this.tahun = tahun;
            this.exp = exp;
            this.photo = photo;
        }

        public long getId_misi() {
            return id_misi;
        }

        public String getSatuan() {
            return satuan;
        }

        public String getPam() {
            return pam;
        }

        public String getTahun() {
            return tahun;
        }

        public long getExp() {
            return exp;
        }

        public String getPhoto() {
            return photo;
        }
    }
}