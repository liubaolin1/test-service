package com.demo.common;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Author: Po Lam
 * @Date: 2019/3/8 15:37
 */
public class RegxUtils {
    /**
     * 去除html标签
     */
    private static String regxpForHtml="<([^>]*)>";
    /**
     * 去除尖括号注释
     */
    private static String regxpForHtml2="<!--[\\s\\S]*-->";
    /**
     * 去掉js代码
     */
    private static String rex = "<script\\b[^<]*(?:(?!<\\/script>)<[^<]*)*<\\/script>";

    public static String getNewString(String s){
        Pattern compile = Pattern.compile(regxpForHtml);
        Matcher matcher = compile.matcher(s);

        StringBuffer sb = new StringBuffer();
        boolean result1 = matcher.find();
        while (result1){
            matcher.appendReplacement(sb,"");
            result1=matcher.find();
        }
        matcher.appendTail(sb);
        if(StringUtils.isEmpty(sb)){
           return s;
        }
        String sb2 = "";
        sb2 = sb.toString();
        return sb2;
    }

    private static String getNewString2(String s){
        Pattern compile = Pattern.compile(regxpForHtml2);
        Matcher matcher = compile.matcher(s);

        StringBuffer sb = new StringBuffer();
        boolean result1 = matcher.find();
        while (result1){
            matcher.appendReplacement(sb,"");
            result1=matcher.find();
        }
        matcher.appendTail(sb);
        if(StringUtils.isEmpty(sb)){
            return s;
        }
        return sb.toString();
    }
    public static String getNewString3(String s){
        Pattern compile = Pattern.compile(rex);
        Matcher matcher = compile.matcher(s);

        StringBuffer sb = new StringBuffer();
        boolean result1 = matcher.find();
        while (result1){
            matcher.appendReplacement(sb,"");
            result1=matcher.find();
        }
        matcher.appendTail(sb);
        if(StringUtils.isEmpty(sb)){
            return s;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String c = "<td align=\"center\" class=\"title\" height=\"30\" style=\"padding:10px\"> <!--<$[标题名称(html)]>begin-->关于常山县辉埠新区燃煤热电联产建设等二个项目（噪声、固废部分）受理的公示 <!--<$[标题名称(html)]>end--></td>";
        System.out.println(getNewString(c));

    }

}
