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
 * Servlet implementation class Registration
 */
@WebServlet("/registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String username=request.getParameter("u");
		String email=request.getParameter("e");
		String password=request.getParameter("p");
		String address=request.getParameter("a");
		Long mobile=Long.parseLong(request.getParameter("m"));
	
	
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wjp","root","MYSQLServer123");
			//String qry="select * from registration2 where u=?";
			String qry="insert into Login  values (?,?)";
			PreparedStatement pst=con.prepareStatement(qry);
			//pst.setString(1,username);
			pst.setString(1, username);
			pst.setString(2, password);
			pst.executeUpdate();

			/*ResultSet rs=pst.executeQuery();

			if(rs.next()) {
				HttpSession session=request.getSession();
				session.setAttribute("username",username);
   				out.print("<h1>Username::"+(username)+"</h1>");
   				out.print("<h1>Email"+(email)+"</h1>");
   				out.print("<h1>Password::"+(password)+"</h1>");
				out.print("<h1>Address"+(address)+"</h1>");
				out.print("<h1>Mobile"+(mobile)+"</h1>");
				
  			
			}
			else {
			out.print("<script>");
				out.print("alert('Invalid username and password')");
				out.print("window.location='Registration.html';");
				out.print("<a href='Login'>LOGIN</a><br><br>");

				out.print("</script>");
			}
*/
			pst.close();
			con.close();
			
			//PrintWriter out = response.getWriter();
            out.println("<html><body><b>Successfully Inserted"
                        + "</b></body></html>");
			response.sendRedirect("Login.html");

		}
		catch (Exception e) {
			// TODO: handle exception
			out.print(e);
			e.getStackTrace();
		
		}
	}
}
