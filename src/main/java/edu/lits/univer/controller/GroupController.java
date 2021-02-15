package edu.lits.univer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/group")
public class GroupController {

    @RequestMapping("/list")
    public String list(ModelMap model) {
        model.addAttribute("content", "groupList");
        return "index";
    }

}


