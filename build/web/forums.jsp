<%-- 
    Document   : forums
    Created on : Mar 21, 2012, 10:06:14 PM
    Author     : Zerotension
--%>

<%@page import="Forums.*"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% ForumRequestHandler fr = new ForumRequestHandler(request, response, out); %>
    </body>
</html>
