package edu.lits.maliatko.controller;


import edu.lits.maliatko.model.CreatingGroupsModel;

import edu.lits.maliatko.service.CreatingGroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CreatingGroupsController {

    @Autowired
    private CreatingGroupsService creatingGroupsService;

    @RequestMapping("/creating_groups")
    public String creating(CreatingGroupsModel creatingGroups, ModelMap model) {
        model.addAttribute("content", "creatingGroups");
        return "index";
    }


    @RequestMapping(value = "/addNameGroup", method = RequestMethod.POST)
    public String addNameGroups(CreatingGroupsModel creatingGroups) {

        creatingGroupsService.save(creatingGroups);

        return "redirect:/management";
    }
}
