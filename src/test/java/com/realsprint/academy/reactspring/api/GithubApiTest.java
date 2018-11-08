package com.realsprint.academy.reactspring.api;

import com.realsprint.academy.reactspring.models.Job;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GithubApiTest {

    private GithubApi githubApi;

    @Before
    public void setup(){
        githubApi = new GithubApi();
    }

    @Ignore
    public void searchForJobs() {
        List<Job> results = githubApi.searchForJobs("code");
        assertFalse(results.isEmpty());
    }
}