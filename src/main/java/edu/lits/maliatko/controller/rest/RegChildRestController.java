package edu.lits.maliatko.controller.rest;


import edu.lits.maliatko.model.KidReg;
import edu.lits.maliatko.service.RegistrationToKindergartenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rest")
public class RegChildRestController {

    @Autowired
    private RegistrationToKindergartenService service;

    @RequestMapping(method = RequestMethod.POST, value = "/add_child_to_queue")
    public void addChildToQueue(@RequestBody KidReg kidReg) {

        service.saveKidAddress(kidReg);

        service.saveUserAddress(kidReg);

        service.saveUserParentOne(kidReg);

        service.saveChild(kidReg);

        service.saveQueue(kidReg);

    }
}
