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

    List<ChildModel> getChildrenInQueue(Integer kindergartenId);

    void removeEducatorFromCluster(Integer userId, Integer clusterId);

    List<EducatorModel> getEducatorsInKindergarten(Integer kindergartenId, Integer clusterId);

    void addEducatorToCluster(Integer userId, Integer clusterId);

    List<ClusterModel> getAvailableClusters(List<ClusterModel> groupList, Integer clusterId);

    void moveChildToCluster(Integer clusterId, Integer childId);

    void addChildFromQueue(Integer childInQueueId, Integer clusterId);

    void createNewCluster(Integer kindergartenId, String newClusterName);

    void removeCluster(Integer clusterId);

    List<ClusterModel> getClustersInKindergarten(Integer kindergartenId);

    List<ChildModel> getChildrenInCluster(Integer clusterId);

    List<EducatorModel> getEducatorsInCluster(Integer clusterId);

    void returnChildToQueue(String kindergartenName, Integer childId);
}
