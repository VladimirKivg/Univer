package edu.lits.maliatko.service;

import edu.lits.maliatko.model.ChildModel;
import edu.lits.maliatko.model.ClusterModel;
import edu.lits.maliatko.model.EducatorModel;

import java.util.List;

public interface GroupManagementService {
    List<ClusterModel> findAllCluster();
    List<ChildModel> findAllChild();
    List<EducatorModel> findAllEducator();

    void deleteById(Integer id);
}
