package toba.business;
import java.io.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import toba.data.UserDB;


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
            //String username = request.getParameter("username");
            //String password = request.getParameter("password");
            String userName = lastName + zipcode;
            String passWord = "welcome1";
            
           
            User user = new User();
            
            String message = "";
            HttpSession session = request.getSession();
                                 
            //if all the fields are null or empty then display message (stays on the New_customer page 
            if (firstName == null || firstName.isEmpty() ||
                lastName == null || lastName.isEmpty() ||
                phone == null || phone.isEmpty() ||
                address == null || address.isEmpty() ||
                city == null || city.isEmpty() ||
                state == null || state.isEmpty() ||
                zipcode == null || zipcode.isEmpty() ||
                email == null || email.isEmpty() ){
                    message = "Please fill out all the form fields";
                    url = "/New_customer.jsp";
            }
             
            ////**** ADDED THIS ON 11/20/16 - VALIDATE the parameters HERE
            else if(UserDB.emailExists(user.getEmail())){
               message = "This email address already exists.<br>" +
                        "Please enetr another email address.";
                url = "/New_customer.jsp";
                
            }
            
           else {
            user = new User(firstName, lastName, phone, address, city, state, zipcode, email);        
            UserDB.insert(user);

            Account checking = new Account("CHECKING", 0.00, user);
            Account savings = new Account("SAVINGS", 25.00, user);
        
            AccountDB.insert(checking);
            AccountDB.insert(savings);

            request.getSession().setAttribute("user", user);
            url = "/Success.jsp";
        } 
          
            request.setAttribute("message", message);
            
            //***not sure this is doing anything???? i think we are setting the request attribute to user
            request.setAttribute("user", user);
            
        }

        response.setContentType("text/html");//is this needed?
        
        // page 149
      getServletContext()
        .getRequestDispatcher(url)
        .forward(request, response);

    }


}
