/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basharat.preferences.Model;

/**
 *
 * @author rehma
 */
public class Preferences {
    private String name;
    private String color;
    private boolean remember;



    public String getName() {
        return name;
    }
    
    public String getColor() {
        return color;
    }

    public boolean isRemember() {
        return remember;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public void setRemember(boolean remember) {
        this.remember = remember;
    }
    
    
}
