<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<title>Supplier Registration</title>
</head>
<body>

<h1>Login Page</h1>

<form method="get" action="/processlogin">

<div>

<label>Id</label>
<input type="number"  name="id">

</div>
<label>Name</label>
<input type="text" name="name">
<div>

<label>Password</label>
<input type="password"  name="password">

</div>

<input type="submit" value="Create Supplier">

</form>

</body>
</html>