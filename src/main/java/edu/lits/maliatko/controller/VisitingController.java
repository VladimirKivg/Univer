package edu.lits.maliatko.controller;

import edu.lits.maliatko.model.ChildModel;
import edu.lits.maliatko.model.ClusterModel;
import edu.lits.maliatko.model.VisitingList;
import edu.lits.maliatko.pojo.User;
import edu.lits.maliatko.service.VisitingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/visiting")
public class VisitingController {

    private User educator;
    private List<ClusterModel> clusterList;
    private List<ChildModel> childList;
    private String currentDate;
    private Integer selectedCluster;

    @Autowired
    VisitingService visitingService;

    @RequestMapping(value = "/child_list", method = RequestMethod.GET)
    public String visitingCheck(ModelMap model) {

        educator = visitingService.getEducator(2);

        clusterList = visitingService.getClusterList(2);

        if (!clusterList.isEmpty()) {
            selectedCluster = clusterList.get(0).getId();
            childList = visitingService.getChildList(selectedCluster);
        } else {
            childList = new ArrayList<>();
        }

        currentDate = visitingService.getCurrentTime();

        model.addAttribute("educator", educator);
        model.addAttribute("clusterList", clusterList);
        model.addAttribute("childList", childList);
        model.addAttribute("content", "visiting");
        model.addAttribute("currentDate", currentDate);
        model.addAttribute("selectedCluster", selectedCluster);
        return "index";
    }

    @RequestMapping(value = "/change_cluster", method = RequestMethod.GET)
    public String visitingChangeCluster(Integer currentCluster, ModelMap model) {

        selectedCluster = currentCluster;

        childList = visitingService.getChildList(selectedCluster);

        model.addAttribute("educator", educator);
        model.addAttribute("clusterList", clusterList);
        model.addAttribute("childList", childList);
        model.addAttribute("content", "visiting");
        model.addAttribute("currentDate", currentDate);
        model.addAttribute("selectedCluster", selectedCluster);
        return "index";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String visitingUpdate(VisitingList visitingList, ModelMap model) {

        if (visitingList.getVisitingList() != null) {
            visitingService.addVisiting(visitingList);
        }

        model.addAttribute("educator", educator);
        model.addAttribute("clusterList", clusterList);
        model.addAttribute("childList", childList);
        model.addAttribute("content", "visiting");
        model.addAttribute("currentDate", currentDate);
        model.addAttribute("selectedCluster", selectedCluster);
        return "index";
    }
}
