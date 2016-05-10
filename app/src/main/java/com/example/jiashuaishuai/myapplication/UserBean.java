package com.example.jiashuaishuai.myapplication;

import java.util.ArrayList;

/**
 * 登录时访问服务器返回的javaBean
 *
 * @author Administrator
 */
public class UserBean {

    public Data data;

    public class Data {
        public String code;  //返回码
        public String message;  //返回描述信息
        public String sessionId;  //  sessionId
        public String userId;  // 用户身份标识id
        public String username;  //  用户名
        public String phone;  //  手机号
        public String realName;  //真实姓名
        public String idCardNo;  //身份证号码
        public String registerTime;  //注册时间
        public String isNewbie;  // 是否新手
        public String cash;  // 账户余额
        public String versionNum;  // 否需要转余额（0为不需要，1为需要）
        public String headInfoDic;//用户头像信息
        public ArrayList<Bank> userBankList;  //银行数组

    }

    public class Bank {
        public String bank;  //银行名称
        public String bankcode;  //银行编号
        public String cardcode;  //银行卡号
        public String provinceCityId;  //城市编号
        public String cardtype;  //银行编号
        public String id;  //银行编号
        public String state;  //银行卡状态
        public String provinceCode;  //省份编码态
        public String cityCode;  //地市编码
        public String branchBankname; //支行名称
        public String cityName; //地市的名字
        public String provinceName; //省级的名字
        public String userid; //省级的名字
    }
}
