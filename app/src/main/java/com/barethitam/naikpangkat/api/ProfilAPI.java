package com.barethitam.naikpangkat.api;

import com.barethitam.naikpangkat.model.ProfilModel;

import java.util.HashMap;

import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by LTE on 10/8/2016.
 */
public interface ProfilAPI {

    @POST
    Observable<Response<ProfilModel>> postProfil(@Url String url, @Body HashMap<String, Object> postProfilModel);

}
