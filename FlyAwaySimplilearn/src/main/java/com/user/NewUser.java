package com.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbc.DBConfig;

/**
 * Servlet implementation class NewUser
 */
public class NewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUser() {
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
		PrintWriter out = response.getWriter();
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		try {
			PreparedStatement stmt = conn.prepareStatement("insert into user(username,password) values(?,?)");
			stmt.setString(1, name);
			stmt.setString(2, password);
			int x=stmt.executeUpdate();
			if(x>0) {
			out.print("<h3>You Have Register Successfully<h3>");
			out.print("<a href=userLogin.jsp>CLICK HERE FOR LOGIN</a>");
			}else {
				out.print("<h3>Error user already exists <h3>");
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
