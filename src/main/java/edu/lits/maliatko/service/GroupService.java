package edu.lits.maliatko.service;

import edu.lits.maliatko.model.ClusterModel;
import edu.lits.maliatko.pojo.Cluster;

import java.util.List;

public interface GroupService {
    List<ClusterModel> findAll();

    void deleteById(Integer id);
}
