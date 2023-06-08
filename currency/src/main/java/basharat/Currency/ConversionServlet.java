/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basharat.Currency;

import chevalier.utility.CurrencyHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.Format;
import java.util.Locale;

/**
 *
 * @author rehma
 */
@WebServlet(name = "CurrencyConversionServlet", urlPatterns = {"/CurrencyConversion"})
public class ConversionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String amount = request.getParameter("amount");
        String currency = request.getParameter("currency");
        double amountInInt = Integer.parseInt(amount);
        Format eurFormat = CurrencyHelper.getCurrencyFormatter(Locale.FRANCE);
        Format usdFormat = CurrencyHelper.getCurrencyFormatter(Locale.US);
        Format cadFormat = CurrencyHelper.getCurrencyFormatter(Locale.CANADA);
        
        response.setContentType("text/html;charset=UTF-8");
        
        try(PrintWriter out = response.getWriter()){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<body>");   
            if (currency == null) {
                out.println("Empty!");
            }
            else{
                if (currency.equals("USD")) {
                    double convertedToUSD = amountInInt * 0.75;
                    out.println("<p>"+ cadFormat.format(amountInInt) + " = " + usdFormat.format(convertedToUSD) + "</p>");
                }
                else if (currency.equals("EUR")) {
                    double convertedToEUR = amountInInt * 0.69;
                    out.println("<p>"+ cadFormat.format(amountInInt)+ " = " + eurFormat.format(convertedToEUR) + "</p>");
                }
                else {
                    out.println("<p>Invalid currency!</p>");
                }
            }
            out.println("<a href=\"/currency\">Return</a>");
            out.println("</body>");
            out.println("</html>"); 
        }
    }
}
