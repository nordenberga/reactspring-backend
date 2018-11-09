package com.realsprint.academy.reactspring.Repositories;

import com.realsprint.academy.reactspring.DAO.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<JobEntity,Long > {

    List<JobEntity> findAllByCompany(String company);

    List<JobEntity> findAllByTitle(String title);
}
