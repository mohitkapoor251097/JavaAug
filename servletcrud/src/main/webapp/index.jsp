
 <%@page import="com.user.UserDetails"%>
<%@page import="com.DAO.UserDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.user.UserDetails"%>

<%@page import="com.Db.DBConnect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <%@include file="allCss.jsp" %>
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
    <body  style="background-color:#f0f1f2">
     
         <div class="container p-3">
             <div class="row">
                 <div class="col-md-4 offset-md-4">
                     <div class="card"  >
                         <div class="card-body ">
                             <h4 class="text-center nam">Registration Page</h4>
                             <%
                                String regMsg=(String)session.getAttribute("succMsg");
                                if(regMsg!=null)
                                {%>
                                <p class="text-center"style="color: green">
                                            
                                    <%=  regMsg  %></p>
                                       
                                <%
                                session.removeAttribute("succMsg");
                                %>
                                
                                <%
                                }

                                
                                %>
                                 <%
                                String failedMsg=(String)session.getAttribute("failedMsg");
                                if(failedMsg!=null)
                                {%>
                                         <p style="color: red">
                                            
                                             <%=  failedMsg  %></p>
                                            
                                            
                                  
      
                            <%
                                 session.removeAttribute("failedMsg");
                                
                                %>
                               <% 
                                }

                                
                                %>
                              
    <form action="UserServlet" method="post" name="form1" onsubmit="return myfun1()">
       <div class="form-group">
    <label for="exampleInputEmail1">Enter Full Name</label>
    <input type="text" required="required" class="form-control"name="fname" id="exampleInputEmail1" aria-describedby="emailHelp">
  </div>
  <div class="form-group">
    <label for="ema">Email address</label>
    <input type="email" class="form-control"  required="required" name="email" id="ema" aria-describedby="emailHelp" >
     
  </div>
  <div class="form-group">
    <label for="passw1">Password</label>
    <input type="password" required="required" class="form-control" name="password" id="passw1" >
 
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
      
                                                                 
             <table class="table">
  <thead class="bg-primary text-white">
    <tr>
        <th scope="col">Id</th>
      <th scope="col">Name</th>
      <th scope="col">Email</th>
      <th scope="col">Password</th>
      <th scope="col">Action</th><!-- comment -->
       
    </tr>
  </thead>
   
  <tbody>
    
<!--
 <div class="container-fluid">
            <div class="row p-3">-->
               
                   <%
                        UserDAO dao=new UserDAO(DBConnect.getConn());
     List<UserDetails> list= dao.getAllUser();
     
       for(UserDetails b:list)
                       {%>
               
      <tr>
          <td><%=b.getId()    %></td>
    
      <td><%=b.getName() %></td>
      <td><%=b.getEmail()    %></td>
      <td><%=b.getPassword()    %></td>
          <div class="modal fade" id="exampleModalCenter1" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle"></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          
          <div class="text-center">
              
               <h4>Do You want Delete</h4>
               
           <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
              <a href="deleteUser?id=<%= b.getId() %>" class="btn btn-sm btn-danger"><i class="fas fa-trash-alt"></i> Delete</a>
                  <a href="editUser.jsp?id=<%= b.getId() %>" class="btn btn-sm btn-danger"><i class="fas fa-trash-alt"></i> Update</a>
          </div>
      </div>
      <div class="modal-footer">
       
      </div>
    </div>
  </div>
</div>          
     <td>
          <a  data-toggle="modal" data-target="#exampleModalCenter1" >
                  <i class="material-icons" style="font-size:34px;"><span class="material-icons-outlined">
more_vert
</span></i>
                  </a>
<!--     <a href="../deleteuser?id=<%= b.getId() %>" class="btn btn-sm btn-danger"><i class="fas fa-trash-alt"></i> Delete</a>-->
     </td>

    </tr>
    
          
       <%}
        %>
       
</tbody>
</table>
           
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             <script type="text/javascript">
        function myfun1(){
            
             var a=document.getElementById("phone").value;
            
              if(a==''){
                document.getElementById('messages').innerHTML="Please Fill Phone no.";
                return false;
                   }
                    if(isNaN(a))
        {
             document.getElementById('messages').innerHTML="Only Numeric values are allowed";
                return false;
        }
            if(a.length<10){
            document.getElementById('messages').innerHTML="Mobile Number Must be 10 Digits";
                return false;
        }
         if(a.length>10){
            document.getElementById('messages').innerHTML="Mobile Number Must be 10 Digits";
                return false;
        }
        if((a.charAt(0)!=9) && (a.charAt(0)!=8) && (a.charAt(0)!=7)){
            document.getElementById('messages').innerHTML="Mobile Number Must start with 9,8,7";
                return false;
        }
          
    }
   </script>
   
   
   
   
    </body>
</html>
