package edu.lits.maliatko.controller;

import edu.lits.maliatko.model.ChildModel;
import edu.lits.maliatko.model.ClusterModel;
import edu.lits.maliatko.model.EducatorModel;
import edu.lits.maliatko.service.GroupManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/management")
public class GroupManagementController {

    private Integer selectedCluster;
    private List<ClusterModel> clustersInKindergarten;
    private List<ChildModel> childrenInCluster;
    private List<EducatorModel> educatorsInCluster;
    private List<ChildModel> childrenInQueue;
    private List<EducatorModel> educatorsInKindergarten;
    private List<ClusterModel> availableClusters;

    @Autowired
    private GroupManagementService groupManagementService;

    @RequestMapping(value = "/cluster_list", method = RequestMethod.GET)
    public String showClusters(Model model) {
        List<ClusterModel> clustersInKindergarten = groupManagementService.getClustersInKindergarten(1);
        model.addAttribute("groups", clustersInKindergarten);
        model.addAttribute("content", "managerGroup");
        return "index";
    }

    @RequestMapping(value = "/cluster_content", method = RequestMethod.GET)
    public String showClusterContent(Integer id, Model model) {

        selectedCluster = id;

        clustersInKindergarten = groupManagementService.getClustersInKindergarten(1);
        childrenInCluster = groupManagementService.getChildrenInCluster(selectedCluster);
        educatorsInCluster = groupManagementService.getEducatorsInCluster(selectedCluster);
        childrenInQueue = groupManagementService.getChildrenInQueue(1);
        educatorsInKindergarten = groupManagementService.getEducatorsInKindergarten(1, selectedCluster);
        availableClusters = groupManagementService.getAvailableClusters(clustersInKindergarten, selectedCluster);

        model.addAttribute("groups", clustersInKindergarten);
        model.addAttribute("attributeChild", childrenInCluster);
        model.addAttribute("attributeEducator", educatorsInCluster);
        model.addAttribute("childrenInQueue", childrenInQueue);
        model.addAttribute("selectedCluster", selectedCluster);
        model.addAttribute("educatorsInKindergarten", educatorsInKindergarten);
        model.addAttribute("availableClusters", availableClusters);
        model.addAttribute("content", "managerGroup");
        return "index";
    }

    @RequestMapping(value = "/remove_educator", method = RequestMethod.GET)
    public String removeEducator(Integer id, Model model) {

        groupManagementService.removeEducatorFromCluster(id, selectedCluster);

        educatorsInCluster = groupManagementService.getEducatorsInCluster(selectedCluster);
        educatorsInKindergarten = groupManagementService.getEducatorsInKindergarten(1, selectedCluster);

        model.addAttribute("groups", clustersInKindergarten);
        model.addAttribute("attributeChild", childrenInCluster);
        model.addAttribute("attributeEducator", educatorsInCluster);
        model.addAttribute("childrenInQueue", childrenInQueue);
        model.addAttribute("selectedCluster", selectedCluster);
        model.addAttribute("educatorsInKindergarten", educatorsInKindergarten);
        model.addAttribute("availableClusters", availableClusters);
        model.addAttribute("content", "managerGroup");
        return "index";
    }

    @RequestMapping(value = "/add_educator", method = RequestMethod.GET)
    public String addEducator(Integer id, Model model) {

        groupManagementService.addEducatorToCluster(id, selectedCluster);

        educatorsInCluster = groupManagementService.getEducatorsInCluster(selectedCluster);
        educatorsInKindergarten = groupManagementService.getEducatorsInKindergarten(1, selectedCluster);

        model.addAttribute("groups", clustersInKindergarten);
        model.addAttribute("attributeChild", childrenInCluster);
        model.addAttribute("attributeEducator", educatorsInCluster);
        model.addAttribute("childrenInQueue", childrenInQueue);
        model.addAttribute("selectedCluster", selectedCluster);
        model.addAttribute("educatorsInKindergarten", educatorsInKindergarten);
        model.addAttribute("availableClusters", availableClusters);
        model.addAttribute("content", "managerGroup");
        return "index";
    }

    @RequestMapping(value = "/change_cluster", method = RequestMethod.GET)
    public String changeCluster(Integer id, Integer childId, Model model) {

        groupManagementService.moveChildToCluster(id, childId);

        childrenInCluster = groupManagementService.getChildrenInCluster(selectedCluster);

        model.addAttribute("groups", clustersInKindergarten);
        model.addAttribute("attributeChild", childrenInCluster);
        model.addAttribute("attributeEducator", educatorsInCluster);
        model.addAttribute("childrenInQueue", childrenInQueue);
        model.addAttribute("selectedCluster", selectedCluster);
        model.addAttribute("educatorsInKindergarten", educatorsInKindergarten);
        model.addAttribute("availableClusters", availableClusters);
        model.addAttribute("content", "managerGroup");
        return "index";
    }

    @RequestMapping(value = "/add_child_from_queue", method = RequestMethod.GET)
    public String addChild(Integer id, Model model) {

        groupManagementService.addChildFromQueue(id, selectedCluster);

        childrenInCluster = groupManagementService.getChildrenInCluster(selectedCluster);
        childrenInQueue = groupManagementService.getChildrenInQueue(1);

        model.addAttribute("groups", clustersInKindergarten);
        model.addAttribute("attributeChild", childrenInCluster);
        model.addAttribute("attributeEducator", educatorsInCluster);
        model.addAttribute("childrenInQueue", childrenInQueue);
        model.addAttribute("selectedCluster", selectedCluster);
        model.addAttribute("educatorsInKindergarten", educatorsInKindergarten);
        model.addAttribute("availableClusters", availableClusters);
        model.addAttribute("content", "managerGroup");
        return "index";
    }

    @RequestMapping(value = "/add_new_cluster", method = RequestMethod.GET)
    public String addCluster(String newClusterName, Model model) {

        groupManagementService.createNewCluster(1, newClusterName);

        clustersInKindergarten = groupManagementService.getClustersInKindergarten(1);
        availableClusters = groupManagementService.getAvailableClusters(clustersInKindergarten, selectedCluster);

        model.addAttribute("groups", clustersInKindergarten);
        model.addAttribute("attributeChild", childrenInCluster);
        model.addAttribute("attributeEducator", educatorsInCluster);
        model.addAttribute("childrenInQueue", childrenInQueue);
        model.addAttribute("selectedCluster", selectedCluster);
        model.addAttribute("educatorsInKindergarten", educatorsInKindergarten);
        model.addAttribute("availableClusters", availableClusters);
        model.addAttribute("content", "managerGroup");
        return "index";
    }

    @RequestMapping(value = "/delete_cluster", method = RequestMethod.GET)
    public String deleteCluster(Integer id, Model model) {

        groupManagementService.removeCluster(id);

        clustersInKindergarten = groupManagementService.getClustersInKindergarten(1);
        availableClusters = groupManagementService.getAvailableClusters(clustersInKindergarten, selectedCluster);

        model.addAttribute("groups", clustersInKindergarten);
        model.addAttribute("attributeChild", childrenInCluster);
        model.addAttribute("attributeEducator", educatorsInCluster);
        model.addAttribute("childrenInQueue", childrenInQueue);
        model.addAttribute("selectedCluster", selectedCluster);
        model.addAttribute("educatorsInKindergarten", educatorsInKindergarten);
        model.addAttribute("availableClusters", availableClusters);
        model.addAttribute("content", "managerGroup");
        return "index";
    }

    @RequestMapping(value = "/return_child_to_queue", method = RequestMethod.GET)
    public String returnToQueue(String kindergartenName, Integer childId, Model model) {

        groupManagementService.returnChildToQueue(kindergartenName, childId);

        childrenInCluster = groupManagementService.getChildrenInCluster(selectedCluster);
        childrenInQueue = groupManagementService.getChildrenInQueue(1);

        model.addAttribute("groups", clustersInKindergarten);
        model.addAttribute("attributeChild", childrenInCluster);
        model.addAttribute("attributeEducator", educatorsInCluster);
        model.addAttribute("childrenInQueue", childrenInQueue);
        model.addAttribute("selectedCluster", selectedCluster);
        model.addAttribute("educatorsInKindergarten", educatorsInKindergarten);
        model.addAttribute("availableClusters", availableClusters);
        model.addAttribute("content", "managerGroup");
        return "index";
    }
}
