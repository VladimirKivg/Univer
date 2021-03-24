package edu.lits.maliatko.controller;

import edu.lits.maliatko.model.KidReg;
import edu.lits.maliatko.pojo.Address;
import edu.lits.maliatko.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationToKindergartenController {

    @Autowired
    private AddressRepository addressRepository;

    @RequestMapping("/registration")
    public String registration(ModelMap model) {
        model.addAttribute("content", "registrationToKindergarten");
        return "index";
    }

    @RequestMapping(value = "/addKidToList", method = RequestMethod.POST)
    public String addKidToList(KidReg kidReg) {

        Address kidAddress = new Address(kidReg.getKidRegion(), kidReg.getKidCity(), kidReg.getKidStreet(),
                kidReg.getKidBuildingNumber(), kidReg.getKidApartment());

        addressRepository.save(kidAddress);

        return "redirect:/registration";
    }
}
