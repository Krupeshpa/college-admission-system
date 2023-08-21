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
 * Servlet implementation class ViewFee
 */
@WebServlet("/viewfee")
public class ViewFee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			//int no=Integer.parseInt(request.getParameter("no"));
			 //int no=1;
			PrintWriter out=response.getWriter();
			response.setContentType("text/html");
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wjp","root","MYSQLServer123");
				String qry = "SELECT * FROM Fee";
				PreparedStatement ps=con.prepareStatement(qry);
				//ps.setInt(1,no);
				ResultSet rs=ps.executeQuery();
				out.print("<h1 align=center style=color:olive>Fee submitted</h1>");
				out.print("<h1 align=center style=color:olive>Join college before open</h1>");
				out.print("<caption><h1 style=color:red align=center>Available Records</h1></caption>");
				out.print("<tr style=background-color:orange; color:blue;><th align=center style=color:red;>No</th><th align=center style=color:red;>Actions</th></tr>");

				out.print("<body style=backgroundColor:#555>");

				out.print("<table align='center' border='1' rules='all' cellpadding='5' width='40%' style=color:violet>");
				while(rs.next()) {
					out.print("<tr><td>Receipt Number</td>");
					out.print("<td>"+rs.getInt("no")+"</td>");
					out.print("<td>");

					out.print("<a href='view?no="+rs.getInt("no")+"'>Details</a>");

					/*
					 * out.print("<td>Education Fee</td>");
					 * out.print("<td>"+rs.getFloat("ef")+"</td></tr>");
					 * out.print("<tr><td>Extra Curriculum Fee</td>");
					 * out.print("<td>"+rs.getFloat("ex")+"</td></tr>");
					 * out.print("<tr><td>Maintainance Fee</td>");
					 * out.print("<td>"+rs.getFloat("m")+"</td></tr>");
					 */
					out.print("</td>");

					out.print("</tr>");

				}
				out.print("</table>");

				
			}
			catch (Exception e) {
				// TODO: handle exception
				out.print(e);
				e.printStackTrace();

			}
			out.print("<a href='CollegeFee.html'>CollegeFee</a><br><br><br>");
			out.print("<a href='Logout.html'>Logout</a>");

	}

}
