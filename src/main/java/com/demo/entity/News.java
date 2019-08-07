package com.demo.entity;
import java.util.Date;


public class News {

    private Long id;

    private String title;

    private String biz_platform;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBiz_platform() {
        return biz_platform;
    }

    public void setBiz_platform(String biz_platform) {
        this.biz_platform = biz_platform;
    }
}