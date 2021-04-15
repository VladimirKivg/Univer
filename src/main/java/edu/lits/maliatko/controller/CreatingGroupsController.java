package edu.lits.maliatko.controller;


import edu.lits.maliatko.model.CreatingGroups;
import edu.lits.maliatko.pojo.Cluster;
import edu.lits.maliatko.repository.ClusterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CreatingGroupsController {

    @Autowired
    private ClusterRepository clusterRepository;

    @RequestMapping("/creating_groups")
    public String creating(CreatingGroups creatingGroups, ModelMap model) {
        model.addAttribute("content", "creatingGroups");
        return "index";
    }


    @RequestMapping(value = "/addNameGroup", method = RequestMethod.POST)
    public String addNameGroups(CreatingGroups creatingGroups) {

        Cluster cluster = new Cluster(creatingGroups.getNameGroup(), creatingGroups.getKindergartenId());

        clusterRepository.save(cluster);


        return "redirect:/management";
    }
}
