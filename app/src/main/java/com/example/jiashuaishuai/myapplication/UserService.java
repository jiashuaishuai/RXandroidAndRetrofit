package com.example.jiashuaishuai.myapplication;


import java.util.Map;

import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by jiashuaishuai on 2016/5/9.
 */
public interface UserService {
    @Headers({"Accept: application/json", "Content-Type: application/json; charset=UTF-8"})
    @POST("/Cxf_xzlc_app/user/login")
//    Observable<TotalBean> getUser(@FieldMap Map<String, String> map);
    Observable<TotalBean> getUser(@Body UserParms userParms);
}
