package com.school.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.school.model.Matiere;

@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping(path = "/matiere")
public interface MatiereRest {


    @GetMapping(path = "/matieres")
    public List<Matiere> showMatiere();

    @GetMapping(path = "/matieres/{id}")
    public ResponseEntity<Matiere> getMatiereById(@PathVariable Integer id);

    @PostMapping(path = "/add")
    public Matiere addMatiere(@RequestBody Matiere matiere);

    @PutMapping("/matieres/{id}")
    public ResponseEntity<Matiere> updateMatiere(@PathVariable Integer id, @RequestBody Matiere matiere);

    @DeleteMapping(path = "matieres/{id}")
    public String deleteMatiereById(@PathVariable Integer id);
    
}
