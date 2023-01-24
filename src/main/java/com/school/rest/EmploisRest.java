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

import com.school.model.Emplois;

@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping(path  = "/emplois")
public interface EmploisRest {


    @GetMapping(path = "/emplois")
    public List<Emplois> showEmplois();

    @GetMapping(path = "/emplois/{id}")
    public ResponseEntity<Emplois> getEmploisById(@PathVariable Integer id);

    @PostMapping(path = "/add")
    public Emplois addEmplois(@RequestBody Emplois emplois);

    @PutMapping("/emplois/{id}")
    public ResponseEntity<Emplois> updateEmplois(@PathVariable Integer id, @RequestBody Emplois emplois);

    @DeleteMapping(path = "emplois/{id}")
    public String deleteEmploisById(@PathVariable Integer id);
    
}
