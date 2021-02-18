package edu.lits.maliatko.controller;

import edu.lits.maliatko.model.Group;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/group")
public class GroupController {

    private static final List<Group> groupList = new ArrayList<>();
    static {
        Group group1 = new Group();
        group1.setId(1);
        group1.setName("Яслі_1 - Малятко");
        group1.setNumber(25);
        groupList.add(group1);

        Group group2 = new Group();
        group2.setId(2);
        group2.setName("Яслі_1 - Дзвіночок");
        group2.setNumber(27);
        groupList.add(group2);
    }

    @RequestMapping("/list")
    public String list(ModelMap model) {
        model.addAttribute("groups", groupList);
        model.addAttribute("content", "groupList");
        return "index";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, ModelMap model) {
        groupList.remove(id - 1);
        return "redirect:/group/list";
    }

    @RequestMapping("/add-group")
    public String addGroup(Group group, ModelMap model, BindingResult result) {
        model.addAttribute("content", "createGroup");
        return "index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@Valid Group group , BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            model.addAttribute("content", "createGroup");
            return "index";
        }

        groupList.add(group);
        return "redirect:/group/list";
    }

    @RequestMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Group group = groupList.get(0); // this logic is not correct, group has to be                        //                                    selected by it’s id.
        model.addAttribute("group", group);
        model.addAttribute("content", "updateGroup");
        return "index";
    }
    @RequestMapping("/update/{id}")
    public String updateGroup(@PathVariable("id") int id, Group group,
                              BindingResult result, Model model) {

        groupList.get(id).setName(group.getName());
        groupList.get(id).setNumber(group.getNumber());
        return "redirect:/group/list";
    }


}
