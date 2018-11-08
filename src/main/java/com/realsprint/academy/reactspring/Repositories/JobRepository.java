package com.realsprint.academy.reactspring.Repositories;

import com.realsprint.academy.reactspring.DAO.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<JobEntity,Long > {


    
}
