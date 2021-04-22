package edu.lits.maliatko.controller;

import edu.lits.maliatko.model.ChildModel;
import edu.lits.maliatko.model.ClusterModel;
import edu.lits.maliatko.model.ManagerGroupModel;
import edu.lits.maliatko.service.GroupManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class GroupManagementController {

    private Integer selectedCluster;

    @Autowired
    private GroupManagementService groupManagementService;


    @RequestMapping(value = "/management", method = RequestMethod.GET)
    public String showClusters(Model model) {

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

        ManagerGroupModel managerGroupModel = groupManagementService.getManagerGroupModel(1, null);

        model.addAttribute("groups", managerGroupModel.groupList);
        model.addAttribute("content", "managerGroup");
        return "index";
    }

    @RequestMapping(value = "/management_cluster_content", method = RequestMethod.GET)
    public String showClusterContent(Integer id, Model model) {

        selectedCluster = id;
        ManagerGroupModel managerGroupModel = groupManagementService.getManagerGroupModel(1, selectedCluster);
        List<ChildModel> childrenInQueue = groupManagementService.getChildrenInQueue(1);

        model.addAttribute("groups", managerGroupModel.groupList);
        model.addAttribute("attributeChild", managerGroupModel.childModelList);
        model.addAttribute("attributeEducator", managerGroupModel.educatorModelList);
        model.addAttribute("childrenInQueue", childrenInQueue);
        model.addAttribute("selectedCluster", selectedCluster);
        model.addAttribute("content", "managerGroup");
        return "index";
    }

    @RequestMapping(value = "/management_remove_educator", method = RequestMethod.GET)
    public String removeEducator(Integer id, Model model) {

        groupManagementService.removeEducatorFromCluster(id, selectedCluster);
        ManagerGroupModel managerGroupModel = groupManagementService.getManagerGroupModel(1, selectedCluster);
        List<ChildModel> childrenInQueue = groupManagementService.getChildrenInQueue(1);

        model.addAttribute("groups", managerGroupModel.groupList);
        model.addAttribute("attributeChild", managerGroupModel.childModelList);
        model.addAttribute("attributeEducator", managerGroupModel.educatorModelList);
        model.addAttribute("childrenInQueue", childrenInQueue);
        model.addAttribute("selectedCluster", selectedCluster);
        model.addAttribute("content", "managerGroup");
        return "index";
    }
}
