package com.barethitam.naikpangkat.base;

import retrofit2.Retrofit;

/**
 * Created by LTE on 10/8/2016.
 */
public class NetworkManager<T> extends BaseNetworkManager {

    private T api;
    private Class<T> apiClass;

    public T getInstance() {
        if (api == null) {
            api = create(apiClass);
        }
        return api;
    }

    public NetworkManager(Class<T> t) {
        apiClass = t;
    }

    private <T> T createInstanceForUpload(Class<T> service) {
        return (T) getRetrofitForUpload().create(service);
    }

    private <T> T createInstantForToken(Class<T> service) {
        return (T) getRetrofitForTokens().create(service);
    }

    private <T> T create(Class<T> service) {
        return (T) getRetrofit()
                .create(service);
    }

    private static Retrofit getRetrofitForUpload() {
        return initiateRetrofit(getHttpClient(getInterceptorForUpload()));
    }

    public T getInstanceForUpload() {
        return createInstanceForUpload(apiClass);
    }

    private static Retrofit getRetrofitForTokens() {
        return initiateRetrofit(getHttpClient(getInterceptorForToken()));
    }

    public T getInstanceForToken() {
        return createInstantForToken(apiClass);
    }
}