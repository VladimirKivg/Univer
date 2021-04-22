package edu.lits.maliatko.repository;

import edu.lits.maliatko.pojo.Cluster;
import org.springframework.data.repository.CrudRepository;

 public interface ClusterRepository extends CrudRepository <Cluster,Integer>{

  Iterable<Cluster> findByKindergartenId(Integer kindergartenId);
}
