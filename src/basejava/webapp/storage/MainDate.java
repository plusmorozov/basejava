package basejava.webapp.storage;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class MainDate {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Date date = new Date();
        System.out.println(date);
        System.out.println(System.currentTimeMillis() - start);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
        System.out.println(calendar.getTime());

        LocalDate ld = LocalDate.now();
        System.out.println(ld);
        LocalTime lt = LocalTime.now();
        System.out.println(lt);
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        SimpleDateFormat sdf = new SimpleDateFormat("YY-dd-MM");
        System.out.println(sdf.format(date));

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YY/MM/dd");
        System.out.println(dtf.format(ldt));
    }
}
