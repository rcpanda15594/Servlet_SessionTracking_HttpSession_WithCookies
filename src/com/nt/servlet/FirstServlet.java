package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.jdt.internal.compiler.parser.ParserBasicInformation;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {

	@Override
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw=null;
		String name=null,address=null,age=null;
		
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		
//read form1/req1 data
		name=req.getParameter("name");
		address=req.getParameter("address");
		age=req.getParameter("age");
		
//create session for browser window
		HttpSession ses=req.getSession();
		
//keep form1/req1 data in session attributes
		ses.setAttribute("name",name);
		ses.setAttribute("addr",address);
		ses.setAttribute("age",age);
		
//Generate form2 dynamically
		pw.println("<body bgcolor=cyan>");
		pw.println("<h1><center><font color=red>Provide your Exp & Skill</font></center></h1>");
		pw.println("<form action='secondurl' method='post'>");
		pw.println("<table align=center>");
		pw.println("<tr>");
		pw.println("<td>");
		pw.println("<h3><font color=blue>Enter no of Exp:</font></h3>");
		pw.println("<input type=text name=exp");
		pw.println("</td>");
		pw.println("</tr>");
		
		
//=======================================================================================
		
		pw.println("<tr>");
		pw.println("<td>");
		pw.println("<h3><font color=blue>Select Skill:</font></h3>");
		//pw.println("<input type=text name=skil");
		pw.print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp");
		pw.print("<select name=skill");
		pw.print("<option value=any>Select First</option>");
		pw.print("<option value=java>JAVA</option>");
		pw.print("<option value=asp>.Net</option>");
		pw.print("<option value=oracle>Oracle</option>");
		pw.print("<option value=xml>XML & WebService</option>");
		pw.print("</select>");
		pw.println("</td>");
		pw.println("</tr>");
		
		
		pw.println("<tr>");
		pw.println("<td>");
		pw.println("<input type=submit value=Continue>");
		pw.println("</td></tr></table></body>");
		
		
		//close stream
		pw.close();
	
	}//doget
	
	@Override
public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//dopost
	
	
}//class
