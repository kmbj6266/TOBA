<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />
<div class="toba-wrapper">
    <h3>Account Activity</h3>
    

    <c:if test="${user != null}">
        <p>Welcome ${user.firstName} ${user.lastName}</p>
        <p>You are now logged in</p>
    </c:if>
        
    <c:if test="${user == null}">
        <p>Oops! You are not logged in.</p>
    </c:if>
    
    <footer>
        <c:import url="/includes/footer.jsp" />
    </footer>
</div>