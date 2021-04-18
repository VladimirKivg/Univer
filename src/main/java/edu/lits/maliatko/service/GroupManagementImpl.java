package edu.lits.maliatko.service;

import edu.lits.maliatko.model.ChildModel;
import edu.lits.maliatko.model.ClusterModel;
import edu.lits.maliatko.model.EducatorModel;
import edu.lits.maliatko.pojo.Child;
import edu.lits.maliatko.pojo.Cluster;
import edu.lits.maliatko.pojo.UserToRole;
import edu.lits.maliatko.repository.ChildRepository;
import edu.lits.maliatko.repository.ClusterRepository;
import edu.lits.maliatko.repository.UserToRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupManagementImpl implements GroupManagementService{

    @Autowired
    UserToRoleRepository userToRoleRepository;

    @Autowired
    ClusterRepository clusterRepository;

    @Autowired
    ChildRepository childRepository;


    @Override
    public List<ClusterModel> findAllCluster() {
        Iterable<Cluster> all = clusterRepository.findAll();
        List<ClusterModel>clusterModelList=new ArrayList<>();
        for (Cluster cluster:all){
            ClusterModel clusterModel=new ClusterModel(cluster.getId(),cluster.getName(),cluster.getKindergarten());
            clusterModelList.add(clusterModel);
        }
        return clusterModelList;
    }

    @Override
    public List<ChildModel> findAllChild() {
        Iterable<Child> all = childRepository.findAll();
        List<ChildModel>childModelList=new ArrayList<>();
        for (Child child : all){
            ChildModel childModel=new ChildModel(child.getId(),child.getName(), child.getSurname(), child.getFatherName());
            childModelList.add(childModel);
        }
        return childModelList;
    }

    @Override
    public List<EducatorModel> findAllEducator() {
        Iterable<UserToRole> role_educator = userToRoleRepository.findByRole_Role("ROLE_EDUCATOR");
List<EducatorModel>educatorModelList=new ArrayList<>();
for (UserToRole userToRole:role_educator){

EducatorModel educatorModel=new EducatorModel(userToRole.getUser().getId(),userToRole.getUser().getName(),userToRole.getUser().getSurname(),userToRole.getUser().getFatherName());
educatorModelList.add(educatorModel);
}
        return educatorModelList;
    }

    @Override
    public void deleteById(Integer id) {
        clusterRepository.deleteById(id);
    }
}
