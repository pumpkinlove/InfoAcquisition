package com.pump.ia.domain;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/8/25 0025.
 */
public class Notification implements Serializable {

    private String id;
    private String content;
    private String time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
