<%--
  Created by IntelliJ IDEA.
  User: Maciej Podkowa
  Date: 10.12.2019
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>List Customers</title>
</head>
<body>
    <div id="wrapper">

        <div id="header">
            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Nick Name</th>
                    <th>Password</th>
                    <th>Client Orders</th>
                    <th>Adresses</th>

                </tr>

                <!-- look over and print our clients -->
                <c:forEach var="tempClient" items="${clients}">
                    <tr>
                        <td>${tempClient.firstName}</td>
                        <td>${tempClient.lastName}</td>
                        <td>${tempClient.nickName}</td>
                        <td>${tempClient.password}</td>
                        <td>${tempClient.clientOrders}</td>
                        <td>${tempClient.addresses}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>
