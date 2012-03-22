package Forums;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zerotension
 */

import Forums.Constants.PostsTable;
import Forums.Constants.SessionsTable;
import Forums.Constants.UsersTable;
import java.sql.*;

public class Database { 
    private static final String 
            m_pass = "shadow",
            m_user = "root",
            m_url = "jdbc:mysql://localhost:3306/forums";
    
    public static void install(Connection con) throws SQLException {
        DataTable session = new DataTable(SessionsTable.NAME, con);
        session.addColumn(SessionsTable.FIELDS_ID, "text");
        session.addColumn(SessionsTable.FIELDS_USER, "text");
        
        DataTable hubs = new DataTable(PostsTable.NAME, con);
        hubs.addColumn(PostsTable.FIELDS_PARENT, "text");
        hubs.addColumn(PostsTable.FIELDS_TITLE, "text");
        hubs.addColumn(PostsTable.FIELDS_TYPE, "int");
        hubs.addColumn(PostsTable.FIELDS_DESCRIPTION, "longtext");
        hubs.addColumn(PostsTable.FIELDS_CONTENT, "longtext");
        hubs.addColumn(PostsTable.FIELDS_OP, "text");
        hubs.addColumn(PostsTable.FIELDS_POSTED, "date");
        
        DataTable users = new DataTable(UsersTable.NAME, con);
        users.addColumn(UsersTable.FIELDS_USER, "text");
        users.addColumn(UsersTable.FIELDS_PASS, "text");
        users.addColumn(UsersTable.FIELDS_EMAIL, "text");
        
        session.createTable();
        hubs.createTable();
        users.createTable();
        
        con.close();
    }
    
    public static void nonQuery(String query, Connection con) throws SQLException {
        Statement statement = con.createStatement();
        statement.executeUpdate(query);
        statement.close();
    }
    
    public static ResultSet query(String query, Connection con) throws SQLException {
        Statement statement = con.createStatement();
        return statement.executeQuery(query);
    }
    
    public static boolean isFound(String query, Connection con) throws SQLException {
        boolean isFound = false;
        Statement statement = con.createStatement();
        ResultSet results = statement.executeQuery(query);
        isFound = results.next();
        return isFound;
    }
    
    public static String isFound(String query, String colName, Connection con) throws SQLException {
        String isFound = "";
        Statement statement = con.createStatement();
        ResultSet results = statement.executeQuery(query);
        while(results.next()){
            isFound = results.getString(colName);
            break;
        }
        return isFound;
    }
    
    public static Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver()); 
        return DriverManager.getConnection(m_url, m_user, m_pass);
    }
}
