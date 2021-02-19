package edu.lits.maliatko.controller;
//зупин презент 7
import edu.lits.maliatko.model.СhildInAGroup;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, ModelMap model) {
        getСhildInAGroup.remove(id-1);
        return "redirect:/childInAGroup/list";
    }



}
