import java.util.*;
import java.time.LocalDateTime;

public class Planner {

  private LocalDateTime now = LocalDateTime.now();
  private int[] numDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
  private ArrayList<Month> Folders = new ArrayList<>();
  private String day = now.getDayOfWeek().toString();
  private int month = now.getMonthValue();
  private int date = now.getDayOfMonth();
  private int startMonth = month;
  private int showFrom = 0;
  private int endMonth = month;
  private int showUntil = 0;

  public Planner() {
    findWeekRange();
    for (int i = 0; i < 12; i++) {
      Month a = new Month();
      Folders.add(a);
    }
  }

  public ArrayList<Month> getFolders() {
    return Folders;
  }

  public void removeTask(String name) {
    for (int i = 0; i < Folders.size(); i++) {
      for (int k = 0; k < Folders.get(i).getTaskList().size(); k++) {
        if (Folders.get(i).getTaskList().get(k).getName().equalsIgnoreCase(name)) {
          Folders.get(i).getTaskList().remove(k);
        }
      }
    }
  }

  public void addTask(String name, int month, int date) {
    Item a = new Item(name, month, date);
    Folders.get(month - 1).getTaskList().add(a);
    Collections.sort(Folders.get(month - 1).getTaskList());
  }

  public void findWeekRange() {
    int maxDays = numDays[month - 1];
    int previousMaxDays = 0;
    if (month > 1) {
      previousMaxDays = numDays[month - 2];
    }
    if (day.equalsIgnoreCase("Monday")) {
      showFrom = date;
      showUntil = date + 6;
      if (date > maxDays - 6) { // next month
        int difference = maxDays - date;
        showUntil = 6 - difference;
        endMonth = month + 1;
        if (month == 12) {
          endMonth = month;
          showUntil = maxDays;
        }
      }
    } else if (day.equalsIgnoreCase("Tuesday")) {
      showFrom = date - 1;
      showUntil = date + 5;
      if (date > maxDays - 5) { // next month
        int difference = maxDays - date;
        showUntil = 5 - difference;
        endMonth = month + 1;
        if (month == 12) {
          endMonth = month;
          showUntil = maxDays;
        }
      }
      if (date < 2) { // last month
        int difference = 1 - date;
        showFrom = previousMaxDays - difference;
        startMonth = month - 1;
        if (month == 1) {
          startMonth = month;
          showFrom = 1;
          showUntil = 7;
        }
      }
    } else if (day.equalsIgnoreCase("Wednesday")) {
      showFrom = date - 2;
      showUntil = date + 4;
      if (date > maxDays - 4) { // next month
        int difference = maxDays - date;
        showUntil = 4 - difference;
        endMonth = month + 1;
        if (month == 12) {
          endMonth = month;
          showUntil = maxDays;
        }
      }
      if (date < 3) { // last month
        int difference = 2 - date;
        showFrom = previousMaxDays - difference;
        startMonth = month - 1;
        if (month == 1) {
          startMonth = month;
          showFrom = 1;
          showUntil = 7;
        }
      }
    } else if (day.equalsIgnoreCase("Thursday")) {
      showFrom = date - 3;
      showUntil = date + 3;
      if (date > maxDays - 3) { // next month
        int difference = maxDays - date;
        showUntil = 3 - difference;
        endMonth = month + 1;
        if (month == 12) {
          endMonth = month;
          showUntil = maxDays;
        }
      }
      if (date < 4) { // last month
        int difference = 3 - date;
        showFrom = previousMaxDays - difference;
        startMonth = month - 1;
        if (month == 1) {
          startMonth = month;
          showFrom = 1;
          showUntil = 7;
        }
      }
    } else if (day.equalsIgnoreCase("Friday")) {
      showFrom = date - 4;
      showUntil = date + 2;
      if (date > maxDays - 2) {
        int difference = maxDays - date;
        showUntil = 2 - difference;
        endMonth = month + 1;
        if (month == 12) {
          endMonth = month;
          showUntil = maxDays;
        }
      }
      if (date < 5) {
        int difference = 4 - date;
        showFrom = previousMaxDays - difference;
        startMonth = month - 1;
        if (month == 1) {
          startMonth = month;
          showFrom = 1;
          showUntil = 7;
        }
      }
    } else if (day.equalsIgnoreCase("Saturday")) {
      showFrom = date - 5;
      showUntil = date + 1;
      if (date > maxDays - 1) { // next month
        int difference = maxDays - date;
        showUntil = 1 - difference;
        endMonth = month + 1;
        if (month == 12) {
          endMonth = month;
          showUntil = maxDays;
        }
      }
      if (date < 6) { // last month
        int difference = 5 - date;
        showFrom = previousMaxDays - difference;
        startMonth = month - 1;
        if (month == 1) {
          startMonth = month;
          showFrom = 1;
          showUntil = 7;
        }
      }
    } else if (day.equalsIgnoreCase("Sunday")) {
      showFrom = date - 6;
      showUntil = date;
      if (date < 7) { // last month
        int difference = 6 - date;
        showFrom = previousMaxDays - difference;
        startMonth = month - 1;
        if (month == 1) {
          startMonth = month;
          showFrom = 1;
          showUntil = 7;
        }
      }
    }
  }

  public boolean fallsWithinRange(Item item) {
    if ((item.getMonth() >= startMonth && item.getMonth() <= endMonth) &&
        (item.getDate() >= showFrom && item.getDate() <= showUntil)) {
      return true;
    } else
      return false;
  }
}