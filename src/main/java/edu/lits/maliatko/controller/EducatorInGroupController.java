package edu.lits.maliatko.controller;

import edu.lits.maliatko.model.EducatorInGroup;
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
@RequestMapping("/educator-in-group")
public class EducatorInGroupController {
    public static List<EducatorInGroup> educatorInGroup = new ArrayList<>();




    @RequestMapping("/list")
    public String list(ModelMap model) {
        model.addAttribute("educatorInGroupList", educatorInGroup);
        model.addAttribute("content", "");
        return "index";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, ModelMap model) {
        educatorInGroup.remove(id-1);// this logic is not correct, id doesn’t depend on index
        return "redirect:/educator-in-group/list";
    }

    @RequestMapping("/add-educator-in-group")
    public String addEducatorInGroup(EducatorInGroup educator, ModelMap model, BindingResult result) {
        model.addAttribute("content", "");
        return "index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(EducatorInGroup educator) {
        educatorInGroup.add(educator);
        return "redirect:/educator-in-group/list";
    }

    @RequestMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        EducatorInGroup educator = educatorInGroup.get(id-1); // this logic is not correct, group has to be                        //                                    selected by it’s id.
        model.addAttribute("educatorInGroup", educator);
        model.addAttribute("content", "");
        return "index";
    }

    @RequestMapping("/update/{id}")
    public String updateGroup(@PathVariable("id") int id, EducatorInGroup educator, BindingResult result, Model model) {
        educatorInGroup.get(id-1).setName(educator.getName());
        educatorInGroup.get(id-1).setSurname(educator.getSurname());
        educatorInGroup.get(id-1).setCategory(educator.getCategory());
        return "redirect:/educator-in-group/list";
    }
}
