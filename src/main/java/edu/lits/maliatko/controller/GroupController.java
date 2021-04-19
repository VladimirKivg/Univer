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



}
