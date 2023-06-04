/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Students.Model;

import java.time.LocalDate;
import static java.time.LocalDate.now;
import java.time.Period;

/**
 *
 * @author rehma
 */
public class Student {
    
    private final int id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

    public Student(int id, String firstName, String lastName, LocalDate dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        
        if (firstName == null) {
            throw new IllegalArgumentException("Invalid First Name");
        }
        if (lastName == null) {
            throw new IllegalArgumentException("Invalid Last Name");
        }
        if (dateOfBirth == null || dateOfBirth.isAfter(now())) {
            throw new IllegalArgumentException("Invalid Date Of Birth");
        }
    }

    //getters
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    
    //calculated getters
    public String getFullName(){
        return firstName + lastName;
    }
        
    public int getAge(){
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(dateOfBirth, currentDate);
        return period.getYears();
    }    
    
    //setters
    public void setFirstName(String fullName) {
        if (firstName != null) {
            this.firstName = fullName;            
        }
    }

    public void setLastName(String lastName) {
        if (lastName != null) {
            this.lastName = lastName;    
        }
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {        
        if (dateOfBirth != null || dateOfBirth.isBefore(now()) ) {
            this.dateOfBirth = dateOfBirth;        
        }
    }

    @Override
    public String toString() {
        return "Student " +  id + " " + firstName + " " + lastName;
    }
       
}
