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
 * Servlet implementation class display1
 */
@WebServlet("/display2")
public class display2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wjp","root","MYSQLServer123");
		String qry="select * from Round2";
		PreparedStatement ps=con.prepareStatement(qry);
		ResultSet rs=ps.executeQuery();
	
		out.print("<table align='center' border='1' rules='all' cellpadding='5' width='40%'>");
		out.print("<caption><h1 style=color:green;>Available Records</h1></caption>");
		out.print("<tr style=background-color:blue;color:orange;><th>Number</th><th>NameOf Student</th><th>Actions</th></tr>");

		out.print("<body style=backgroundColor:#555>");

		out.print("<h1 align=center style=color:olive>Round2</h1>");
		out.print("<h1 align=center style=color:olive>Congratulations!!!You got college in round 2</h1>");

		out.print("<table align='center' border='1' rules='all' cellpadding='5' width='40%' style=color:green>");
		while(rs.next()) {
			
			out.print("<tr>");
			out.print("<td>"+rs.getInt("no")+"</td>");
					
			
			out.print("<td>"+rs.getString("n")+"</td>");
			out.print("<td>");
			out.print("<a href='view2?no="+rs.getInt("no")+"'>Details</a>");
			//out.print("<a href=''>Update</a>");

			out.print("<a href='delete2?no="+rs.getInt("no")+"'>Delete</a>");

			out.print("</td>");

			out.print("</tr>");
			/*
			 * out.print("<tr><td>Percentage</td>");
			 * out.print("<td>"+rs.getFloat("p")+"</td></tr>");
			 * out.print("<tr><td>College Name</td>");
			 * out.print("<td>"+rs.getString("nc")+"</td></tr>");
			 */
		}
		out.print("</table>");

		out.print("</body>");

	}
	catch (Exception e) {
		// TODO: handle exception
		out.print(e);
		e.printStackTrace();

	}
	out.print("<a href='Round2.html'>Round2</a><br><br><br>");
	out.print("<a href='CollegeFee.html'>CollegeFee</a><br><br><br>");

	out.print("<a href='Logout.html'>Logout</a>");

}

}


