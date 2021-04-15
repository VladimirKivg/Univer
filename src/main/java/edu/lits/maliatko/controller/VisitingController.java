package edu.lits.maliatko.controller;

import edu.lits.maliatko.model.VisitingList;
import edu.lits.maliatko.pojo.Child;
import edu.lits.maliatko.pojo.User;
import edu.lits.maliatko.service.VisitingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
public class VisitingController {

    @Autowired
    VisitingService visitingService;

    @RequestMapping(value = "/visiting", method = RequestMethod.GET)
    public String visiting(ModelMap model) {

        User educator = visitingService.getEducator(2);
        Iterable<Child> childList = visitingService.getChildList();
        String currentDate = DateFormat.getDateTimeInstance(3,2, Locale.UK).format(new Date());

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
