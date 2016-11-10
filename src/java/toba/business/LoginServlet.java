package toba.business;

import java.io.IOException;
//import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response)
                          throws ServletException, IOException {
        String url = "/index.jsp"; //have a default page
        
        //get current action
        String action = request.getParameter("action");
        if (action == null){
            action = "login"; //default action
        }
        
        if (action.equals("login")){
                 //get params from request  
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            
            HttpSession session = request.getSession();
            //session.setAttribute("user", user);
            
            User user = (User) session.getAttribute("user");
            if (user == null){
              //set url to newcustomer page
              url = "/New_customer.jsp";
            }
            
            //you have to get the username by getUsername on the object
            else if ( (username != null) && (username.equals(user.getUsername() )) && (password !=null) && (password.equals(user.getPassword() )) ){
               url = "/Account_activity.jsp"; //logged in
          }
            else {
                url = "/Login_failure.jsp"; //login failed
            }
        }

        
       
        
        
        
        
        
        
        
        
        response.setContentType("text/html");//is this needed?
        
        // page 149
    getServletContext()
     .getRequestDispatcher(url)
     .forward(request, response);

    }

}
