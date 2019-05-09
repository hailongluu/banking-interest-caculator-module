/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author hailongluu
 */
public class DateTimeFomater {
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) {

//        System.out.println(DateTimeFomater.getDays("2018-03-25", "2019-04-01"));
//        getEndDate(1);
//        getEndDate(2);
//        getEndDate(3);
//        getEndDate(5);
//        getEndDate(6);
//        getEndDate(8);
//        getEndDate(9);
//        getEndDate(11);
//        getEndDate(12);
//        getEndDate(16);
//        getEndDate(18);
//        getEndDate(20);
//        getEndDate(24);
//        getEndDate(30);
//        getEndDate(36);
//        System.out.println(String.format("%,d", 1000000000));
        System.out.println(getDays("2018-03-01","2019-04-16"));

    }

    public DateTimeFomater() {
    }

    public static String convertDateToString(Date date) {
        return sdf.format(date);
    }

    public static Date convertStringToDate(String s) {
        try {
            return sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getEndDate(int term) {
        int days = term * 30;
        Date startDate = convertStringToDate("2018-03-01");
        String endDateString;
        Date endDate;
        long diff = (long) days * (1000 * 60 * 60 * 24);
        long range = (long) 1 * (1000 * 60 * 60 * 24);
        long endDateNum;

        // đáo hạn sớm
        endDateNum = startDate.getTime() - range + diff;
        endDate = new Date(endDateNum - range);
        endDateString = convertDateToString(endDate);
        System.out.println(endDateString);
//        System.out.println(getDays("2018-03-01",endDateString));

        // đáo hạn đúng ngày
        endDateNum = diff + startDate.getTime();
        endDate = new Date(endDateNum);
        endDateString = convertDateToString(endDate);
        System.out.println(endDateString);
//        System.out.println(getDays("2018-03-01",endDateString));

        //đáo hạn quá ngày chưa đủ kì hạn
        endDateNum = diff + startDate.getTime() + range;
        endDate = new Date(endDateNum);
        endDateString = convertDateToString(endDate);
        System.out.println(endDateString);
//        System.out.println(getDays("2018-03-01",endDateString));

        //đáo hạn khi trải qua 2 kì hạn
        endDateNum = diff * 2 + startDate.getTime();
        endDate = new Date(endDateNum);
        endDateString = convertDateToString(endDate);
        System.out.println(endDateString);
//        System.out.println(getDays("2018-03-01",endDateString));

        // đáo hạn khi trải qua 2 kì hạn nhưng chưa sang kì mới
        endDateNum = diff * 2 + startDate.getTime() + range;
        endDate = new Date(endDateNum);
        endDateString = convertDateToString(endDate);
        System.out.println(endDateString);
//        System.out.println(getDays("2018-03-01",endDateString));


        return convertDateToString(endDate);
    }


    public static long getDays(String start, String end) {
        Date startDate = convertStringToDate(start);
        Date endDate = convertStringToDate(end);
        long diff = endDate.getTime() - startDate.getTime();
        return (long) diff / (1000 * 60 * 60 * 24);
    }

    public static Date getCurrentDate() {
        return DateTimeFomater.convertStringToDate(DateTimeFomater.convertDateToString(new Date()));
    }

}
