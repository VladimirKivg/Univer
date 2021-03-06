package edu.lits.maliatko.repository;



import edu.lits.maliatko.pojo.UserToRole;
import org.springframework.data.repository.CrudRepository;

public interface UserToRoleRepository extends CrudRepository<UserToRole,Integer> {
    Iterable<UserToRole> findByRole_Role(String role);
    Iterable<UserToRole> findByRoleId(Integer roleId);
    UserToRole findByUserId (Integer userId);

}
