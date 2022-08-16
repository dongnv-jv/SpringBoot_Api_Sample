package com.example.springboot_api_sample.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="user_information")
@Data
public class UserPojo {
    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_name")
    private String name;
    @Column(name = "user_email")
    private String email;
    @Column(name = "user_pass")
    private String password;

}
