package com.school.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.model.Matiere;

@Repository
public interface MatiereDao extends JpaRepository<Matiere, Integer>{

}
