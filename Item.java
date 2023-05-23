import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Item implements Comparable<Item> {
  private String name;
  private int date;
  private int month;
  private String day;
  private LocalDate fullDate;

  public Item(String name, int month, int date) {
    this.name = name;
    this.date = date;
    this.month = month;
    fullDate = LocalDate.of(2023, month, date);
    day = fullDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
  }

  @Override
  public String toString() {
    return name + " | " + month + "/" + date + " | " + day;
  }

  public String getName() {
    return name;
  };

  public int getDate() {

    return date;

  };

  public int getMonth() {
    return month;
  };

  public String getDay() {
    return day;
  };

  public LocalDate getFulLDate() {
    return fullDate;
  };

  @Override
  public int compareTo(Item task) {
    return Integer.compare(getDate(), task.getDate());
  }
}