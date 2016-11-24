package toba.business;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import toba.data.UserDB;

@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response)
                          throws ServletException, IOException {
        String url = "/index.jsp"; //have a default page
        System.out.println("POSTING");
        //get current action
        String action = request.getParameter("action");
        if (action == null){
            System.out.println("null action");
            action = "login"; //default action
        }
        
        if (action.equals("login")){
            //System.out.println("LOGIN");
            url = "/Login.jsp";    // the "join" page
        
            //System.out.println("ADDING");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
                  
            User user = new User();
            Account account = new Account();
            String message = null;
            
            //User user = UserDB.selectUser(username, password);
            
            if (username.equals("") || password.equals("")) {
                // forward to the view to get missing parameters
                message = "Please fill in all boxes";
                //System.out.println("FIeld is blank");
                url = "/Login.jsp";
            } else {
                //System.out.println("Logging in with us" + username + " : " + password);
                message = "";
            }
            
//            if (user == null){
//              //set url to newcustomer page
//              url = "/New_customer.jsp";
//            }
            

            // store the data in User object and save the User object in the database
            //Login login = new Login(username, password);
            HttpSession session = request.getSession();

            user = UserDB.selectUser(username, password);
                //System.out.println(user);
            session.setAttribute("user", user);
            //set User object in request object and set URL
            //request.setAttribute("Login", login);
            request.setAttribute("message", message);


            if(UserDB.userExists(username, password)){
                //
                System.out.println("User exists");
            }
            else
            {
                System.out.println("User does not exist");
            }
            
             
            //HttpSession session = request.getSession();
            session.setAttribute("user", user);
            url = "/Account_activity.jsp";
        }
        
        else {
            url = "/Login_failure.jsp";
        }
        
        response.setContentType("text/html");//is this needed?
        
        // page 149
    getServletContext()
     .getRequestDispatcher(url)
     .forward(request, response);
System.out.println("DONE");
    }

}
