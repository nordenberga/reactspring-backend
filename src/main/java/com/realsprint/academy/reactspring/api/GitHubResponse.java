package com.realsprint.academy.reactspring.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubResponse {
    private List<GitHubJob> jobs;

    public GitHubResponse(List<GitHubJob> jobs) {
        this.jobs = jobs;
    }

    public List<GitHubJob> getJobs() {
        return jobs;
    }

    public void setJobs(List<GitHubJob> jobs) {
        this.jobs = jobs;
    }
}
