/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Forums;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author Zerotension
 */
public class DataTable {
    private String m_name;
    private Connection m_con;
    private String m_cols = "";
    
    public DataTable(String name, Connection con) {
        m_name = name;
        m_con = con;
    }
    
    public void addColumn(String name, String type) {
        m_cols += name + " " + type + ", ";
    }
    public void createTable() throws SQLException {
        Database.nonQuery(getQuery());
    }
    public String getQuery() {
        String query = "CREATE TABLE IF NOT EXISTS ";
        query += " " + m_name + " (" + m_cols.substring(0, m_cols.length() - 2) + " )";
        return query;
    }
}
