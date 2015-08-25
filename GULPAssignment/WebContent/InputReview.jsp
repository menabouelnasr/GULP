<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${message}

<form class= "text-center" action="InputReview.jsp"  method="post">
Date (MM/DD/YYYY):
<input type="number" placeholder= "ex 08/12/1999" name="date"> </input><br>
<br>
Average Rating:<br>
<input type="number" placeholder= "0-5" name="rating"> </input><br>
<br>
Review:<br>
<input type="text" name="review"></input><br>
<br>
<button type="submit" value = "submit" class= "button btn-primary form-control">Submit</button>

</form>

</body>
</html>