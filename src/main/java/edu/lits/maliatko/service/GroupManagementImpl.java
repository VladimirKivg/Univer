package edu.lits.maliatko.service;

import edu.lits.maliatko.model.ChildModel;
import edu.lits.maliatko.model.ClusterModel;
import edu.lits.maliatko.model.EducatorModel;
import edu.lits.maliatko.pojo.*;
import edu.lits.maliatko.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    UserToKindergartenRepository userToKindergartenRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    KindergartenRepository kindergartenRepository;


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
            userToGroupRepository.delete(u);
        }

    }

    @Override
    public List<EducatorModel> getEducatorsInKindergarten(Integer kindergartenId, Integer clusterId) {



        List<Integer> usersInKindergarten = new ArrayList<>();
        Iterable<UserToKindergarten> userToKindergartenIterable = userToKindergartenRepository.findByKindergartenId(kindergartenId);
        for (UserToKindergarten u :
                userToKindergartenIterable) {
            usersInKindergarten.add(u.getUser().getId());
        }

        Iterable<UserToGroup> userToGroupIterable = userToGroupRepository.findByClusterId(clusterId);
        for (UserToGroup u :
                userToGroupIterable) {
            usersInKindergarten.remove(u.getUser().getId());
        }

        List<EducatorModel> educatorsInKindergarten = new ArrayList<>();
        Iterable<UserToRole> userToRoleIterable = userToRoleRepository.findByRoleId(2);
        for (UserToRole u :
                userToRoleIterable) {
            if (usersInKindergarten.contains(u.getUser().getId())) {
                EducatorModel educatorModel = new EducatorModel(u.getUser().getId(), u.getUser().getName(), u.getUser().getSurname(), u.getUser().getFatherName());
                educatorsInKindergarten.add(educatorModel);
            }
        }

        return educatorsInKindergarten;

    }

    @Override
    public void addEducatorToCluster(Integer userId, Integer clusterId) {
        User user = userRepository.findById(userId).get();
        Cluster cluster = clusterRepository.findById(clusterId).get();
        userToGroupRepository.save(new UserToGroup(user, cluster));

    }

    @Override
    public List<ClusterModel> getAvailableClusters(List<ClusterModel> groupList, Integer clusterId) {
        List<ClusterModel> availableClusters = new ArrayList<>();
        for (ClusterModel c : groupList) {
            if (c.getId().equals(clusterId)) {
                continue;
            }
            availableClusters.add(c);
        }
        return availableClusters;
    }

    @Override
    public void moveChildToCluster(Integer clusterId, Integer childId) {
        Child child = childRepository.findById(childId).get();
        Cluster cluster = clusterRepository.findById(clusterId).get();
        child.setCluster(cluster);
        childRepository.save(child);
    }

    @Override
    public void addChildFromQueue(Integer childInQueueId, Integer clusterId) {
        Child child = childRepository.findById(childInQueueId).get();
        Cluster cluster = clusterRepository.findById(clusterId).get();
        child.setCluster(cluster);
        childRepository.save(child);

        Queue queue = queueRepository.findByChildId(childInQueueId);
        queueRepository.delete(queue);
    }

    @Override
    public void createNewCluster(Integer kindergartenId, String newClusterName) {
        Kindergarten kindergarten = kindergartenRepository.findById(kindergartenId).get();
        Cluster newCluster = new Cluster(newClusterName, kindergarten);
        clusterRepository.save(newCluster);
    }

    @Override
    public void removeCluster(Integer clusterId) {
        clusterRepository.deleteById(clusterId);
    }

    @Override
    public List<ClusterModel> getClustersInKindergarten(Integer kindergartenId) {

        List<ClusterModel> clusterModelList = new ArrayList<>();

        Iterable<Cluster> clusterIterable = clusterRepository.findByKindergartenId(kindergartenId);
        for (Cluster c : clusterIterable) {
            ClusterModel clusterModel = new ClusterModel(c.getId(), c.getName(), c.getKindergarten());
            clusterModelList.add(clusterModel);
        }

        return clusterModelList;
    }

    @Override
    public List<ChildModel> getChildrenInCluster(Integer clusterId) {

        List<ChildModel> childModelList = new ArrayList<>();

        Iterable<Child> childIterable = childRepository.findByClusterId(clusterId);
        for (Child c : childIterable) {
            ChildModel childModel = new ChildModel(c.getId(), c.getName(), c.getSurname(), c.getFatherName());
            childModelList.add(childModel);
        }
        return childModelList;
    }

    @Override
    public List<EducatorModel> getEducatorsInCluster(Integer clusterId) {

        List<EducatorModel> educatorModelList = new ArrayList<>();

        Iterable<UserToGroup> userToGroupIterable = userToGroupRepository.findByClusterId(clusterId);
        for (UserToGroup u : userToGroupIterable) {
            EducatorModel educatorModel = new EducatorModel(u.getUser().getId(), u.getUser().getName(), u.getUser().getSurname(), u.getUser().getFatherName());
            educatorModelList.add(educatorModel);
        }
        return educatorModelList;
    }

    @Override
    public void returnChildToQueue(String kindergartenName, Integer childId) {
        Iterable<Kindergarten> kindergartenIterable = kindergartenRepository.findByName(kindergartenName);
        Kindergarten kindergarten = null;
        for (Kindergarten k :
                kindergartenIterable) {
            kindergarten = k;
        }

        Child child = childRepository.findById(childId).get();
        child.setCluster(null);
        childRepository.save(child);

        Date applyDate = new Date();

        queueRepository.save(new Queue(child, kindergarten, applyDate));
    }

}
