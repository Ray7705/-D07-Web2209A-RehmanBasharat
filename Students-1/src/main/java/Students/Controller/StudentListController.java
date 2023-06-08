/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Students.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import Students.Model.Student;
import Students.Repository.StudentRepository;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author rehma
 */
@WebServlet(name = "StudentListController" , urlPatterns = {""})
public class StudentListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
        StudentRepository repository = new StudentRepository();
        ArrayList<Student> students = repository.getStudents();
        
        // write to the response (headers and body)
        response. setContentType( "text/html; charset-UTF-8" );
        DateTimeFormatter dateFormatter = DateTimeFormatter .ofPattern( "yyyy-MM-dd");
        
        try(PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Students</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Students</h1>");
            for (Student student : students) {
                out.println("<ul>");
                out.println("<li>" + student.toString() + "</li>");
                out.println("<li>Date Of Birth: " + student.getDateOfBirth() + "</li>");
                out.println("<li>Age: " + dateFormatter.format(student.getDateOfBirth())+ "</li>");
                out.println("</ul>");
            }
            out.println("</body>");
            out.println("</html>");
            out.flush();
        } 
    }
}
