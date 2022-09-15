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
 * Servlet implementation class Profile
 */
@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	   
	        HttpSession session=request.getSession();  
	        String name=(String)session.getAttribute("name"); 
	        if(name!=null){  
	       
	        	session.setAttribute("name", name);
                response.sendRedirect("profile.jsp");
	       
	      // out.print("Hello, "+name+" Welcome to Profile");  
	       // out.print("<a href='Logout'>Logout</a>");
	        }  
	        else{  
	         //  out.print("Please login first");  
	          // request.getRequestDispatcher("index.html").include(request, response);  
	        	session.setAttribute("msg1","Please Login First....");
                response.sendRedirect("index.jsp");
	       
	        }  
	}

	

}
