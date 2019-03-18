package com.demo.config;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 发送邮件列表
 * @Author: Po Lam
 * @Date: 2019/3/15 13:26
 */
public class MailConfig {
    /**
     * 接收邮件的邮箱地址
     */
    private static String mail1="954618447@qq.com";
    private static String mail2="1693324674@qq.com";

    /**
     * 发送邮件的账号
     * 发件人的 邮箱 和 密码
     * 有的密码需要设置为授权码
     * 某些邮箱服务器为了增加邮箱本身密码的安全性，给 SMTP 客户端设置了独立密码（有的邮箱称为“授权码”）
     */
    public static String myEmailAccount = "a1693324674@163.com";
    public static String myEmailPassword = "XXXXXX";
    /**
     * 发件人邮箱的 SMTP 服务器地址, 必须准确, 不同邮件服务器地址不同, 一般(只是一般, 绝非绝对)格式为: smtp.xxx.com
     * 网易163邮箱的 SMTP 服务器地址为: smtp.163.com
     * qq邮箱   smtp.qq.com
     */
    public static String myEmailSMTPHost = "smtp.163.com";


    private static List<String> mailList = new ArrayList<>();

    /**
     * 获取发送邮件的邮箱列表
     * @return
     */
    public static List<String> getMailList() {
        mailList.add(mail1);
        mailList.add(mail2);
        return mailList;
    }

    public static String getMail1() {
        return mail1;
    }

    public static void setMail1(String mail1) {
        MailConfig.mail1 = mail1;
    }

    public static String getMail2() {
        return mail2;
    }

    public static void setMail2(String mail2) {
        MailConfig.mail2 = mail2;
    }
}
