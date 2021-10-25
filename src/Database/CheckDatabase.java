package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CheckDatabase implements ILinks {

    private String query;
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public boolean CheckInternet() {
        try {
            query = "SELECT COUNT(*) AS Total FROM accounts;";
            con = DriverManager.getConnection(AppURL, DUsername, DPassword);
            st = con.createStatement();
            rs = st.executeQuery(query);
            st.close();
            con.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean CheckConnection() {
        try {
            query = "SELECT COUNT(*) AS Total FROM accounts;";
            con = DriverManager.getConnection(AppURL, DUsername, DPassword);
            st = con.createStatement();
            rs = st.executeQuery(query);
            st.close();
            con.close();
            return true;
        } catch (Exception ex) {
            try {
                query = "CREATE DATABASE BugReporter;";
                con = DriverManager.getConnection(DatabaseURL, DUsername, DPassword);
                st = con.createStatement();
                int effect = st.executeUpdate(query);
                st.close();
                con.close();
                con = DriverManager.getConnection(AppURL, DUsername, DPassword);
                st = con.createStatement();
                query = "CREATE TABLE accounts (UserId int,Name varchar(50),UserName varchar(50),Email varchar(50),"
                        + "Password varchar(20),Role varchar(50),PRIMARY KEY(UserId));";
                effect = st.executeUpdate(query);
                query ="CREATE TABLE bugs (Id int AUTO_INCREMENT,BugId varchar(30),Priroty varchar(10),expected text,actual text,TesterName varchar(100),"
                        + "DeveloperName varchar(100),BugName text,Description text,CreateDate varchar(50),Status varchar(30),Comments text,PRIMARY KEY(Id));";
                effect = st.executeUpdate(query);
                st.close();
                con.close();
                return true;
            } catch (Exception e) {
                return false;
            }
        }
    }
}