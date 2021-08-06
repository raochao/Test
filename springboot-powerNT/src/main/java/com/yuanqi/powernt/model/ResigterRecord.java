package com.yuanqi.powernt.model;

import java.util.Date;

public class ResigterRecord {
    private String registerId;//订单编号
    private String PIN_KEY;//数字订单号(医院返回订单号码)
    private String OUT_TRADE_NO;//商户支付订单号（平台产生）
    private String user_name;//用户名
    private String user_no;//用户标识
    private String REGISTER_TYPE;//诊疗方式0：初诊 1：复诊
    private Date CREATEDATE;//订单生成时间



}
