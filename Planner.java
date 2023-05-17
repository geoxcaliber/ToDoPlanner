import java.util.*;
import java.time.LocalDateTime;

public class Planner {

  private Scanner scan = new Scanner(System.in);

  private LocalDateTime now = LocalDateTime.now();

  int[] numDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
  private ArrayList<Month> Folders = new ArrayList<>();
  String day = now.getDayOfWeek().toString();
  int month = now.getMonthValue();
  int date = now.getDayOfMonth();

  public Planner() {

    for (int i = 0; i < 12; i++) {

      Month a = new Month();

      Folders.add(a);

    }

  }

  public void addTask() {
    System.out.print("Enter number of tasks: ");
    int numberTasks = scan.nextInt();
    scan.nextLine();
    for (int i = 1; i <= numberTasks; i++) {
      System.out.print("Enter name of task " + i + ": ");
      String name = scan.nextLine();
      int month = 0;
      int date = 0;
      boolean success = false;
      while (!success) {
        System.out.print("Enter day as MM/DD: ");
        String currentCombined = scan.next();
        String[] splitArr = currentCombined.split("/");
        month = Integer.parseInt(splitArr[0]);
        date = Integer.parseInt(splitArr[1]);
        scan.nextLine();
        int maxDays = numDays[month - 1];
        if (month < 1 || month > 12) {
          System.out.print("Month is out of bounds. ");
        } else if (date < 1 || date > maxDays) {
          System.out.print("Date is out of bounds. ");
        } else {
          success = true;
        }
      }
      Item a = new Item();
      a.setName(name);
      a.setMonth(month);
      a.setDate(date);
      Folders.get(month - 1).taskList.add(a);
      Collections.sort(Folders.get(month - 1).taskList);
    }
  }

  public void printTasks() {
    for (int i = 0; i < Folders.size(); i++) {
      if (Folders.get(i).taskList.size() >= 1) {
        System.out.println("Tasks in month " + (i + 1) + ":");
      }
      for (int k = 0; k < Folders.get(i).taskList.size(); k++) {
        System.out.println(Folders.get(i).taskList.get(k));
      }
    }
  }

  public void removeTask() {
    printTasks();
    System.out.print("Enter name of task you wish to remove: ");
    String taskName = scan.nextLine();
    for (int i = 0; i < Folders.size(); i++) {
      for (int k = 0; k < Folders.get(i).taskList.size(); k++) {
        if (Folders.get(i).taskList.get(k).getName().equalsIgnoreCase(taskName)) {
          Folders.get(i).taskList.remove(k);
        }
      }
    }
    printTasks();
  }

  public void thisWeek() {

    int maxDays = numDays[month - 1];

    int previousMaxDays = 0;

    if (month > 1) {

      previousMaxDays = numDays[month - 2];

    }

    boolean showFromLastMonth = false;

    boolean showToNextMonth = false;

    int showFrom = 0;

    int showUntil = 0;

    if (day.equalsIgnoreCase("Monday")) {

      showFrom = date;

      showUntil = date + 6;

      if (date > maxDays - 6) {

        int difference = maxDays - date;

        showUntil = 6 - difference;

        showToNextMonth = true;

        if (month == 12) {

          showUntil = maxDays;

          showToNextMonth = false;

        }

      }

    } else if (day.equalsIgnoreCase("Tuesday")) {

      showFrom = date - 1;

      showUntil = date + 5;

      if (date > maxDays - 5) {

        int difference = maxDays - date;

        showUntil = 5 - difference;

        showToNextMonth = true;

        if (month == 12) {

          showUntil = maxDays;

          showToNextMonth = false;

        }

      }

      if (date < 2) {

        int difference = 1 - date;

        showFrom = previousMaxDays - difference;

        showFromLastMonth = true;

        if (month == 1) {

          showFrom = 1;

          showUntil = 7;

          showFromLastMonth = false;

        }

      }

    } else if (day.equalsIgnoreCase("Wednesday")) {

      showFrom = date - 2;

      showUntil = date + 4;

      if (date > maxDays - 4) {

        int difference = maxDays - date;

        showUntil = 4 - difference;

        showToNextMonth = true;

        if (month == 12) {

          showUntil = maxDays;

          showToNextMonth = false;

        }

      }

      if (date < 3) {

        int difference = 2 - date;

        showFrom = previousMaxDays - difference;

        showFromLastMonth = true;

        if (month == 1) {

          showFrom = 1;

          showUntil = 7;

          showFromLastMonth = false;

        }

      }

    } else if (day.equalsIgnoreCase("Thursday")) {

      showFrom = date - 3;

      showUntil = date + 3;

      if (date > maxDays - 3) {

        int difference = maxDays - date;

        showUntil = 3 - difference;

        showToNextMonth = true;

        if (month == 12) {

          showUntil = maxDays;

          showToNextMonth = false;

        }

      }

      if (date < 4) {

        int difference = 3 - date;

        showFrom = previousMaxDays - difference;

        showFromLastMonth = true;

        if (month == 1) {

          showFrom = 1;

          showUntil = 7;

          showFromLastMonth = false;

        }

      }

    } else if (day.equalsIgnoreCase("Friday")) {

      showFrom = date - 4;

      showUntil = date + 2;

      if (date > maxDays - 2) {

        int difference = maxDays - date;

        showUntil = 2 - difference;

        showToNextMonth = true;

        if (month == 12) {

          showUntil = maxDays;

          showToNextMonth = false;

        }

      }

      if (date < 5) {

        int difference = 4 - date;

        showFrom = previousMaxDays - difference;

        showFromLastMonth = true;

        if (month == 1) {

          showFrom = 1;

          showUntil = 7;

          showFromLastMonth = false;

        }

      }

    } else if (day.equalsIgnoreCase("Saturday")) {

      showFrom = date - 5;

      showUntil = date + 1;

      if (date > maxDays - 1) {

        int difference = maxDays - date;

        showUntil = 1 - difference;

        showToNextMonth = true;

        if (month == 12) {

          showUntil = maxDays;

          showToNextMonth = false;

        }

      }

      if (date < 6) {

        int difference = 5 - date;

        showFrom = previousMaxDays - difference;

        showFromLastMonth = true;

        if (month == 1) {

          showFrom = 1;

          showUntil = 7;

          showFromLastMonth = false;

        }

      }

    } else if (day.equalsIgnoreCase("Sunday")) {

      showFrom = date - 6;

      showUntil = date;

      if (date < 7) {

        int difference = 6 - date;

        showFrom = previousMaxDays - difference;

        showFromLastMonth = true;

        if (month == 1) {

          showFrom = 1;

          showUntil = 7;

          showFromLastMonth = false;

        }

      }

    }

    if (showFromLastMonth) {

      System.out.println("Tasks due from: " + (month - 1) + "/" + showFrom + " to " + month + "/" + showUntil);

      // Tasks that fall from last month to it's end: task's date has to be within

      // from to the month's max Days

      for (int i = 0; i < Folders.get(month - 2).taskList.size(); i++) {

        Item pastMonthItem = Folders.get(month - 2).taskList.get(i);

        if (pastMonthItem.getDate() >= showFrom

            && pastMonthItem.getDate() <= previousMaxDays) {

          System.out.println(pastMonthItem);

        }

      }

      // Tasks that continue to the beginning of this month: less than until

      for (int i = 0; i < Folders.get(month - 1).taskList.size(); i++) {

        Item currentMonthItem = Folders.get(month - 1).taskList.get(i);

        if (currentMonthItem.getDate() <= showUntil) {

          System.out.println(currentMonthItem);

        }

      }

    } else if (showToNextMonth) {

      System.out.println("Tasks due from: " + month + "/" + showFrom + " to " + (month + 1) + "/" + showUntil);

      // Tasks that fall from this month's end to next month: Greater than from

      for (int i = 0; i < Folders.get(month - 1).taskList.size(); i++) {
        Item currentMonthItem = Folders.get(month - 1).taskList.get(i);
        if (currentMonthItem.getDate() >= showFrom) {
          System.out.println(currentMonthItem);
        }
      }

      // Tasks that fall in the start of next month: Less than until

      for (int i = 0; i < Folders.get(month).taskList.size(); i++) {
        Item nextMonthItem = Folders.get(month).taskList.get(i);
        if (nextMonthItem.getDate() <= showUntil) {
          System.out.println(nextMonthItem);
        }
      }

    } else {

      System.out.println("Tasks due from: " + month + "/" + showFrom + " to " + month + "/" + showUntil);

      // Tasks that neither go into last month or next, within current month: within

      // from AND until

      for (int i = 0; i < Folders.get(month - 1).taskList.size(); i++) {

        Item currentMonthItem = Folders.get(month - 1).taskList.get(i);

        if (currentMonthItem.getDate() >= showFrom

            && currentMonthItem.getDate() <= showUntil) {

          System.out.println(currentMonthItem);

        }

      }

    }

  }

  public static void main(String[] args) {

    Planner obj = new Planner();

    obj.addTask();
    obj.thisWeek();
    obj.removeTask();

  }

}