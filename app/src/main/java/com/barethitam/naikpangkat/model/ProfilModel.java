package com.barethitam.naikpangkat.model;

import java.util.ArrayList;

/**
 * Created by LTE on 10/6/2016.
 */
public final class ProfilModel {
    public final long res;
    public final String msg;
    public final ArrayList<Data> data;

    public ProfilModel(long res, String msg, ArrayList<Data> data){
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
        public final String nama_personel;
        public final String pangkat_personel;
        public final String jabatan_personel;
        public final String tgl_lahir;
        public final String provinsi_lahir;
        public final String kab_lahir;
        public final String kec_lahir;
        public final String kel_lahir;

        public Data(String nama_personel, String pangkat_personel, String jabatan_personel, String tgl_lahir, String provinsi_lahir, String kab_lahir, String kec_lahir, String kel_lahir){
            this.nama_personel = nama_personel;
            this.pangkat_personel = pangkat_personel;
            this.jabatan_personel = jabatan_personel;
            this.tgl_lahir = tgl_lahir;
            this.provinsi_lahir = provinsi_lahir;
            this.kab_lahir = kab_lahir;
            this.kec_lahir = kec_lahir;
            this.kel_lahir = kel_lahir;
        }

        public String getNama_personel() {
            return nama_personel;
        }

        public String getPangkat_personel() {
            return pangkat_personel;
        }

        public String getJabatan_personel() {
            return jabatan_personel;
        }

        public String getTgl_lahir() {
            return tgl_lahir;
        }

        public String getProvinsi_lahir() {
            return provinsi_lahir;
        }

        public String getKab_lahir() {
            return kab_lahir;
        }

        public String getKec_lahir() {
            return kec_lahir;
        }

        public String getKel_lahir() {
            return kel_lahir;
        }
    }
}