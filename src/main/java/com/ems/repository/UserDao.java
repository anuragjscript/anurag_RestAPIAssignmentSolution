package com.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ems.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{

}
