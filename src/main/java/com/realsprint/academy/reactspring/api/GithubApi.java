package com.realsprint.academy.reactspring.api;

import com.realsprint.academy.reactspring.DAO.JobEntity;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GithubApi {

    private static final String SEARCH_URL = "https://jobs.github.com/positions.json?search=";

    public List<JobEntity> searchForJobs(String query) {
        RestTemplate template = new RestTemplate();
        String url = SEARCH_URL + query;
        ResponseEntity<List<GitHubJob>> responseEntity = template.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<GitHubJob>>(){});

        List<GitHubJob> gitHubJobs = responseEntity.getBody();


        if (gitHubJobs != null && !gitHubJobs.isEmpty()) {
            return convertJobs(gitHubJobs);
        }
        return new ArrayList<>();
    }

    private List<JobEntity> convertJobs(List<GitHubJob> gitHubJobs){
        return gitHubJobs.stream().map(this::convertJob).collect(Collectors.toList());
    }

    private JobEntity convertJob(GitHubJob gitHubJob){
        return new JobEntity(gitHubJob.getLocation(), gitHubJob.getTitle(), gitHubJob.getId(), gitHubJob.getCompany(),
                gitHubJob.getCompanyUrl(), gitHubJob.getUrl(), gitHubJob.getCreatedAt(), gitHubJob.getType(),
                gitHubJob.getDescription(), gitHubJob.getHowToApply(), gitHubJob.getCompanyLogo());
    }




}
