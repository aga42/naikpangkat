package com.barethitam.naikpangkat.utils;

import com.barethitam.naikpangkat.BuildConfig;

/**
 * Created by LTE on 10/6/2016.
 */
public class Constant{

    public static final String BASE_URL = BuildConfig.BASE_URL;
    public static String BLANK ="";
    public final static String NO_ID_ANGGOTA = "no_id";
    public final static String MISI_ID = "misi_id";
    public final static int ACTION_EXIT = 0;
    public final static int ACTION_LOGOUT = 1;

    public static final String URL_LOGIN = BASE_URL + "login";
    public static final String URL_MISI = BASE_URL + "misi";
    public static final String URL_MISI_DETAIL = BASE_URL + "detailmisi";
    public static final String URL_MISI_SAYA = BASE_URL + "login";
    public static final String URL_JALANKAN_MISI = BASE_URL + "runmission";
    public static final String URL_PROFIL = BASE_URL + "profile";

    public static final String REQUEST_FAILED = "Request Failed";
    public static final int CODE_OK = 200;
}
