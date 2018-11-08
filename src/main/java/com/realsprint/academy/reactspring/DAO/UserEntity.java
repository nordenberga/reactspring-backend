package com.realsprint.academy.reactspring.DAO;


import com.realsprint.academy.reactspring.models.Job;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Table(name = "user")
public class UserEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;

        @NotNull
        @Column(name = "username")
        private String username;

        @NotNull
        @Column(name = "password")
        private String password;

       /* @OneToMany(mappedBy="id", cascade = CascadeType.ALL)
        private List<JobEntity> jobApplicationList;*/
    }


