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
    
    
    <h3>Account Activity</h3>
    

    <c:if test="${user != null}">
        <h1>Welcome ${user.firstName} ${user.lastName}</h1>
        <h2>Account Activity</h2>
        
        <h3>Checking Account: ${user.checkingBalance}</h3>
        <h3>Savings Account: ${user.savingsBalance}</h3>
        
        
        <ul>
            <c:forEach var="transactions" items ="${transactions}">
                <li>${transactions.amount}</li>
            </c:forEach>
        </ul>
        
        
    </c:if>
        
        
    <c:if test="${user == null}">
        <p>Oops! You are not logged in.</p>
    </c:if>
    
 
        
    <footer>
        <c:import url="/includes/footer.jsp" />
    </footer>
</div>