package com.Admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jdbc.DBConfig;

/**
 * Servlet implementation class AdminLogin
 */
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminLogin() {
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
		
		Connection conn = DBConfig.getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement("select * from admin");

			ResultSet rs = stmt.executeQuery();

			PrintWriter out = response.getWriter();
			String name = request.getParameter("admin_name");
			String password = request.getParameter("admin_password");
			while (rs.next()) {
				
				//if (name.equalsIgnoreCase("shivam") && password.equals(rs.getString("Shivam123")))
				if (name.equalsIgnoreCase(rs.getString("a_name")) && password.equals(rs.getString("a_password"))) {
					out.print("<center><h1 style='color:green'>Login Successful</h1><center>");
					HttpSession session = request.getSession();
					session.setAttribute("session_name",name );
					
				  //to invalidate session if user is inactive for more than 5 minutes
					 
				 /* long creationTimeMillis = session.getCreationTime(); or .getLastAccessedTime()
					long currentTimeMillis  = System.currentTimeMillis();
					long inactiveTimeMillis = currentTimeMillis-creationTimeMillis;
					long inactiveTimeSeconds= inactiveTimeMillis/1000;//convert millis into second
					if(inactiveTimeSeconds>300)//5 minutes = 300 seconds
					{
						session.invalidate();
					}*/
					out.println("<center><h3 style='color:blue'>welcome "+name+" Logged in  "+new Date()+"</h3><center>");
					request.getRequestDispatcher("adminOptions.html").include(request, response);

				} else {

					out.print("<center><h1 style='color:red'>Login Failed Try Again!!</h1></center>");
					request.getRequestDispatcher("adminLogin.html").include(request, response);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
