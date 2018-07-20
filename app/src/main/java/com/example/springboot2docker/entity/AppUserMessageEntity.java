package com.example.springboot2docker.entity;

import java.util.Date;

/**
 * @Author: wujiapeng
 * @Description:
 * @Date: created in 19:31 2018/7/19
 */
public class AppUserMessageEntity {

    private String id;

    private String message;

    private Date senddate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getSenddate() {
        return senddate;
    }

    public void setSenddate(Date senddate) {
        this.senddate = senddate;
    }

    @Override
    public String toString() {
        return "AppUserMessageEntity{" +
                "id='" + id + '\'' +
                ", message='" + message + '\'' +
                ", senddate=" + senddate +
                '}';
    }
}
