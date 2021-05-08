package edu.lits.maliatko.controller;
//зупин презент 7

import edu.lits.maliatko.model.ChildInAGroup;
import edu.lits.maliatko.pojo.Child;
import edu.lits.maliatko.repository.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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


    @Autowired
    private ChildRepository childRepository;

    @RequestMapping("/list")
    public String list(ModelMap model) {
        Iterable<Child> all = childRepository.findAll();
        List<Child> childList = new ArrayList<>();
        all.forEach(childList::add);

        model.addAttribute("childInAGroupList", childList);
        model.addAttribute("content", "childInAGroupList");
        return "index";
    }

    @RequestMapping("/add-childInAGroup")
    public String addChildInAGroup(Child child, ModelMap model, BindingResult result) {
        model.addAttribute("content", "createChildInAGroup");
        return "index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Child child) {
        childRepository.save(child);
        return "redirect:/childInAGroup/list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, ModelMap model) {
        childRepository.deleteById(id);
        return "redirect:/childInAGroup/list";
    }

    @RequestMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {


        Child child = childRepository.findById(id).get();
        model.addAttribute("child", child);
        model.addAttribute("content", "updateChildInAGroup");
        return "index";
    }

    @RequestMapping("/update/{id}")
    public String updateChildInAGroup(@PathVariable("id") int id, Child child,
                                      BindingResult result, Model model) {
//        getChildInAGroup.get(id).setDateOfBirdth(child.getDateOfBirdth());
        childRepository.save(child);
        return "redirect:/childInAGroup/list";
    }


}
