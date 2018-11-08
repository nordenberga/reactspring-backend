package com.realsprint.academy.reactspring.api;

import com.realsprint.academy.reactspring.models.Job;
import io.jsonwebtoken.lang.Assert;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GithubApi {

    private static final String SEARCH_URL = "https://jobs.github.com/positions.json?search=";
    public List<Job> searchForJobs(String query){
        RestTemplate template = new RestTemplate();
        String url = SEARCH_URL + query;
        ResponseEntity<GitHubResponse> responseEntity = template.getForEntity(url, GitHubResponse.class);
        Assert.isTrue(responseEntity.getStatusCode() == HttpStatus.OK);

        Optional<GitHubResponse> response = Optional.ofNullable(responseEntity.getBody());


        if(response.isPresent()){
            return parseResponse(response.get());
        }
        return new ArrayList<>();
    }

    private List<Job> parseResponse(GitHubResponse response){
        List<GitHubJob> jobs = response.getJobs();

        return null;
    }

    private Job parseGitHubJob(GitHubJob gitHubJob){
        return new Job(100, gitHubJob.getLocation(), gitHubJob.getTitle(), gitHubJob.getId());
    }
}
