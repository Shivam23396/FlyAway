package com.Admin;

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
 * Servlet implementation class ChangePassword
 */
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangePassword() {
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
		out.print("<html><body>");
		Connection conn = DBConfig.getConnection();
		HttpSession session = request.getSession(false);
		if(session!=null) {
		try {

			String username = request.getParameter("username");
			String oldpassword = request.getParameter("oldpass");

			String newpassword = request.getParameter("newpass");

			PreparedStatement stmt1 = conn.prepareStatement("select * from admin where a_name=?");
			stmt1.setString(1, username);
			ResultSet rs = stmt1.executeQuery();
			while (rs.next()) {
				
				if(username.equalsIgnoreCase(rs.getString("a_name"))) {
					if (oldpassword.equals(rs.getString("a_password"))) {
						PreparedStatement stmt2 = conn.prepareStatement("update admin set a_password=? where a_name=? ");
						stmt2.setString(1, newpassword);
						stmt2.setString(2, username);
						stmt2.executeUpdate();
						out.print("<center><h2 style='color:blue'> Password Changed Successfully!!</h2>");
						
						out.print("<form action=\"adminLogin.html\"method=\"post\">");
						 out.println("<input type=\"submit\" value=\"PLEASE LOGIN AGAIN TO COTINUE\">");
						out.print("</form>");
						out.print("</center>");
						out.print("</body></html>");

						conn.close();

					} else {
						out.print("<center><h2 style='color:red'> Old Password Is Incorrect!!</h2></center>");
						request.getRequestDispatcher("ChangePassword.html").include(request, response);
					}
					
				}else {
					
					out.print("\"<center><h2 style='color:red'>Enter A Valid User. Username Not Found </h2></center>");
					request.getRequestDispatcher("ChangePassword.html").include(request, response);
				}
				
				
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
