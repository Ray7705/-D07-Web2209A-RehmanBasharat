/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basharat.date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author rehma
 */

@WebServlet(name = "StocksServlet", urlPatterns = {"/"})
public class Date extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setIntHeader("refresh", 1);
        
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/mm/dd");
        DateTimeFormatter TimeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        
        
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Date</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>Cureent Time " + now + "</p>");
        out.println("<p>Cureent Date Formatted " + dateFormatter.format(now) + "</p>");
        out.println("<p>Cureent Time Formatted " + TimeFormatter.format(now) + "</p>");
        
        out.println("</body>");
        out.println("</html>");
        out.flush();
        
    }
    
}
