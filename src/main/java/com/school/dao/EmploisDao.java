package com.school.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.model.Emplois;

@Repository
public interface EmploisDao extends JpaRepository<Emplois, Integer>{
    
}
