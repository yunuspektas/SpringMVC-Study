<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Add Student</title>
</head>
<body>
<form:form modelAttribute="student" method="post">
    First Name:<form:input path="firstName"/><br/>
    Last Name:<form:input path="lastName"/><br/>
    Grade:<form:input path="grade"/><br/>
    <form:button name="submit">Create</form:button>
</form:form>
</body>
</html>