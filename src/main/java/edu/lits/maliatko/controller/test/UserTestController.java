package edu.lits.maliatko.controller.test;

import edu.lits.maliatko.pojo.User;
import edu.lits.maliatko.repository.UserRepository;

import edu.lits.maliatko.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserTestController {

@Autowired
    UserRepository userRepository;

@Autowired
    UserService userService;

    @RequestMapping("/userTest")
    public String userTest(Model model) {
        userService.findUserById();
        User user=userRepository.findById(1).get();
        String adres=user.getAddress().getApartment();
        String name = user.getName();
         model.addAttribute("name",name);
         model.addAttribute("apartment",adres);
         model.addAttribute("content","TESTuser");

        return "index";
    }
}
