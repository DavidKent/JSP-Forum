<%-- 
    Document   : register
    Created on : Mar 21, 2012, 9:16:39 PM
    Author     : Zerotension
--%>
<%@page import="Forums.Forms.RegisterForm"%>
<%@page import="Forums.*"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
        <% 
        Connection con = Database.getConnection();
        boolean isRequest = true;
        String errorMessage = "";
        String name = request.getParameter("user");
        String pass = request.getParameter("pass");
        String email = request.getParameter("email");
        
        if(name == null || pass == null || email == null)
            isRequest = false;
        
        if(isRequest) {
            RegisterForm rf = new RegisterForm(name, pass, email);
            errorMessage = rf.validate(con);
            if(errorMessage.length() < 1)
                rf.addToDatabase(con);
          }

        %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
    if(isRequest) {
            if(errorMessage.length() < 1) {
                out.println("<h1>You have successfully registered, redirecting you to the main page</h1>");
                response.sendRedirect("index.jsp");
              }
            else
                out.println("<h1>Please review the following errors with your registration form: " + errorMessage + "</h1>");
        }
        %>
        <form action="<%= request.getRequestURI() %>" method="POST">
            <h1>Registration</h1>
            Username:
            <input name="user" type="text"></input><br>
            Password:
            <input name="pass" type="password"></input><br>
            Email:
            <input name="email" type="text"></input><br>
            <input type="submit" value="Submit">
            <input type="reset" value="Reset">
        </form>
    </body>
</html>
