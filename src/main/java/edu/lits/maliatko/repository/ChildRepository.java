package edu.lits.maliatko.repository;

import edu.lits.maliatko.pojo.Child;
import org.springframework.data.repository.CrudRepository;

public interface KidRepository extends CrudRepository<Child, Integer> {
Child findById(int id);
}
