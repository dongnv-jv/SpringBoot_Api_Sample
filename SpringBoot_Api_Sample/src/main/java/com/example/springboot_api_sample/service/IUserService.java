package com.example.springboot_api_sample.service;

import com.example.springboot_api_sample.dto.UserDto;
import com.example.springboot_api_sample.entity.UserPojo;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    UserPojo add(UserPojo userPojo);
    List<UserDto> getAll();
    List<UserPojo> getAllPojo();
    Optional<UserDto>  findById(int id);
//    @Query("select UserPojo from UserPojo where name like %?1%")
   List<UserPojo>  findByNameUser(String name);
}
