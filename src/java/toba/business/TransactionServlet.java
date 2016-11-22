//@author kathyborne
package toba.business;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static org.eclipse.persistence.sessions.SessionProfiler.Transaction;

public class TransactionServlet extends HttpServlet {

   @Override
    protected void doPost(HttpServletRequest request, 
         HttpServletResponse response)  
         throws ServletException, IOException {
        
        String url = "/Transaction.jsp";
        
        String From = request.getParameter("From");
        String To = request.getParameter("To");
        
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        
        String Amount = request.getParameter("Amount");
        
        Account source = AccountDB.selectAccount(user, From);
        source.debit(Double.parseDouble(Amount));
        
        Account destination = AccountDB.selectAccount(user, To);
        destination.credit(Double.parseDouble(Amount));
        
        AccountDB.update(source);
        AccountDB.update(destination);

        Transaction trans = new Transaction(source, destination, Double.parseDouble(Amount));

        ArrayList<Transaction>transactions = new ArrayList<>();
    }
}
    
