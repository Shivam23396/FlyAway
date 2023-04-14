package com.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jdbc.DBConfig;

/**
 * Servlet implementation class UserLogin
 */
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		request.getRequestDispatcher("index.jsp").include(request, response);
		Connection conn = DBConfig.getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement("select * from user");

			ResultSet rs = stmt.executeQuery();

			PrintWriter out = response.getWriter();
			String name = request.getParameter("user_name");
			String password = request.getParameter("user_password");
			boolean flag=false;
			while (rs.next()) {
				
				//if (name.equalsIgnoreCase("shivam") && password.equals(rs.getString("Shivam123")))
				if (name.equalsIgnoreCase(rs.getString("username")) && password.equals(rs.getString("password"))) {
					out.print("<h1>Successfull Login</h1>");
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
					out.println("<h3>welcome "+name+" Logged in  "+new Date()+"</h3>");
					request.getRequestDispatcher("userFlightSearch.jsp").include(request, response);
					flag=true;

				}
			} if(flag==false) {

			out.print("<h1>Login Failed Try Again!!</h1>");
			request.getRequestDispatcher("userLogin.jsp").include(request, response);
		}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
