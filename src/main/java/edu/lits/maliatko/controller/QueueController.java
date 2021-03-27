package edu.lits.maliatko.controller;

// цей клас писав Вова
import edu.lits.maliatko.pojo.Child;
import edu.lits.maliatko.repository.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class QueueController {

    @Autowired
private ChildRepository childRepository;


    @RequestMapping("/list-kind")
    public String listKinder(Model model){
        Iterable<Child> all = childRepository.findAll();
        List<Child>childList=new ArrayList<>();
        for (Child child:all){
            childList.add(child);
        }
//        Child child =new Child();
//        child.setName("Вова");
//        child.setSurname("Великий");
//        child.setFatherName("Володимирович");

        model.addAttribute("attributeKidList",childList);
model.addAttribute("content","listKind");
        return "index";
    }

}
