package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.Db.DBConnect;
import com.user.UserDetails;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
    {
       String name=request.getParameter("fname");
       String email=request.getParameter("email");
       String password=request.getParameter("password");
       
       UserDetails us=new UserDetails();
       us.setName(name);
       us.setEmail(email);
       us.setPassword(password);
      
       UserDAO dao=new UserDAO(DBConnect.getConn());
       boolean f=dao.addUser(us);
        HttpSession session;
       if(f)
       {
         
          session= request.getSession();
         session.setAttribute("succMsg","Register Successfully..");
          response.sendRedirect("index.jsp");
       }
       else
       {
            session= request.getSession();
          session.setAttribute("failedMsg","Something went wrong..");
           response.sendRedirect("index.jsp");
       }
    }
}