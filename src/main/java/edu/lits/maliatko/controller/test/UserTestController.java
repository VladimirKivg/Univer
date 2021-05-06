package edu.lits.maliatko.controller.test;

import edu.lits.maliatko.model.test.UserModel;
import edu.lits.maliatko.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserTestController {

@Autowired
    UserService userService;

    @RequestMapping("/userTest")
    public String userTest(Model model) {
        UserModel userModel = userService.findUserById(1);


        String name=userModel.getName();
        String address=userModel.getAddress();
         model.addAttribute("name",name);
         model.addAttribute("apartment",address);
         model.addAttribute("content","TESTuser");

        return "index";
    }
}
