package edu.lits.maliatko.service;

import edu.lits.maliatko.model.ClusterModel;
import edu.lits.maliatko.pojo.Cluster;
import edu.lits.maliatko.repository.ClusterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupImpl implements GroupService{

    @Autowired
    private ClusterRepository clusterRepository;

    @Override
    public List<ClusterModel> findAll() {
        Iterable<Cluster> all = clusterRepository.findAll();
        List<ClusterModel>clusterModelList=new ArrayList<>();
        for (Cluster cluster:all){
          ClusterModel clusterModel = new ClusterModel(cluster.getId(),cluster.getName(),cluster.getKindergarten());
          clusterModelList.add(clusterModel);
        }
        return clusterModelList;
    }

    @Override
    public void deleteById(Integer id) {
clusterRepository.deleteById(id);
    }
}
