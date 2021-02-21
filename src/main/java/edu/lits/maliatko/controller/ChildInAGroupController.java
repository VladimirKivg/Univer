package edu.lits.maliatko.controller;
//зупин презент 7
import edu.lits.maliatko.model.ChildInAGroup;
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
public class ChildInAGroupController {

    private static List<ChildInAGroup> getChildInAGroup = new ArrayList<>();
    static {
        ChildInAGroup child = new ChildInAGroup();
        child.setName("Маленький");
        child.setSurname("Малюк");
        child.setDateOfBirdth("24.13.2022");
        child.setId(1);
        getChildInAGroup.add(child);
        // add other groups
    }

    @RequestMapping("/list")
    public String list(ModelMap model) {

        List<ChildInAGroup> childInAGroup = getChildInAGroup;
        model.addAttribute("childInAGroupList", childInAGroup);

        model.addAttribute("content", "childInAGroupList");
        return "index";
    }

    @RequestMapping("/add-childInAGroup")
    public String addChildInAGroup(ChildInAGroup child, ModelMap model, BindingResult result) {
        model.addAttribute("content", "createChildInAGroup");
        return "index";
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(ChildInAGroup child) {
        child.setId((getChildInAGroup.size())+1);
        getChildInAGroup.add(child);

        return "redirect:/childInAGroup/list";
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, ModelMap model) {
        getChildInAGroup.remove(id-1);// this logic is not correct, id doesn’t depend on index
        return "redirect:/childInAGroup/list";
    }



}
