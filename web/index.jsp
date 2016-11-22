<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />

    <div class="toba-wrapper nav-buttons">
            <h2>Welcome to TOBA Titan Online Banking Application</h2>
            <ul>
                <li><a href="index.jsp">Home</a></li>   
                <li><a href="Login.jsp">Login</a></li>   
                <li><a href="New_customer.jsp">New Customer</a></li> 
                <li><a href="Account_activity.jsp">Account Activity</a></li> 
                <li><a href="Transaction.jsp">Transactions</a></li> 
            </ul>
     
        <footer>  
            <c:import url="/includes/footer.jsp" />
        </footer>
   </div>