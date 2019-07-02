package com.demo.entity;

import java.util.Date;

/**
 * @Description:
 * @Author: Po Lam
 * @Date: 2019/6/24 9:24
 */
public class Article {

    private int id;
    private String title;
    private String summary;
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
