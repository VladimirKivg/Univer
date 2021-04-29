package edu.lits.maliatko.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/educator-in-group")
public class EducatorInGroupController {





    @RequestMapping("/list")
    public String list(ModelMap model) {
        model.addAttribute("educatorInGroupList");
        model.addAttribute("content", "");
        return "index";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, ModelMap model) {
        // this logic is not correct, id doesn’t depend on index
        return "redirect:/educator-in-group/list";
    }

    @RequestMapping("/add-educator-in-group")
    public String addEducatorInGroup( ModelMap model, BindingResult result) {
        model.addAttribute("content", "");
        return "index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add() {

        return "redirect:/educator-in-group/list";
    }

    @RequestMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        ; // this logic is not correct, group has to be                        //                                    selected by it’s id.
        model.addAttribute("educatorInGroup");
        model.addAttribute("content", "");
        return "index";
    }

    @RequestMapping("/update/{id}")
    public String updateGroup(@PathVariable("id") int id,  BindingResult result, Model model) {

        return "redirect:/educator-in-group/list";
    }
}
