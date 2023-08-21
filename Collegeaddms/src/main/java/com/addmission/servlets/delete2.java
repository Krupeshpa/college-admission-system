package com.addmission.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class deleteeducation
 */
@WebServlet("/delete2")
public class delete2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//String applicationtype =request.getParameter("at");
		int no=Integer.parseInt(request.getParameter("no"));
		PrintWriter out =response.getWriter();
		response.setContentType("text/html");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wjp", "root","MYSQLServer123");
			String qry = "DELETE FROM Round2 WHERE no=?";
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setInt(1,no);
			int i=ps.executeUpdate();
			if(i>0) {
			response.sendRedirect("display2");
			}
		} catch(Exception e) {
			out.print(e);
			e.printStackTrace();
		}
		out.print("<a href='Round2.html'>Go back</a>");

		out.print("<a href='AddmissionForm.html'>Addmission</a>");
	}
	
	

}
