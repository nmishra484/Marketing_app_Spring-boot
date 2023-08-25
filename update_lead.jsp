<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file = "menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update</title>
</head>
<body>
<h1>update Lead</h1>
<form action="updatereg" method="post">
<pre>
<input type="hidden" name= "id" value = "${lead.jsp}"/>
First Name<input type="text" name="firstName" value="${lead.firstName}"/>
Last Name<input type="text" name="lastName" value="${lead.lastName}"/>
Email<input type="text" name="email" value="${lead.email}"/>
mobile<input type="text" name="mobile" value="${lead.mobile}"/>
<input type="submit"  value="update"/>
</pre>
</form>
${msg}
</body>
</html>