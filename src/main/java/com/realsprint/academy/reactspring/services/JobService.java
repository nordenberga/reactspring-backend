package com.realsprint.academy.reactspring.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {

    public List<String> getAllJobs(){
        return new ArrayList<>(
                Arrays.asList("first job", "second job", "third job"));
    }
}
