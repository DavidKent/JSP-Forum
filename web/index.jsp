<%-- 
    Document   : index
    Created on : Mar 21, 2012, 5:01:47 PM
    Author     : Zerotension
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Forums.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            String user = PageRequest.loggedIn(request);
          
            if(user.length() != 0)
              response.sendRedirect("forums.jsp");
        %>
        <!--<link rel=stylesheet type="text/css" href="bootstrap.css">-->
        <title>JSP Page</title>
    </head>
    <body>
        <form action="<%= request.getRequestURI() %>" method="POST">
            <h1>Please Log in or Register</h1>
            Username:
            <input name="user" type="text"></input><br>
            Password:
            <input name="password" type="password"></input><br>
            <button type="submit">Log in</button> 
            <a href="register.jsp"> <button>Register</button> </a>
            
        </form>
    </body>
</html>

