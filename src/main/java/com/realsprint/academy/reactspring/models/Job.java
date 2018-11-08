package com.realsprint.academy.reactspring.models;

public class Job {
    private String gitId;
    private String location;
    private String title;

    public Job(String gitId, String location, String title) {
        this.gitId = gitId;
        this.location = location;
        this.title = title;

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
        return "Job{location='" + location + '\'' +
                ", title='" + title + '\'' +
                ", gitId='" + gitId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
