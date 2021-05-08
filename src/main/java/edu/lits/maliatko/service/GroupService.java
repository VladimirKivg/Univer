package edu.lits.maliatko.service;

import edu.lits.maliatko.model.ClusterModel;

import java.util.List;

public interface GroupService {
    List<ClusterModel> findAll();

    void deleteById(Integer id);
}
