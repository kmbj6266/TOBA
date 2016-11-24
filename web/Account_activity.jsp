<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />
    
    <h1>Account Activity</h1>

    <c:if test="${user != null}">
        <h2>Welcome ${user.firstName} ${user.lastName}</h2>

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
