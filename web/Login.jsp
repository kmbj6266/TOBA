<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/header.html" />

<div class="toba-wrapper">
    <ul>
        <li><a href="index.jsp">Home</a></li>   
        <li><a href="Login.jsp">Login</a></li>   
        <li><a href="New_customer.jsp">New Customer</a></li> 
        <li><a href="Account_activity.jsp">Account Activity</a></li> 
        <li><a href="Transaction.jsp">Transactions</a></li> 
    </ul>

    
<h4>Please Login</h4>
    
    <form action="LoginServlet" method="post">
       <input type="hidden" name="action" value="login">

       <label class="">Username:</label>
       <input type="text" name="username" required><br>

       <label class="">Password:</label>
       <input type="text" name="password" required><br>

       <a href="New_customer.jsp"><p>New Customer Sign Up Page</p></a>

       <a href="password_reset.jsp"><p>Reset Password</p></a>

       <input type="submit" value="login" >
    </form>

    <footer>  
       <c:import url="/includes/footer.jsp" />
    </footer>  
 </div>