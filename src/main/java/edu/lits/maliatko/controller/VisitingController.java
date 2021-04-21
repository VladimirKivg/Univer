package edu.lits.maliatko.controller;

import edu.lits.maliatko.model.VisitingList;
import edu.lits.maliatko.pojo.Child;
import edu.lits.maliatko.pojo.User;
import edu.lits.maliatko.repository.ChildRepository;
import edu.lits.maliatko.service.VisitingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class VisitingController {
    @Autowired
    ChildRepository childRepository;

    @Autowired
    VisitingService visitingService;

    @RequestMapping(value = "/visiting", method = RequestMethod.GET)
    public String visiting(ModelMap model) {

        User educator = visitingService.getEducator(2);

        //Цей код виводить лист відвідування дітей з однієі групи
        List<Child> childList = new ArrayList<>();
        Iterable<Child> all1 = childRepository.findByClusterId (3);
        for (Child child : all1) {
            childList.add(child);
        }

        //Iterable<Child> childList = visitingService.getChildList();

        String currentDate = visitingService.getCurrentTime();

        model.addAttribute("educator", educator);
        model.addAttribute("childList", childList);
        model.addAttribute("content", "visiting");
        model.addAttribute("currentDate", currentDate);
        return "index";
    }

    @RequestMapping(value = "/visiting", method = RequestMethod.POST)
    public String visitingUpdate(VisitingList visitingList) {

        visitingService.addVisiting(visitingList);

        return "redirect:/visiting";
    }
}
