package edu.lits.maliatko.repository;

import edu.lits.maliatko.pojo.Kindergarten;
import edu.lits.maliatko.pojo.Queue;
import edu.lits.maliatko.pojo.User;
import org.springframework.data.repository.CrudRepository;

public interface QueueRepository extends CrudRepository<Queue, Integer> {


    Iterable<Queue> findByKindergarten_Name(String kindergartenName);

    Iterable<Queue> findByKindergartenId(Integer kindergartenId);
}
