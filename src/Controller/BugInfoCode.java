package Controller;

import Database.Insertion;
import Entity.Bug;
import Entity.Person;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class BugInfoCode {

    private String status, comment;

    public boolean update(Person user, Bug bug, JTextArea commentarea, JComboBox statusbox) {
        status = getStatus(statusbox);
        comment = commentarea.getText();
        Insertion obj = new Insertion();
        boolean flag = obj.updateBugReport(user,bug, comment, status);
        return flag;
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
}
