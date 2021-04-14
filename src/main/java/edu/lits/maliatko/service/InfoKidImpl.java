package edu.lits.maliatko.service;

import edu.lits.maliatko.model.test.InfoKidModel;
import edu.lits.maliatko.pojo.Child;
import edu.lits.maliatko.repository.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InfoKidImpl implements InfoKidService{

    @Autowired
private ChildRepository childRepository;

    @Override
    public InfoKidModel findById(Integer id) {
        Child child = childRepository.findById(id).get();
        return null;
    }
}
