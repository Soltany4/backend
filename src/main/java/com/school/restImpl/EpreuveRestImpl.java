package com.school.restImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.school.dao.EpreuveDao;
import com.school.model.Epreuve;
import com.school.rest.EpreuveRest;

@RestController
public class EpreuveRestImpl implements EpreuveRest{

    @Autowired
    EpreuveDao epreuveDao;

    @Override
    public List<Epreuve> showEpreuve() {
        return epreuveDao.findAll();
    }

    @Override
    public ResponseEntity<Epreuve> getEpreuveById(Integer id) {
        Epreuve e = epreuveDao.findById(id).get();
        return ResponseEntity.ok().body(e);
    }

    @Override
    public Epreuve addEpreuve(Epreuve epreuve) {
        Epreuve e = epreuveDao.save(epreuve);
        return e;
    }
    
}
