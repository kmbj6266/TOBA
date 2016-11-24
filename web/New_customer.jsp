<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />

<div class="register-page">
    <form action="NewCustomerServlet" method="post">
        <h1 class="header">New Customer Registration</h1>
        <h4>${message}</h4>
        
       <input type="hidden" name="action" value="add">

       <label class="">First Name:</label>
       <input type="text" name="firstName" value="${user.firstName}" ><br>

       <label class="">Last Name:</label>
       <input type="text" name="lastName" value="${user.lastName}" ><br>

       <label class="">Phone:</label>
       <input type="text" name="phone" value="${user.phone}" ><br>

       <label class="">Address:</label>
       <input type="text" name="address" value="${user.address}" ><br>

       <label class="">City:</label>
       <input type="text" name="city" value="${user.city}" ><br>

       <label class="">State:</label>
       <input type="text" name="state" value="${user.state}" ><br>

       <label class="">Zip Code:</label>
       <input type="text" name="zipcode" value="${user.zipcode}" ><br>

       <label class="">Email:</label>
       <input type="email" name="email" value="${user.email}"><br>
       

       <input type="submit" value="Submit" class="submit">

    </form>

<footer>
    <c:import url="/includes/footer.jsp" />
</footer>
