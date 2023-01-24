package com.school.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.school.model.Epreuve;

@RequestMapping(path = "/epreuve")
public interface EpreuveRest {

    @CrossOrigin(origins = "http://localhost:4200")

    @GetMapping(path = "/epreuves")
    public List<Epreuve> showEpreuve();

    @GetMapping(path = "/epreuves/{id}")
    public ResponseEntity<Epreuve> getEpreuveById(@PathVariable Integer id);

    @PostMapping(path = "/add")
    public Epreuve addEpreuve(@RequestBody Epreuve epreuve);

    @DeleteMapping(path = "epreuves/{id}")
    public String deleteEpreuveById(@PathVariable Integer id);

}
