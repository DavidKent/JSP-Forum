/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Forums.Forms;

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
    public String validate() throws SQLException {
       return Database.isFound("SELECT * in " + UsersTable.NAME + " WHERE " + UsersTable.FIELDS_USER + " = '" + m_user + "' AND " +
                UsersTable.FIELDS_PASS + " = '" + m_pass + "'", UsersTable.FIELDS_USER);
    }
}
