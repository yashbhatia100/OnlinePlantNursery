package com.cg.onlineplantnursery.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

@Component
public class DateUtil {

    private  static final String pattern="dd/MM/yy";


    public String toText(LocalDate date, String pattern){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        String text=formatter.format(date);
        return text;
    }

    public String toText(LocalDate date){
        String text= toText(date,pattern);
        return text;
    }

    public LocalDate toLocalDate(String dateText, String pattern){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDate date= LocalDate.parse(dateText,formatter);
        return date;
    }


    public LocalDate toLocalDateTime(String datetimeText){
        LocalDate date= toLocalDate(datetimeText,pattern);
        return date;
    }


}

