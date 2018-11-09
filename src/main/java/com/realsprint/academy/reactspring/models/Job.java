package com.realsprint.academy.reactspring.models;

public class Job {
    private String gitId;
    private String location;
    private String title;
    private String createdAt;
    private String type;
    private String description;
    private String howToApply;
    private String company;
    private String companyUrl;
    private String companyLogo;
    private String url;

    public Job(String gitId, String location, String title) {
        this.gitId = gitId;
        this.location = location;
        this.title = title;

    }

    public Job(String gitId, String location, String title, String createdAt, String type, String description,
               String howToApply, String company, String companyUrl, String companyLogo, String url) {
        this.gitId = gitId;
        this.location = location;
        this.title = title;
        this.createdAt = createdAt;
        this.type = type;
        this.description = description;
        this.howToApply = howToApply;
        this.company = company;
        this.companyUrl = companyUrl;
        this.companyLogo = companyLogo;
        this.url = url;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHowToApply() {
        return howToApply;
    }

    public void setHowToApply(String howToApply) {
        this.howToApply = howToApply;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompanyUrl() {
        return companyUrl;
    }

    public void setCompanyUrl(String companyUrl) {
        this.companyUrl = companyUrl;
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
