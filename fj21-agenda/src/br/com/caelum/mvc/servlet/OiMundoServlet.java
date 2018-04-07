package br.com.caelum.mvc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OiMundoServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter(); //using response because we are going to show this on the tomcat response to the navigator, the html file
		Calendar calendar = Calendar.getInstance();
		
		pw.println("<html><body><h1>");
		
		pw.println(calendar.getTime());
		
		pw.println("</h1></body></html>");
	}

}
