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

/**
 * Servlet implementation class deleteUser
 */
@WebServlet("/deleteUser")
public class deleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	       
	        try
	        {
	             int id=Integer.parseInt(req.getParameter("id"));
	             UserDAO dao=new UserDAO(DBConnect.getConn());
	            boolean f=dao.deleteUsers(id);
	            HttpSession session=req.getSession();
	          if(f)
	          {
	              session.setAttribute("successMsg", "User Delete Successfully");
	              resp.sendRedirect("index.jsp");
	          }else
	          {
	              session.setAttribute("failedMsg", "Something wrong on Server");
	              resp.sendRedirect("index.jsp");
	          }
	             
	        }catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	        
	        
	    }

}
