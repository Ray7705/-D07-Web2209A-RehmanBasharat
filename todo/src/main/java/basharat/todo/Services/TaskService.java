/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basharat.todo.Services;

import basharat.todo.Models.Task;
import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Objects;

/**
 *
 * @author rehma
 */
public class TaskService {

    private final HttpSession session;
    
    public TaskService(HttpSession session) {
        this.session = Objects.requireNonNull(session);
    }
    
    public void addTask(String name) {
        HashMap<String, Task> tasks = (HashMap<String, Task>) session.setAttribute("tasks");
        if (tasks == null) {
            tasks = new HashMap<>();
            session.setAttribute("tasks", tasks);
        }
        
        
    }
}
