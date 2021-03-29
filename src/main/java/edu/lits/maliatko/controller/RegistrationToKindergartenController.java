package edu.lits.maliatko.controller;

import edu.lits.maliatko.model.KidReg;
import edu.lits.maliatko.pojo.Address;
import edu.lits.maliatko.pojo.Child;
import edu.lits.maliatko.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationToKindergartenController {

    public final static Integer LOGGED_IN_PARENT_ID = 1;

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

        Child child = new Child();
// вичитати юзера за id =LOGGED_IN_PARENT_ID
        // помінятти адресу LOGGED_IN_PARENT_ID тобто того юзера якого ми маємо за цією ціфрою - на ту яка прийшла сюди


        // створити обєкт поджо чаілд з данними з кід KidReg
        // parentOne заповнити даними з  LOGGED_IN_PARENT_ID
        // child.addressId = kidAddress.id
        // зберегти обєкт child

        // створити обєкт queue тут
        // kidId = child.id
        // kidReg.getKindergartenName();//get.id
        // вичитати kindergarten записати його в Queue.kindergarten
        // date = date.now
        // зберегти обєкт Queue

        return "redirect:/queue";
    }
}
