import java.util.*;

public class List {
  private ArrayList<Month> Folders = new ArrayList<>();

  public List() {
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

}