package com.realsprint.academy.reactspring.Controllers;

import com.realsprint.academy.reactspring.models.Job;
import com.realsprint.academy.reactspring.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JobController {

    private JobService jobService;

    @Autowired
    public JobController (JobService jobService){
        this.jobService = jobService;
    }

    @RequestMapping("/jobs")
    public List<Job> getAllJobs(){
        return jobService.getAllJobs();
    }

    @RequestMapping("/job/id/{gitId}")
    public Job getByGitId(@PathVariable("gitId") String gitId){
        return jobService.findById(gitId);
    }

    @RequestMapping("/jobs/company/{company}")
    public List<Job> getByCompanyName(@PathVariable("company") String company){
        return jobService.findByCompany(company);
    }

    @RequestMapping("jobs/sample")
    public List<Job> getSampleOfJobs(){
        return jobService.getSampleJobs();
    }

    @RequestMapping("/jobs/title/{title}")
    public List<Job> getByTitle(@PathVariable("title") String title){
        return jobService.findByTitle(title);
    }

    @RequestMapping("/search/{query}")
    public List<Job> searchForJobs(@PathVariable("query") String query) { return jobService.searchForJobs(query);};
}
