<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />
<div class="toba-wrapper">
        <h3>Please enter your username and old Password</h3>
        <p>${messageTwo}</p>
        <form action="PasswordResetServlet" method="post">
           <input type="hidden" name="action" value="reset">

           <label class="">New Password:</label>
           <input type="text" name="password" value="${user.password}" ><br>
            
           <input type="submit" value="Reset Password">    
        </form>
        <footer>  
            <c:import url="/includes/footer.jsp" />
        </footer>
</div>