/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Forums;

import Forums.Constants.SessionsTable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Zerotension
 */
public class PageRequest {
    public static Map<String, String> getQueryMap(String queryString) {
        String[] params = queryString.split("&");  
        Map<String, String> map = new HashMap<String, String>();  
        for (String param : params)  
        {  
            String name = param.split("=")[0];  
            String value = param.split("=")[1];  
            map.put(name, value);  
        }  
        return map;  
    }
    
    /**
     * Checks if session ID is saved in the database.
     * @param req request
     * @return username associated with session ID
     * @throws SQLException 
     */
    public static String loggedIn(HttpServletRequest req, Connection con) throws SQLException {
        String id = req.getSession(true).getId();
        String isFound = Database.isFound("SELECT * FROM " + SessionsTable.NAME + " WHERE " + SessionsTable.FIELDS_ID + 
                " = '"+id+"'", "username", con);
        return isFound;
    }
}
