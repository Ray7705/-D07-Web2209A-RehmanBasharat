/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basharat.stocks;

import chevalier.utility.CurrencyHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Formatter;
import java.util.Locale;
import java.util.Random;

/**
 *
 * @author rehma
 */
@WebServlet(name = "StocksServlet", urlPatterns = {"/"})
public class Stocks extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                
                
                
                
        Random random = new Random();
        float Oracle = random.nextFloat(50, 100);
        float Microsoft = random.nextFloat(50, 100);
        float Google = random.nextFloat(50, 100);
        NumberFormat formatter = CurrencyHelper.getCurrencyFormatter(Locale.US);
        
                
        PrintWriter out = response.getWriter();
        response.setIntHeader("refresh", 3);
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Stocks</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>Oracle " + formatter.format(Oracle) + "</p>");
        out.println("<p>Microsoft " + formatter.format(Microsoft) + "</p>");
        out.println("<p>Google " + formatter.format(Google) + "</p>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
                
    }
}
