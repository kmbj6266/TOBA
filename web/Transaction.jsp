<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />
<!--KATHY BORNE-->
<h1>Welcome To Your Transactions Page</h1>

<h2>Your Balances: </h2>
  <h3 class="balance-header">Checking Account: ${user.checkingBalance}</h3>
    <h3 class="balance-header">Savings Account: ${user.savingsBalance}</h3>

      <form action="TransactionServlet" method="post">
          <div class="transfer">
            <label>Transfer From:</label>
            <select name = "From">
              <option value="select"> </option>
              <option value="CHECKING">Checking</option>
              <option value="SAVINGS">Savings</option>
            </select>
          </div>

         <div class="transfer">
          <label>Transfer To:</label>
          <select name="To">
            <option value="select"> </option>    
            <option value="CHECKING">Checking</option>
            <option value="SAVINGS">Savings</option>                        
          </select>
         </div>

      <div>
        <label>Enter Transfer Amount:</label>
        <input type="number" name="amount" placeholder="0" value="${transfer.amount}">
      </div>

      <input type="submit" value="Submit Transfer">
      </form>

<div>
    <a href="Account_activity.jsp">See Account Activity</a>
</div>

 
 
<footer>      
    <c:import url="/includes/footer.jsp" />
</footer>