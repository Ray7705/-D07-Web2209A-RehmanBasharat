/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basharat.jobs.Repository;

import basharat.jobs.Model.Job;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rehma
 */
public class JobRepository {
    public ArrayList<Job> getJobs(){
        ArrayList<Job> jobList = new ArrayList<>();
        jobList.add(new Job(JobType.PartTime , "Front-End Web Developer"));
        jobList.add(new Job(JobType.PartTime , "Unity Developper"));
        jobList.add(new Job(JobType.FullTime , "Back-End JAVA Developer"));
        jobList.add(new Job(JobType.FullTime , "Database Admin"));
        jobList.add(new Job(JobType.FullTime , "Project Manager"));
        jobList.add(new Job(JobType.Contractor , "ASP.NET Developer"));
        jobList.add(new Job(JobType.Contractor , "User Experience Designer"));
        return jobList;    
    }
    
    public ArrayList<Job> getJobsByType(JobType type){
        ArrayList<Job> filteredJobs = new ArrayList<>();
        for (Job job : jobs) {
            if (job.getType() == type) {
                filteredJobs.add(job);
            }
        }
        return filteredJobs;
    }

}
