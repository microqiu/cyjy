package com.linfeiyang.shop.bean;

import com.linfeiyang.shop.common.GsonUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.List;

@Slf4j
public class ResultListBean<T> implements Serializable {

    private static final long serialVersionUID = -6058508022120154076L;

    private Integer code; //代码

    private String message; //信息

    private List<T> data; //列表数据

    private Long totalCount; //总数量

    private Long currPage; //当前页数

    private Long pageSize; //每页数量

    private Long systemTime; //系统时间

    public ResultListBean(Integer code, String message, List<T> data, Long totalCount, Long currPage, Long pageSize) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.currPage = currPage;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.systemTime = System.currentTimeMillis();
    }

    public ResultListBean(Integer code, String message, List<T> data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.systemTime = System.currentTimeMillis();
        log.info(GsonUtils.toJson(this));
    }

    public static<T> ResultListBean<T> ok(List<T> data, String... message) {
        return new ResultListBean<>(200, message.length > 0 ? message[0] : "", data);
    }

    public ResultListBean(){
        this.systemTime = System.currentTimeMillis();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message == null ? "ok" : message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Long getCurrPage() {
        return currPage;
    }

    public void setCurrPage(Long currPage) {
        this.currPage = currPage;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public Long getSystemTime() {
        return systemTime;
    }

    public void setSystemTime(Long systemTime) {
        this.systemTime = systemTime;
    }
}
