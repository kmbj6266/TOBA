/*
 * kathy borne
 */
package toba.business;

import toba.data.UserDB;
import toba.business.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet(urlPatterns = {"/ReportsServlet"})
public class ReportsServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("here i am");
        
        String url = "/admin/reports.jsp";
        
        String report = request.getParameter("report");
           
        if(report != null) {
          
            HttpSession session = request.getSession();
              
            //get the current month/yr for report
            DateFormat df = new SimpleDateFormat("MM/yyyy");
            Date Date = new Date();
            String currDate = df.format(Date);
        
        
            // Call the database for the report with the current month and year
            List<User> userMonthReport = toba.db.UserDB.selectUserMonthReport(currDate);
            
            // Save the report data to the Session so it can be displayed on reports.jsp
            session.setAttribute("userMonthReport", userMonthReport);
            
            
            // Return to reports.jsp page with results from session
            url = "/admin/reports.jsp";
        
        }
        else {
            
            // Return to reports.jsp no results so display nothing.
            url = "/admin/reports.jsp";

        }
        
        getServletContext()
        .getRequestDispatcher(url)
        .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
