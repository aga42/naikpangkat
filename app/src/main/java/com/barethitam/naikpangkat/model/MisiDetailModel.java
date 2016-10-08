package com.barethitam.naikpangkat.model;

/**
 * Created by LTE on 10/6/2016.
 */
public final class MisiDetailModel {
    public final long res;
    public final String msg;
    public final Data data;

    public MisiDetailModel(long res, String msg, Data data){
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
        public final long id_misi;
        public final String satuan;
        public final String pam;
        public final Tmt tmt;
        public final String tahun;
        public final String deskripsi;

        public Data(long id_misi, String satuan, String pam, Tmt tmt, String tahun, String deskripsi){
            this.id_misi = id_misi;
            this.satuan = satuan;
            this.pam = pam;
            this.tmt = tmt;
            this.tahun = tahun;
            this.deskripsi = deskripsi;
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

        public Tmt getTmt() {
            return tmt;
        }

        public String getTahun() {
            return tahun;
        }

        public String getDeskripsi() {
            return deskripsi;
        }

        public static final class Tmt {

            public Tmt(){
            }
        }
    }
}