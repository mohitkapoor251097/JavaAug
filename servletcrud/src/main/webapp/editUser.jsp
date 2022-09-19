<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@page import="com.user.UserDetails"%>
<%@page import="com.DAO.UserDAO"%>
<%@page import="com.Db.DBConnect"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
  <style>
             .nam {
           
            font-family: serif;
            color: transparent;
            text-align: center;
            animation: effect 2s linear infinite;
            
        }
 
        @keyframes effect {
            0% {
                background: linear-gradient(
                        #008000, #00FF00);
                -webkit-background-clip: text;
            }
 
            100% {
                background: linear-gradient(
                        #3CE7D7, #000FFF);
                -webkit-background-clip: text;
            }
        }
         </style>
</head>
<body>
 <%
           Integer id=Integer.parseInt(request.getParameter("id")); 
            
            UserDAO user1=new UserDAO(DBConnect.getConn());
            UserDetails b= user1.getUserById(id);
            
            %>
   <div class="container p-3">
     <%@include file="allCss.jsp" %>
             <div class="row">
                 <div class="col-md-4 offset-md-4">
                     <div class="card"  >
                         <div class="card-body ">
                             <h4 class="text-center nam">Edit User</h4>
                             <%
                                String regMsg=(String)session.getAttribute("s1");
                                if(regMsg!=null)
                                {%>
                                <p class="text-center"style="color: green">
                                            
                                    <%=  regMsg  %></p>
                                       
                                <%
                                session.removeAttribute("s1");
                                %>
                                
                                <%
                                }

                                
                                %>
                                 <%
                                String failedMsg=(String)session.getAttribute("f1");
                                if(failedMsg!=null)
                                {%>
                                         <p style="color: red">
                                            
                                             <%=  failedMsg  %></p>
                                            
                                            
                                  
      
                            <%
                                 session.removeAttribute("f1");
                                
                                %>
                               <% 
                                }

                                
                                %>
                              
    <form action="EditServlet" method="post" name="form1" onsubmit="return myfun1()">
       <div class="form-group">
       <input type="hidden" name="id" value="<%= b.getId()     %>">
       
    <label for="exampleInputEmail1">Enter Full Name</label>
    <input type="text" required="required" class="form-control"name="fname" id="exampleInputEmail1" aria-describedby="emailHelp"
     value="<%= b.getName()     %>">
  </div>
  <div class="form-group">
    <label for="ema">Email address</label>
    <input type="email" class="form-control"  required="required" name="email" id="ema" aria-describedby="emailHelp" 
     value="<%= b.getEmail()     %>">
     
  </div>
  <div class="form-group">
    <label for="passw1">Password</label>
    <input type="password" required="required" class="form-control" name="password" id="passw1"
     value="<%= b.getPassword()     %>" >
 
  </div>
  <button type="submit" class="btn btn-primary" style="border-radius: 20px;width:300px" >Submit</button>
</form>
                         </div>
                     </div>
                 </div>
             </div>
         </div> 
             
<div  style="margin-top:30px">
            
             </div>     
             
                
</body>
</html>