<%@page import="com.user.ShowFlight"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style >
#mytable tr th{
border:2px solid black;text-align:left;
background-color: rgb(151, 207, 232);
padding: 1px; 

}

</style>

</head>


<body style="background: url(img/HeaderImage-1.png); background-size: cover; background-attachment:fixed;"> 


<h2 style="color:blue">TICKETS DETAILS AND PRICE!!<h2>
 <%
 request.getRequestDispatcher("index.jsp").include(request, response);
 int id=(int) session.getAttribute("selectedId");
 String source=(String) session.getAttribute("selectedSource");
 String destination=(String) session.getAttribute("selectedDestination");
 String airline=(String) session.getAttribute("selectedAirlineNo");
 String days=(String) session.getAttribute("selectedAvailabledays");
 double price=(double) session.getAttribute("selectedPrice"); %>


 <table id="mytable" >
 
 <tr>
 <th>ID:</th><th> <%=id %> </th>
 </tr>
 
 <tr>
 <th>Source:</th><th> <%=source %> </th>
</tr>

 <tr>
 <th>Destination:</th><th> <%=destination %> </th>
</tr>

 <tr>
 <th>Airline No.:</th><th> <%=airline %> </th>
</tr>

 <tr>
 <th>Available Days:</th><th> <%=days %> </th>
</tr>

 <tr>
 <th>Single Ticket Price:</th><th> <%=price%> </th>
</tr>

 <tr>
 <th>Total Price:</th><th> <%=price*ShowFlight.persons %> </th>
</tr>
 


 </table>
 
 
 <form action="payment" method="post">
Bank Name:<input type="text" name="bank"><br>
Card Number:<input type="text" name="card"><br>
Password:<input type="text" name="password"><br>

<input type="submit" value="Proceed Ahead">
</form>

</body>
</html>