package com.dicoding.commonclass;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeApp {
    public static void main(String[] args) {

        // CurrentTimeMillis
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("Waktu sekarang adalah " + currentTimeMillis + " milliseconds");

        // Date
        Date date = new Date();
        System.out.println("Tanggal sekarang adalah " + date.toString());

        // Calendar
        Calendar calendar = Calendar.getInstance();
        System.out.println("Waktu sekarang adalah " + calendar.getTime());
        System.out.println("Tanggal " + calendar.get(Calendar.DATE));
        System.out.println("Bulan " + calendar.get(Calendar.MONTH));
        System.out.println("Tahun " + calendar.get(Calendar.YEAR));
        // 15 hari yang lalu
        calendar.add(Calendar.DATE, -15);
        System.out.println("15 hari yang lalu " + calendar.getTime());
        // 4 bulan kemudian
        calendar.add(Calendar.MONTH, 4);
        System.out.println("4 bulan kemudian " + calendar.get(Calendar.MONTH));
        // 2 tahun kemudian
        System.out.println("2 tahun kemudian " + calendar.get(Calendar.YEAR));

        // SimpleDateFormat
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d-M-Y");
        String dateFormated = simpleDateFormat.format(new Date());
        System.out.println("Format tanggal default " + new Date());
        System.out.println("Format dengan SimpleDateFormat " + dateFormated);

    }
}
