package com.realsprint.academy.reactspring.controllers;

import com.realsprint.academy.reactspring.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<String> getAllJobs(){
        return jobService.getAllJobs();
    }
}
