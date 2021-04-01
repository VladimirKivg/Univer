package edu.lits.maliatko.controller.test;

import edu.lits.maliatko.model.ChildModel;
import edu.lits.maliatko.model.ClusterModel;
import edu.lits.maliatko.model.ManagerGroupModel;
import edu.lits.maliatko.pojo.Child;
import edu.lits.maliatko.pojo.Cluster;
import edu.lits.maliatko.repository.ChildRepository;
import edu.lits.maliatko.repository.ClusterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GroupManagementController {
   @Autowired
     ClusterRepository clusterRepository;
   @Autowired
   ChildRepository childRepository;

     @RequestMapping("/alibab")
    public String addGroupManagementController(ManagerGroupModel managerGroupModel, Model model){
         Iterable<Cluster> all = clusterRepository.findAll();
         for (Cluster cluster:all){
             ClusterModel clusterModel=new ClusterModel();
             clusterModel.setName(cluster.getName());
             managerGroupModel.groupList.add(clusterModel);
         }

         Iterable<Child> all1 = childRepository.findAll();
         for (Child child:all1){
             ChildModel childModel=new ChildModel();
             childModel.setName(child.getName());
             childModel.setSurname(child.getSurname());
             childModel.setFatherName(child.getFatherName());
             managerGroupModel.childModelList.add(childModel);
         }
         model.addAttribute("groups",managerGroupModel.groupList);
         model.addAttribute("attributeChild",managerGroupModel.childModelList);
         model.addAttribute("content","managerGroup");
    return "index"; }

}
