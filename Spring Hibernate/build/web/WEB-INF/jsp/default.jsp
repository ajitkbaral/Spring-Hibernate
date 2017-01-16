<%-- 
    Document   : default
    Created on : Mar 28, 2015, 8:34:32 AM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello ${employee.getName()}</h1>
        <c:forEach items="${employees}" var="emp">
            ${emp.getName()}
        </c:forEach>
        
        <h2>Get By Name ${byName.getName()}</h2>
        
        <form role="form" method="Post">
            <input type="text" name="name"/>
            <input type="submit" value="submit"/>
        </form>
    </body>
</html>
