/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basharat.jobs.Model;

import basharat.jobs.Repository.JobType;

/**
 *
 * @author rehma
 */
public class Job {
    private String title;
    private JobType type;

    //Getters
    public String getTitle() {
        return title;
    }

    public JobType getType() {
        return type;
    }
    
    //Setters
    public void setTitle(String title) {
        if (title != null) {
            this.title = title;
        }
    }

    public void setType(JobType type) {
        if (type != null) {
            this.type = type;
        }
    }

    public Job(JobType type, String title) {
        this.title = title;
        this.type = type;
        if (title == null) {
            throw new IllegalArgumentException("Invalid Title");
        }
        if (type == null) {
            throw new IllegalArgumentException("Invalid Job Type");
        }
    }

    @Override
    public String toString() {
        return type + " " + title;
    }
}
