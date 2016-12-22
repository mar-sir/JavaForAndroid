package com.example;

import java.util.Calendar;

/**
 * Created by huangcl on 2016/12/21.
 */

public class Demo4 {
    public static void main(String[] args) {

        // 获取日历对象
        Calendar cal = Calendar.getInstance();

        int year = cal.get(Calendar.YEAR);// 获取年
        int month = cal.get(Calendar.MONTH); // 获取月份
        int day = cal.get(Calendar.DAY_OF_MONTH);// 日

        int hour = cal.get(Calendar.HOUR_OF_DAY); // 24小时
        int minute = cal.get(Calendar.MINUTE);// 分钟
        int second = cal.get(Calendar.SECOND);

        int week = cal.get(Calendar.DAY_OF_WEEK);//星期（1~7，1：周日，7：周六）


        System.out.println(String.format("%d-%d-%d %d:%d:%d", year, month + 1,
                day, hour, minute, second));
        System.out.println("================================");
        String[] wName = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        System.out.println(wName[week - 1] + "," + week);
        System.out.println("================================");
        cal.set(Calendar.MONTH, 12 - 1);//12月份

        //查看每一个月中的天数
        for (int i = 1; i <= cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            cal.set(Calendar.DAY_OF_MONTH, i);

            week = cal.get(Calendar.DAY_OF_WEEK);
            System.out.println(wName[week - 1] + "," + week + "," + (i) + "号");
        }

    }
}
