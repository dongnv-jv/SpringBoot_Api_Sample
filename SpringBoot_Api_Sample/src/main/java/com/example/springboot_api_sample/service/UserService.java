package com.example.springboot_api_sample.service;

import com.example.springboot_api_sample.dto.UserDto;
import com.example.springboot_api_sample.entity.UserPojo;
import com.example.springboot_api_sample.repository.IUserRepository;
import com.example.springboot_api_sample.responseobject.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository iUserRepository;

    @Override
    public UserPojo add(UserPojo userPojo) {
        iUserRepository.save(userPojo);
        return userPojo;
    }

    @Override
    public List<UserDto> getAll() {
        List<UserDto> list = new ArrayList<>();
        List<UserPojo> listPojo = new ArrayList<>();
        iUserRepository.findAll().forEach(listPojo::add);
        for (UserPojo userPojo : listPojo) {
            list.add(new UserDto(userPojo));
        }
        return list;
    }

    @Override
    public List<UserPojo> getAllPojo() {
        List<UserPojo> listPojo = new ArrayList<>();
        iUserRepository.findAll().forEach(listPojo::add);
        return listPojo;
    }

    @Override
    public Optional<UserDto> findById(int id) {
        Optional<UserPojo> userpojo = iUserRepository.findById(id);
        Optional<UserDto> optional =  Optional.empty();
        if (userpojo.isPresent()) {
            optional = Optional.of(new UserDto(userpojo.get()));
        }
        return optional;
    }

    @Override
    public Optional<UserPojo> findByIdPojo(int id) {
        Optional<UserPojo> optional =  Optional.empty();
        optional = iUserRepository.findById(id);
        if (optional.isPresent()) {
            return optional;
        }else
            return  Optional.empty();

    }

    @Override
    public List<UserPojo>  findByNameUser(String name) {
        List<UserPojo> list =iUserRepository.findByUserpojoName(name);

        return list;
    }


}
