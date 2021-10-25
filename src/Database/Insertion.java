package Database;

import Entity.Bug;
import Entity.Person;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Insertion implements ILinks {

    private String query;
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public boolean insertBugReport(Bug bug) {
        try {
            con = DriverManager.getConnection(AppURL, DUsername, DPassword);
            st = con.createStatement();
            query = "INSERT INTO `bugs`( `BugId`, `Priroty`, `expected`, `actual`, `TesterName`, `DeveloperName`, `BugName`, `Description`, `CreateDate`, `Status`, `Comments`) "
                    + "VALUES ('" + bug.getBugId() + "','" + bug.getPriroty() + "','" + bug.getExpected() + "','" + bug.getActual() + "','" + bug.getTesterName() + "','" + bug.getDeveloperName() + "','" + bug.getName() + "','" 
                    + bug.getDescription() + "','" + bug.getDate() + "','" + bug.getStatus() + "','" + bug.getComment() + "');";
            int effect = st.executeUpdate(query);
            st.close();
            con.close();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public boolean updateBugReport(Person user,Bug bug,String comment,String status) {
        try {
            con = DriverManager.getConnection(AppURL, DUsername, DPassword);
            st = con.createStatement();
            query = "UPDATE bugs set DeveloperName='"+user.getName()+"',Status='"+status+"',Comments='"+comment+"' WHERE id="+bug.getId()+";";
            int effect = st.executeUpdate(query);
            st.close();
            con.close();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

}
