package com.realsprint.academy.reactspring.services;

import com.realsprint.academy.reactspring.api.GithubApi;
import com.realsprint.academy.reactspring.models.Job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {


    private GithubApi githubApi;

    @Autowired
    public JobService(GithubApi githubApi) {
        this.githubApi = githubApi;
    }


    public List<String> getAllJobs(){
        return new ArrayList<>(
                Arrays.asList("first job", "second job", "third job"));
    }

    public List<Job> searchForJobs(String query){
        return githubApi.searchForJobs(query);
    }
}
