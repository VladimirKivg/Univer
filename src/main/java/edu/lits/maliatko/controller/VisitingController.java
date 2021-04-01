package edu.lits.maliatko.controller;

import edu.lits.maliatko.pojo.Child;
import edu.lits.maliatko.pojo.User;
import edu.lits.maliatko.repository.ChildRepository;
import edu.lits.maliatko.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VisitingController {

    @Autowired
    private ChildRepository childRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/visiting")
    public String visiting(ModelMap model) {

        User educator = userRepository.findById(2).get();
        Iterable<Child> allChildren = childRepository.findAll();

        model.addAttribute("educator", educator);
        model.addAttribute("allChildren", allChildren);
        model.addAttribute("content", "visiting");
        return "index";
    }

}
