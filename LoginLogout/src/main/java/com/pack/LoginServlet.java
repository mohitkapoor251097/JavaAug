package com.pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();   
	        String name=request.getParameter("name").trim();  
	        String password=request.getParameter("password").trim();  
	        HttpSession session=request.getSession();  
	        if(password.equals("admin") && name.equals("admin")){  
	        out.print("Welcome, "+name);  
	       
	        session.setAttribute("name",name);
	        response.sendRedirect("Profile");
	        }  
	        else{  
	            //out.print("Sorry, username or password error!");  
	            //request.getRequestDispatcher("index.html").include(request, response);  
	        	session.setAttribute("msg","Sorry, username or password error!");
		        response.sendRedirect("index.jsp");
	        }  
	}

}
