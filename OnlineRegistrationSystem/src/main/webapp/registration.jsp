<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form</title>
</head>
<body>
<%@ include file="header.jsp" %>
			<h2>Registration Form</h2>
			<form action="RegistrationServlet" method ='post'>
			Name: <input type="text" name = "name"><br>
			Email: <input type="text" name = "email"><br>
			Password: <input type="password" name ="password"><br>

		<input type="submit" value="Register">
</form>
</body>
</html>