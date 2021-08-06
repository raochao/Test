package com.yuanqi.powernt.tools;

import orgine.powermop.api.gateway.sdk.ApiExecute;
import orgine.powermop.api.gateway.sdk.info.BusinessCallRequest;
import orgine.powermop.api.gateway.sdk.info.BusinessCallResponse;

public class HttpTools {


    public static BusinessCallResponse requestHttp(String head,String body){
        BusinessCallResponse response =null;
        try {
            ApiExecute apiExecute = ApiExecute.newBuilder().publicKey("xR39hgEV+oKhtMOrakzkJQ==")
                    .url("http://orgine.cloud.1451cn.com:42007/orgine/powermsp/service/overt")
                    .isEncrypt(true)
                    .build();
            BusinessCallRequest request = new BusinessCallRequest(head, body);
             response = apiExecute.businessCall(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    public static BusinessCallResponse requestPay(String head,String body){
        BusinessCallResponse response =null;
        try {
            ApiExecute apiExecute = ApiExecute.newBuilder()
                    .publicKey("xR39hgEV+oKhtMOrakzkJQ==")
                    .url("http://orgine.cloud.1451cn.com:42007/orgine/powermpp/pay/aggre/service/api")
                    .isEncrypt(true)
                    .build();
            BusinessCallRequest request = new BusinessCallRequest(head, body);
            response = apiExecute.businessCall(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}
