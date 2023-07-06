/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basharat.todo.Models;

import java.util.Objects;
import java.util.UUID;

/**
 *
 * @author rehma
 */
public class Task {

    //UUID  id = UUID.randomUUID();
    private final String id;
    private final String name;
    private boolean comeplete;

    public Task(String id, String name) {
        this.id = Objects.requireNonNull(id);

        if (name != null && name.isBlank() && name.isEmpty()) {
            this.name = name;
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isComeplete() {
        return comeplete;
    }

    public void setComeplete(boolean comeplete) {
        this.comeplete = comeplete;
    }

}
