package edu.lits.maliatko.controller.rest;

import edu.lits.maliatko.model.KindergartenModel;
import edu.lits.maliatko.model.QueueModel;
import edu.lits.maliatko.pojo.Address;
import edu.lits.maliatko.pojo.Child;
import edu.lits.maliatko.repository.QueueRepository;
import edu.lits.maliatko.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class Queue2RestController {

    @Autowired
    private QueueService queueService;

    @RequestMapping("/queue2")
    public List<Child> listKinder(
            @RequestBody
                    KindergartenModel kindergartenName) {

        List<Child> childList = new ArrayList<>();
        Address address = new Address();

        if (kindergartenName != null) {

            List<KindergartenModel> byName = queueService.findByName(kindergartenName.getName());

            KindergartenModel kindergarten = byName.iterator().next();
            address = kindergarten.getAddress();

            List<QueueModel> byKindergarten_name = queueService.findByKindergarten_Name(kindergartenName.getName());


            for (QueueModel queueModel : byKindergarten_name) {
                childList.add(queueModel.getChild());
            }
        }

        return childList;
    }




}
