package toba.business;

import java.io.IOException;
//import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kathyborne
 */
public class NewCustomerServlet extends HttpServlet {

   @Override
    protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response)
                          throws ServletException, IOException {
        String url = "/index.html"; //have a default page
        
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
            
            //validate parameters
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
            else {
                message = "";
                url = "/Success.html";
            }
            request.setAttribute("message", message);
            
        }

        response.setContentType("text/html");//is this needed?
        
        // page 149
    getServletContext()
     .getRequestDispatcher(url)
     .forward(request, response);

    }


}
