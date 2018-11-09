package com.realsprint.academy.reactspring.restControllers;

import com.realsprint.academy.reactspring.models.Job;
import com.realsprint.academy.reactspring.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JobController {

    @Autowired
    private JobService jobService;
/*
    @Autowired
    public JobController (JobService jobService){
        this.jobService = jobService;
    }*/

    @RequestMapping("/jobs")
    public List<Job> getAllJobs(){
        return jobService.getAllJobs();
    }

    @RequestMapping("/search/{query}")
    public List<Job> searchForJobs(@PathVariable("query") String query) { return jobService.searchForJobs(query);};
}
