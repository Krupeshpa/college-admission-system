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
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
   		PrintWriter out=response.getWriter();
		response.setContentType("text/html");

   		String username=request.getParameter("u");
   		String password=request.getParameter("p");
   		try {
   			Class.forName("com.mysql.cj.jdbc.Driver");
   			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wjp","root","MYSQLServer123");
   			String qry="SELECT * FROM Login WHERE u=? AND p=?";
   		
			PreparedStatement ps=con.prepareStatement(qry);
	
			ps.setString(1,username);
			ps.setString(2,password);
			
			ResultSet rs=ps.executeQuery();
			
   			if(rs.next()) {
   				HttpSession session=request.getSession();
   				session.setAttribute("username",username);
   				out.print("<h1>Username::"+(username)+"</h1>");
   				out.print("<h1>Password::"+(password)+"</h1>");
   				
   				response.sendRedirect("Form.html");
   				response.sendRedirect("Dashboard");
   			}
   			else {
   				out.print("<h1>Username::"+(username)+"</h1>");
   				out.print("<h1>Password::"+(password)+"</h1>");
   				
   				out.print("<script>");
   				out.print("alert('Invalid username and password')");
   				out.print("window.location='Login.html';");
   				out.print("<a href='form'>Form</a><br><br>");

   				out.print("</script>");
   			}
   			}
   			catch (Exception e) {
   				out.print(e);
   				e.printStackTrace();
   			}
   		}

   	}
