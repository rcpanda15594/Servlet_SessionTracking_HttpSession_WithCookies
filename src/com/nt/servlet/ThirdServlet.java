package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/thirdurl")
public class ThirdServlet extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String city=null,sal=null;
//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		
		
//read form3/req3 data
		
		city=req.getParameter("city");
		sal=req.getParameter("sal");
	
//Get access to Session Object
		HttpSession ses=req.getSession(false);
		
//read form1/req1 and form2/req2 data from session object
		String name=(String)ses.getAttribute("name");
		String addr=(String)ses.getAttribute("addr");
		String age=(String)ses.getAttribute("age");
		String exp=(String)ses.getAttribute("exp");
		String skil=(String)ses.getAttribute("skil");
		
		
//insert form1/req1,form2/req2,form3/frq3 value as record
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			PreparedStatement ps=con.prepareStatement("insert into info values(?,?,?,?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,addr);
			ps.setString(3,age);
			ps.setString(4,exp);
			ps.setString(5,skil);
			ps.setString(6,city);
			ps.setString(7,sal);
			
			int i=ps.executeUpdate();
			
		
		
//invaildate the session
		ses.invalidate();
		
		if(i>0) {
			pw.println("<body bgcolor=cyan");
			pw.println("<h1><center><font color=red><b>Your Details Sucessfully Inserted...</center></h1>");
		    pw.println("<a href=personal.html>Home</a>");
		}
		else {
			pw.println("<body bgcolor=cyan");
			pw.println("<h1><center><font color=red>Your Details Not Inserted ,try again...</center></h1>");
			pw.println("<a href=personal.html>Home</a>");
		}//else
		}//try
		catch(Exception e) {
			e.printStackTrace();
			pw.println("<body bgcolor=cyan");
			pw.println("<h1><center><font color=red>Your Details Not Inserted ,try again...</center></h1>");
	
			
		}
	
		
	}//doget
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}//class
