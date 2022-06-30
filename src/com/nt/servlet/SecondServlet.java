package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   PrintWriter pw=null;
	   String exp=null,skil=null;
	//general settings
			pw=res.getWriter();
			res.setContentType("text/html");
			
//read form2/req2 data
			exp=req.getParameter("exp");
			skil=req.getParameter("skill");

//get access to Session object
			HttpSession ses=req.getSession(false);

//keep form2/req2 data in session attributes
			ses.setAttribute("exp",exp);
			ses.setAttribute("skill", skil);
			
//Generate form2 dynamically
			pw.println("<body bgcolor=cyan>");
			pw.println("<h1><center><font color=red>Provide City & Salary</font></center></h1>");
			pw.println("<form action='thirdurl' method='post'>");
			pw.println("<table align=center>");
			pw.println("<tr>");
			pw.println("<td>");
			pw.println("<h3><font color=blue>Enter Prefernce City:</font></h3>");
			pw.println("<input type=text name=city");
			pw.println("</td>");
			pw.println("</tr>");
			
						
			pw.println("<tr>");
			pw.println("<td>");
			pw.println("<h3><font color=blue>Enter Expected Salary:</font></h3>");
			pw.println("<input type=text name=sal");
			pw.println("</td>");
			pw.println("</tr>");
			
			
			pw.println("<tr>");
			pw.println("<td>");
			pw.println("<input type=submit value=Submit>");
			pw.println("</td></tr></table></body>");
			
			//close stream
			pw.close();
}//doget

	
public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//dpost

}//class
