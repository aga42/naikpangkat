package com.barethitam.naikpangkat.api;

import com.barethitam.naikpangkat.model.JalankanMisiModel;
import com.barethitam.naikpangkat.model.MisiDetailModel;
import com.barethitam.naikpangkat.model.MisiModel;
import com.barethitam.naikpangkat.model.MisiSayaModel;
import com.barethitam.naikpangkat.utils.Constant;

import java.util.HashMap;

import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by LTE on 10/6/2016.
 */
public interface MisiAPI {

    @GET(Constant.URL_MISI)
    Observable<Response<MisiModel>> getMisiList();

    @POST
    Observable<Response<MisiDetailModel>> postMisiDetail(@Url String url, @Body HashMap<String, Object> postMisiDetailModel);

    @POST
    Observable<Response<MisiSayaModel>> postMisiSaya(@Url String url, @Body HashMap<String, Object> postMisiSayaModel);

    @POST
    Observable<Response<JalankanMisiModel>> postJalankanMisi(@Url String url, @Body HashMap<String, Object> postJalankanMisiModel);

}
