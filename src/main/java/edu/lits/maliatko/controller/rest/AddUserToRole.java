package edu.lits.maliatko.controller.rest;

import edu.lits.maliatko.pojo.User;
import edu.lits.maliatko.repository.UserRepository;
import edu.lits.maliatko.repository.UserToRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class AddUserToRole {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserToRoleRepository userToRoleRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/lookUser")
public User lookUser(String mail){
    User byMailUser = userRepository.findByMail(mail);
 return byMailUser;}

@RequestMapping("sevUserToRole")
 public void sevUserToRole(){

 }

}

