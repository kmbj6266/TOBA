 <%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />
<div class="display-form">
  
    <h3>Congratulations, your account has been successfully created</h3>

    <!--TODAY ADDED THIS FOR PART A#4-->
    <h4>Here is the information that you entered:</h4>

    <label>First Name:</label>
    <span>${user.firstName}</span><br>

    <label>Last Name:</label>
    <span>${user.lastName}</span><br>

    <label>Phone:</label>
    <span>${user.phone}</span><br>

    <label>Address:</label>
    <span>${user.address}</span><br>

    <label>City:</label>
    <span>${user.city}</span><br>

    <label>State:</label>
    <span>${user.state}</span><br>

    <label>Zip Code:</label>
    <span>${user.zipcode}</span><br>

    <label>Email:</label>
    <span>${user.email}</span><br>

    <label>Username:</label>
    <span>${user.username}</span><br>

    <label>Password:</label>
    <span>${user.password}</span><br>

<footer>      
    <c:import url="/includes/footer.jsp" />
</footer>
</div>