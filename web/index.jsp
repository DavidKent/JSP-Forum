<%-- 
    Document   : index
    Created on : Mar 21, 2012, 5:01:47 PM
    Author     : Zerotension
--%>

<%@page import="Forums.Forms.LoginForm"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Forums.*"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            Connection con = Database.getConnection();
            boolean errors = false;
           
            String user = PageRequest.loggedIn(request, con);
          
            if(user.length() != 0)
              response.sendRedirect("forums.jsp");
            
            boolean isRequest = true;
            String name = request.getParameter("name");
            String pass = request.getParameter("pass");
            if(name == null || pass == null)
                isRequest = false;
            
            if(isRequest) {
                 LoginForm lf = new LoginForm(name, pass, request.getSession().getId());
                 errors = lf.validate(con);
                 if(errors) {
                        lf.addToDatabase(con);
                        response.sendRedirect("forums.jsp");
                   }
                 
            }
            con.close();
        %>
        <!--<link rel=stylesheet type="text/css" href="bootstrap.css">-->
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if(errors)
                out.println("That username or password is incorrect");
        %>
        <form action="<%= request.getRequestURI() %>" method="POST">
            <h1>Please Log in or Register</h1>
            Username:
            <input name="name" type="text"></input><br>
            Password:
            <input name="pass" type="password"></input><br>
            <button type="submit">Log in</button> 
            <a href="register.jsp"> <button>Register</button> </a>
            
        </form>
    </body>
</html>

