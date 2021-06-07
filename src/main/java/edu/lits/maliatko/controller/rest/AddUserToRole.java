package edu.lits.maliatko.controller.rest;

import edu.lits.maliatko.pojo.Role;
import edu.lits.maliatko.pojo.User;
import edu.lits.maliatko.pojo.UserToGroup;
import edu.lits.maliatko.pojo.UserToRole;
import edu.lits.maliatko.repository.UserRepository;
import edu.lits.maliatko.repository.UserToRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest")
public class AddUserToRole {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserToRoleRepository userToRoleRepository;

    @RequestMapping( value = "/lookUser",method =RequestMethod.POST
    )
public User lookUser(@RequestBody User user){
        User bySurname = userRepository.findBySurname(user.getSurname());

        return bySurname;}

@RequestMapping("/sevUserToRole")
 public void sevUserToRole(User user){
    Role role=new Role();
    role.setId(2);
    UserToRole userToRole =new UserToRole(user,role);
    userToRoleRepository.save(userToRole);
 }

}

