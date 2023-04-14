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
<body>

<body style="background: url(img/airline.jpg); background-size: cover; background-attachment:fixed;">
	 <div class="container ">
		<div class="row">
			<div class="col m6" >
			<!--	<div class="card" >
				<div class="card-content"> -->
				<h2 style="color: yellow" class="center-align">New User Register Here!!</h2>
				<div class="form center-align ">


					
					 <form action="NewUser" method="post">
						<table>
							<tr>
								<td style="color: grey">Enter Username: </td>
								<td><input type="text" name="username"
									placeholder="enter username here" style="background-color: white;border: 2px solid black;height: 35px"></td>
							</tr>
							<tr>
								<td style="color: grey">Enter Password:</td>
								<td><input type="text" name="password"
									placeholder="enter password here" style="background-color: white;border: 2px solid black;height: 35px"></td>
							</tr>
							 
								<!-- <td><input type="submit" value="Login" style="color:red" ></td> -->
								
							


						</table>
						<br>
						<button type="submit" class="btn red ">Register</button>
						



					</form>
					<!-- </div>
					</div> -->
				</div>
			</div>
		</div>
	</div>

</body>
</html>



<!-- <form action="NewUser" method="post">
Enter Username:<input type="text" name="username"><br><br>
Enter Password:<input type="text" name="password"><br><br>
<input type="submit" value="SUBMIT">
</form> -->