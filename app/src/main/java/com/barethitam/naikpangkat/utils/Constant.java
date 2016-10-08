package com.barethitam.naikpangkat.utils;

import com.barethitam.naikpangkat.BuildConfig;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by LTE on 10/6/2016.
 */
public class Constant{

    public static final String BASE_URL = BuildConfig.BASE_URL;
    public static String BLANK ="";
    public final static String NO_ID_ANGGOTA = "no_id";
    public final static String MISI_ID = "misi_id";
    public final static String NO_PERS = "no_pers";

    public final static int ACTION_EXIT = 0;
    public final static int ACTION_LOGOUT = 1;

    public static final String URL_LOGIN = BASE_URL + "login";
    public static final String URL_MISI = BASE_URL + "misi";
    public static final String URL_MISI_DETAIL = BASE_URL + "detailmisi";
    public static final String URL_MISI_SAYA = BASE_URL + "mymission";
    public static final String URL_JALANKAN_MISI = BASE_URL + "runmission";
    public static final String URL_PROFIL = BASE_URL + "profile";

    public static final String REQUEST_FAILED = "Request Failed";
    public static final int CODE_OK = 200;

    public static final SimpleDateFormat CREATED_AT = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss", Locale.getDefault());
    public static final SimpleDateFormat SHORT_DATE_FORMAT = new SimpleDateFormat("d MMMM yyyy", Locale.getDefault());

    public static final int MISI_SELESAI = 1;
    public static final int MISI_SEKARANG = 0;
    public final static String IS_FROM_MISI = "is_from_misi";
}
