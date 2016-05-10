package com.example.jiashuaishuai.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private String URL = "http://192.168.0.31:8080";
    private String password = "adb3fcf6bfac1044576a3b71db4ad557";
    private String phone = "18536640819";
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);

    }

    public void onclick(View v) {
//        Retrofit retrofit = new Retrofit.Builder()
//                .addConverterFactory(GsonConverterFactory.create())
//                .baseUrl("http://apis.baidu.com")
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .build();
//        PhoneService phoneService = retrofit.create(PhoneService.class);
//
//
//        phoneService.request("8e13586b86e4b7f3758ba3bd6c9c9135", "18536640819")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<PhoneBean>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(PhoneBean phoneBean) {
//                        Log.e("TAG", phoneBean.getRetData().getCity());
//                        tv.setText(phoneBean.getRetData().getCity());
//
//                    }
//                });


        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())//解析方法
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(URL)//主机地址
                .build();
        UserService service = retrofit.create(UserService.class);

        Map<String, String> map = new HashMap<>();
        map.put("phone", phone);
        map.put("password", password);

        service.getUser(new UserParms(phone, password))
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TotalBean>() {
                    @Override
                    public void onCompleted() {
//                        Log.e("TAG", "失败");
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        Log.e("TAG", "失败");
                    }

                    @Override
                    public void onNext(TotalBean totalBean) {
                        Log.e("TAG", "----" + totalBean.data);
                    }
                });
    }
}
