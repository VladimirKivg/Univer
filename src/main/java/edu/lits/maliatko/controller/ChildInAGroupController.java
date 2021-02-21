package edu.lits.maliatko.controller;
//зупин презент 7
import edu.lits.maliatko.model.СhildInAGroup;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/childInAGroup")
public class СhildInAGroupController {

    private static List<СhildInAGroup> getСhildInAGroup = new ArrayList<>();
    static {
        СhildInAGroup child = new СhildInAGroup();
        child.setName("Маленький");
        child.setSurname("Малюк");
        child.setDateOfBirdth("24.13.2022");
        child.setId(1);
        getСhildInAGroup.add(child);
        // add other groups
    }

    @RequestMapping("/list")
    public String list(ModelMap model) {

        List<СhildInAGroup> childInAGroup = getСhildInAGroup;
        model.addAttribute("childInAGroupList", childInAGroup);

        model.addAttribute("content", "childInAGroupList");
        return "index";
    }

    @RequestMapping("/add-сhildInAGroup")
    public String addСhildInAGroup(СhildInAGroup сhild, ModelMap model, BindingResult result) {
        model.addAttribute("content", "createChildInAGroup");
        return "index";
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(СhildInAGroup сhild) {
        getСhildInAGroup.add(сhild);
        return "redirect:/childInAGroup/list";
    }



}
