package com.pump.ia.domain;

import com.google.gson.Gson;
import com.pump.ia.domain.web.Page;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xu.nan on 2016/8/27.
 */
public class ResponseEntity<T> implements Serializable {
    private String code;
    private String message;
    private T data;
    private List<T> listData;
    private Page<T> pageData;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Page<T> getPageData() {
        return pageData;
    }

    public void setPageData(Page<T> pageData) {
        this.pageData = pageData;
    }

    public List<T> getListData() {
        return listData;
    }

    public void setListData(List<T> listData) {
        this.listData = listData;
    }
}
