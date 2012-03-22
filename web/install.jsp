<%-- 
    Document   : install
    Created on : Mar 21, 2012, 7:47:00 PM
    Author     : Zerotension
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Forums.*"%>
<% 
    Connection con = Database.getConnection();
    Database.install(con);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome to the install page</h1>
    </body>
</html>
<% con.close(); %>