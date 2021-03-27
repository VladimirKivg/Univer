package edu.lits.maliatko.controller;
//Вова
import edu.lits.maliatko.pojo.Child;
import edu.lits.maliatko.pojo.Queue;
import edu.lits.maliatko.repository.QueueRepository;
import edu.lits.maliatko.repository.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class InfoKidController {
    @Autowired
    private QueueRepository kidListRepository;
    @Autowired
    private ChildRepository kidRepository;

    @RequestMapping("/info-kid")
    public String informKind(Model model) {
        Queue kidList = new Queue();
        Child child = kidRepository.findById(11).get();
        Optional<Child> byId = kidRepository.findById(11);

//child.setFatherName("Б");
//child.setName("и");
//child.setSurname("З");
        String name = child.getName();
        String surname = child.getSurname();
        String fatherName = child.getFatherName();

        model.addAttribute("name", name);
        model.addAttribute("surname", surname);
        model.addAttribute("fatherName", fatherName);

        model.addAttribute("content","kidInfo");
//kidIfo
        return "index";
    }

}
