package com.demo.Encrypt;

import org.apache.http.util.TextUtils;

import java.security.MessageDigest;

/**
 * @Description:
 * @Author: Po Lam
 * @Date: 2019/4/10 8:55
 */
public class MD5Utils {

    /**
     * MD5加密
     * @param string
     * @return
     */
    public static String md5(String string) {
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(string.getBytes("utf-8"));
            String result = "";
            for (byte b : bytes) {
                String temp = Integer.toHexString(b & 0xff);
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                result += temp;
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(md5("金额=1_目标账户=1234_Key=ABCD"));
    }
}
