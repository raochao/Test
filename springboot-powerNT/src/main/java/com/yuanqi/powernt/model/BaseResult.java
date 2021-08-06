package com.yuanqi.powernt.model;

import java.io.Serializable;

/**
 * @ClassName: BaseResult
 * @Description:
 * @see:
 * @Date: 2021-7-30#10:57
 * @WEEK: 星期五
 * @Author: crain_yz
 * @email: 1145122969@qq.com
 * @words: Coding and Funny
 **/
public class BaseResult<T> implements Serializable {

    private static final long serialVersionUID = 3863559687276427577L;

    private int code;
    private String msg;
    private T data;

    public BaseResult() {
        super();
    }

    public BaseResult(int code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    public static BaseResult ok(Object data){

        return new BaseResult(200,"操作成功", data);
    }

    public static BaseResult ok(String msg, Object data){

        return new BaseResult(200, msg, data);
    }

    public static BaseResult fail(int code, String msg, Object data){

        return new BaseResult(code, msg, data);
    }

    public static BaseResult fail(String msg, Object data){

        return new BaseResult(9999, msg, data);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
