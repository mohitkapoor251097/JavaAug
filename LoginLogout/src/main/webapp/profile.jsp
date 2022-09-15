<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%

String name=(String)session.getAttribute("name"); 
if(name==null)
{
    response.sendRedirect("index.jsp");
    session.setAttribute("login-failed","Please Login...");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="Stylesheet" href="style.css">

</head>
<body>
 <div class="menu_bar">
        <h1 class="logo">Mohit<span>Kapoor .</span></h1>
        <ul>
           
            <li><a href="Logout">Logout</a></li>
            <li><a href="#"><%=name %></a></li>
        </ul>
    </div>
</body>
</html>