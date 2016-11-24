
package toba.business;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TransactionServlet extends HttpServlet {
 
   @Override
    protected void doPost(HttpServletRequest request, 
         HttpServletResponse response)  
         throws ServletException, IOException {
        
        System.out.println("YOU ARE HERE Handling transaction");
        

        String url = "/Transaction.jsp";
        
        String From = request.getParameter("From");
        String To = request.getParameter("To");
        
        System.out.println("From " + From + " to " + To);

        
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        
        String Amount = request.getParameter("amount");
        
        System.out.println("Amt $" + Amount);
        
        
        
        
        Account source = AccountDB.selectAccount(user, From);
        source.debit(Double.parseDouble(Amount));
        
        Account destination = AccountDB.selectAccount(user, To);
        destination.credit(Double.parseDouble(Amount));
        
        
        
        AccountDB.update(source);
        AccountDB.update(destination);

        Transaction trans = new Transaction(source, destination, Double.parseDouble(Amount));

          System.out.println("Where do I send you from here?");
          
          getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
    }
    
    
        ArrayList<Transaction>transactions = new ArrayList<>();
 

    }

    
