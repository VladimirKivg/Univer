package edu.lits.maliatko.repository;

import edu.lits.maliatko.pojo.Kindergarten;
import org.springframework.data.repository.CrudRepository;

public interface KindergartenRepository extends CrudRepository<Kindergarten, Integer> {
    Iterable<Kindergarten> findByName(String kindergartenName);
}
