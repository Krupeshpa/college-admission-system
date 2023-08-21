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
import java.sql.Statement;

/**
 * Servlet implementation class AdmissionForm
 */
@WebServlet("/addmission")
public class AddmissionForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String name = request.getParameter("n");
		String email = request.getParameter("e");
		long mobileno = Long.parseLong(request.getParameter("mo"));

		String date = request.getParameter("d");
		String cast = request.getParameter("c");
		String city = request.getParameter("ci");
		String state = request.getParameter("s");
		long adharcard = Long.parseLong(request.getParameter("a"));
		float marks = Float.parseFloat(request.getParameter("m"));
		String achievements = request.getParameter("ac");
		String college = request.getParameter("co");
		 String aplicationstatus="N";
		String applicationtype =(String)request.getSession().getAttribute("edcn");
		System.out.println(applicationtype);
		
		String username = request.getParameter("u");
		if (username == null) {

			//response.sendRedirect("Round1.html");
			//response.sendRedirect("Round2.html");
			 response.sendRedirect("Round3.html");
			// response.sendRedirect("CollegeFee.html");

		}
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wjp", "root", "MYSQLServer123");
			Statement smt = con.createStatement();
			String qry = "insert into AddmissionForm values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(qry);

			ps.setString(1, name);
			ps.setString(2, email);
			ps.setLong(3, mobileno);
			ps.setString(4, date);
			ps.setString(5, state);
			ps.setLong(6, adharcard);
			ps.setFloat(7, marks);
			ps.setString(8, achievements);
			// ps.setString(9,aplicationstatus);
			ps.setString(9, applicationtype);

			//ResultSet rs = ps.executeQuery();
			int i=ps.executeUpdate();
			if(i==1) {
				out.print("<h1>One record inserted</h1>");
				out.print("<a href='AddmissionForm.html'></a>");
				HttpSession session = request.getSession();
				session.setAttribute("message", "One Record Inserted");
				//response.sendRedirect("round1");

				//response.sendRedirect("round2");
				//response.sendRedirect("round3");
			}
			/*
			 * if(rs.next()) { out.print("Name: "+rs.getString("n"));
			 * out.print("Email: "+rs.getString("e"));
			 * out.print("Mobile: "+rs.getLong("mo"));
			 * out.print("Date: "+rs.getString("d")); out.print("Cast: "+rs.getString("c"));
			 * out.print("City: "+rs.getString("ci"));
			 * out.print("State: "+rs.getString("s"));
			 * out.print("Adharcard: "+rs.getLong("a"));
			 * out.print("Marks: "+rs.getFloat("m"));
			 * out.print("AdharcardNumber: "+rs.getString("ac"));
			 * out.print("College Name: "+rs.getString("co"));
			 * 
			 * out.print("<h1>::Name"+(name)+"</h1>");
			 * out.print("<h1>::Email"+(email)+"</h1>");
			 * //out.print("<h1>::Mobile"+(mobileno)+"</h1>");
			 * out.print("<h1>::Date"+(date)+"</h1>");
			 * out.print("<h1>::Cast"+(cast)+"</h1>");
			 * out.print("<h1>::City"+(city)+"</h1>");
			 * out.print("<h1>::State"+(state)+"</h1>");
			 * //out.print("<h1>::Adharcard"+(adharcard)+"</h1>");
			 * //out.print("<h1>::Marks"+(marks)+"</h1>");
			 * out.print("<h1>::Achievements"+(achievements)+"</h1>");
			 * out.print("<h1>::CollegeName"+(college)+"</h1>");
			 * 
			 * out.print("<a href='dashboard'>Dashboard</a>");
			 * out.print("<a href='logout'>Log Out</a>");
			 * 
			 * 
			 * // ps.setString(1,email); //ps.setLong(3,mobileno); //ps.setString(4,date);
			 * //ps.setString(5,cast); //ps.setString(6,city); //ps.setString(7,state);
			 * ps.setLong(8,adharcard); ps.setFloat(9,marks); ps.setString(10,achievements);
			 * ps.setString(11,college);
			 * 
			 * } else { out.print("<script>"); out.print("alert('Invalid email')");
			 * out.print("<h1>::Name"+(name)+"</h1>");
			 * out.print("<h1>::Email"+(email)+"</h1>"); //
			 * out.print("<h1>::Mobile"+(mobileno)+"</h1>");
			 * out.print("<h1>::Date"+(date)+"</h1>");
			 * out.print("<h1>::Cast"+(cast)+"</h1>");
			 * out.print("<h1>::City"+(city)+"</h1>");
			 * out.print("<h1>::State"+(state)+"</h1>");
			 * //out.print("<h1>::Adharcard"+(adharcard)+"</h1>");
			 * //out.print("<h1>::Marks"+(marks)+"</h1>");
			 * out.print("<h1>::Achievements"+(achievements)+"</h1>");
			 * out.print("<h1>::CollegeName"+(college)+"</h1>");
			 * 
			 * out.print("window.location='AddmissionForm.html'"); out.print("</script>"); }
			 */
		
			 //out.println("<html><body><b>Successfully Inserted"
            //         + "</b></body></html>");

		} catch (Exception e) {
			out.print(e);
			e.getStackTrace();
		}
	}

}
