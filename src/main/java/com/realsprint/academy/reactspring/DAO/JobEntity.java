package com.realsprint.academy.reactspring.DAO;

import javax.persistence.*;

@Entity
@Table(name = "job")
public class JobEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long jobId;
    @Column(nullable = false)
    private String location;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String gitId;
    @Column(nullable = false)
    private String company;
    @Column
    private String companyUrl;
    @Column
    private String url;
    @Column
    private String createdAt;
    @Column(nullable = false)
    private String type;
    @Lob
    @Column(length = 15000)
    private String description;
    @Column(length = 1000)
    private String howToApply;
    @Column
    private String companyLogo;

    public JobEntity() {}

    public JobEntity(String location, String title, String gitId, String company, String companyUrl, String url,
                     String createdAt, String type, String description, String howToApply, String companyLogo) {
        this.location = location;
        this.title = title;
        this.gitId = gitId;
        this.company = company;
        this.companyUrl = companyUrl;
        this.url = url;
        this.createdAt = createdAt;
        this.type = type;
        this.description = description;
        this.howToApply = howToApply;
        this.companyLogo = companyLogo;
    }

    public long getJobId() {
        return jobId;
    }

    public void setJobId(long jobId) {
        this.jobId = jobId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGitId() {
        return gitId;
    }

    public void setGitId(String gitId) {
        this.gitId = gitId;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }
}
