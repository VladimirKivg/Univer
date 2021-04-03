package edu.lits.maliatko.controller.test;

import edu.lits.maliatko.model.ChildModel;
import edu.lits.maliatko.model.ClusterModel;
import edu.lits.maliatko.model.EducatorModel;
import edu.lits.maliatko.model.ManagerGroupModel;
import edu.lits.maliatko.pojo.*;
import edu.lits.maliatko.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GroupManagementController {

    @Autowired
    UserToRoleRepository userToRoleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

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



UserToRole userToRole=new UserToRole();
         Iterable<UserToRole> all2 = userToRoleRepository.findAll();
         for (UserToRole userToRol:all2){
             if("ROLE_EDUCATOR".equals(userToRol.getRole().getRole())){
               userToRole=userToRol;
             }
         }
         EducatorModel educatorModel = new EducatorModel(userToRole.getUser().getName(),userToRole.getUser().getSurname(),userToRole.getUser().getFatherName());




//         Iterable<User> all2 = userRepository.findAll();
//         for (User us:all2){
//             us.g
//         }

//         Iterable<Role> all2 = roleRepository.findAll();
//         for (Role role:all2){
//             role.
//         }

         model.addAttribute("groups",managerGroupModel.groupList);
         model.addAttribute("attributeChild",managerGroupModel.childModelList);
         model.addAttribute("educator",managerGroupModel.groupList);
         model.addAttribute("content","managerGroup");
    return "index"; }

}
