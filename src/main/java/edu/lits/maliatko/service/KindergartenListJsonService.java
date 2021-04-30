package edu.lits.maliatko.service;

import edu.lits.maliatko.model.KindergartenModel;
import edu.lits.maliatko.pojo.Kindergarten;

import java.util.List;

public interface KindergartenListJsonService {
    public List<KindergartenModel> findAll();
}
