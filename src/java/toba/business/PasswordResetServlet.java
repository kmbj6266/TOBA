package toba.business;

import java.io.IOException;
//import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import toba.data.UserDB;


public class PasswordResetServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response)
                          throws ServletException, IOException {
        String url = "/index.jsp"; //have a default page
        
        //get current action
        String action = request.getParameter("action");
        if (action == null){
            action = "reset"; //default action
        }
        
        if (action.equals("reset")){
            //retrieve user from the session
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
                       
            //get params from request  
            String password = request.getParameter("password");
           
            //have to setParameter ("password") and save it back to the session
            //why do we bind something to a page? to display something to the page.
                String messageTwo;
                
                if (password == null || password.isEmpty() ){
                    messageTwo = "Please type in new password";
                    url = "/password_reset.jsp";
                }
                else { 
                    user.setPassword(password);
                    //****updated THIS ON 11/20/16 - somewhere need to do an UPDATE to DATABASE??? and get rid of session stuff???
                    //session.setAttribute("user",user);

                    messageTwo = "";
                    url = "/Account_activity.jsp";

                    //****ADDED THIS ON 11/20/16 - somewhere need to do an UPDATE to DATABASE??? PART B:2
                    UserDB.update(user);
               }

              
                request.setAttribute("messageTwo", messageTwo);  
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
