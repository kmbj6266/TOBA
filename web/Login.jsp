<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/header.html" />
 
    <h1>Please Login</h1>
    
    <form action="LoginServlet" method="post">
       <input type="hidden" name="action" value="login">

       <label class="">Username:</label>
       <input type="text" name="username" value="${user.username}" required><br>

       <label class="">Password:</label>
       <input type="text" name="password" value="${user.password}" required><br>

       <a href="New_customer.jsp"><p>New Customer Sign Up Page</p></a>

       <a href="password_reset.jsp"><p>Reset Password</p></a>

       <input type="submit" value="login" >
    </form>

<footer>  
   <c:import url="/includes/footer.jsp" />
</footer>  
