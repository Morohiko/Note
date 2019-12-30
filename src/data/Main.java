package data;

import java.time.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Day = " + MonthDay.now().getDayOfMonth());
        System.out.println("Month = " + MonthDay.now().getMonth().getValue());
        System.out.println("Year = " + Year.now());
        System.out.println(LocalDate.now().getDayOfMonth());
        System.out.println(LocalTime.now().getHour() + ":" + LocalTime.now().getMinute());
        String time;
        time = "\n" + LocalDate.now().getDayOfMonth() + "." + LocalDate.now().getMonthValue() + "." +
                LocalDate.now().getYear() + '\n' + LocalTime.now().getHour() + ":" +
                LocalTime.now().getMinute() + '\n';
        System.out.println("time = \n" + time);
    }
}
