package edu.lits.maliatko.repository;

import edu.lits.maliatko.pojo.Visiting;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Date;

public interface VisitingRepository extends CrudRepository <Visiting,Integer> {
    Iterable<Visiting> findAllByPresence(Integer presence);

    @Query(value = "SELECT * FROM visiting WHERE DATE(visiting_date) = DATE(?1)", nativeQuery = true)
    Iterable<Visiting> findAllVisitingByDate(Date date);
}
