package com.example.demo.bean;

import java.util.Map;

/**
 * @author xiaojie.Ma
 * Created by xiaojie.Ma on 2018/4/11.
 */
public class UserInfo {

    private Integer code;
    private String msg;
    private Map<String,Object> data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
