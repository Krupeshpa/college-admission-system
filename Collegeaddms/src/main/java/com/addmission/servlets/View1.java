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
 * Servlet implementation class View1
 */
@WebServlet("/view1")
public class View1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
		//int no=Integer.parseInt(request.getParameter("no"));
		int no=1;
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wjp","root","MYSQLServer123");
			String qry="select * from Round1 where no=?";
			PreparedStatement ps=con.prepareStatement(qry);
			ps.setInt(1,no);
			ResultSet rs=ps.executeQuery();
		
			out.print("<h1 style=color:green align=center>Round1 Details</h1>");
			out.print("<table align='center' border='1' rules='all' cellpadding='5' width='40%'style=color:purple>");
			while(rs.next()) {
				out.print("<tr><td>Number</td>");
				out.print("<td>"+rs.getInt("no")+"</td></tr>");
				out.print("<tr><td>Student Name</td>");
				out.print("<td>"+rs.getString("n")+"</td></tr>");
				out.print("<tr><td>Percentage</td>");
				out.print("<td>"+rs.getFloat("p")+"</td></tr>");
				out.print("<tr><td>College</td>");
				out.print("<td>"+rs.getString("nc")+"</td></tr>");
				
			}
			out.print("</table>");
		} catch(Exception e) {
			out.print(e);
			e.printStackTrace();
		}
		out.print("<a href='Round1.html'>Round1</a><br><br><br>");

			
	}
}
			
			
			
			
			
			
		