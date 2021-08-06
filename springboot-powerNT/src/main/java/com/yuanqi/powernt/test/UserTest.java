package com.yuanqi.powernt.test;

import com.ctc.wstx.util.StringUtil;
import com.yuanqi.powernt.dao.UserDao;
import com.yuanqi.powernt.model.UserInfo;
import org.junit.Before;
import org.junit.Test;
import orgine.powermop.api.gateway.sdk.ApiExecute;
import orgine.powermop.api.gateway.sdk.info.BusinessCallRequest;
import orgine.powermop.api.gateway.sdk.info.BusinessCallResponse;
import orgine.powermop.api.gateway.sdk.info.Result;
import pnbclient.util.JSONParser;

import java.util.HashMap;
import java.util.List;

public class UserTest {

    UserDao userDao = null;

    @Before
    public void init() {
        userDao = new UserDao();
    }

    /**
     * 获取用户信息列表
     */
//    @Test
//    public void getAllUser(){
//        final List list = userDao.getAllUser();
//        if(list!=null&&list.size()>0){
//            list.forEach(item->{
//                UserInfo user= (UserInfo)item;
//                System.out.println(user.getUsername());
//            });
//        }
//    }

    /**
     * 根据userid获取用户信息
     */
//    @Test
//    public void getUserById() {
//        final List list = userDao.getUserById("admin");
//        if(list!=null&&list.size()>0){
//            list.forEach(item->{
//                UserInfo user= (UserInfo)item;
//                System.out.println(user.getUsername());
//            });
//        }
//    }


    /**
     * 使用别名的方式：添加用户
     */
//    @Test
//    public void addUser(){
//        userDao.addUser();
//    }

    /**
     * 别名方式：批量添加操作
     */
//    @Test
//    public void batchAddUser(){
//        userDao.batchAddUser();
//    }

    /**
     * sql方式：添加用户信息
     */
//    @Test
//    public void addUserBySql(){
//        userDao.addUserBySql();
//
//    }

//    @Test
//    public void getListPage(){
//        final List list = userDao.getListPage();
//        if(list!=null&&list.size()>0){
//            list.forEach(item->{
//                UserInfo user= (UserInfo)item;
//                System.out.println(user.getUsername());
//            });
//        }
//    }

    @Test
    public void test(){

            String head=getHeadJson();
            String body="{ \"info\": {\n" +
                    "\t\t\t\"deptment_area\": \"2909\",\n" +
                    "\t\t\t\"parent_deptment_code\": \"1\",\n" +
                    "\t\t\t\"extend_params\": null,\n" +
                    "\t\t\t\"deptment_code\": null,\n" +
                    "\t\t\t\"time_interval\": null,\n" +
                    "\t\t\t\"patient_id\": \"8000003997\",\n" +
                    "\t\t\t\"id_card\": \"360124199410200312\",\n" +
                    "\t\t\t\"birthday\": null,\n" +
                    "\t\t\t\"category_mark\": null,\n" +
                    "\t\t\t\"level\": 1,\n" +
                    "\t\t\t\"operator\": null,\n" +
                    "\t\t\t\"input_name\": null,\n" +
                    "\t\t\t\"sex\": null\n" +
                    "\t\t}," +
                    "\"pagein\": {\n" +
                    "\t\t\t\"rowsperpage\": 20,\n" +
                    "\t\t\t\"pageaction\": \"Topage\",\n" +
                    "\t\t\t\"topagenum\": 1,\n" +
                    "\t\t\t\"currentpagenum\": 1\n" +
                    "\t\t} }";

            try {
            ApiExecute apiExecute = ApiExecute.newBuilder().publicKey("0xy3i51rzlZsZbhcDjfcHQ==").
                    url("http://220.249.79.58:61117/orgine/powermsp/service/overt")
                    .isEncrypt(false)
                    .build();
            BusinessCallRequest request = new BusinessCallRequest(head, body);
            BusinessCallResponse response = apiExecute.businessCall(request);
            Result result = response.getResult();
            System.out.println(result);
            } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String getHeadJson() {
        String headJson = "";
        try {
            HashMap<String, String> headMap = new HashMap<>();
            headMap.put("charset",  "utf-8");
            headMap.put("encrypt_type", "AES");
            headMap.put("enterprise_id",  "orgine");
            headMap.put("language", "zh_CN");
            headMap.put("method", "orgine.powermsp.service.overt.register.getRegDeptmentList");
            headMap.put("timestamp", System.currentTimeMillis() + "");
            headMap.put("sign_type",  "md5");
            headMap.put("sys_track_code", String.valueOf(System.currentTimeMillis()));
            headMap.put("version",  "1.0");
            headMap.put("access_token", "");
            headMap.put("sign", "");
            headMap.put("app_id",  "22cc577ecb6a4b8b990c25b92e9c5e99");
            headJson = JSONParser.fromObject(headMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return headJson;
    }

}