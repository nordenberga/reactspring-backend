package com.realsprint.academy.reactspring.services;

import com.realsprint.academy.reactspring.DAO.JobEntity;
import com.realsprint.academy.reactspring.Repositories.JobRepository;
import com.realsprint.academy.reactspring.api.GithubApi;
import com.realsprint.academy.reactspring.models.Job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobService {


    private GithubApi githubApi;
    private JobRepository jobRepository;

    @Autowired
    public JobService(GithubApi githubApi, JobRepository jobRepository) {
        this.githubApi = githubApi;
        this.jobRepository = jobRepository;
    }


    public List<Job> getAllJobs(){
        return convertJobs(jobRepository.findAll());
    }

    public List<Job> searchForJobs(String query){
        List<JobEntity> results = githubApi.searchForJobs(query);
        jobRepository.saveAll(results);

        return convertJobs(results);
    }

    public List<Job> findByTitle(String title){
        List<JobEntity> results = jobRepository.findAllByTitle(title);
        return convertJobs(results);
    }

    public List<Job> findByCompany(String company){
        List<JobEntity> results = jobRepository.findAllByCompany(company);
        return convertJobs(results);
    }

    public List<Job> getSampleJobs(){
        List<JobEntity> results = jobRepository.findFirst10ByCreatedAtIsNotNull();
        return convertJobs(results);
    }

    public Job findById(String id){
        return convertJobEntity(jobRepository.findByGitId(id));
    }

    private Job convertJobEntity(JobEntity jobEntity){
        return new Job(jobEntity.getGitId(), jobEntity.getLocation(), jobEntity.getTitle(), jobEntity.getCreatedAt(),
                jobEntity.getType(), jobEntity.getDescription(), jobEntity.getHowToApply(), jobEntity.getCompany(),
                jobEntity.getCompanyUrl(), jobEntity.getCompanyLogo(), jobEntity.getUrl());
    }

    private List<Job> convertJobs(List<JobEntity> jobs){
        return jobs.stream().map(this::convertJobEntity).collect(Collectors.toList());
    }

}
