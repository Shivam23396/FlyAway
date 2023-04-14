<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.jdbc.DBConfig"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>



</head>
<body style="background: url(img/web_aircraft-no-identification_iStock-155439315.png); background-size: cover; background-attachment:fixed;">
	<div class="container ">
		<div class="row">
			<div class="col m8 offset-m2" >
				<div class="card" >
				<div class="card-content">
				<h2 style="color: blue" class="center-align">Enter Flight Details!!</h2>
				<div class="form center-align ">
				<div class="input-field">


					
					<form action="ShowFlight" method="post">
						<table>
							<tr>
								<td>Enter your Name:</td>
								<td><input type="text" name="name"placeholder="enter name here"></td>
							</tr>
							<tr>
								<td>Date of Travel (in DD/MM/YYYY ):</td>
								<td><input type="date" name="date"></td>
							</tr>
							
							<tr>
								<td>Choose Gender:</td>
								<td><input type="radio" name="gender" value="Male">MALE <input type="radio" name="gender" value="Female">FEMALE</td>
							</tr>
							
							<%
	   							Connection conn = DBConfig.getConnection();
								Statement statement = conn.createStatement();
		
							%>
							
							<tr>
								<td>Source City:</td>
								<td>
								
								
								<select name="source_city">
								<option >Select Source City</option>
								
								<%
								ResultSet resultSet1 = statement.executeQuery("SELECT DISTINCT source FROM airline");
								while (resultSet1.next()) {
			
								%>
								<option value="<%=resultSet1.getString("source") %>"><%=resultSet1.getString("source")%></option>
								<%
								}
								resultSet1.close();
								%>
								</select>
								
								</td>
								
							</tr>
							
							<tr>
								<td>Destination City:</td>
								
								<td>
								
								<select name="destination_city">
								
								<option >Select Destination City</option>
								
								<%
								ResultSet resultSet2 = statement.executeQuery("SELECT DISTINCT destination FROM airline");
								while (resultSet2.next()) {
				
								%>
								<option value="<%=resultSet2.getString("destination") %>"><%=resultSet2.getString("destination")%></option>
								<%
								}
								resultSet2.close();
								%>
								
								</select>
								
								</td>
								
							</tr>
							
							<tr>
								<td>Enter Number Of Person:</td>
								<td><input type="number" name="number" min="1" max="10"></td>
							</tr>
							 
								<!-- <td><input type="submit" value="Login" style="color:red" ></td> -->
								
							


						</table>
						<br>
						<button type="submit" class="btn blue ">Show Flight</button>
						



					</form>
					</div>
					</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

<%-- <form action="ShowFlight" method="post">
		Enter your Name:<input type="text" name="name"> <br><br>
		 Date of Travel (in DD/MM/YYYY ):<input type="date" name="date"><br><br>
		 <input type="radio" name="male" value="Male">MALE

		<%
		Connection conn = DBConfig.getConnection();
		Statement statement = conn.createStatement();
		
		%>

		Source City:<select name="source_city">
		
		<option >Select Source City</option>

			<%
			ResultSet resultSet1 = statement.executeQuery("SELECT DISTINCT source FROM airline");
			while (resultSet1.next()) {
			
			%>
			<option value="<%=resultSet1.getString("source") %>"><%=resultSet1.getString("source")%></option>
			<%
			}
			resultSet1.close();
			%>
		</select>
		<br><br>
		
		Destination city:<select name="destination_city">
		
		<option >Select Destination City</option>
		
		<%
		
		ResultSet resultSet2 = statement.executeQuery("SELECT DISTINCT destination FROM airline");
			while (resultSet2.next()) {
				
			%>
			<option value="<%=resultSet2.getString("destination") %>"><%=resultSet2.getString("destination")%></option>
			<%
			}
			resultSet2.close();
			%>
		</select>
		<br><br>
		
		
		
		  Enter Number Of Person: <input type="number" name="number" min="1" max="10"><br><br> 
		  
		  
		
	comment
	
	    Enter number of person<select name ="persons">
		<%
		 for(int i=0;i<=10;i++){
		
		%>

		<option value="i"><%=i %></option>
		<%
		 }
		%> 
		
			
		
		
		</select>
		<input type="submit" value="SUBMIT">

	</form>
 --%>