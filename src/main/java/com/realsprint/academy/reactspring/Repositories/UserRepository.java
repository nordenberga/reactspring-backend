package com.realsprint.academy.reactspring.Repositories;


import com.realsprint.academy.reactspring.DAO.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long > {


}
