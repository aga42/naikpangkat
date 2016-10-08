package com.barethitam.naikpangkat.base;

import com.barethitam.naikpangkat.BuildConfig;
import com.barethitam.naikpangkat.utils.Constant;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by LTE on 10/8/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class BaseNetworkManager implements Interceptor {

    private static Retrofit retrofit;
    //private static Retrofit retrofitToken;

    public static Retrofit getRetrofit() {
        if (null == retrofit) {
            OkHttpClient okHttpClient = getHttpClient(getInterceptor());
            retrofit = initiateRetrofit(okHttpClient);
        }
        return retrofit;
    }

    /*public static Retrofit getRetrofitForToken() {
        return initiateRetrofit(getHttpClient(getInterceptorForToken()));
    }*/


    protected static Retrofit initiateRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    public static OkHttpClient getHttpClient(Interceptor interceptor) {
        /*int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(context.getCacheDir(), cacheSize);
        builder.cache(cache);*/
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            return new OkHttpClient.Builder()
                    .addNetworkInterceptor(interceptor)
                    .addInterceptor(logging)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .build();
        } else {
            return new OkHttpClient.Builder()
                    .addNetworkInterceptor(interceptor)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .build();
        }
    }

    private static Interceptor getInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                return chain.proceed(getRequest(chain));
            }
        };
    }

    /*public static Interceptor getInterceptorForUpload() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                return chain.proceed(getRequestForUpload(chain));
            }
        };
    }*/

    public static Interceptor getInterceptorForToken() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                return chain.proceed(getRequestForToken(chain));
            }
        };
    }

    private static Request getRequestForToken(Chain chain) {
        return chain.request()
                .newBuilder()
                .build();
    }

    private static Request getRequest(Chain chain) {
        return getChainRequest(chain)
                //.addHeader("authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ2ZXJzaW9uIjoiMS4wIiwiZGV2aWNlIjoiMiIsImtleSI6ImNsaWVudDAyLUlibm5qc2FkYm91Mjg5NDgxODhiQUd3amZrc2RoaWJ2am9vd2Vmb2J2aGNqN0ZEQmJoaGpkc2Y4OTI4Mzg0NzcxOGhoZkhJREhGS0hTRktTaGgiLCJwb3N0Ijp7InVzZXJuYW1lIjoiaWJ1a290YSIsInBhc3N3b3JkIjoiaWJ1aWJ1IiwiZW1haWwiOiJpYnVrb3RhQGZlbWFsZWRhaWx5LmNvbSJ9LCJpYXQiOjE0NzIxMTQ3OTQsImV4cCI6MTQ3MjEyMTk5NH0.iVQ99PAy0BrGNYgvg5_U8_Crd1xDRhkP1VLcQiBK3G4")
                .build();
    }

    /*private static Request getRequestForUpload(Chain chain) {
        return getChainRequest(chain)
                .addHeader("Accept", "multipart/form-data")
                //.addHeader("authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ2ZXJzaW9uIjoiMS4wIiwiZGV2aWNlIjoiMiIsImtleSI6ImNsaWVudDAyLUlibm5qc2FkYm91Mjg5NDgxODhiQUd3amZrc2RoaWJ2am9vd2Vmb2J2aGNqN0ZEQmJoaGpkc2Y4OTI4Mzg0NzcxOGhoZkhJREhGS0hTRktTaGgiLCJwb3N0Ijp7InVzZXJuYW1lIjoiaWJ1a290YSIsInBhc3N3b3JkIjoiaWJ1aWJ1IiwiZW1haWwiOiJpYnVrb3RhQGZlbWFsZWRhaWx5LmNvbSJ9LCJpYXQiOjE0NzIxMTQ3OTQsImV4cCI6MTQ3MjEyMTk5NH0.iVQ99PAy0BrGNYgvg5_U8_Crd1xDRhkP1VLcQiBK3G4")
                .build();
    }*/

    private static Request.Builder getChainRequest(Chain chain) {
        //Utils.d("hloa", "heh " + App.getInstance().getFromPreference(Constant.ACCESS_TOKEN_PREF));
        return chain.request()
                .newBuilder();
    }

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        //long t1 = System.nanoTime();
        return chain.proceed(request);
    }

}
