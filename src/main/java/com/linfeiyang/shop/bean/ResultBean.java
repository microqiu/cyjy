package com.linfeiyang.shop.bean;

import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Date;

@Component
public class ResultBean<T> implements Serializable {

    @Resource
    private Gson gson;

    private static final Logger log = LoggerFactory.getLogger(ResultBean.class);
    private static final long serialVersionUID = -5018424384556350415L;
    private int code;
    private String message;
    private long systemTime;
    private T data;

    public long getSystemTime() {
        return this.systemTime;
    }

    public void setSystemTime(long systemTime) {
        this.systemTime = systemTime;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String msg) {
        this.message = msg;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResultBean() {
        this.code = 400;
        this.systemTime = (new Date()).getTime();
    }

    public ResultBean(int code, String message, T data) {
        this.data = data;
        this.code = code;
        this.message = message;
        if (this.code == 200 && StringUtils.isBlank(this.message)) {
            this.message = "";
        }

        this.systemTime = (new Date()).getTime();
        log.info("out result:" + new Gson().toJson(this));
    }

    public boolean ok() {
        return this.code == 200;
    }

    public boolean notOk() {
        return this.code != 200;
    }

    public static <T> ResultBean<T> booleanResult(boolean booleanResult, String... falseReason) {
        return booleanResult ? new ResultBean<>(200, "", null) : new ResultBean<>(400, falseReason.length > 0 ? falseReason[0] : "", null);
    }

    public static <T> ResultBean<T> ok(T data, String... message) {
        return new ResultBean<>(200, message.length > 0 ? message[0] : "", data);
    }

    public static <T> ResultBean<T> error(String message) {
        return new ResultBean<>(400, message, null);
    }

    public String toString() {
        return "ResultBean" + new Gson().toJson(this);
    }
}