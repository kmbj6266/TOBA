package toba.business;

import java.io.IOException;
//import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class NewCustomerServlet extends HttpServlet {
    
   @Override
    protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response)
                          throws ServletException, IOException {
        String url = "/index.jsp"; //have a default page
        
        //get current action
        String action = request.getParameter("action");
        if (action == null){
            action = "add"; //default action
        }
        
        if (action.equals("add")){
                 //get params from request  
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String zipcode = request.getParameter("zipcode");
            String email = request.getParameter("email");
        
            
            //TODAY*** - i think i need to store data here for the user object
            User user = new User(firstName, lastName, phone, address, city, state, zipcode, email);
            
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            
            //set a variable named "message" here, then validate parameters, and display message 
            //if all the fields are null or empty then display message (stays on the New_customer page
            
            String message;
            if (firstName == null || firstName.isEmpty() ||
                lastName == null || lastName.isEmpty() ||
                phone == null || phone.isEmpty() ||
                address == null || address.isEmpty() ||
                city == null || city.isEmpty() ||
                state == null || state.isEmpty() ||
                zipcode == null || zipcode.isEmpty() ||
                email == null || email.isEmpty() 
            
              ){
                message = "Please fill out all the form fields";
                url = "/New_customer.jsp";
            }
            //else because all the form fields are filled in, it goes to the successs page
            else {         
                message = "";
                url = "/Success.jsp";
                
                //TODAY ** --- we dont' have a real database - make a fake one
                //UserDB.insert(user);
            }
                       
            request.setAttribute("message", message);
            
            //TODAY*** - i think we are setting the request attribute to user
            request.setAttribute("user", user);
            
        }

        response.setContentType("text/html");//is this needed?
        
        // page 149
      getServletContext()
     .getRequestDispatcher(url)
     .forward(request, response);

    }


}
