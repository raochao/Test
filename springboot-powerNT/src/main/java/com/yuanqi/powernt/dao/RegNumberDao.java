package com.yuanqi.powernt.dao;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yuanqi.powernt.model.BaseResult;
import com.yuanqi.powernt.tools.HttpTools;
import org.springframework.stereotype.Service;
import orgine.powermop.api.gateway.sdk.info.BusinessCallResponse;
import pnbclient.util.JSONParser;

import java.sql.Date;
import java.util.HashMap;

@Service
public class RegNumberDao {
    //操作别名对象
    private pnbclient.alias.SQLCommandService aliasSrv = null;
    //操作sql语句对象
    private pnbclient.command.SQLCommandService sqlSrv = null;

    public RegNumberDao(){
        try {
            aliasSrv = new pnbclient.alias.SQLCommandService();
            sqlSrv = new pnbclient.command.SQLCommandService();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public BaseResult request (Object obj,String interfaceId) throws Exception{
        BaseResult result =null;
        final JSONObject jsonObject = (JSONObject)JSON.toJSON(obj);
        System.out.println("前端传入参数对象=================="+jsonObject.toString());
//        String interfaceId=jsonObject.getJSONObject("headers").getString("interfaceId");
        System.out.println("请求的interfaceId================="+interfaceId);
        if("getRegDeptmentList".equals(interfaceId)){
            result = getRegDeptmentList(obj,"orgine.powermsp.service.overt.register."+interfaceId);
        }
        if("getRegDoctorList".equals(interfaceId)){
            result = getRegDoctorList(obj,"orgine.powermsp.service.overt.register."+interfaceId);
        }
        if("createRegOrder".equals(interfaceId)){
            result = createRegOrder(obj,"orgine.powermsp.service.overt.register."+interfaceId);
        }
        if("prepay".equals(interfaceId)){
            result = prepay(obj,"orgine.powermpp.pay.aggre.service.api.pay."+interfaceId);
        }
        if("confirmRegOrder".equals(interfaceId)){
            result = confirmRegOrder(obj,"orgine.powermsp.service.overt.register."+interfaceId);
        }
        return result;
    }


    public BaseResult getRegDeptmentList(Object obj,String interfaceId) throws Exception{
        System.out.println("开始执行获取科室列表方法-----------------------------");
        final JSONObject jsonObject = (JSONObject)JSON.toJSON(obj);
        String headJson = "";
        String bodyJson = "";
        BaseResult baseResult=null;
        try {
//            JSONObject headObject=jsonObject.getJSONObject("headers");
//            String interfaceId=headObject.getString("interfaceId");
//            JSONObject bodyObject=jsonObject.getJSONObject("body");
            headJson=getHeader(interfaceId);

            //重构请求参数-body部分
            HashMap<String, Object> bodyMap = new HashMap<>();
            HashMap<String, String> infoMap = new HashMap<>();
            JSONObject infoObject=jsonObject.getJSONObject("info");

            infoMap.put("deptment_area",infoObject.getString("deptment_area"));
            infoMap.put("parent_deptment_code",infoObject.getString("parent_deptment_code"));
            infoMap.put("extend_params",infoObject.getString("extend_params"));
            infoMap.put("deptment_code",infoObject.getString("deptment_code"));
            infoMap.put("time_interval",infoObject.getString("time_interval"));
            infoMap.put("id_card",infoObject.getString("id_card"));
            infoMap.put("birthday",infoObject.getString("birthday"));
            infoMap.put("category_mark",infoObject.getString("category_mark"));
            infoMap.put("level",infoObject.getString("level"));
            infoMap.put("operator",infoObject.getString("operator"));
            infoMap.put("input_name",infoObject.getString("input_name"));
            infoMap.put("sex",infoObject.getString("sex"));
            bodyMap.put("info",infoMap);

            //重构请求参数-extInfo部分
            HashMap<String, Object> extInfoMap = new HashMap<>();
            extInfoMap.put("pass_through",null);
            bodyMap.put("ext_info",extInfoMap);

            //重构请求参数-pagein部分
            JSONObject pageinObject=jsonObject.getJSONObject("pagein");
            HashMap<String, String> pageinMap = new HashMap<>();
            pageinMap.put("rowsperpage",pageinObject.getString("rowsperpage"));
            pageinMap.put("pageaction",pageinObject.getString("pageaction"));
            pageinMap.put("topagenum",pageinObject.getString("topagenum"));
            pageinMap.put("currentpagenum",pageinObject.getString("currentpagenum"));
            bodyMap.put("pagein",pageinMap);

//            int a=1/0;
            bodyJson = JSONParser.fromObject(bodyMap);
            //请求接口
            BusinessCallResponse response = HttpTools.requestHttp(headJson, bodyJson);
            if("10000".equals(response.getResult().getCode())){
                baseResult=new BaseResult(200, response.getResult().getMsg()+","+response.getResult().getSubMsg(), JSON.parseObject(response.getBody()!=null?response.getBody().toString():null));
            }else{
                baseResult=new BaseResult(500, response.getResult().getMsg()+","+response.getResult().getSubMsg(), JSON.parseObject(response.getBody()!=null?response.getBody().toString():null));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("结束执行获取科室列表方法-----------------------------");
        return baseResult;
    }

    /**
     * 获取医生和排班信息
     * @param obj
     * @return
     */
    public BaseResult getRegDoctorList(Object obj,String interfaceId){
        System.out.println("开始执行获取医生和排版信息方法-----------------------------");

        final JSONObject jsonObject = (JSONObject)JSON.toJSON(obj);
        String headJson = "";
        String bodyJson = "";
        BaseResult baseResult =null;

        try {
//            JSONObject headObject=jsonObject.getJSONObject("headers");
//            String interfaceId=headObject.getString("interfaceId");
//            JSONObject bodyObject=jsonObject.getJSONObject("body");
            headJson=getHeader(interfaceId);

            //重构请求参数-body部分
            HashMap<String, Object> bodyMap = new HashMap<>();
            HashMap<String, String> infoMap = new HashMap<>();
            JSONObject infoObject=jsonObject.getJSONObject("info");

            infoMap.put("end_time",infoObject.getString("end_time"));
            infoMap.put("doctor_code",infoObject.getString("doctor_code"));
            infoMap.put("start_time",infoObject.getString("start_time"));
            infoMap.put("extend_params",infoObject.getString("extend_params"));
            infoMap.put("category_mark",infoObject.getString("category_mark"));
            infoMap.put("patient_id",infoObject.getString("patient_id"));
            infoMap.put("operator",infoObject.getString("operator"));
            infoMap.put("deptment_code",infoObject.getString("deptment_code"));
            infoMap.put("input_name",infoObject.getString("input_name"));
            infoMap.put("parent_deptment_code",infoObject.getString("parent_deptment_code"));
            infoMap.put("charge_type",infoObject.getString("charge_type"));
            infoMap.put("time_interval",infoObject.getString("time_interval"));
            bodyMap.put("info",infoMap);


            //重构请求参数-extInfo部分
            HashMap<String, Object> extInfoMap = new HashMap<>();
            extInfoMap.put("pass_through",null);
            bodyMap.put("ext_info",extInfoMap);

            //重构请求参数-pagein部分
            JSONObject pageinObject=jsonObject.getJSONObject("pagein");
            HashMap<String, String> pageinMap = new HashMap<>();
            pageinMap.put("rowsperpage",pageinObject.getString("rowsperpage"));
            pageinMap.put("pageaction",pageinObject.getString("pageaction"));
            pageinMap.put("topagenum",pageinObject.getString("topagenum"));
            pageinMap.put("currentpagenum",pageinObject.getString("currentpagenum"));
            bodyMap.put("pagein",pageinMap);

            bodyJson = JSONParser.fromObject(bodyMap);
            //请求接口
            BusinessCallResponse response = HttpTools.requestHttp(headJson, bodyJson);
            if("10000".equals(response.getResult().getCode())){
                baseResult=new BaseResult(200, response.getResult().getMsg()+","+response.getResult().getSubMsg(), JSON.parseObject(response.getBody()!=null?response.getBody().toString():null));
            }else{
                baseResult=new BaseResult(500, response.getResult().getMsg()+","+response.getResult().getSubMsg(), JSON.parseObject(response.getBody()!=null?response.getBody().toString():null));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("结束执行获取医生和排版信息方法-----------------------------");
        return baseResult;
    }

    /**
     * 创建订单
     * @param obj
     * @return
     */
    public BaseResult createRegOrder(Object obj,String interfaceId){
        System.out.println("开始执行创建订单方法-----------------------------");

        final JSONObject jsonObject = (JSONObject)JSON.toJSON(obj);
        String headJson = "";
        String bodyJson = "";
        BaseResult baseResult=null;
        try {
//            JSONObject headObject=jsonObject.getJSONObject("headers");
//            String interfaceId=headObject.getString("interfaceId");
//            JSONObject bodyObject=jsonObject.getJSONObject("body");
            headJson=getHeader(interfaceId);

            //重构请求参数-body部分
            HashMap<String, Object> bodyMap = new HashMap<>();
            HashMap<String, String> infoMap = new HashMap<>();
            JSONObject infoObject=jsonObject.getJSONObject("info");

            infoMap.put("family_address",infoObject.getString("family_address"));
            infoMap.put("card_number",infoObject.getString("card_number"));
            infoMap.put("start_time",infoObject.getString("start_time"));
            infoMap.put("patient_id",infoObject.getString("patient_id"));
            infoMap.put("extend_params",infoObject.getString("extend_params"));
            infoMap.put("schedule_alias",infoObject.getString("schedule_alias"));
            infoMap.put("treatment_fee",infoObject.getString("treatment_fee"));
            infoMap.put("mac_number",infoObject.getString("mac_number"));
            infoMap.put("patient_name",infoObject.getString("patient_name"));
            infoMap.put("doctor_name",infoObject.getString("doctor_name"));
            infoMap.put("category_mark",infoObject.getString("category_mark"));
            infoMap.put("other_fees",infoObject.getString("other_fees"));

            infoMap.put("id_type",infoObject.getString("id_type"));
            infoMap.put("doctor_code",infoObject.getString("doctor_code"));
            infoMap.put("schedule_id",infoObject.getString("schedule_id"));
            infoMap.put("discount_allfee",infoObject.getString("discount_allfee"));
            infoMap.put("time_id",infoObject.getString("time_id"));
            infoMap.put("deptment_code",infoObject.getString("deptment_code"));

            infoMap.put("out_call_date",infoObject.getString("out_call_date"));
            infoMap.put("id_number",infoObject.getString("id_number"));
            infoMap.put("deptment_name",infoObject.getString("deptment_name"));
            infoMap.put("serial_number",infoObject.getString("serial_number"));

            infoMap.put("sex",infoObject.getString("sex"));
            infoMap.put("end_time",infoObject.getString("end_time"));
            infoMap.put("registration_fee",infoObject.getString("registration_fee"));
            infoMap.put("time_interval",infoObject.getString("time_interval"));

            infoMap.put("operator",infoObject.getString("operator"));
            infoMap.put("mobile_number",infoObject.getString("mobile_number"));
            infoMap.put("pay_choice",infoObject.getString("pay_choice"));
            infoMap.put("card_type",infoObject.getString("card_type"));

            bodyMap.put("info",infoMap);


            //重构请求参数-extInfo部分
            HashMap<String, Object> extInfoMap = new HashMap<>();
            extInfoMap.put("pass_through",null);
            bodyMap.put("ext_info",extInfoMap);
            bodyJson = JSONParser.fromObject(bodyMap);
            //请求接口
            BusinessCallResponse response = HttpTools.requestHttp(headJson, bodyJson);
            if("10000".equals(response.getResult().getCode())){
                baseResult=new BaseResult(200, response.getResult().getMsg()+","+response.getResult().getSubMsg(), JSON.parseObject(response.getBody()!=null?response.getBody().toString():null));
            }else{
                baseResult=new BaseResult(500, response.getResult().getMsg()+","+response.getResult().getSubMsg(), JSON.parseObject(response.getBody()!=null?response.getBody().toString():null));
            }
            ;
            String orderId=JSON.parseObject((String) response.getBody()).getJSONObject("info").getString("order_id");
            String tradeOrderId=JSON.parseObject((String) response.getBody()).getJSONObject("info").getString("trade_order_id");

            //创建本地订单
            aliasSrv.setLangId("sc");
            aliasSrv.addParameter(orderId);//订单编号
            aliasSrv.addParameter(tradeOrderId);//数字订单号(医院返回订单号码)
            aliasSrv.addParameter(tradeOrderId);//  商户支付订单号（平台产生）
            aliasSrv.addParameter("李四");//用户名
            aliasSrv.addParameter("123456");//用户标识
            aliasSrv.addParameter("0");//诊疗方式0：初诊 1：复诊
            aliasSrv.addParameter(new Date(System.currentTimeMillis()));//订单生成时间
            aliasSrv.addParameter(infoObject.getString("enterprise_id"));//医院代码
            aliasSrv.addParameter(infoObject.getString("deptment_code"));//科室代码
            aliasSrv.addParameter(infoObject.getString("doctor_code"));//医生代码
            aliasSrv.addParameter(infoObject.getString("positional_titles"));//医生职称
            aliasSrv.addParameter("");//号源类型0:当天号源   1:预约号源
            aliasSrv.addParameter("1");//号别1:普通号    2:专家号
            aliasSrv.addParameter("");
            aliasSrv.addParameter("");
            aliasSrv.addParameter("");
            aliasSrv.addParameter("");
            aliasSrv.addParameter(infoObject.getString("registration_fee"));//挂号费
            aliasSrv.addParameter("");
            aliasSrv.addParameter("");
            aliasSrv.addParameter("");
            aliasSrv.addParameter("");
            aliasSrv.addParameter("0");//状态：0平台新建订单
            aliasSrv.execute("RegNumber_CreateOrderInfo_sql");
        } catch (Exception e) {
            baseResult=new BaseResult(500, e.getMessage(), null);
            e.printStackTrace();
            return baseResult;
//            e.printStackTrace();

        }
        System.out.println("结束执行创建订单方法-----------------------------");
        return baseResult;

    }

    /**
     * 确认订单
     * @param obj
     * @return
     */
    public BaseResult confirmRegOrder(Object obj,String interfaceId){
        System.out.println("开始执行确认订单方法-----------------------------");

        final JSONObject jsonObject = (JSONObject)JSON.toJSON(obj);
        String headJson = "";
        String bodyJson = "";
        BaseResult baseResult=null;
        try {
//            JSONObject headObject=jsonObject.getJSONObject("headers");
//            String interfaceId=headObject.getString("interfaceId");
//            JSONObject bodyObject=jsonObject.getJSONObject("body");
            headJson=getHeader(interfaceId);

            //重构请求参数-body部分
            HashMap<String, Object> bodyMap = new HashMap<>();
            HashMap<String, String> infoMap = new HashMap<>();
            JSONObject infoObject=jsonObject.getJSONObject("info");

            infoMap.put("extend_params",infoObject.getString("extend_params"));
            infoMap.put("trade_order_id",infoObject.getString("trade_order_id"));
            infoMap.put("order_id",infoObject.getString("order_id"));
            infoMap.put("operator",infoObject.getString("operator"));
            infoMap.put("pay_allamount",infoObject.getString("pay_allamount"));
            infoMap.put("discount_amount",infoObject.getString("discount_amount"));
            infoMap.put("mac_number",infoObject.getString("mac_number"));
            infoMap.put("on_line_flag",infoObject.getString("on_line_flag"));
            bodyMap.put("info",infoMap);


            //重构请求参数-extInfo部分
            HashMap<String, Object> extInfoMap = new HashMap<>();
            extInfoMap.put("pass_through",null);
            bodyMap.put("ext_info",extInfoMap);
            JSONArray infoJSONArray=jsonObject.getJSONArray("paylist");
            bodyMap.put("paylist",infoJSONArray);

            bodyJson = JSONParser.fromObject(bodyMap);
            //请求接口
            BusinessCallResponse response = HttpTools.requestHttp(headJson, bodyJson);
            if("10000".equals(response.getResult().getCode())){
                baseResult=new BaseResult(200, response.getResult().getMsg()+","+response.getResult().getSubMsg(), JSON.parseObject(response.getBody()!=null?response.getBody().toString():null));
            }else{
                baseResult=new BaseResult(500, response.getResult().getMsg()+","+response.getResult().getSubMsg(), JSON.parseObject(response.getBody()!=null?response.getBody().toString():null));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("结束执行确认订单方法-----------------------------");
        return baseResult;

    }


    public BaseResult prepay(Object obj,String interfaceId){
        System.out.println("开始执行预支付方法-----------------------------");
        final JSONObject jsonObject = (JSONObject)JSON.toJSON(obj);
        BaseResult baseResult=null;
        String headJson = "";
        try {
//            JSONObject headObject=jsonObject.getJSONObject("headers");
//            String interfaceId=headObject.getString("interfaceId");
//            JSONObject bodyObject=jsonObject.getJSONObject("body");
            headJson=getHeader(interfaceId);

            HashMap<String, Object> bodyMap = new HashMap<>();
            bodyMap.put("request_no",  jsonObject.getString("request_no"));//订单号
            bodyMap.put("trade_no",  jsonObject.getString("trade_no"));//交易订单号
            bodyMap.put("pay_type",  jsonObject.getString("pay_type"));
            bodyMap.put("mac_number",  jsonObject.getString("mac_number"));
            bodyMap.put("pay_amount",  jsonObject.getString("pay_amount"));
            bodyMap.put("identity_id",  jsonObject.getString("identity_id"));
            bodyMap.put("name",  jsonObject.getString("name"));
            bodyMap.put("notify_url",  jsonObject.getString("notify_url"));//回调地址

            HashMap<String, Object> attachParamsMap = new HashMap<>();
            attachParamsMap.put("order_id",jsonObject.getString("request_no"));
            attachParamsMap.put("trade_order_id",jsonObject.getString("trade_no"));
            bodyMap.put("attach_params",  JSONObject.toJSON(attachParamsMap));//穿透字段

            HashMap<String, String> bizContentMap = new HashMap<>();
            bizContentMap.put("openid",jsonObject.getJSONObject("biz_content").getString("openid"));
            bizContentMap.put("product_id",jsonObject.getJSONObject("biz_content").getString("product_id"));
            bizContentMap.put("goods_desc",jsonObject.getJSONObject("biz_content").getString("goods_desc"));

            bodyMap.put("biz_content", JSONParser.fromObject(bizContentMap));
            String bodyJson = JSONParser.fromObject(bodyMap);
            BusinessCallResponse response = HttpTools.requestPay(headJson, bodyJson);

            if("10000".equals(response.getResult().getCode())){
                JSONObject object=JSONObject.parseObject(response.getBody().toString());
                HashMap<String, Object> map = new HashMap<>();
                object.put("order_id",jsonObject.getString("request_no"));
                object.put("trade_order_id",jsonObject.getString("trade_no"));
                baseResult=new BaseResult(200, response.getResult().getMsg()+","+response.getResult().getSubMsg(), JSON.parseObject(object!=null?object.toString():null));
            }else{
                baseResult=new BaseResult(500, response.getResult().getMsg()+","+response.getResult().getSubMsg(), JSON.parseObject(response.getBody()!=null?response.getBody().toString():null));
            }
            String sqlCommand="update IT_REGISTER_RECORD set REGISTER_STATUS=? where REGISTER_ID=?";
            sqlSrv.setLangId("sc");
            sqlSrv.addParameter("1");
            sqlSrv.addParameter(jsonObject.getString("request_no"));
            sqlSrv.execute(sqlCommand);
        }catch (Exception e) {
            e.printStackTrace();
            return baseResult;
        }
        System.out.println("结束执行预支付方法-----------------------------");
        return baseResult;
    }

    public String getHeader(String interfaceId){
        HashMap<String, String> headMap = new HashMap<>();
        headMap.put("charset",  "utf-8");
        headMap.put("encrypt_type", "AES");
        headMap.put("enterprise_id",  "yqjkzhyy");
        headMap.put("language", "zh_CN");
        headMap.put("method", interfaceId);
        headMap.put("timestamp", System.currentTimeMillis() + "");
        headMap.put("sign_type",  "md5");
        headMap.put("sys_track_code", String.valueOf(System.currentTimeMillis()));
        headMap.put("version",  "1.0");
        headMap.put("access_token", "");
        headMap.put("sign", "");
        headMap.put("app_id",  "b11a72077d9743369f9812c7cab193e6");
        final String headJson = JSONParser.fromObject(headMap);
        return headJson;
    }
}
