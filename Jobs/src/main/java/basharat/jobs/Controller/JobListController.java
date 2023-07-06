/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basharat.jobs.Controller;

import basharat.jobs.Repository.JobRepository;
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
@WebServlet(name = "JobListController" , urlPatterns = {"/Job"})
public class JobListController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JobRepository repository = new JobRepository();
        String selectedJobType = request.getParameter("jobType");
        
               
        try(PrintWriter out = response.getWriter()){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Jobs</title>");
            out.println("</head>");
            out.println("<body>");
            if(selectedJobType.equals("All")){
                
            }
            out.println("</body>");
            out.println("</html>");
            out.flush();

        }

    }
    
}
