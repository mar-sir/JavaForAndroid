package com.example;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Date类
 */
public class Demo1 {
    public static void main(String[] args) {
        Date date = new Date();//获取当前的时间
        System.out.println(date.toString());
        long time = date.getTime();
        Date d2 = new Date(time);
        System.out.println(d2.toString()); //获取Long类型的时期值
        //使用定义好的日期格式化工具类
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);//获取日期的格式化对象
        DateFormat dtf = DateFormat.getDateTimeInstance();//获取日期和时间格式化对象
        System.out.println(df.format(date));
        System.out.println(dtf.format(date));
        try {
            Date d3 = df.parse("17-07-19");
            System.out.println(d3.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //自定义格式化日期或时间
        //注：月 MM,分钟：mm,ss: 秒,SSS:毫秒
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        System.out.println(sdf.format(date));
    }
}
