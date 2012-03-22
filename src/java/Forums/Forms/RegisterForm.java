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
public class RegisterForm {
    private String m_user;
    private String m_pass;
    private String m_email;
    
    public RegisterForm (String user, String pass, String email) {
        m_user = user;
        m_pass = pass;
        m_email = email;
    }

    public String validate() throws SQLException {
        String errorMessage = "";
        if(Database.isFound("SELECT * FROM " + UsersTable.NAME + " WHERE " + UsersTable.FIELDS_USER + " = '" + m_user + "'"))
                errorMessage += "The username '" + m_user + "' is already taken<br>";
            if(Database.isFound("SELECT * FROM " + UsersTable.NAME + " WHERE " + UsersTable.FIELDS_EMAIL + " = '" + m_email + "'"))
                errorMessage += "The email '" + m_email + "' is already in use<br>";
            if(m_pass.length() < 6)
                errorMessage += "The password must be 6 characters or longer in length<br>";
        return errorMessage;
    }
    
    public void addToDatabase() throws SQLException {
        String nonQuery = "INSERT INTO " + UsersTable.NAME + " (";
        nonQuery += UsersTable.FIELDS_USER + ", ";
        nonQuery += UsersTable.FIELDS_PASS + ", ";
        nonQuery += UsersTable.FIELDS_EMAIL + ") ";
        nonQuery += " VALUES (";
        nonQuery += m_user + ", " + m_pass + ", " + m_email + " )";
        Database.nonQuery(nonQuery);
    }
    
}
