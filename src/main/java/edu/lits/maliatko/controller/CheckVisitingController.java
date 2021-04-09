package edu.lits.maliatko.controller;

import edu.lits.maliatko.pojo.Child;
import edu.lits.maliatko.pojo.Visiting;
import edu.lits.maliatko.repository.ChildRepository;
import edu.lits.maliatko.repository.VisitingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Controller
public class CheckVisitingController {

    @Autowired
VisitingRepository visitingRepository;

    @Autowired
    ChildRepository childRepository;

    @RequestMapping("/visitingCheck")
    public String visiting(Model model){
        Iterable<Visiting> all = visitingRepository.findAll();
        List<Visiting>visitingList=new ArrayList<>();
        all.forEach(visitingList::add);

        Iterable<Child> all2 = childRepository.findAll();
        List<Child>childList=new ArrayList<>();
        all2.forEach(childList::add);

        List<Child>childList2=new ArrayList<>();
        for (Visiting visiting:all){
            childList2.add(visiting.getChild());
        }

        childList.removeAll(childList2);

        Iterable<Visiting> allByPresence = visitingRepository.findAllByPresence(null);
List<Visiting>visitingList2=new ArrayList<>();
allByPresence.forEach(visitingList2::add);

        model.addAttribute("attributeChildList2",visitingList2);
        model.addAttribute("attributeChildList",childList);
        model.addAttribute("content","checkVisiting");
    return "index";}

}
