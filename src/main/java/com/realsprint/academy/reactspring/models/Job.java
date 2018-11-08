package com.realsprint.academy.reactspring.models;

import javax.persistence.Entity;

@Entity
public class Job {

    
    private long jobId;

    private String location;
    private String title;
    private String gitId;

    public Job(long jobId, String location, String title, String gitId) {
        this.jobId = jobId;
        this.location = location;
        this.title = title;
        this.gitId = gitId;
    }


    public long getJobId() {
        return jobId;
    }

    public String getLocation() {
        return location;
    }

    public String getTitle() {
        return title;
    }

    public String getGitId() {
        return gitId;
    }

    public void setJobId(long jobId) {
        this.jobId = jobId;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGitId(String gitId) {
        this.gitId = gitId;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobId=" + jobId +
                ", location='" + location + '\'' +
                ", title='" + title + '\'' +
                ", gitId='" + gitId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
