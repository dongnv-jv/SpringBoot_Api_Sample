package com.example.springboot_api_sample.repository;

import com.example.springboot_api_sample.entity.UserPojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<UserPojo,Integer> {
//    @Query(value="select u from UserPojo u where u.name like %?1%", nativeQuery = true)
    @Query("select u from UserPojo u where u.name like %?1%")
    List<UserPojo> findByUserpojoName(String name);
}
