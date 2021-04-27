package edu.lits.maliatko.controller;


import edu.lits.maliatko.model.KidReg;
import edu.lits.maliatko.pojo.*;
import edu.lits.maliatko.repository.*;

import edu.lits.maliatko.service.RegistrationToKindergartenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;


@Controller
public class RegistrationToKindergartenController {

    @Autowired
private RegistrationToKindergartenService service;



    @RequestMapping("/registration")
    public String registration(ModelMap model) {
        model.addAttribute("content", "registrationToKindergarten");
        return "index";
    }

    @RequestMapping(value = "/addKidToList", method = RequestMethod.POST)
    public String addKidToList(KidReg kidReg) {

        service.saveKidAddress(kidReg);


        service.saveUserAddress(kidReg);


//        User userParentOne = new User(kidReg.getParentSurname(), kidReg.getParentName(), kidReg.getParentFatherName(), kidReg.getParentBirthDate(), kidReg.getParentPhone(), kidReg.getParentMail(), userAddress);
//        userRepository.save(userParentOne);

        service.saveUserParentOne(kidReg);


//        Date date = new Date();
//
//        Child child = new Child(kidReg.getKidSurname(), kidReg.getKidName(), kidReg.getKidFatherName(), kidReg.getKidBirthDate(), kidReg.getKidGender(), kidReg.getKidBirthDocument(), kidAddress, userParentOne, kidReg.getKidBenefits(), "в черзі", null, 0, date, null);
//        childRepository.save(child);

       service.saveChild(kidReg);



        service.saveQueue(kidReg);

        return "redirect:/queue";
    }
}
