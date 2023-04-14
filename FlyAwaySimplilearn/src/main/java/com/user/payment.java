package com.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jdbc.DBConfig;

/**
 * Servlet implementation class payment
 */
public class payment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public payment() {
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
		Connection conn = DBConfig.getConnection();
		PrintWriter out = response.getWriter();
		String bank = request.getParameter("bank");
		int card = Integer.parseInt(request.getParameter("card"));
		String password = request.getParameter("password");
		HttpSession session = request.getSession(false);
		int flag = 0;

		if (session != null) {
			try {
//			int id=(int) session.getAttribute("selectedId");
//			String source=(String) session.getAttribute("selectedSource");
//			String destination=(String) session.getAttribute("selectedDestination");
//			String airline=(String) session.getAttribute("selectedAirlineNo");
//			String availabledays=(String) session.getAttribute("selectedAvailabledays");
//			double price=(double) session.getAttribute("selectedPrice");

				PreparedStatement stmt = conn.prepareStatement("select * from user");
				ResultSet rs = stmt.executeQuery();
				if (rs != null) {
					while (rs.next()) {
						if (card == rs.getInt("BankcardNO") && password.equals(rs.getString("password"))) {
							// double totalPrice= price* ShowFlight.persons;
							// out.print("<h2>Total Price="+totalPrice+"<h2>");
							out.println("<h2>ticket booked successfully<h2>");
							flag = 1;

						}

					}
					if (flag == 0) {
						out.print("<h2>card no and password is incorrects<h2>");
						out.print("<br>");
						out.print("<html><body>");
						out.print("<form action=\"payment.jsp\"method=\"post\">");
						out.println("<center><input type=\"submit\" value=\"GO BACK TO PAYMENT AGAIN\"></center>");
						out.print("</form>");
						out.print("</body></html>");
					}

				} else {
					out.print("<h2>user not found<h2>");
				}

			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		else {
			out.print("<h2>Session is expire. Please Login!!<h2>");
		}

	}

}
