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
public class AddUserToRoleRestController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserToRoleRepository userToRoleRepository;



    @RequestMapping("/lookUser")
public User lookUser(@RequestBody User user){
User byMail = userRepository.findByMail(user.getMail());

        return byMail;}

@RequestMapping("/sevUserToRole")
 public void sevUserToRole(@RequestBody User user){
    Role role=new Role();
    role.setId(2);
    UserToRole userToRole =new UserToRole(user,role);
    userToRoleRepository.save(userToRole);
 }

}

