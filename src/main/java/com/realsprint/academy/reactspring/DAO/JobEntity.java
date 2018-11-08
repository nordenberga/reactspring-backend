package com.realsprint.academy.reactspring.DAO;


import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "job")
public class JobEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long jobId;


        @Column(name = "location")
        private String location;

        @Column(name = "title")
        private String title;
        private String gitId;


}
