package com.example.springboot_api_sample.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "user_information")
@Data
public class UserPojo {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Username should not be blank")
    @Column(name = "user_name")
    private String name;
    @Column(name = "user_email")
    @NotBlank(message = "Email should not be blank")
    @Email
    private String email;
    @Column(name = "user_pass")
    @NotBlank(message = "Password should not be blank")
    private String password;

}
