package edu.lits.maliatko.controller.rest;

import edu.lits.maliatko.model.test.CheckVisitingModel;
import edu.lits.maliatko.service.CheckVisitingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class CheckVisitingRestController {

    @Autowired
    private CheckVisitingService checkVisitingService;

    @RequestMapping("/visitingCheck")
    public List<CheckVisitingModel> visiting() {
        List<CheckVisitingModel> allByPresence1 = checkVisitingService.findAllByPresence(null);
//
//        model.addAttribute("attributeChildList2", allByPresence1);
//
//        model.addAttribute("content", "checkVisiting");
        return allByPresence1;
    }


}
