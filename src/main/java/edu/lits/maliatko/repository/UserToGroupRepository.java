package edu.lits.maliatko.repository;

import edu.lits.maliatko.pojo.User;
import org.springframework.data.repository.CrudRepository;

public interface UserToGroupRepository extends CrudRepository<User,Integer> {
}
