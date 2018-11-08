package com.realsprint.academy.reactspring.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubJob {
    private String id;
    @JsonProperty("created_at")
    private String createdAt;
    private String title;
    private String location;
    private String type;
    private String description;
    @JsonProperty("how_to_apply")
    private String howToApply;
    private String company;
    @JsonProperty("company_url")
    private String companyUrl;
    @JsonProperty("company_logo")
    private String companyLogo;
    private String url;

    public GitHubJob() {
    }

    public GitHubJob(String id, String createdAt, String title, String location, String type, String description,
                     String howToApply, String company, String companyUrl, String companyLogo, String url) {
        this.id = id;
        this.createdAt = createdAt;
        this.title = title;
        this.location = location;
        this.type = type;
        this.description = description;
        this.howToApply = howToApply;
        this.company = company;
        this.companyUrl = companyUrl;
        this.companyLogo = companyLogo;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }
    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    @JsonProperty("how_to_apply")
    public String getHowToApply() {
        return howToApply;
    }

    @JsonProperty("how_to_apply")
    public void setHowToApply(String howToApply) {
        this.howToApply = howToApply;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @JsonProperty("company_url")
    public String getCompanyUrl() {
        return companyUrl;
    }

    @JsonProperty("company_url")
    public void setCompanyUrl(String companyUrl) {
        this.companyUrl = companyUrl;
    }

    @JsonProperty("company_logo")
    public String getCompanyLogo() {
        return companyLogo;
    }

    @JsonProperty("company_logo")
    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
