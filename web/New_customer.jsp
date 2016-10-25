<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>New Customer Sign Up</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div class="new-customer-wrapper">
            <div>Please register</div>
            <p>${message}</p>
            <form action="NewCustomerServlet" method="post">
               <input type="hidden" name="action" value="add">

               <label class="">First Name:</label>
               <input type="text" name="firstName" ><br>

               <label class="">Last Name:</label>
               <input type="text" name="lastName" ><br>

               <label class="">Phone:</label>
               <input type="text" name="phone" ><br>

               <label class="">Address:</label>
               <input type="text" name="address" ><br>

               <label class="">City:</label>
               <input type="text" name="city" ><br>

               <label class="">State:</label>
               <input type="text" name="state" ><br>

               <label class="">Zip Code:</label>
               <input type="text" name="zipcode" ><br>

               <label class="">Email:</label>
               <input type="email" name="email" ><br>

               <input type="submit" value="Submit" >

            </form>
        </div>
    </body>
</html>
