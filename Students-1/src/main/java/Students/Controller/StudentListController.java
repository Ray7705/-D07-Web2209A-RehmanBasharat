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
import java.util.ArrayList;

/**
 *
 * @author rehma
 */
@WebServlet(name = "StudentListController" , urlPatterns = {""})
public class StudentListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
        StudentRepository studentRepository = new StudentRepository();
        
        ArrayList<Student> allStudents = studentRepository.getStudents();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Stocks</title>");
        out.println("</head>");
        out.println("<body>");
        
        for (int i = 0; i < 5; i++) {
            out.println("<ul>");
            //out.println("<li>" + studentRepository.toString()+ "</li>");
            out.println("<li>"  + "</li>"); 
            out.println("</ul>");
        }
        out.println("</body>");
        out.println("</html>");
        out.flush();
    }
    
}
