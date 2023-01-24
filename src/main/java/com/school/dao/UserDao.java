package com.school.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.google.common.base.Optional;
import com.school.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{

    Optional<User> findByEmail(@Param("email") String email);

}