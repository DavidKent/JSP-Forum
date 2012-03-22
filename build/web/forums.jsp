<%-- 
    Document   : forums
    Created on : Mar 21, 2012, 10:06:14 PM
    Author     : Zerotension
--%>

<%@page import="Forums.PageRequest"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Logged in as <%= PageRequest.loggedIn(request) %></h2>
        <h1>Hello World!</h1>
    </body>
</html>
