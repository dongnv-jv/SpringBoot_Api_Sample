package com.example.springboot_api_sample.controller;

import com.example.springboot_api_sample.dto.UserDto;
import com.example.springboot_api_sample.entity.UserPojo;
import com.example.springboot_api_sample.responseobject.ResponseObject;
import com.example.springboot_api_sample.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserApiController {
    @Autowired
    IUserService userService;

    @GetMapping("/list")
    public ResponseEntity<?> getAllList() {
        List<UserDto> list = userService.getAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<ResponseObject> findById(@PathVariable("id") int id) {
        Optional<UserDto> optional = userService.findById(id);


        return optional.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("Find Successfully", "ok", optional))
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("Can not find user with id : " + id, "fail", ""));
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseObject> add(@RequestBody UserPojo user) {
        List<UserPojo> userPojos = userService.findByNameUser(user.getName().trim());
        if (userPojos.size() > 0) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("User is already exist", "fail", ""));
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("Add Successfully", "ok", userService.add(user)));
    }

    @GetMapping("/seach-by-name")
    public ResponseEntity<?> findByName(@RequestParam("name") String name) {
        List<UserPojo> userDtos = userService.findByNameUser(name);
        return ResponseEntity.ok().body(userDtos);
    }

}
