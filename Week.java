import java.time.LocalDate;
import java.time.*;

public class Week {
  private LocalDate firstDayOfWeek;
  private LocalDate lastDayOfWeek;

  public Week(LocalDate firstDayOfWeek, LocalDate lastDayOfWeek) {
    this.firstDayOfWeek = firstDayOfWeek;
    this.lastDayOfWeek = lastDayOfWeek;
  }

  public static Week findWeek() {
    LocalDate now = LocalDate.now();
    DayOfWeek currentDay = now.getDayOfWeek();
    LocalDate firstDayOfWeek = now.minusDays(currentDay.getValue() - 1);
    LocalDate lastDayOfWeek = now.plusDays(7 - currentDay.getValue());
    Week week = new Week(firstDayOfWeek, lastDayOfWeek);
    return week;
  }

  public boolean isInWeek(LocalDate date) {
    return !date.isBefore(firstDayOfWeek) && !date.isAfter(lastDayOfWeek);
  }

}