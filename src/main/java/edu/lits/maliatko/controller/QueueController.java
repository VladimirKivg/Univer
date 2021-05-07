package edu.lits.maliatko.controller;

// цей клас писав Вова

import edu.lits.maliatko.model.KindergartenModel;
import edu.lits.maliatko.model.QueueModel;
import edu.lits.maliatko.pojo.Address;
import edu.lits.maliatko.pojo.Child;
import edu.lits.maliatko.service.QueueService;
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
    private QueueService queueService;


    @RequestMapping("/queue")
    public String listKinder(
            @RequestParam(value = "kindergartenName", required = false)
                    String kindergartenName,
            Model model) {

        List<Child> childList = new ArrayList<>();
        Address address = new Address();

        if (kindergartenName != null) {

            List<KindergartenModel> byName = queueService.findByName(kindergartenName);

            KindergartenModel kindergarten = byName.iterator().next();
          address=kindergarten.getAddress();

            List<QueueModel> byKindergarten_name = queueService.findByKindergarten_Name(kindergartenName);


            for (QueueModel queueModel : byKindergarten_name) {
                childList.add(queueModel.getChild());
            }
        }

        model.addAttribute("attributeAddress", address);
        model.addAttribute("attributeKidList", childList);
        model.addAttribute("selectedKindergarten", kindergartenName);


        model.addAttribute("content", "listKind");
        return "index";
    }

}
