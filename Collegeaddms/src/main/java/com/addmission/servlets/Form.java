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
@WebServlet("/form")
public class Form extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		//HttpSession session = request.getSession();

		response.setContentType("text/html");
		String education=request.getParameter("edu");
		String username=request.getParameter("u");
		request.getSession().setAttribute("edcn", education);

		if(username==null) {
			response.sendRedirect("AddmissionForm.html");
		}
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wjp","root","MYSQLServer123");
		//String qry="SELECT * FROM Form WHERE u=?";
		//PreparedStatement ps=con.prepareStatement(qry);
		//ps.setString(1,username);
		
		//ResultSet rs=ps.executeQuery();
		/*
		 * if(rs.next()) {
		 * 
		 * HttpSession session=request.getSession();
		 * session.setAttribute("username",username);
		 * response.sendRedirect("Addmission.html");
		 * 
		 * out.print("Education: "+rs.getString("edu"));
		 * out.print("<h1>Education::"+(education)+"</h1>");
		 * 
		 * out.print("<a href='Dashboard'>Dashboard</a>");
		 * out.print("<a href='logout'>Logout</a>");
		 * 
		 * } else { out.print("<script>");
		 * out.print("alert('Invalid education field');");
		 * out.print("<h1>Education::"+(education)+"</h1>");
		 * 
		 * out.print("window.location='Form.html';"); out.print("</script>"); }
		 * //out.print("<a href='addmission'>AddmissionForm.html");
		 * 
		 */}
	catch (Exception e) {
		// TODO: handle exception
		out.print(e);
		e.printStackTrace();
	}
}

}

	