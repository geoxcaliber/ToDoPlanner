import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Item implements Comparable<Item> {
  private String name;
  private int date;
  private int month;
  private String day;

  public Item(String name, int month, int date) {
    this.name = name;
    this.date = date;
    this.month = month;
    LocalDate fullDate = LocalDate.of(2023, month, date);
    day = fullDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
  }

  @Override
  public String toString() {
    return name + " | " + month + "/" + date + " | " + day;
  }

  public String getName() {
    return name;
  };

  public void setName(String name) {
    this.name = name;
  };

  public int getDate() {

    return date;

  };

  public void setDate(int date) {
    this.date = date;
  };

  public int getMonth() {
    return month;
  };

  public void setMonth(int month) {
    this.month = month;
  };

  public String getDay() {
    return day;
  };

  public void setMonth(String day) {
    this.day = day;
  };

  @Override
  public int compareTo(Item task) {
    return Integer.compare(getDate(), task.getDate());
  }
}