package com.sandbox.console;

import java.text.SimpleDateFormat;
import java.util.*;

public class ThreadSafe {
    public static void ff()         {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<Calendar> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Calendar startDay = new GregorianCalendar();
            Calendar checkDay = new GregorianCalendar();
            checkDay.setTime(startDay.getTime());//不污染入参
            checkDay.add(checkDay.DATE, i);
            list.add(checkDay);
            checkDay = null;
            startDay = null;
        }
        List<Object> objects = Collections.synchronizedList(new ArrayList<>());


        list.stream().forEach(day -> System.out.println(sdf.format(day.getTime())));
        System.out.println("-----------------------");
        list.parallelStream().forEach(day -> System.out.println(sdf.format(day.getTime())));
        System.out.println("-----------------------");

        System.exit(0);
    }
}
