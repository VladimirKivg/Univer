package edu.lits.maliatko.controller;

// цей клас писав Вова

import edu.lits.maliatko.pojo.Child;
import edu.lits.maliatko.pojo.Kindergarten;
import edu.lits.maliatko.pojo.Queue;
import edu.lits.maliatko.repository.KindergartenRepository;
import edu.lits.maliatko.repository.QueueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
public class QueueController {


    @Autowired
    private QueueRepository queueRepository;

    @Autowired
    private KindergartenRepository kindergartenRepository;

    @RequestMapping("/queue")
    public String listKinder(
            @RequestParam(value = "kindergartenName", required = false)
                    String kindergartenName,
            Model model) {

        List<Child> childList = new ArrayList<>();

        if (kindergartenName != null) {
            Iterable<Kindergarten> kindergartenIterable = kindergartenRepository.findByName(kindergartenName);
            Kindergarten kindergarten = kindergartenIterable.iterator().next();


            Iterable<Queue> all1 = queueRepository.findByKindergarten_Name(kindergartenName);
            for (Queue queue : all1) {
                childList.add(queue.getChild());
            }
        }


        model.addAttribute("attributeKidList", childList);
        model.addAttribute("selectedKindergarten", kindergartenName);


        model.addAttribute("content", "listKind");
        return "index";
    }

}
