package edu.lits.maliatko.controller;

import edu.lits.maliatko.model.ChildModel;
import edu.lits.maliatko.model.ClusterModel;
import edu.lits.maliatko.model.EducatorModel;
import edu.lits.maliatko.model.ManagerGroupModel;
import edu.lits.maliatko.pojo.*;
import edu.lits.maliatko.repository.*;
import edu.lits.maliatko.service.GroupManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GroupManagementController {
//
    @Autowired
    UserToRoleRepository userToRoleRepository;

   @Autowired
     ClusterRepository clusterRepository;

   @Autowired
   ChildRepository childRepository;

   @Autowired
   private GroupManagementService groupManagementService;


     @RequestMapping("/management")
    public String addGroupManagementController(ManagerGroupModel managerGroupModel, Model model){

         managerGroupModel.groupList= groupManagementService.findAllCluster();

//         Iterable<Cluster> all = clusterRepository.findAll();
//         for (Cluster cluster:all){
//             ClusterModel clusterModel=new ClusterModel(cluster.getId(),cluster.getName(),cluster.getKindergarten());
////             clusterModel.setName(cluster.getName());
//             managerGroupModel.groupList.add(clusterModel);
//         }



         managerGroupModel.childModelList= groupManagementService.findAllChild();

//         Iterable<Child> all1 = childRepository.findAll();
//         for (Child child:all1){
//             ChildModel childModel=new ChildModel();
//             childModel.setName(child.getName());
//             childModel.setSurname(child.getSurname());
//             childModel.setFatherName(child.getFatherName());
//             managerGroupModel.childModelList.add(childModel);
//         }





 //закоментована поки не буде аповнена таблиця з ролями rolle і user_to_role

         // groupManagementService.findAllEducator() дає тільки "ROLE_EDUCATOR"


//         Iterable<UserToRole> all2 = userToRoleRepository.findAll();
//         for (UserToRole userToRol:all2){
//             if("ROLE_EDUCATOR".equals(userToRol.getRole().getRole())){
//                 EducatorModel educatorModel = new EducatorModel( userToRol.getUser().getId(),userToRol.getUser().getName(), userToRol.getUser().getSurname(), userToRol.getUser().getFatherName());
//                 managerGroupModel.educatorModelList.add(educatorModel);
//             }
//         }
         managerGroupModel.educatorModelList=groupManagementService.findAllEducator();


         model.addAttribute("groups",managerGroupModel.groupList);
         model.addAttribute("attributeChild",managerGroupModel.childModelList);
         model.addAttribute("attributeEducator", managerGroupModel.educatorModelList);
         model.addAttribute("content","managerGroup");
    return "index"; }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, ModelMap model) {

         groupManagementService.deleteById(id);

//        clusterRepository.deleteById(id);
        return "redirect:/management";
    }
}
