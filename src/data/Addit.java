package data;

import java.time.LocalDate;
import java.time.LocalTime;

class Addit {
    static String shfrUp(String text){
        String txt = "";
        for (int i = 0; i < getDate().length(); i++) {
            txt += Character.toString((char)(getDate().charAt(i) + 4));
        }
        for(int i = 0; i<text.length(); i++) {
            txt += Character.toString((char) (text.charAt(i)+4));
        }
        return txt;
    }

    static String shfrDown(String text){
        String txt = "";
        for(int i = 0; i<text.length(); i++) {
            txt += Character.toString((char) (text.charAt(i)-4));
        }
        return txt;
    }

    private static String getDate(){
        String time;
        time = "\n" + LocalDate.now().getDayOfMonth() + "." + LocalDate.now().getMonthValue() + "." +
                LocalDate.now().getYear() + '\n' + LocalTime.now().getHour() + ":" +
                LocalTime.now().getMinute() + '\n';
        return time;
    }
}
