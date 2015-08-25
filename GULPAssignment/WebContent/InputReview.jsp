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
</head>
<body>
<nav class="navbar navbar-inverse">
    <div>
      <ul class="nav navbar-nav">
      	<li><a><b>Restaurant Review and Information:</a></li></b><br><br>
      </ul>
    </div>
</nav>
      
${message}
</div>
<br>
<br>
<br>

${message2}

<br>
<br>
<br>

${message3}
<br>
<br>
<br>

<div class ="class=col-sm-8 col-sm-6 col-sm-offset-0">
<form class= "text-center" action="ToDatabase"  method="post">
Date:<br>
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
</div>
</body>
</html>