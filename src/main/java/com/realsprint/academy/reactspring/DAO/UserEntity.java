package com.realsprint.academy.reactspring.DAO;


import com.realsprint.academy.reactspring.models.Job;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

public class UserEntity {


    @Entity
    @Table(name = "user")
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;

        @NotNull
        @Column(name = "username")
        private String username;

        @NotNull
        @Column(name = "password")
        private String password;

        @OneToMany(mappedBy="user", cascade = CascadeType.ALL)
        private List<Job> jobApplicationList;
    }

}
