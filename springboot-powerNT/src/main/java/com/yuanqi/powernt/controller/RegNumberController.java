package com.yuanqi.powernt.controller;

import com.alibaba.fastjson.JSONObject;
import com.yuanqi.powernt.dao.RegNumberDao;
import com.yuanqi.powernt.model.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("RegNumber")
@Controller
public class RegNumberController {

    @Autowired
    private RegNumberDao regNumberDao;

    @RequestMapping("/request")
    @ResponseBody
    public BaseResult request(@RequestBody Object object,@RequestHeader String interfaceId) throws Exception{
        final BaseResult result = regNumberDao.request(object,interfaceId);
        System.out.println("执行结果："+ JSONObject.toJSON(result));
        return result;
    }

    /**
     * 获取科室列表
     * @param object
     * @return
     */
    @RequestMapping("/getRegDeptmentList")
    @ResponseBody
    public BaseResult getRegDeptmentList(@RequestBody Object object,@RequestHeader String interfaceId) throws Exception{
        final BaseResult result = regNumberDao.getRegDeptmentList(object,interfaceId);
        return result;
    }

    /**
     * 获取医生和排班
     * @param object
     * @return
     */
    @RequestMapping("/getRegDoctorList")
    @ResponseBody
    public BaseResult getRegDoctorList(@RequestBody Object object,@RequestHeader String interfaceId){
        final BaseResult result = regNumberDao.getRegDoctorList(object,interfaceId);
        return result;
    }


    /**
     * 创建订单
     * @param object
     * @return
     */
    @RequestMapping("/createRegOrder")
    @ResponseBody
    public BaseResult createRegOrder(@RequestBody Object object,@RequestHeader String interfaceId){
        final BaseResult result = regNumberDao.createRegOrder(object,interfaceId);
        return result;
    }


    /**
     * 预支付
     * @param object
     * @return
     */
    @RequestMapping(value = "/prepay",method = RequestMethod.POST)
    @ResponseBody
    public BaseResult prepay(@RequestBody Object object,@RequestHeader String interfaceId){
        final BaseResult result = regNumberDao.prepay(object,interfaceId);
        return result;
    }


    /**
     * 确认订单
     * @param object
     * @return
     */
    @RequestMapping("/createInHosOrder")
    @ResponseBody
    public BaseResult createInHosOrder(@RequestBody Object object,@RequestHeader String interfaceId){
        final BaseResult result = regNumberDao.confirmRegOrder(object,interfaceId);
        return result;
    }

}
