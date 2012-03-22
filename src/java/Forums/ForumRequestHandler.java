/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Forums;

import Forums.Constants.PostsTable;
import Forums.Modules.Channel;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;

/**
 *
 * @author Zerotension
 */
public class ForumRequestHandler {
    private Connection m_con;
    private String m_user;
    private HttpServletRequest m_request;
    private HttpServletResponse m_response;
    private JspWriter m_out;
    public ForumRequestHandler(HttpServletRequest request, HttpServletResponse response, JspWriter out) throws SQLException, IOException {
        m_con = Database.getConnection();
        m_request = request;
        m_out = out;
        m_response = response;
        m_user = PageRequest.loggedIn(request, m_con);
        handleRequest();
    }
    
    public String handleRequest() throws IOException, SQLException {
        if(m_user.length() < 1) {
            m_response.sendRedirect("index.jsp");
            m_con.close();
        }
        String view = m_request.getParameter("view");
        if("channels".equals(view))
            return viewChannels();
        else if("forum".equals(view))
            return viewForum();
        else if("post".equals(view))
            return viewPost();
        else
            return viewChannels();
    }
    
    private String viewChannels() throws IOException, SQLException {
        String output = "";
        String query = "SELECT * FROM " + PostsTable.NAME + " WHERE " + PostsTable.FIELDS_TYPE + " = 0";
        ResultSet rs = Database.query(query, m_con);
        while(rs.next()) {
            Channel ch = new Channel(rs.getString(PostsTable.FIELDS_TITLE), PostsTable.FIELDS_DESCRIPTION);
            output += ch.toString();
        }
        m_out.println(output);
        return "";
    }
    
    public String viewForum()
    {
        return "";
    }
    
    public String viewPost()
    {
        return "";
    }
}
