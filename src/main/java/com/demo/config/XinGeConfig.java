package com.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @Description: 配置文件的值映射到实体字段demo 由于交给了spring管理 所以自动注入时候才生效
 * @Author: Po Lam
 * @Date: 2019/6/17 8:55
 */
@Component
@ConfigurationProperties(prefix="xinge")
public class XinGeConfig implements Serializable{
    private boolean xingeOpen;
    private String xingeAccessId;
    private String xingeServerkey;

    public boolean getXingeOpen() {
        return xingeOpen;
    }

    public void setXingeOpen(boolean xingeOpen) {
        this.xingeOpen = xingeOpen;
    }

    public String getXingeAccessId() {
        return xingeAccessId;
    }

    public void setXingeAccessId(String xingeAccessId) {
        this.xingeAccessId = xingeAccessId;
    }

    public String getXingeServerkey() {
        return xingeServerkey;
    }

    public void setXingeServerkey(String xingeServerkey) {
        this.xingeServerkey = xingeServerkey;
    }

    @Override
    public String toString() {
        return "XinGeConfig{" +
                "xingeOpen='" + xingeOpen + '\'' +
                ", xingeAccessId='" + xingeAccessId + '\'' +
                ", xingeServerkey='" + xingeServerkey + '\'' +
                '}';
    }
}
