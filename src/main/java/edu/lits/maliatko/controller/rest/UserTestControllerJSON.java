package edu.lits.maliatko.controller.rest;

import edu.lits.maliatko.pojo.User;
import edu.lits.maliatko.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
