package com.Admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jdbc.DBConfig;

/**
 * Servlet implementation class AddFlight
 */
public class AddFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddFlight() {
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
		PrintWriter out = response.getWriter();
		Connection conn = DBConfig.getConnection();
		
		HttpSession session= request.getSession(false);
		
		if (session!=null) {

		try {
			String source = request.getParameter("source");
			String destination = request.getParameter("destination");
			String airline = request.getParameter("airline_no.");
			String days = request.getParameter("days");
			double price = Double.parseDouble(request.getParameter("price"));

			PreparedStatement stmt = conn.prepareStatement("insert into airline(source,destination,airlineNo,availabledays,price) values(?,?,?,?,?)");
			stmt.setString(1, source);
			stmt.setString(2, destination);
			stmt.setString(3, airline);
			stmt.setString(4, days);
			stmt.setDouble(5, price);

			int x = stmt.executeUpdate();
			if (x > 0) {
				out.print("<center><h2 style='color:green'>New Flight Added Successfully<h2>");
				out.print("<html><body>");
				out.print("<form action=\"adminOptions.html\"method=\"post\">");
				 out.println("<input type=\"submit\" value=\"GO BACK TO ADMIN PORTAL\">");
				out.print("</form>");
				out.print("</body></html>");
			} else {
				out.print("<center><h2 style='color:red'><h2>Error!! Unable To Insert New Flight<h2></center>");
				out.println("<center><h2 style='color:red'><h2>Please Enter Again<h2></center>");
				request.getRequestDispatcher("AddFlight.html").include(request, response);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		}else {
			out.print("<center><h2 style='color:red'>Session Has Expired Please Login!!<h2></center>");
			request.getRequestDispatcher("adminLogin.html").include(request, response);
		}

	}

}
