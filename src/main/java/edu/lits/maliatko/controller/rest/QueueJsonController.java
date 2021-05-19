package edu.lits.maliatko.controller.rest;


import edu.lits.maliatko.model.KindergartenModel;
import edu.lits.maliatko.model.QueueModel;
import edu.lits.maliatko.pojo.Address;
import edu.lits.maliatko.pojo.Child;
import edu.lits.maliatko.pojo.Queue;
import edu.lits.maliatko.repository.QueueRepository;
import edu.lits.maliatko.service.QueueService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class QueueJsonController {

    @Autowired
    private QueueRepository queueRepository;
    @Autowired
    private QueueService queueService;

    @ApiImplicitParams(
            @ApiImplicitParam(
                    name = "Authorization",
                    value = "Access Token",
                    required = true,
                    allowEmptyValue = false,
                    paramType = "header",
                    dataTypeClass = String.class,
                    example = "Bearer access_token"))
//    @RequestMapping("/queue")
//    public List<Queue> listKinder(Model model){
//        Iterable<Queue> all1 = queueRepository.findAll();
//        List<Queue> childList=new ArrayList<>();
//        all1.forEach(childList::add);
//
//        return childList;
//    }
    @RequestMapping("/queue")
    public List<Child> listKinder(
            @RequestParam(value = "kindergartenName", required = false)
                    String kindergartenName,
            Model model) {

        List<Child> childList = new ArrayList<>();
        Address address = new Address();

        if (kindergartenName != null) {

            List<KindergartenModel> byName = queueService.findByName(kindergartenName);

            KindergartenModel kindergarten = byName.iterator().next();
            address = kindergarten.getAddress();

            List<QueueModel> byKindergarten_name = queueService.findByKindergarten_Name(kindergartenName);


            for (QueueModel queueModel : byKindergarten_name) {
                childList.add(queueModel.getChild());
            }
        }

        return childList;
    }


}

