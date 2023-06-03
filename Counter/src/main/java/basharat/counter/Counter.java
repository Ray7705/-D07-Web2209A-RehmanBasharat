/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basharat.counter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author rehma
 */
@WebServlet(name = "StocksServlet", urlPatterns = {"/"})
public class Counter extends HttpServlet {
        int visitsNumber = 1;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        

        
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Counter</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Number Of Visits: " + visitsNumber++ + "</h1>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
    }
    
}
