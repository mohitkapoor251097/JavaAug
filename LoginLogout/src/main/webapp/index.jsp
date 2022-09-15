<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="Stylesheet" href="style.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="menu_bar">
        <h1 class="logo">Mohit<span>Kapoor .</span></h1>
        <ul>
            <li><a href="Demosite.htm">Home</a></li>
            <li><a href="#">About</a></li>
            <li><a href="#">Pages</a></li>
            <li><a href="#">Sign Up</a></li>
            <li><a href="#">Sign in</a></li>
        </ul>
</div>

 <div class="container p-5 " style="margin-top:100px">
             <div class="row mt-5">
                 <div class="col-md-6 offset-md-4" style="margin:auto">
                     <div class="card c" >
                         <div class="card-body">
                           <p class="text-center"><img src="https://thumbs.dreamstime.com/b/login-icon-black-circle-web-button-white-background-72944800.jpg" width="200px " height="200px"></p>
                            
                            <%
                                  String invalidMsg=(String) session.getAttribute("login-failed");
                                  
                                if(invalidMsg!=null)
                                {%>
                                    
                                            <div class="alert alert-danger" role="alert">
                                                 <%=  invalidMsg  %> 
                                                
                                 
                                            </div>
                                                  <%
                                 session.removeAttribute("login-failed");
                                
                                %>
                                <% }
                                   
                                
                                %>
                                
                                
                                  <%
                                  String Msg=(String) session.getAttribute("msg");
                                  
                                if(Msg!=null)
                                {%>
                                    
                                            <div class="alert alert-danger" role="alert">
                                                 <%=  Msg  %> 
                                                
                                 
                                            </div>
                                                  <%
                                 session.removeAttribute("msg");
                                
                                %>
                                <% }
                                   
                                
                                %>
                                
                                  <%
                                  String Msg1=(String) session.getAttribute("msg1");
                                  
                                if(Msg1!=null)
                                {%>
                                    
                                            <div class="alert alert-danger" role="alert">
                                                 <%=  Msg1  %> 
                                                
                                 
                                            </div>
                                                  <%
                                 session.removeAttribute("msg1");
                                
                                %>
                                <% }
                                   
                                
                                %>
                            <form onsubmit="return validation()" action="LoginServlet" method="post">
  <div class="form-group mt-3">
    <label for="exampleInputEmail1">Enter Name</label>
    <input type="text" class="form-control" class="uname "id="fname" name="name" aria-describedby="emailHelp" placeholder="Enter Name">
  <span id="username" class="text-danger font-weight-bold "></span>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" id="fpass" name="password" placeholder="Enter Password">
     <span id="userpass" class="text-danger font-weight-bold "></span>
  </div>
  
  <button type="submit" class="btn btn-primary" style="border-radius: 20px;width:200px;margin-left:100px " >Login</button>
</form>
                           
                                    
   
                              
                         </div>
                     </div>
                 </div>
             </div>
         </div> 
     <script>
    function validation()
    {
    	let user=document.getElementById("fname").value;
    	let pass=document.getElementById("fpass").value;
    	if(user=="")
    		{
    		document.getElementById('username').innerHTML="Please fill user name !";
    		return false;
    		}
    	if(pass=="")
		{
		document.getElementById('userpass').innerHTML="Please fill password !";
		return false;
		}
    }
     </script>   
</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</html>