package com.demo.cache;

/**
 * @Description:
 * @Author: Po Lam
 * @Date: 2019/3/13 15:39
 */
public class News {
    /**
     * 标题
     */
    private String title;
    /**
     * 正文部分
     */
    private String body;
    /**
     * 发布日期时间戳
     */
    private long timestamp;

    public News(String title, String body, long timestamp) {
        this.title = title;
        this.body = body;
        this.timestamp = timestamp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
