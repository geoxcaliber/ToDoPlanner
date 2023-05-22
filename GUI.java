import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.*;

public class GUI implements ActionListener {
  // Frame and Panels
  private JFrame myFrame = new JFrame();
  private JPanel buttonPanel = new JPanel(new FlowLayout());
  private JPanel taskPanel = new JPanel(new FlowLayout());
  private JPanel textPanel = new JPanel(new BorderLayout());

  // ActionListeners
  private JButton addTaskButton = new JButton("Add Task");
  private JButton thisWeekButton = new JButton("This Week");
  private JButton printAllButton = new JButton("Print All");
  private JButton removeButton = new JButton("Remove");
  private JLabel nameLabel = new JLabel("");
  private JTextField text = new JTextField(20);

  // List
  private DefaultListModel<String> listModel = new DefaultListModel<>();
  private JList<String> list = new JList<>(listModel);
  private JScrollPane scrollPane = new JScrollPane(list);

  private Planner obj = new Planner();
  private String name;
  private int month;
  private int date;

  public GUI() {
    initializeFrame();
    myFrame.add(buttonPanel, BorderLayout.NORTH);
    myFrame.add(taskPanel, BorderLayout.EAST);
    myFrame.add(textPanel, BorderLayout.CENTER);
    buttonPanel.add(addTaskButton);
    buttonPanel.add(printAllButton);
    buttonPanel.add(thisWeekButton);
    buttonPanel.add(removeButton);
    addTaskButton.addActionListener(this);
    printAllButton.addActionListener(this);
    thisWeekButton.addActionListener(this);
    removeButton.addActionListener(this);
    text.addActionListener(this);
  }

  public void initializeFrame() {
    myFrame.setTitle("My GUI");
    myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    myFrame.setSize(500, 500);
    myFrame.setLocationRelativeTo(null);
    myFrame.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == text) {
      if (nameLabel.getText().equals("Name:")) {
        name = text.getText();
        nameLabel.setText("MM/DD:");
      } else if (nameLabel.getText().equals("MM/DD:")) {
        String currentCombined = text.getText();
        String[] splitArr = currentCombined.split("/");
        month = Integer.parseInt(splitArr[0]);
        date = Integer.parseInt(splitArr[1]);
        obj.addTask(this.name, this.month, this.date);
        nameLabel.setText("Name:");
      }
      text.setText("");
    }
    if (e.getSource() == addTaskButton) { // Add Task
      taskPanel.removeAll();
      textPanel.removeAll();
      nameLabel = new JLabel("Name:");
      taskPanel.add(nameLabel, BorderLayout.CENTER);
      taskPanel.add(text, BorderLayout.CENTER);
    }
    if (e.getSource() == thisWeekButton) { // This Week
      taskPanel.removeAll();
      listModel.clear();
      textPanel.add(scrollPane, BorderLayout.CENTER);
      for (Month month : obj.getFolders()) {
        for (Item item : month.getTaskList()) {
          if (obj.fallsWithinRange(item)) {
            listModel.addElement(item.toString());
          }
        }
      }
    }
    if (e.getSource() == printAllButton) { // Print All
      taskPanel.removeAll();
      listModel.clear();
      textPanel.add(scrollPane, BorderLayout.CENTER);
      for (Month month : obj.getFolders()) {
        for (Item item : month.getTaskList()) {
          listModel.addElement(item.toString());
        }
      }
    }

    if (e.getSource() == removeButton)

    { // Remove Task
      int selectedIndex = list.getSelectedIndex();
      if (selectedIndex != -1) {
        String savedName = listModel.get(selectedIndex);
        String taskName = savedName.substring(0, savedName.indexOf("/") - 4);
        listModel.remove(selectedIndex);
        obj.removeTask(taskName);
      }
    }
    myFrame.revalidate();
    myFrame.repaint();
  }

  public static void main(String[] args) {
    new GUI();
  }
}