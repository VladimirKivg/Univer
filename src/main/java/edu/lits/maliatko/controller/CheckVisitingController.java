package edu.lits.maliatko.controller;

import edu.lits.maliatko.model.test.CheckVisitingModel;
import edu.lits.maliatko.service.CheckVisitingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CheckVisitingController {


    @Autowired
    private CheckVisitingService checkVisitingService;

    @RequestMapping("/visitingCheck")
    public String visiting(Model model) {
        List<CheckVisitingModel> allByPresence1 = checkVisitingService.findAllByPresence(null);

        model.addAttribute("attributeChildList2", allByPresence1);

        model.addAttribute("content", "checkVisiting");
        return "index";
    }

}
