package toba.business;

import java.io.IOException;
//import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
            
            //validate if username and password match -THIS IS OLD, FROM THE FIRST WEEK, DO WE CHANGE THIS ON 2ND ASSIGNMENT????
            
//            if ( (username != null) && (username.equals("jsmith@toba.com")) && (password !=null) && (password.equals("letmein")) ){
//                url = "/Account_activity.jsp"; //logged in
//            }



            //THIS IS NEW, BECAUSE NOW, THE USERNAME IS lastName + zipcode and password is welcome1 - NOT SURE WHAT TO DO HERE????
            if ( (username != null)  && (password !=null)  ){
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
