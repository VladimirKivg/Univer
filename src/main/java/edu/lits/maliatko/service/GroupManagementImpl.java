package edu.lits.maliatko.service;

import edu.lits.maliatko.model.ChildModel;
import edu.lits.maliatko.model.ClusterModel;
import edu.lits.maliatko.model.EducatorModel;
import edu.lits.maliatko.model.ManagerGroupModel;
import edu.lits.maliatko.pojo.*;
import edu.lits.maliatko.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupManagementImpl implements GroupManagementService {

    @Autowired
    UserToRoleRepository userToRoleRepository;

    @Autowired
    ClusterRepository clusterRepository;

    @Autowired
    ChildRepository childRepository;

    @Autowired
    UserToGroupRepository userToGroupRepository;

    @Autowired
    QueueRepository queueRepository;


    @Override
    public List<ClusterModel> findAllCluster() {
        Iterable<Cluster> all = clusterRepository.findAll();
        List<ClusterModel> clusterModelList = new ArrayList<>();
        for (Cluster cluster : all) {
            ClusterModel clusterModel = new ClusterModel(cluster.getId(), cluster.getName(), cluster.getKindergarten());
            clusterModelList.add(clusterModel);
        }
        return clusterModelList;
    }

    @Override
    public List<ChildModel> findAllChild() {
        Iterable<Child> all = childRepository.findAll();
        List<ChildModel> childModelList = new ArrayList<>();
        for (Child child : all) {
            ChildModel childModel = new ChildModel(child.getId(), child.getName(), child.getSurname(), child.getFatherName());
            childModelList.add(childModel);
        }
        return childModelList;
    }

    @Override
    public List<EducatorModel> findAllEducator() {
        Iterable<UserToRole> role_educator = userToRoleRepository.findByRole_Role("ROLE_EDUCATOR");
        List<EducatorModel> educatorModelList = new ArrayList<>();
        for (UserToRole userToRole : role_educator) {

            EducatorModel educatorModel = new EducatorModel(userToRole.getUser().getId(), userToRole.getUser().getName(), userToRole.getUser().getSurname(), userToRole.getUser().getFatherName());
            educatorModelList.add(educatorModel);
        }
        return educatorModelList;
    }

    @Override
    public void deleteById(Integer id) {
        clusterRepository.deleteById(id);
    }

    @Override
    public ManagerGroupModel getManagerGroupModel(Integer kindergartenId, Integer clusterId) {

        ManagerGroupModel managerGroupModel = new ManagerGroupModel();

        List<ClusterModel> clusterModelList = new ArrayList<>();

        Iterable<Cluster> clusterIterable = clusterRepository.findByKindergartenId(kindergartenId);
        for (Cluster c : clusterIterable) {
            ClusterModel clusterModel = new ClusterModel(c.getId(), c.getName(), c.getKindergarten());
            clusterModelList.add(clusterModel);
        }

        managerGroupModel.setGroupList(clusterModelList);

        if (clusterId == null) {
            return managerGroupModel;
        }

        List<ChildModel> childModelList = new ArrayList<>();

        Iterable<Child> childIterable = childRepository.findByClusterId(clusterId);
        for (Child c : childIterable) {
            ChildModel childModel = new ChildModel(c.getId(), c.getName(), c.getSurname(), c.getFatherName());
            childModelList.add(childModel);
        }

        managerGroupModel.setChildModelList(childModelList);

        List<EducatorModel> educatorModelList = new ArrayList<>();

        Iterable<UserToGroup> userToGroupIterable = userToGroupRepository.findByClusterId(clusterId);
        for (UserToGroup u : userToGroupIterable) {
            EducatorModel educatorModel = new EducatorModel(u.getUser().getId(), u.getUser().getName(), u.getUser().getSurname(), u.getUser().getFatherName());
            educatorModelList.add(educatorModel);
        }

        managerGroupModel.setEducatorModelList(educatorModelList);

        return managerGroupModel;
    }

    @Override
    public List<ChildModel> getChildrenInQueue(Integer kindergartenId) {

        Iterable<Queue> queueIterable = queueRepository.findByKindergartenId(kindergartenId);

        List<ChildModel> childModelList = new ArrayList<>();

        for (Queue q : queueIterable) {
            ChildModel childModel = new ChildModel(q.getChild().getId(), q.getChild().getName(), q.getChild().getSurname(), q.getChild().getFatherName());
            childModelList.add(childModel);
        }

        return childModelList;
    }

    @Override
    public void removeEducatorFromCluster(Integer userId, Integer clusterId) {
        Iterable<UserToGroup> userToGroupIterable = userToGroupRepository.findByUserIdAndClusterId(userId, clusterId);
        for (UserToGroup u : userToGroupIterable) {
            userToGroupRepository.deleteById(u.getId());
        }

    }

}
