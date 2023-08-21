package com.addmission.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class Fee
 */
@WebServlet("/fee")
public class Fee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		HttpSession session=request.getSession();
		int no=Integer.parseInt(request.getParameter("no"));
		float educationfee=Float.parseFloat(request.getParameter("ef"));
		float extracurriculumfee=Float.parseFloat(request.getParameter("ex"));
		float maintainancefee=Float.parseFloat(request.getParameter("m"));
		String username=request.getParameter("u");
		if(username==null) {

			response.sendRedirect("viewfee");
		}

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wjp", "root","MYSQLServer123");
			String qry = "insert into fee values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setInt(1,no);
			ps.setFloat(2,educationfee);
			ps.setFloat(3,extracurriculumfee);
			ps.setFloat(4,maintainancefee);
			
			
			
			int i=ps.executeUpdate();
			if(i==1) {
				out.print("<h1>One record inserted</h1>");
				out.print("<a href='CollegeFee.html'></a>");
				//HttpSession session = request.getSession();
				session.setAttribute("message", "One Record Inserted");
				response.sendRedirect("view");
			}
			
			
			
			
			
			/*
			 * ResultSet rs = ps.executeQuery(); if(rs.next()) {
			 * out.print("<body style=color:blue align=center>");
			 * 
			 * out.print("<br>educationfee:"+rs.getFloat("ef"));
			 * out.print("<br>Extra curriculum fee:"+rs.getFloat("ex"));
			 * out.print("<br>Maintainance fee:"+rs.getFloat("m")); out.print("<br><br>");
			 * out.print("<h1>Education Fee"+(educationfee)+"</h1>");
			 * out.print("<a href='logout'>Logout</a>");
			 * out.print("<a href='Dashboard'>Dashboard</a>");
			 * 
			 * out.print("</body>"); }
			 */		} catch (Exception e) {
			out.print(e);
			e.printStackTrace();
			out.print("<a href='CollegeFee.html'>Go back");

		}

	}

}
