package edu.lits.maliatko.repository;


import edu.lits.maliatko.pojo.UserToGroup;
import org.springframework.data.repository.CrudRepository;

public interface UserToGroupRepository extends CrudRepository<UserToGroup,Integer> {
    Iterable<UserToGroup> findByClusterId(Integer clusterId);
    Iterable<UserToGroup> findByUserIdAndClusterId(Integer userId, Integer clusterId);
    Iterable<UserToGroup> findByUserId(Integer userId);
}
