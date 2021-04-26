package edu.lits.maliatko.repository;


import edu.lits.maliatko.pojo.UserToKindergarten;
import org.springframework.data.repository.CrudRepository;

public interface UserToKindergartenRepository extends CrudRepository<UserToKindergarten,Integer> {
    Iterable<UserToKindergarten> findByKindergartenId(Integer kindergartenId);
}
