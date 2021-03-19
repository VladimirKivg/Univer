package edu.lits.maliatko.repository;

import edu.lits.maliatko.pojo.User;
import org.springframework.data.repository.CrudRepository;

public interface userToRoleRepository extends CrudRepository<User,Integer> {
}
