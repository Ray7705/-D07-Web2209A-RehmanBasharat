/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Students.Repository;


import java.util.ArrayList;
import Students.Model.Student;
import java.time.LocalDate;

/**
 *
 * @author rehma
 */
public class StudentRepository {
    
    public ArrayList<Student> getStudents(){
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Student(10001, "Anna" , "Brown", LocalDate.of(1999, 5, 31)));
        studentList.add(new Student(10002, "Catherine" , "Dubois", LocalDate.of(1999, 5, 31)));
        studentList.add(new Student(10003, "Emily" , "Freeman", LocalDate.of(1999, 5, 31)));
        studentList.add(new Student(10004, "Gabriel" , "Harcourt", LocalDate.of(1999, 5, 31)));

        
        return studentList;
    }
    
    
}
