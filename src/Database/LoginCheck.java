package Database;

import Entity.Person;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginCheck implements ILinks {

    private Person user;
    private String query;
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public Person getAccount(String username) {
        try {
            query = "SELECT * FROM `accounts` WHERE UserName='" + username + "';";
            con = DriverManager.getConnection(AppURL, DUsername, DPassword);
            st = con.createStatement();
            rs = st.executeQuery(query);
            if (rs.next() == true) {
                user = new Person(rs.getInt("UserId"), rs.getString("Name"), rs.getString("UserName"), rs.getString("Email"), rs.getString("Password"), rs.getString("Role"));
            }
            st.close();
            con.close();

        } catch (Exception ex) {

        }
        return user;
    }
}
