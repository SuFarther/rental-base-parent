package com.company.utils;

import org.apache.commons.lang.time.DateFormatUtils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName DateUtils
 * @company 公司
 * @Description TODO
 * @createTime 2022年07月16日 14:00:00
 */
public class DateUtils extends org.apache.commons.lang.time.DateUtils {
    private static String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd）
     */
    public static String getDate() {
        return getDate("yyyy-MM-dd");
    }

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String getDate(String pattern) {
        return DateFormatUtils.format(new Date(), pattern);
    }

    /**
     * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String formatDate(Date date, Object... pattern) {
        String formatDate = null;
        if (pattern != null && pattern.length > 0) {
            formatDate = DateFormatUtils.format(date, pattern[0].toString());
        } else {
            formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
        }
        return formatDate;
    }

    /**
     * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String formatDateTime(Date date) {
        return formatDate(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 得到当前时间字符串 格式（HH:mm:ss）
     */
    public static String getTime() {
        return formatDate(new Date(), "HH:mm:ss");
    }

    /**
     * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String getDateTime() {
        return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 得到当前年份字符串 格式（yyyy）
     */
    public static String getYear() {
        return formatDate(new Date(), "yyyy");
    }

    /**
     * 得到当前月份字符串 格式（MM）
     */
    public static String getMonth() {
        return formatDate(new Date(), "MM");
    }

    /**
     * 得到当天字符串 格式（dd）
     */
    public static String getDay() {
        return formatDate(new Date(), "dd");
    }

    /**
     * 得到当前星期字符串 格式（E）星期几
     */
    public static String getWeek() {
        return formatDate(new Date(), "E");
    }

    /**
     * 日期型字符串转化为日期 格式
     * { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
     * "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm",
     * "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm" }
     */
    public static Date parseDate(Object str) {
        if (str == null) {
            return null;
        }
        try {
            return parseDate(str.toString(), parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 把毫秒转为日期
     *
     * @param millisecond
     * @return
     */
    public static Date parseDate(Long millisecond) {
        return new Date(millisecond);
    }

    /**
     * 把毫秒转为 日期字符串
     * yyyy-MM-dd hh:mm:ss SSS a
     * yyyy/MM/dd hh:mm:ss SSS a
     *
     * @param millisecond
     * @return
     */
    public static String parseDateStr(Long millisecond, String pattern) {

        Date date = new Date(millisecond);
        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss SSS a");
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        //System.out.println("毫秒[1483159625851]对应日期时间字符串：" + format.format(date));
        return format.format(date);
    }

    /**
     * 把毫秒转为 日期字符串
     *
     * @param millisecond
     * @return yyyy-MM-dd hh:mm:ss SSS a
     */
    public static String parseDateStr(Long millisecond) {

        Date date = new Date(millisecond);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss SSS");
        //System.out.println("毫秒[1483159625851]对应日期时间字符串：" + format.format(date));
        return format.format(date);
    }

    /**
     * 把Date转为毫秒
     *
     * @param date
     * @return
     */
    public static long parseDateToMillisecond(Date date) {
        return date.getTime();
    }

    /**
     * 把Day转为毫秒
     *
     * @param day
     * @return
     */
    public static long parseDayToMillisecond(Integer day) {
        return 24*60*60*1000*day;
    }

    /**
     * 获取过去的天数
     *
     * @param date
     * @return
     */
    public static long pastDays(Date date) {
        long t = System.currentTimeMillis() - date.getTime();
        return t / (24 * 60 * 60 * 1000);
    }

    /**
     * 获取过去的小时
     *
     * @param date
     * @return
     */
    public static long pastHour(Date date) {
        long t = System.currentTimeMillis() - date.getTime();
        return t / (60 * 60 * 1000);
    }

    /**
     * 获取过去的分钟
     *
     * @param date
     * @return
     */
    public static long pastMinutes(Date date) {
        long t = System.currentTimeMillis() - date.getTime();
        return t / (60 * 1000);
    }

    /**
     * 转换为时间（天,时:分:秒.毫秒）
     *
     * @param timeMillis
     * @return
     */
    public static String formatDateTime(long timeMillis) {
        long day = timeMillis / (24 * 60 * 60 * 1000);
        long hour = (timeMillis / (60 * 60 * 1000) - day * 24);
        long min = ((timeMillis / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (timeMillis / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        long sss = (timeMillis - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000 - min * 60 * 1000 - s * 1000);
        return (day > 0 ? day + "," : "") + hour + ":" + min + ":" + s + "." + sss;
    }

    /**
     * 获取当前月份前的12个月份中指定月份
     * @param i 【0 - 12】
     * @return
     */
    public static String getLastMonths(int i) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, -i);
        Date m = c.getTime();
        return sdf.format(m);
    }

    /**
     * 获取下周指定星期几的时间
     * @param day
     * @return
     */
    public static Date caclNextWeekDay(Date time, Integer day) throws ParseException {

        //根据指定时间增加几天，找到对应的这一天的时间
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        cal.add(Calendar.DATE, day);
        return cal.getTime();
    }

    /**
     * 检查本周内，传入的星期是否在当日之前
     * @param day
     * @return
     * @throws ParseException
     */
    public static Date parseDayToDate(Integer day) throws ParseException {
        //获取本周指定的星期（day）的当前时分秒的这一天是几月几号
        String times = DateUtils.geWeek(day);
        Date date = DateUtils.formDate(times);

        return date;
    }


    /**
     * 判断收花日 - 当前时间是否 >= 3
     * @param nowTime
     * @param receiveTime
     * @param diffDay
     * @return 大于返回true,否则返回false
     */
    public static boolean checkDiffDay(Date nowTime, Date receiveTime, Integer diffDay) {

        String nowtime = formatDateTime(nowTime);
        System.out.println("nowtime: "+ nowtime);
        String receivetime = formatDateTime(receiveTime);
        System.out.println("receiveTime: "+ receivetime);


        //当前时间毫秒
        long nowMi = DateUtils.parseDateToMillisecond(nowTime);

        long receiveMi = DateUtils.parseDateToMillisecond(receiveTime);

        long diffMi = DateUtils.parseDayToMillisecond(diffDay);

        return receiveMi - nowMi >= diffMi ? true : false;
    }

    /**
     * 获取两个日期之间的天数
     *
     * @param before
     * @param after
     * @return
     */
    public static double getDistanceOfTwoDate(Date before, Date after) {
        long beforeTime = before.getTime();
        long afterTime = after.getTime();
        return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
    }
    public static long getDistanceOfTwoDatelong(Date before, Date after) {
        long beforeTime = before.getTime();
        long afterTime = after.getTime();
        return (afterTime - beforeTime);
    }

    /**
     * @param args
     * @throws ParseException
     */
    public static void main(String[] args) throws ParseException {

        long millisecond = System.currentTimeMillis() + 86400000;
        Date date = new Date(millisecond);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss SSS");
        System.out.println("毫秒[1483159625851]对应日期时间字符串：" + format.format(date));


        System.out.println(formatDate(parseDate("2010/3/6")));
        System.out.println(getDate("yyyy年MM月dd日 E"));
        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis() + 86400000);
        System.out.println(formatDateTime(System.currentTimeMillis() + 86400000));
        long time = System.currentTimeMillis() - parseDate("2012-11-19").getTime();
        System.out.println(time / (24 * 60 * 60 * 1000));
    }
    /**
     * 输入星期数字，得到本周该星期的具体时间
     *
     * @return yyyy-MM-dd
     */
    public static String geWeek(int weekday) {
        Calendar c = Calendar.getInstance();
        int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0) {
            day_of_week = 7;
        }
        c.add(Calendar.DATE, -day_of_week + weekday);
        return FormatString(c.getTime());
    }
    /**
     * 下周时间
     * @param date
     * @return
     */
    public static String getNextWeekMonday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, 7);
        return FormatString(cal.getTime());
    }
    public static String FormatString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = sdf.format(date);
        return dateString;
    }
    public static SimpleDateFormat formSDF() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
    public static Date formDate(String time) throws ParseException {
        return formSDF().parse(time);
    }
    public static int weekDay(){
        Calendar c = Calendar.getInstance();
        int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0) {
            day_of_week = 7;
        }
        return day_of_week;
    }
    public static int getTimeDistance(Date beginDate , Date endDate) {
        Calendar beginCalendar = Calendar.getInstance();
        beginCalendar.setTime(beginDate);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(endDate);
        long beginTime = beginCalendar.getTime().getTime();
        long endTime = endCalendar.getTime().getTime();
        /**
         * 先算出两时间的毫秒数之差大于一天的天数
         */
        int betweenDays = (int) ((endTime - beginTime) / (1000 * 60 * 60 * 24));
        /**
         * 使endCalendar减去这些天数，将问题转换为两时间的毫秒数之差不足一天的情况
         */
        endCalendar.add(Calendar.DAY_OF_MONTH, -betweenDays);
        /**
         * 再使endCalendar减去1天
         */
        endCalendar.add(Calendar.DAY_OF_MONTH, -1);
        /**
         * 比较两日期的DAY_OF_MONTH是否相等
         */
        if (beginCalendar.get(Calendar.DAY_OF_MONTH) == endCalendar.get(Calendar.DAY_OF_MONTH)) {
            /**
             * 相等说明确实跨天了
             */
            return betweenDays + 1;
        }else {
            /**
             * 不相等说明确实未跨天
             */
            return betweenDays + 0;
        }
    }
}