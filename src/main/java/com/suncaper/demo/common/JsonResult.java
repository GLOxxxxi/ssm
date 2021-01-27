package com.suncaper.demo.common;

public class JsonResult <T>{
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private Integer code;
    private T data;



    public  static JsonResult ok(Object data){
        return new JsonResult(200,data);
    }
    public JsonResult(Integer code,T data){
        this.code=code;
        this.data=data;
    }

}
