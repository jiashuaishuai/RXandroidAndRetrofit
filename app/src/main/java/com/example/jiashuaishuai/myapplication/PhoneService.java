package com.example.jiashuaishuai.myapplication;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by jiashuaishuai on 2016/5/10.
 */
public interface PhoneService {
    @GET("/apistore/mobilenumber/mobilenumber")
    Observable<PhoneBean> request(@Header("apikey") String apikey, @Query("phone") String phone);
}
