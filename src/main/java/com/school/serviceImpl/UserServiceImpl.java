package com.school.serviceImpl;

import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.common.base.Optional;
import com.school.constents.SchoolConstent;
import com.school.dao.UserDao;
import com.school.model.User;
import com.school.service.UserService;
import com.school.utils.SchoolUtil;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserDao userDao;

    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        try {log.info("inside signup {}", requestMap);
        if (validateSignUpMap(requestMap)) {

            Optional<User> user = userDao.findByEmail(requestMap.get("email"));
            if(Objects.isNull(user)) {
                userDao.save(getUserFromMap(requestMap));
                return SchoolUtil.getResponseEntity("Succssesfully Registred", HttpStatus.OK);
            } else {
                return SchoolUtil("Email existe déja.", HttpStatus.BAD_REQUEST);
            }

        } else {
            return SchoolUtil.getResponseEntity(SchoolConstent.INVALID_DATA, HttpStatus.BAD_REQUEST);
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }

    return SchoolUtil(SchoolConstent.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    private ResponseEntity<String> SchoolUtil(String string, HttpStatus badRequest) {
        return null;
    }

    private boolean validateSignUpMap(Map<String, String> requestMap) {
        if (requestMap.containsKey("name") && requestMap.containsKey("prenom") && requestMap.containsKey("email") && requestMap.containsKey("phone")
            && requestMap.containsKey("address") && requestMap.containsKey("password") && requestMap.containsKey("classe")){
                return true;
            } else {
                return false;
            }
    }

    private User getUserFromMap(Map<String, String> requestMap){
        User user = new User();
        user.setName(requestMap.get("name"));
        user.setPrenom(requestMap.get("prenom"));
        user.setEmail(requestMap.get("email"));
        user.setPhone(requestMap.get("phone"));
        user.setAddress(requestMap.get("address"));
        user.setPassword(requestMap.get("password"));
        user.setClasse(requestMap.get("classe"));
        user.setRole("role");
        return user;
    }
    
}
