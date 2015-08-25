<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/additional-methods.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/additional-methods.min.js"></script>
<title>Insert title here</title>
</head>
<body>

<div class ="col-sm-6 col-sm-2 col-sm-offset-0">
<form class= "text-center" action="SignUp"  method="post">
First Name:<br>
<input type="text" placeholder= "ex. John" name="fName"> </input><br>
<br>
Last Name:<br>
<input type="text" placeholder= "ex. Doe" name="lName"> </input><br>
<br>
Email:<br>
<input type="text" placeholder= "ex. email@domain.com" name="email"></input><br>
<br>
Zip Code:<br>
<input type="number" placeholder= "ex. 55555" name="zip"></input><br>
<br>
<button type="submit" value = "submit" class= "button btn-primary form-control">Create Account</button>
</form>
</div>
</body>
</html>