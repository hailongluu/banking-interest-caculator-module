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
 *
 * @author hailongluu
 */
public class DateTimeFomater {
    SimpleDateFormat sdf ;

    public static void main(String[] args) {
        DateTimeFomater dtf = new DateTimeFomater();
        System.out.println(dtf.getDays("2018-03-25", "2019-03-20"));
    }
    public DateTimeFomater() {
        this.sdf = new SimpleDateFormat("yyyy-MM-dd");
    }

    public String convertDateToString(Date date){
        return sdf.format(date);
    }
    public Date convertStringToDate(String s){
        try {
            return sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public long getDays(String start, String end){
        Date startDate = convertStringToDate(start);
        Date endDate = convertStringToDate(end);
        long diff = endDate.getTime() - startDate.getTime();
        return (long) diff/(1000*60*60*24);
    }

}
