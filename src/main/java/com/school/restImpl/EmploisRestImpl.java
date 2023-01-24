package com.school.restImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.school.dao.EmploisDao;
import com.school.model.Emplois;
import com.school.rest.EmploisRest;

@RestController
public class EmploisRestImpl implements EmploisRest{


    @Autowired
    EmploisDao emploisDao;

    @Override
    public List<Emplois> showEmplois() {
        return emploisDao.findAll();
    }

    @Override
    public ResponseEntity<Emplois> getEmploisById(Integer id) {
        return null;
    }

    @Override
    public Emplois addEmplois(Emplois emplois) {
        Emplois e = emploisDao.save(emplois);
        return e;
    }

    @Override
    public ResponseEntity<Emplois> updateEmplois(Integer id, Emplois emplois) {
        return null;
    }

    @Override
    public String deleteEmploisById(Integer id) {
        Emplois emplois = emploisDao.findById(id).get();
        emploisDao.delete(emplois);
        return "Emplois deleted!";
    }
    
}
