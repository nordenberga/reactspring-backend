package com.realsprint.academy.reactspring.DAO;


import com.realsprint.academy.reactspring.models.Job;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Table(name = "user")
public class UserEntity {

        public UserEntity() {
        }

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;

        @NotNull
        @Column(name = "username")
        private String username;

        @NotNull
        @Column(name = "password")
        private String password;


        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }
}


