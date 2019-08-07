package com.demo.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.FastDateFormat;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static final String PATTERN_DATE_TIME = "yyyy-MM-dd HH:mm:ss";

    private static final String PATTERN_DATE_TIME_SIMPLY = "yyyyMMddHHmmss";

    public static final String PATTERN_DATE_TIME_MS = "yyyy-MM-dd HH:mm:ss.SSS";

    public static final String PATTERN_DATE_TIME_MS_Z = "yyyy-MM-dd HH:mm:ss.SSSZ";

    public static final String PATTERN_DATE_TIME_MS_UTC = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    public static final String PATTERN_DATE_MINUTE = "yyyy-MM-dd HH:mm";

    public static final String PATTERN_DATE = "yyyy-MM-dd";

    public static final String PATTERN_DATE_F = "yyyyMMdd";

    public static final String PATTERN_TIME_F = "HHmmssSSS";

    public static final String PATTERN_DATE_YYYY_MM = "yyyy-MM";

    public static final String PATTERN_DATE_YYMM = "yyMM";

    public static final String PATTERN_DATE_YYYY = "yyyy";

    public static final String PATTERN_DATE_CALENDAR = "yyyy年MM月dd日";

    public static final String PATTERN_DATE_YYYY_MM_DD = "yyyy/MM/dd";

    public static final String PATTERN_DATE_YYYY_MM_DD_HH = "yyyy/MM/dd HH:mm:ss";
    public static Date parse(String param)throws ParseException,IllegalAccessException{

        Field[] declaredFields = DateUtils.class.getDeclaredFields();
        for (int i=0;i<declaredFields.length;i++){
            if(param.equals(declaredFields[i].get(declaredFields[i].getName()).toString())){
                return FastDateFormat.getInstance(PATTERN_DATE_TIME).parse(param);
            }
        }
        return FastDateFormat.getInstance(PATTERN_DATE_TIME).parse(param);

    }

    public static void main(String[] args)throws Exception {
       p("qw","ff");

    }

    public static Date parses(String v){
        if(v.trim().length()<19){
            v=v.trim()+" 00:00:00";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date parse = sdf.parse(v.replace("/", "-"));
            return parse;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String p(String... v){
        System.out.println(v.length);
        for(String item:v){
            System.out.println(item);
        }
        return "";
    }


}
