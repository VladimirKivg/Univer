package edu.lits.maliatko.controller;

import edu.lits.maliatko.model.ClusterModel;
import edu.lits.maliatko.model.VisitingList;
import edu.lits.maliatko.model.VisitingModel;
import edu.lits.maliatko.pojo.User;
import edu.lits.maliatko.service.VisitingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/visiting")
public class VisitingController {

    private User educator;
    private List<ClusterModel> clusterList;
    private Integer selectedCluster;
    private List<VisitingModel> visitingList;
    private Date visitingDate;

    @Autowired
    VisitingService visitingService;

    @RequestMapping(value = "/child_list", method = RequestMethod.GET)
    public String visitingCheck(ModelMap model) {

        educator = visitingService.getEducator(5);

        clusterList = visitingService.getClusterList(5);

        visitingDate = visitingService.getCurrentDateTime();

        if (!clusterList.isEmpty()) {
            selectedCluster = clusterList.get(0).getId();
            visitingList = visitingService.getVisitingList(selectedCluster, visitingDate);
        } else {
            visitingList = new ArrayList<>();
        }

        model.addAttribute("educator", educator);
        model.addAttribute("clusterList", clusterList);
        model.addAttribute("content", "visiting");
        model.addAttribute("selectedCluster", selectedCluster);
        model.addAttribute("visitingList", visitingList);
        model.addAttribute("visitingDate", visitingService.convertDateToString(visitingDate));
        return "index";
    }

    @RequestMapping(value = "/change_cluster_date", method = RequestMethod.GET)
    public String visitingChangeDate(@DateTimeFormat(pattern = "dd/MM/yyyy") Date newVisitingDate, Integer currentCluster, ModelMap model) {

        visitingDate = newVisitingDate;
        selectedCluster = currentCluster;

        if (!clusterList.isEmpty()) {
            visitingList = visitingService.getVisitingList(selectedCluster, visitingDate);
        } else {
            visitingList = new ArrayList<>();
        }

        model.addAttribute("educator", educator);
        model.addAttribute("clusterList", clusterList);
        model.addAttribute("content", "visiting");
        model.addAttribute("selectedCluster", selectedCluster);
        model.addAttribute("visitingList", visitingList);
        model.addAttribute("visitingDate", visitingService.convertDateToString(visitingDate));
        return "index";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String visitingUpdate(VisitingList newVisitingList, ModelMap model) {

        if (newVisitingList.getVisitingList() != null) {
            visitingService.addVisiting(newVisitingList);
        }

        if (!clusterList.isEmpty()) {
            visitingList = visitingService.getVisitingList(selectedCluster, visitingDate);
        } else {
            visitingList = new ArrayList<>();
        }
        model.addAttribute("educator", educator);
        model.addAttribute("clusterList", clusterList);
        model.addAttribute("content", "visiting");
        model.addAttribute("selectedCluster", selectedCluster);
        model.addAttribute("visitingList", visitingList);
        model.addAttribute("visitingDate", visitingService.convertDateToString(visitingDate));
        return "index";
    }
}
