package com.demo.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

/**
 * @Description:
 * @Author: Po Lam
 * @Date: 2019/3/13 15:43
 */
public class DateUtils {
    /**
     * 今天的日期
     * @return
     */
    public static String getDateValue(){
        String year= LocalDate.now().getYear()+"年";
        String month=LocalDate.now().getMonthValue()+"月";
        String day=LocalDate.now().getDayOfMonth()+"日";
        return year+month+day;
    }

    /**
     * 将yyyy年MM月dd日 转换成毫秒
     * @return
     */
    public static long dateConverter(String date){
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
            long time = sdf.parse(date).getTime();
            return time;
        }catch (ParseException e){
            return 0;
        }


    }
}
