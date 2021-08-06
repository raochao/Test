package com.yuanqi.powernt.model;

import java.util.HashMap;

public class PayInfo {

    private String request_no;
    private String trade_no;
    private String pay_type;
    private String mac_number;
    private String pay_amount;
    private String identity_id;
    private String name;
    private String notify_url;
    private String attach_params;
    private String openid;
    private String product_id;
    private String goods_desc;

    public String getRequest_no() {
        return request_no;
    }

    public void setRequest_no(String request_no) {
        this.request_no = request_no;
    }

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public String getPay_type() {
        return pay_type;
    }

    public void setPay_type(String pay_type) {
        this.pay_type = pay_type;
    }

    public String getMac_number() {
        return mac_number;
    }

    public void setMac_number(String mac_number) {
        this.mac_number = mac_number;
    }

    public String getPay_amount() {
        return pay_amount;
    }

    public void setPay_amount(String pay_amount) {
        this.pay_amount = pay_amount;
    }

    public String getIdentity_id() {
        return identity_id;
    }

    public void setIdentity_id(String identity_id) {
        this.identity_id = identity_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getAttach_params() {
        return attach_params;
    }

    public void setAttach_params(String attach_params) {
        this.attach_params = attach_params;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getGoods_desc() {
        return goods_desc;
    }

    public void setGoods_desc(String goods_desc) {
        this.goods_desc = goods_desc;
    }
}
