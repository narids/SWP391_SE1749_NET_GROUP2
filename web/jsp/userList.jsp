<%-- 
    Document   : userList
    Created on : Feb 21, 2024, 10:23:10 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ page import="java.util.List" %>

<%
    List<String> userList = (List<String>) request.getAttribute("userList");

    if (userList != null && !userList.isEmpty()) {
        for (String username : userList) {
            %>
            <tr>
                <td><%= username %></td>
            </tr>
            <%
        }
    } else {
        %>
        <tr>
            <td colspan="1">Không tìm thấy kết quả nào.</td>
        </tr>
        <%
    }
%>
    </body>
</html>
