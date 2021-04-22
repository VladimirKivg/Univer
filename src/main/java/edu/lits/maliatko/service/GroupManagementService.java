package edu.lits.maliatko.service;

import edu.lits.maliatko.model.ChildModel;
import edu.lits.maliatko.model.ClusterModel;
import edu.lits.maliatko.model.EducatorModel;
import edu.lits.maliatko.model.ManagerGroupModel;

import java.util.List;

public interface GroupManagementService {
    List<ClusterModel> findAllCluster();
    List<ChildModel> findAllChild();
    List<EducatorModel> findAllEducator();

    void deleteById(Integer id);

    ManagerGroupModel getManagerGroupModel(Integer kindergartenId, Integer clusterId);

    List<ChildModel> getChildrenInQueue(Integer kindergartenId);

    void removeEducatorFromCluster(Integer userId, Integer clusterId);
}
