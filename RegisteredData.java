package website;
import java.sql.*;

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
import java.util.Scanner;

/**
 * Servlet implementation class RegisteredData
 */
public class RegisteredData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisteredData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			String fname=request.getParameter("firstname");
			String lname=request.getParameter("lastname");
			String pwd=request.getParameter("password");
			String email=request.getParameter("email");
			String gnd=request.getParameter("gender");
			System.out.println("Name: " +fname+lname);
	        System.out.println("Email: " + email);
	        System.out.println("Password: " +pwd);
	        System.out.println("Gender: " + gnd);

			out.println("<h2>your name : "+fname+lname);
			out.println("<h2>your email :"+email );
			out.print("<h2>your password :"+pwd);
			out.println("<h2>your gender :"+gnd);
			out.println("<h1>you are registered successfully ");
			//out.close();
	
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver loaded and registered ");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/database1","root","Rajesh@204");
			System.out.println("connection is established ");
			 PreparedStatement  ps = con.prepareStatement("insert into user values (?,?,?,?,?)");
	           ps.setString(1, fname);
	           ps.setString(2,lname);
	           ps.setString(3, gnd);
	           ps.setString(4, pwd);
	           ps.setString(5, email);
	             int val=ps.executeUpdate();
	             System.out.println("updated rows are "+val);
	             System.out.println("data added successfully into database ");
	             con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		/*  response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			String fname=request.getParameter("firstname");
			String lname=request.getParameter("lastname");
			String pwd=request.getParameter("password");
			String email=request.getParameter("email");
			String gnd=request.getParameter("gender");
			System.out.println("Name: " +fname+lname);
	        System.out.println("Email: " + email);
	        System.out.println("Password: " +pwd);
	        System.out.println("Gender: " + gnd);

			out.println("<h2>your name : "+fname+lname);
			out.println("<h2>your email :"+email );
			out.print("<h2>your password :+pwd");
			out.println("<h2>your gender :"+gnd);
			out.println("<h1>you are registered successfully ");
			out.close();
			  */
		
	}
	 

}
