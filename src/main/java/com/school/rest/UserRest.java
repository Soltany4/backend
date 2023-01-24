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

import com.school.model.User;


@RequestMapping(path = "/user")
public interface UserRest {

    @CrossOrigin(origins = "http://localhost:4200")
   /*  @PostMapping(path = "/signup")
    public ResponseEntity<String> signUp(@RequestBody(required = true) Map<String,String> requestMap);   */  

    @PostMapping(path = "/signup")
    public User signup(@RequestBody User user);

    @GetMapping(path = "/users")
    public List<User> showUsers();

    @GetMapping(path = "/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id);

    @PutMapping(path = "/useres/{id}")
    public ResponseEntity<User> updateUSer(@PathVariable Integer id, @RequestBody User user);

    @DeleteMapping(path = "useres/{id}")
    public String deleteUserById(@PathVariable Integer id);

    @PutMapping(path = "/useres/{user_id}/matiere/matieres/{matiere_id}")
    public User assignMatiereToUser(@PathVariable Integer userId, @PathVariable Integer matiereId);
    
}