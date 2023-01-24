package com.school.restImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.dao.MatiereDao;
import com.school.model.Matiere;
import com.school.rest.MatiereRest;

@RestController
public class MatiereRestImpl implements MatiereRest{

    @Autowired
    MatiereDao matiereDao;

    @Override
    public List<Matiere> showMatiere() {
        return matiereDao.findAll();
    }

    @Override
    public Matiere addMatiere(@RequestBody Matiere matiere) {
        Matiere m = matiereDao.save(matiere);
        return m;
    }

    @Override
    public ResponseEntity<Matiere> updateMatiere(@PathVariable Integer id, Matiere matiere) {
        Matiere mat = matiereDao.findById(id).get();
        mat.setName(matiere.getName());
        mat.setChaps(matiere.getChaps());
        Matiere updateMat = matiereDao.save(mat);
        return ResponseEntity.ok().body(updateMat);
    }

    @Override
    public ResponseEntity<Matiere> getMatiereById(Integer id) {
        Matiere mat = matiereDao.findById(id).get();
        return ResponseEntity.ok().body(mat);
    }
    
}
