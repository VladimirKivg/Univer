package edu.lits.maliatko.controller;


import edu.lits.maliatko.model.KidReg;
import edu.lits.maliatko.pojo.*;
import edu.lits.maliatko.repository.*;

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
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ChildRepository childRepository;

    @Autowired
    private KindergartenRepository kindergartenRepository;

    @Autowired
    private QueueRepository queueRepository;

    @Autowired
    private ClusterRepository clusterRepository;

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

        Address userAddress = new Address(kidReg.getParentRegion(), kidReg.getParentCity(), kidReg.getParentStreet(), kidReg.getParentBuildingNumber(), kidReg.getParentApartment());

        addressRepository.save(userAddress);

        User userParentOne = new User(kidReg.getParentSurname(), kidReg.getParentName(), kidReg.getParentFatherName(), kidReg.getParentBirthDate(), kidReg.getParentPhone(), kidReg.getParentMail(), userAddress);
        userRepository.save(userParentOne);


        Date date = new Date();

        Child child = new Child(kidReg.getKidSurname(), kidReg.getKidName(), kidReg.getKidFatherName(), kidReg.getKidBirthDate(), kidReg.getKidGender(), kidReg.getKidBirthDocument(), kidAddress, userParentOne, kidReg.getKidBenefits(), "в черзі", null, 0, date, null);
        childRepository.save(child);

        Kindergarten kindergarten = new Kindergarten();
        Iterable<Kindergarten> all = kindergartenRepository.findAll();
        for (Kindergarten kid : all) {
            if (Integer.parseInt(kidReg.getKindergartenName()) == kid.getNumber()) {
                kindergarten = kid;
            }
        }
        Queue queue = new Queue(child, kindergarten, date);
        queueRepository.save(queue);





        // вичитати kindergarten записати його в Queue.kindergarten
        // date = date.now
        // зберегти обєкт Queue

        return "redirect:/queue";
    }
}
