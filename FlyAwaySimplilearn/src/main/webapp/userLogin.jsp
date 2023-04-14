<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

</head>
<body style="background: url(img/airline.jpg); background-size: cover; background-attachment:fixed;">
	<div class="container ">
		<div class="row">
			<div class="col m8 offset-m2" >
				<div class="card" >
				<div class="card-content">
				<h2 style="color: blue" class="center-align">Please Login!!</h2>
				<div class="form center-align ">


					
					 <form action="UserLogin" method="post">
						<table>
							<tr>
								<td>Enter User Name:</td>
								<td><input type="text" name="user_name"
									placeholder="enter username here"></td>
							</tr>
							<tr>
								<td>Enter Password:</td>
								<td><input type="password" name="user_password"
									placeholder="enter password here"></td>
							</tr>
							 
								<!-- <td><input type="submit" value="Login" style="color:red" ></td> -->
								
							


						</table>
						<br>
						<button type="submit" class="btn rgb(102, 153, 115) ">Login</button>
						



					</form>
					</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

<!-- <h2>Please Login</h2>
 <form action="UserLogin" method="post">

Enter User Name:<input type="text" name="user_name"><br><br>
Enter Password:<input type="password" name="user_password"><br><br>

<input type="submit" value="Login">

</form> -->