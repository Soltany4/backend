package com.school.restImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.school.dao.MatiereDao;
import com.school.dao.UserDao;
import com.school.model.Matiere;
import com.school.model.User;
import com.school.rest.UserRest;
import com.school.service.UserService;

@RestController
public class UserRestImpl implements UserRest {

    @Autowired
    UserService userService;

    @Autowired
    UserDao userDao;

    @Autowired
    MatiereDao matiereDao;


    /*public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        try {
            return userService.signUp(requestMap);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return SchoolUtil.getResponseEntity(SchoolConstent.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }*/

    @Override
    public List<User> showUsers() {
        return userDao.findAll();
    }

    @Override
    public User signup(@RequestBody User user) {
        User us = userDao.save(user);
        return us;         
    }

    @Override
    public ResponseEntity<User> updateUSer(Integer id, User user) {
        User us = userDao.findById(id).get();
        us.setName(user.getName());
        us.setPrenom(user.getPrenom());
        us.setEmail(user.getEmail());
        us.setPhone(user.getPhone());
        us.setAddress(user.getAddress());
        us.setPassword(user.getPassword());
        us.setClasse(user.getClasse());
        us.setRole(user.getRole());
        User updateUser = userDao.save(us);
        return ResponseEntity.ok().body(updateUser);
    }

    @Override
    public ResponseEntity<User> getUserById(Integer id) {
        User user = userDao.findById(id).get();
        return ResponseEntity.ok().body(user);
    }

    @Override
    public User assignMatiereToUser(Integer userId, Integer matiereId) {
        User user = userDao.findById(userId).get();
        Matiere matiere = matiereDao.findById(matiereId).get();
        user.enrollMatiere(matiere);
        return userDao.save(user);
    }

    @Override
    public String deleteUserById(Integer id) {
        User user = userDao.findById(id).get();
        userDao.delete(user);
        return "User deleted!";
    }

    
}
