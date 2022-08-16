package com.example.springboot_api_sample.dto;

import com.example.springboot_api_sample.entity.UserPojo;
import lombok.Data;

import javax.persistence.Column;
@Data
public class UserDto {
    private int id;
    private String name;
    private String email;

    public UserDto(UserPojo userPojo) {
        this.id=userPojo.getId();
        this.name = userPojo.getName() ;
        this.email = userPojo.getEmail();
    }

}
