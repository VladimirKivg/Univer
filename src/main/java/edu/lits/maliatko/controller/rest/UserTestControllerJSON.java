package edu.lits.maliatko.controller.rest;

import edu.lits.maliatko.pojo.User;
import edu.lits.maliatko.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/json")
public class UserTestControllerJSON {

@Autowired
    UserRepository userRepository;

    @RequestMapping("/userTest")
    public User userTest(Model model) {

        User user=userRepository.findById(1).get();


        return user;
    }

    @RequestMapping("/userTestTest")
    public List< User> userTestTest(){
        Iterable<User> allById = userRepository.findAllBySurname("Бойчук");
        List<User>userList=new ArrayList<>();
        allById.forEach(userList::add);

    return userList;}



}


