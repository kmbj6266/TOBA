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
    
        <h3>Please enter a new Password</h3>
        <p>${messageTwo}</p>
        <form action="PasswordResetServlet" method="post">
           <input type="hidden" name="action" value="reset">
           
           <label class="">New Password:</label>
           <input type="text" name="password" value="${user.password}">
           <br>
           
           <input type="submit" value="Reset Password">    
        </form>
        <footer>  
            <c:import url="/includes/footer.jsp" />
        </footer>
</div>