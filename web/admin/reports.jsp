<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reports Page</title>
        <link rel="stylesheet" href="../styles/toba_styles.css" type="text/css"/>
    </head>
    <body>
        <div class="toba-wrapper">   
            <nav>  
                <ul>
                    <li></li>  
                </ul>
            </nav> 
        
        <h3>Users that have registered this month</h3>
        
         <table>
            <tr>               
                <th>First Name</th>
                <th>Last Name</th>
                <th>Username</th>
            </tr>        
            <c:forEach items="${allUsers}" var="users">
            <tr>
                <td>${user.getFirstName()}</td>
                <td>${user.getLastName()}</td>
                <td>${user.getUserName()}</td> 
            </tr>
            </c:forEach>            
        </table>
        
        <footer>
                <p>&copy; Copyright - Kathy Borne,  Web Developer</p>
            </footer>
        
        </div>
    </body>
</html>
