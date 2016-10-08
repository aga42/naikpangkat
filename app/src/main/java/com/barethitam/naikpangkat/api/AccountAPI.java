package com.barethitam.naikpangkat.api;

import com.barethitam.naikpangkat.model.LoginModel;

import java.util.HashMap;

import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by LTE on 10/6/2016.
 */
public interface AccountAPI {

    @POST
    Observable<Response<LoginModel>> postLogin(@Url String url, @Body HashMap<String, Object> postLoginModel);

}
