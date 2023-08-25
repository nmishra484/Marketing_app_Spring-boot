<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ include file = "menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>leads</title>
</head>
<body>
<h2>All leads</h2>
<table>
<tr>
<th>Id</th>
<th>First Name</th>
<th>Last Name</th>
<th>Email</th>
<th>Mobile</th>
<th>Actions</th>
</tr>
<c:forEach var="lead" items="${leads}">
           </c:forEach>
<tr>
<td>${lead.id}</td>
<td>${lead.firstName}</td>
<td>${lead.lastName}</td>
<td>${lead.email}</td>
<td>${lead.mobile}</td>
<td><a href="delete?id=${lead.id}">delete</a></td>
<td><a href="update?id=${lead.id}">update</a></td>
</tr>
</table>
</body>
</html>