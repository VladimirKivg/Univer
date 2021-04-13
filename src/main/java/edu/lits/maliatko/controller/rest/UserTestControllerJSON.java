package edu.lits.maliatko.controller.rest;

import edu.lits.maliatko.pojo.User;
import edu.lits.maliatko.pojo.Visiting;
import edu.lits.maliatko.repository.UserRepository;
import edu.lits.maliatko.service.CheckVisitingImpl;
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
//        User user=new User();
        User user=userRepository.findById(1).get();
//        String adres=user.getAddressId().getApartment();
//        String name = user.getName();
//         model.addAttribute("name",name);
//         model.addAttribute("apartment",adres);
//         model.addAttribute("content","userTst");

        return user;
    }

    @RequestMapping("/userTestTest")
    public List< User> userTestTest(){
        Iterable<User> allById = userRepository.findAllBySurname("Бойчук");
        List<User>userList=new ArrayList<>();
        allById.forEach(userList::add);// один із for()

    return userList;}

//
//
//    @RequestMapping("/visitingCheck")//цей не запускається, він через візітінг працює, але нічого не виходить
//    public List<Visiting> visiting(){
//        CheckVisitingImpl checkVisitingService = new CheckVisitingImpl();
//
//        return checkVisitingService.visiting(); }

}


