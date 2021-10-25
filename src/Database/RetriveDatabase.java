package Database;

import Entity.Bug;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class RetriveDatabase implements ILinks {

    private Connection con;
    private Statement st;
    private ResultSet rs;

    public void getBugs(LinkedList bugs, String query) {
        try {
            con = DriverManager.getConnection(AppURL, DUsername, DPassword);
            st = con.createStatement();
            rs = st.executeQuery(query);

            while (rs.next() == true) {
                Bug obj = new Bug(rs.getInt("Id"), rs.getString("BugId"), rs.getString("BugName"), rs.getString("Description"), rs.getString("expected"), rs.getString("actual"), rs.getString("CreateDate"), rs.getString("Comments"), rs.getString("Priroty"), rs.getString("Status"), rs.getString("TesterName"));
                obj.setDeveloperName(rs.getString("DeveloperName"));
                bugs.add(obj);
            }
            st.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No Internet Connection", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
}
