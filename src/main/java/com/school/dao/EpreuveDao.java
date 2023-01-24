package com.school.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.model.Epreuve;


@Repository
public interface EpreuveDao extends JpaRepository<Epreuve, Integer> {
    
}
