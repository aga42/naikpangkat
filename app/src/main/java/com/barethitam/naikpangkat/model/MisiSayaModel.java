package com.barethitam.naikpangkat.model;

import java.util.ArrayList;

/**
 * Created by LTE on 10/8/2016.
 */
public final class MisiSayaModel {
    public final long res;
    public final String msg;
    public final ArrayList<Data> data;

    public MisiSayaModel(long res, String msg, ArrayList<Data> data){
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
        public final String id_misi;
        public final String satuan;
        public final String pam;
        public final String tmt;
        public final String tahun;
        public final String deskripsi;
        public final String exp;
        public final int status;
        public final String photo;

        public Data(String id_misi, String satuan, String pam, String tmt, String tahun, String deskripsi, String exp, int status, String photo){
            this.id_misi = id_misi;
            this.satuan = satuan;
            this.pam = pam;
            this.tmt = tmt;
            this.tahun = tahun;
            this.deskripsi = deskripsi;
            this.exp = exp;
            this.status = status;
            this.photo = photo;
        }

        public String getId_misi() {
            return id_misi;
        }

        public String getSatuan() {
            return satuan;
        }

        public String getPam() {
            return pam;
        }

        public String getTmt() {
            return tmt;
        }

        public String getTahun() {
            return tahun;
        }

        public String getDeskripsi() {
            return deskripsi;
        }

        public String getExp() {
            return exp;
        }

        public int getStatus() {
            return status;
        }

        public String getPhoto() {
            return photo;
        }
    }
}