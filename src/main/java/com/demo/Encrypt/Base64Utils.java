package com.demo.Encrypt;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * @Description:
 * @Author: Po Lam
 * @Date: 2019/4/10 9:13
 */
public class Base64Utils {
    /**
     * 加密
     * @param s
     * @return
     */
    public static String base64Encode(String s){
        try {
            String asB64 = Base64.getEncoder().encodeToString(s.getBytes("utf-8"));
            System.out.println(asB64);
            return asB64;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }

    }

    /**
     * 解密
     * @param s
     * @return
     */
    public static String base64Decode(String s){
        try {
            byte[] asBytes = Base64.getDecoder().decode(s);
            String asb64=new String(asBytes, "utf-8");
            System.out.println(asb64);
            return asb64;
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
            return "";
        }
    }

    public static void main(String[] args) {
        String t = "滴滴出行：17603228330  ceuahssw_1" +
                "百度 17603228330 iwajlkasn_2" +
                "";
        String a = base64Encode("iwajlkasn_2");
        base64Decode(a);
    }
}
