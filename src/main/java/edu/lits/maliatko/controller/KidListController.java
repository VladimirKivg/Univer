package edu.lits.maliatko.controller;

// цей клас писав Вова
import edu.lits.maliatko.pojo.Kid;
import edu.lits.maliatko.repository.KidRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class KidListController {
private KidRepository kidRepository;



    @RequestMapping("/list-kind")
    public String listKinder(Model model){
        List<Kid> kidList=new ArrayList<>();
//        Iterable<Kid> kidIterable ;
//        kidIterable=kidRepository.findAll();
//        for (Kid kid:kidIterable) {
//            kidList.add(kid);
//        }
        Kid kid =new Kid();
        kid.setName("Вова");
        kid.setSurname("Великий");
        kid.setFatherName("Володимирович");
        kidList.add(kid);
        model.addAttribute("attributeKidList",kidList);
model.addAttribute("content","listKind");
        return "index";
    }

}
