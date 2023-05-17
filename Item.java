public class Item implements Comparable<Item> {

  private String name;
  private int date;
  private int month;

  @Override
  public String toString() {
    return name + ", due on " + month + "/" + date;
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

  @Override
  public int compareTo(Item task) {
    return Integer.compare(getDate(), task.getDate());
  }
}