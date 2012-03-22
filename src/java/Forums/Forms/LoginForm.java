/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Forums.Forms;

import Forums.Constants.SessionsTable;
import Forums.Constants.UsersTable;
import Forums.Database;
import java.sql.SQLException;

/**
 *
 * @author Zerotension
 */
public class LoginForm {
    private String m_user;
    private String m_pass;
    private String m_sessionID;
    public LoginForm(String user, String pass, String sessionID) {
        m_user = user;
        m_pass = pass;
        m_sessionID = sessionID;
    }
    
    public boolean validate() throws SQLException {
       return Database.isFound("SELECT * FROM " + UsersTable.NAME + " WHERE " + UsersTable.FIELDS_USER + " = '" + m_user + "' AND " +
                UsersTable.FIELDS_PASS + " = '" + m_pass + "'");
    }
    
    public void addToDatabase() throws SQLException {
        String nonQuery = "INSERT INTO " + SessionsTable.NAME + " (";
        nonQuery += SessionsTable.FIELDS_USER + ", ";
        nonQuery += SessionsTable.FIELDS_ID + ") ";
        nonQuery += " VALUES ('";
        nonQuery += m_user + "', '" + m_sessionID + "' )";
        Database.nonQuery(nonQuery);
    }
}
