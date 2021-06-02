package edu.lits.maliatko.controller.rest;

import edu.lits.maliatko.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class AddUserToRole {

    @Autowired
    UserRepository userRepository;

}
