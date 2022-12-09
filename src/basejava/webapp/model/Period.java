package basejava.webapp.model;

import java.time.LocalDate;
import java.time.Month;


public class Period {
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String title;
    private final String description;

    public Period(LocalDate startDate, LocalDate endDate, String title, String description) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.description = description;
    }

    public Period(int startYear, Month startMonth, int startDay, int endYear, Month endMonth, int endDay, String title, String description) {
        this(LocalDate.of(startYear, startMonth, startDay), LocalDate.of(endYear, endMonth, endDay), title, description);
    }
}
