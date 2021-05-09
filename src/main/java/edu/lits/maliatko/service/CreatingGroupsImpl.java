package edu.lits.maliatko.service;


import edu.lits.maliatko.model.CreatingGroupsModel;
import edu.lits.maliatko.pojo.Cluster;
import edu.lits.maliatko.repository.ClusterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatingGroupsImpl implements CreatingGroupsService{

    @Autowired
   private ClusterRepository clusterRepository;



    @Override
    public void save(CreatingGroupsModel creatingGroups) {
        Cluster cluster = new Cluster(creatingGroups.getNameGroup(), creatingGroups.getKindergartenId());
        clusterRepository.save(cluster);
    }

}
