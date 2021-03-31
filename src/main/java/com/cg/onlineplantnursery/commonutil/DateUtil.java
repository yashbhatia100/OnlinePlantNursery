package com.cg.onlineplantnursery.commonutil;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateUtil {

    private final String pattern="dd/MM/yy";


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

