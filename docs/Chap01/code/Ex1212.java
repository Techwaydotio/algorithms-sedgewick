package Chap01.code;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex1212 {
    public static String getDay(int day, int month, int year) {
        String dayOfWeek = null;
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        String date = String.valueOf(day) + "/" + String.valueOf(month) + "/" + String.valueOf(year);
        try {
            SimpleDateFormat format1 = new SimpleDateFormat("d/M/yyyy");
            Date dt1 = format1.parse(date);
            dayOfWeek = days[dt1.getDay() - 1];
        } catch(Exception e) {
            System.out.println(e);
        }

        return dayOfWeek;
    }

    public static void main(String[] args) {
        System.out.println(getDay(5,12, 1980));
    }
}
