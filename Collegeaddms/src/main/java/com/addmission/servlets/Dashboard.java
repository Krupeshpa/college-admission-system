package com.addmission.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Dashboard
 */
@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("username");
		if(username==null) {
			response.sendRedirect("Registration.html");
		}
		out.print("<body align=center style=color:orange>");

		out.print("<h1>Login page</h1>");
		out.print("<h1>welcome to this page</h1><br><br>");
		out.print("<h1>"+username+"</h1>");
		out.print("<a href='form'>Form</a><br><br>");
		out.print("<a href='addmission'>AddmissionForm</a>");
		
		out.print("<a href='round1'>Round1</a>");
		out.print("<a href='round2'>Round2</a>");
		out.print("<a href='Round3'>Round3</a>");
		out.print("<a href='logout'>Logout</a>");

	}

}
