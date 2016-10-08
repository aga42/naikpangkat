package com.barethitam.naikpangkat.model;

/**
 * Created by LTE on 10/8/2016.
 */
public final class JalankanMisiModel {
    public final long res;
    public final String msg;
    public final Data data;

    public JalankanMisiModel(long res, String msg, Data data){
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
        public final long id_mission_history;
        public final int status;

        public Data(long id_mission_history, int status){
            this.id_mission_history = id_mission_history;
            this.status = status;
        }

        public long getId_mission_history() {
            return id_mission_history;
        }

        public int getStatus() {
            return status;
        }
    }
}