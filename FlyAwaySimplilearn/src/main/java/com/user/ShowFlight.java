package com.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jdbc.DBConfig;

/**
 * Servlet implementation class ShowFlight
 */
public class ShowFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static int persons;
	
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowFlight() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		request.getRequestDispatcher("index.jsp").include(request, response);
		// response.setContentType("");

		Connection conn = DBConfig.getConnection();
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		//String date = request.getParameter("date");
		String sourced = request.getParameter("source_city");
		String destination = request.getParameter("destination_city");
	 	ShowFlight.persons = Integer.parseInt(request.getParameter("number"));
		

		/*
		 *  out.print(name + "<br>");
		 *  out.print(sourced + "<br>"); 
		 *  out.print(destination+ "<br>"); 
		 *  out.print(ShowFlight.persons + "<br>");
		 */

		HttpSession session = request.getSession(false);

		if (session != null) {

			try {
				PreparedStatement stmt = conn
						.prepareStatement("select * from airline where source =? and destination=?");
				stmt.setString(1, sourced);
				stmt.setString(2, destination);
				ResultSet rs = stmt.executeQuery();
				out.print("<h2 style='text-align:center; color:blue'>Select Flights Between Source And Destination!! </h2>");

				// show data as table
				out.print("<style> table,td,th {" 
						+ "border:2px solid black;text-align:center;"
						+ "background-color: rgb(151, 207, 232);" 
						+ "padding: 1px; " 
						+ "}</style>");

				out.print("<center><table >");

				out.print("<tr>");

				out.print("<th> ID</th>");
				out.print("<th> Source</th>");
				out.print("<th> Destination</th>");
				out.print("<th> Airline Name</th>");
				out.print("<th> Available Days</th>");
				out.print("<th> Price</th>");
				out.print("<th> Choose Flight</th>");

				out.print("</tr>");
				
				int flag = 0;

				while (rs.next()) {

					out.print("<tr>");

					out.print("<th>" + rs.getInt("id") + "</th>");
					out.print("<th>" + rs.getString("source") + "</th>");
					out.print("<th>" + rs.getString("destination") + "</th>");
					out.print("<th>" + rs.getString("airlineNo") + "</th>");
					out.print("<th>" + rs.getString("availabledays") + "</th>");
					out.print("<th>" + rs.getDouble("price") + "</th>");
					
					out.print("<th>" + "<a style='color: red' href='payment.jsp'>" + "Select Flight" + "</a>"+"</th>");

					out.print("</tr>");
					
					
					out.print("</table ></center>");
					session.setAttribute("selectedId", rs.getInt("id"));
					session.setAttribute("selectedSource", rs.getString("source"));
					session.setAttribute("selectedDestination", rs.getString("destination"));
					session.setAttribute("selectedAirlineNo", rs.getString("airlineNo"));
					session.setAttribute("selectedAvailabledays", rs.getString("availabledays"));
					session.setAttribute("selectedPrice", rs.getDouble("price"));

					flag = 1;

				}
				if (flag == 0) {
					out.print("<h1>No Flight Available Between This Source And Destination<h1>");
					out.print("<h3>Please Select Again<h3>");
					request.getRequestDispatcher("userFlightSearch.jsp").include(request, response);
				}
				
				
				

			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

}
