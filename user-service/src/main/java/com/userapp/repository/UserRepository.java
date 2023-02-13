package com.userapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userapp.entity.UserData;

public interface UserRepository extends JpaRepository<UserData, Integer> {

}
