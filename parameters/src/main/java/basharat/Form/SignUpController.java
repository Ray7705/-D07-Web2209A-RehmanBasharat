/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basharat.Form;

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
@WebServlet(name = "SignUpControllerServlet", urlPatterns = {"/SignUp"})
public class SignUpController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("firstname");
        String[] courses = request.getParameterValues("course");
        String time = request.getParameter("time");
        String [] semesters = request.getParameterValues( "semester");
        
        try(PrintWriter out = response.getWriter()){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<body>");   
         
            out.println("First Name: " + firstName);
            out.println("Last Name: " + lastName);
            
            if (courses != null) {
                for (String course : courses) {
                    out.println("<p>Courses: " + course + "</p>");
                }
            }
            else{
                out.println("No Course");
            }
            
            if (time != null) {
                out.println("<p>Time: " + time + "</p>");
            }
            else{
                out.println("No Time");
            }
            if (semesters != null) {
                for (String semester : semesters) {
                    out.println("<p>Semesters: " + semester + "</p>");
                }
            }
            else{
                out.println("No Semester");
            }
        }
        
    }
    
}
