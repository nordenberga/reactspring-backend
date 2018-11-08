package com.realsprint.academy.reactspring.api;

import com.realsprint.academy.reactspring.models.Job;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import java.util.stream.Collectors;

@Service
public class GithubApi {

    private static final String SEARCH_URL = "https://jobs.github.com/positions.json?search=";

    public List<Job> searchForJobs(String query) {
        RestTemplate template = new RestTemplate();
        String url = SEARCH_URL + query;
        ResponseEntity<List<GitHubJob>> responseEntity = template.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<GitHubJob>>(){});

        List<GitHubJob> gitHubJobs = responseEntity.getBody();


        if (gitHubJobs != null && !gitHubJobs.isEmpty()) {
            return parseResponse(gitHubJobs);
        }
        return new ArrayList<>();
    }

    private List<Job> parseResponse(List<GitHubJob> gitHubJobs) {
        return gitHubJobs.stream()
                         .filter(Objects::nonNull)
                         .map(this::parseGitHubJob)
                         .collect(Collectors.toList());
    }

    private Job parseGitHubJob(GitHubJob gitHubJob) {
        return new Job(gitHubJob.getId(), gitHubJob.getLocation(), gitHubJob.getTitle());
    }
}
