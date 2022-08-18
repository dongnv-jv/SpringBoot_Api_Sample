package com.example.springboot_api_sample.controller;

import com.example.springboot_api_sample.dto.UserDto;
import com.example.springboot_api_sample.entity.UserPojo;
//import com.example.springboot_api_sample.exceptionhandle.ExceptionHandel;
import com.example.springboot_api_sample.responseobject.ResponseObject;
import com.example.springboot_api_sample.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
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
    public ResponseEntity<ResponseObject> findById(@Valid @PathVariable("id") int id) {
        Optional<UserDto> optional = userService.findById(id);


        return optional.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(new Date(),"Find Successfully", "ok", optional))
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject(new Date(),"Can not find user with id : " + id, "fail", ""));
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody UserPojo user) {
        List<UserPojo> userPojos = userService.findByNameUser(user.getName().trim());
        if (userPojos.size() > 0) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(new Date(),"User is already exist", "fail", ""));
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(new Date(),"Add Successfully", "ok", userService.add(user)));
    }

    @GetMapping("/seach-by-name")
    public ResponseEntity<?> findByName(@Valid  @RequestParam("name") String name) {
        List<UserPojo> userDtos = userService.findByNameUser(name);
        return ResponseEntity.ok().body(userDtos);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseObject> update( @Valid  @RequestBody UserPojo userPojo, @PathVariable("id") int id) {
        Optional<UserPojo> userPojoUpdate = userService.findByIdPojo(id);
        if (userPojoUpdate.isPresent()) {
            userPojoUpdate.get().setEmail(userPojo.getEmail());
            userPojoUpdate.get().setPassword(userPojo.getPassword());
            userPojoUpdate.get().setName(userPojo.getName());
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(new Date(),"Update successfully", "Success", userService.add(userPojoUpdate.get())));
        }
        List<UserPojo> userPojos = userService.findByNameUser(userPojo.getName().trim());
        if (userPojos.size() > 0) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(new Date(),"User is already exist", "fail", ""));
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(new Date(),"Add successfully", "Success", userService.add(userPojo)));
    }
}
