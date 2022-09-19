package com.Servlet;
import com.DAO.UserDAO;
import com.Db.DBConnect;
import com.user.UserDetails;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	     try
	     {
	         int id=Integer.parseInt(req.getParameter("id"));
	          String name=req.getParameter("fname");
	          String email=req.getParameter("email");
	            String password=req.getParameter("password");
	         
	           
	          UserDetails b=new UserDetails();
	        b.setId(id);
	        b.setName(name);
	        b.setEmail(email);
	        b.setPassword(password);
	          
//	           b.setBookName(bookName);
//	           b.setAuthor(Author);
//	           b.setPrice(price);
//	           b.setStatus(status);
	           
	           UserDAO dao=new UserDAO(DBConnect.getConn());
	          boolean f= dao.updateUser(b);
	          
	          HttpSession session=req.getSession();
	          if(f)
	          {
	              //session.setAttribute("s1", "User Update Successfully");
	              resp.sendRedirect("index.jsp");
	          }else
	          {
	             // session.setAttribute("f1", "Something wrong on Server");
	              resp.sendRedirect("index.jsp");
	          }
	                
	     }catch(Exception e)
	     {
	         e.printStackTrace();
	     }
	        
	        
	        
	    }

}
