package com.Admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jdbc.DBConfig;

/**
 * Servlet implementation class ViewAirline
 */
public class ViewAirline extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewAirline() {
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
		response.setContentType("text/html");
		request.getRequestDispatcher("index.jsp").include(request, response);

		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		Connection conn = DBConfig.getConnection();
		HttpSession session = request.getSession(false);
		if (session != null) {
			try {

				PreparedStatement stmt = conn.prepareStatement("select * from airline");
				ResultSet rs = stmt.executeQuery();

				out.print("<h2 style='text-align:center; color:blue'>Registered Airlines:- </h2>");

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

				out.print("</tr>");

				while (rs.next()) {

					out.print("<tr>");

					out.print("<th>" + rs.getInt("id") + "</th>");
					out.print("<th>" + rs.getString("source") + "</th>");
					out.print("<th>" + rs.getString("destination") + "</th>");
					out.print("<th>" + rs.getString("airlineNo") + "</th>");
					out.print("<th>" + rs.getString("availabledays") + "</th>");
					out.print("<th>" + rs.getDouble("price") + "</th>");

					out.print("</tr>");

				}
				out.print("</center></table >");
				out.print("<br>");

				out.print("<form action=\"adminOptions.html\"method=\"post\">");
				out.println(
						"<center><input style=\"color:red\" type=\"submit\" value=\"GO BACK TO ADMIN PORTAL\"></center>");
				out.print("</form>");
				out.print("</body></html>");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			out.print("<center><h2 style='color:blue'>Session Has Expired Please Login!!<h2></center>");
			request.getRequestDispatcher("adminLogin.html").include(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}
