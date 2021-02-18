package edu.lits.maliatko.controller;
//зупин презент 7
import edu.lits.maliatko.model.СhildInAGroup;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/childInAGroup")
public class СhildInAGroupController {


    @RequestMapping("/list")
    public String list(ModelMap model) {

        List<СhildInAGroup> childInAGroup = getСhildInAGroup();
        model.addAttribute("childInAGroupList", childInAGroup);

        model.addAttribute("content", "childInAGroupList");
        return "index";
    }
    private List<СhildInAGroup> getСhildInAGroup() {
        List<СhildInAGroup> getСhildInList = new ArrayList<>();
        СhildInAGroup child = new СhildInAGroup();
        child.setName("Маленький");
        child.setSurname("Малюк");
        child.setDateOfBirdth("24.13.2022");
        child.setId(1);
        getСhildInList.add(child);
        // add other groups
        return getСhildInList;
    }



}
