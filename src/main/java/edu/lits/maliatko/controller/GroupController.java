package edu.lits.maliatko.controller;

import edu.lits.maliatko.model.ClusterModel;
import edu.lits.maliatko.model.Group;
import edu.lits.maliatko.pojo.Cluster;
import edu.lits.maliatko.pojo.Payment;
import edu.lits.maliatko.repository.ClusterRepository;
import edu.lits.maliatko.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private GroupService groupService;

    @RequestMapping("/list")
    public String list(ModelMap model) {
        List<ClusterModel> clusterModelList = groupService.findAll();
        model.addAttribute("groups", clusterModelList);
        model.addAttribute("content", "groupList");
        return "index";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, ModelMap model) {
        groupService.deleteById(id);
        return "redirect:/group/list";
    }

//    @RequestMapping("/add-group")
//    public String addGroup(Group group, ModelMap model, BindingResult result) {
//        model.addAttribute("content", "createGroup");
//        return "index";
//    }

//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public String add(@Valid Group group , BindingResult result, ModelMap model) {
//        if (result.hasErrors()) {
//            model.addAttribute("content", "createGroup");
//            return "index";
//        }
//        groupList.add(group);
//        return "redirect:/group/list";
//    }

//    @RequestMapping("/edit/{id}")
//    public String showUpdateForm(@PathVariable("id") long id, Model model) {
//        Group group = groupList.get(0); // this logic is not correct, group has to be                        //                                    selected by it’s id.
//        model.addAttribute("group", group);
//        model.addAttribute("content", "updateGroup");
//        return "index";
//    }
//    @RequestMapping("/update/{id}")
//    public String updateGroup(@PathVariable("id") int id, Group group,
//                              BindingResult result, Model model) {
//
//        groupList.get(id).setName(group.getName());
//        groupList.get(id).setNumber(group.getNumber());
//        return "redirect:/group/list";
//    }


}
