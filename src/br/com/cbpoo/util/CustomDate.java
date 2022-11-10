package br.com.cbpoo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDate {
    private static SimpleDateFormat Format = new SimpleDateFormat("dd/MM/yyyy");

    public static Date newDate(int day, int month, int year) throws ParseException {
       return Format.parse(day+"/"+month+"/"+year);
    }
}
