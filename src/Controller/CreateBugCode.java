package Controller;

import Database.Insertion;
import Entity.Bug;
import Entity.Person;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CreateBugCode {

    private Bug bug;
    private String priroty, status;

    public CreateBugCode(JTextField idfld, JTextField namefld, JTextArea descarea, JTextArea expectedarea, JTextArea actualarea, JTextArea commentarea, String date, JComboBox prirotybox, JComboBox statusbox, Person user) {
        if (idfld.getText().trim().isEmpty()) {
            idfld.setBackground(Color.RED);
        } else {
            idfld.setBackground(Color.WHITE);
        }
        if (namefld.getText().trim().isEmpty()) {
            namefld.setBackground(Color.RED);
        } else {
            namefld.setBackground(Color.WHITE);
        }
        if (descarea.getText().trim().isEmpty()) {
            descarea.setBackground(Color.RED);
        } else {
            descarea.setBackground(Color.WHITE);
        }
        if (expectedarea.getText().trim().isEmpty()) {
            expectedarea.setBackground(Color.RED);
        } else {
            expectedarea.setBackground(Color.WHITE);
        }
        if (actualarea.getText().trim().isEmpty()) {
            actualarea.setBackground(Color.RED);
        } else {
            actualarea.setBackground(Color.WHITE);
        }
        this.bug = new Bug(0, idfld.getText(), namefld.getText(), descarea.getText(), expectedarea.getText(), actualarea.getText(), date, commentarea.getText(), getPriroty(prirotybox), getStatus(statusbox), user.getName());
    }

    public boolean checkAll() {
        if (bug.getBugId().isEmpty() || bug.getName().isEmpty() || bug.getDescription().isEmpty() || bug.getExpected().isEmpty() || bug.getActual().isEmpty()) {
            return false;
        }
        return true;
    }

    private String getPriroty(JComboBox prirotybox) {
        if (prirotybox.getSelectedIndex() == 0) {
            return "LOW";
        } else if (prirotybox.getSelectedIndex() == 1) {
            return "MEDIUM";
        } else {
            return "HIGH";
        }
    }

    private String getStatus(JComboBox statusbox) {
        if (statusbox.getSelectedIndex() == 0) {
            return "NEW";
        } else if (statusbox.getSelectedIndex() == 1) {
            return "IN PROGRESS";
        } else if (statusbox.getSelectedIndex() == 2) {
            return "FIXED";
        } else if (statusbox.getSelectedIndex() == 3) {
            return "REOPEN";
        } else {
            return "CLOSE";
        }
    }

    public boolean insertInDatabase() {
        Insertion obj = new Insertion();
        boolean flag = obj.insertBugReport(bug);
        if (flag == true) {
            JOptionPane.showMessageDialog(null, "Bug is Reported Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No Internet Connection", "Failed", JOptionPane.WARNING_MESSAGE);
        }
        return flag;

    }
}
