package edu.lits.maliatko.repository;

import edu.lits.maliatko.pojo.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User
        ,Integer> {
}
