package edu.lits.maliatko.controller.rest;

import edu.lits.maliatko.model.KindergartenModel;
import edu.lits.maliatko.pojo.Kindergarten;
import edu.lits.maliatko.repository.KindergartenRepository;
import edu.lits.maliatko.service.KindergartenListJsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/json")
public class KindergartenListJsonController {

    @Autowired
   private KindergartenListJsonService kindergartenListJsonService;

    @RequestMapping("/kindergartenList")
   public List<KindergartenModel> kindergartenList(){
        List<KindergartenModel> all1 = kindergartenListJsonService.findAll();

        return all1;
   }
}
