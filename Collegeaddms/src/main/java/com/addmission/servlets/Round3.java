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
 * Servlet implementation class Round1
 */
@WebServlet("/round3")
public class Round3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	/**
	 *
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PrintWriter out=response.getWriter();
			response.setContentType("text/html");
			HttpSession session=request.getSession();
			int no=Integer.parseInt(request.getParameter("no"));
			String name=request.getParameter("n");
			float percentage=Float.parseFloat(request.getParameter("p"));
			String collegename=request.getParameter("cn");
			String username=request.getParameter("u");
			/*
			 * if(username==null) {
			 * 
			 * response.sendRedirect("view1"); }
			 */
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wjp", "root","MYSQLServer123");
				String qry = "insert into Round3 values(?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(qry);
				ps.setInt(1,no);
				ps.setString(2,name);
				ps.setFloat(3,percentage);
				ps.setString(4,collegename);
				//ResultSet rs = ps.executeQuery();
				int i=ps.executeUpdate();
				if(i==1) {
					out.print("<h1>One record inserted</h1>");
					out.print("<a href='Round3.html'></a>");
					//HttpSession session = request.getSession();
					session.setAttribute("message", "One Record Inserted");
					response.sendRedirect("view3");
				}
				/*
				 * if(rs.next()) { out.print("<body style=color:blue align=center>");
				 * out.print("<br>:Number"+rs.getInt("no"));
				 * out.print("<br>Name of Student:"+rs.getString("n"));
				 * out.print("<br>:Percentage"+rs.getFloat("p"));
				 * out.print("<br>Name of college:"+rs.getString("nc")); out.print("<br><br>");
				 * out.print("<h1>name"+(name)+"</h1>");
				 * out.print("<a href='logout'>Logout</a>");
				 * out.print("<a href='Dashboard'>Dashboard</a>");
				 * 
				 * out.print("</body>"); }
				 */			} catch (Exception e) {
				out.print(e);
				e.printStackTrace();
				out.print("<a href='Round3.html'>Go back");

			}

		}

	}

