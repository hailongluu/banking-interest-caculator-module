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

    public Date getDate(){
        Date d = new Date(System.currentTimeMillis());
        return convertStringToDate(sdf.format(d));
    }
    public String getDateString(){
        Date d = new Date(System.currentTimeMillis());
        return sdf.format(d);
    }
}
