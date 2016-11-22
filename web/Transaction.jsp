<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />

<div class="toba-wrapper-form">
    <ul>
        <li><a href="index.jsp">Home</a></li>   
        <li><a href="Login.jsp">Login</a></li>   
        <li><a href="New_customer.jsp">New Customer</a></li> 
        <li><a href="Account_activity.jsp">Account Activity</a></li> 
        <li><a href="Transaction.jsp">Transactions</a></li> 
    </ul>

<div>Welcome To Your Transactions Page</div>

<h1>Your balances: </h1>
    <h2>Checking Account: ${user.checkingBalance}</h2>
    <h2>Savings Account : ${user.savingsBalance}</h2>
        
    <h2>Transfer from</h2>
      <form action="Account_activity.jsp" method="post">
          <div>
            <label>From:</label>
            <select name = "From">
              <option value="select"> </option>
              <option value="CHECKING">Checking</option>
              <option value="SAVINGS">Savings</option>
            </select>
          </div>

      <h2>Transfer To</h2>
           <div>
            <label>To:</label>
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
        
        
</div>
<c:import url="/includes/footer.jsp" />
