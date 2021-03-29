package edu.lits.maliatko.controller;

// цей клас писав Вова
import edu.lits.maliatko.pojo.Child;
import edu.lits.maliatko.pojo.Queue;
import edu.lits.maliatko.repository.QueueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class QueueController {


@Autowired
    private QueueRepository queueRepository;

    @RequestMapping("/queue")
    public String listKinder(Model model){
        Iterable<Queue> all1 = queueRepository.findAll();
        List<Child>childList=new ArrayList<>();
        for (Queue queue:all1){
            childList.add(queue.getChild());
        }
//        for (Child child:childList){
//            clusterList.add(child.getCluster());
//        }


        model.addAttribute("attributeKidList",childList);
//        model.addAttribute("attributeClusterList",clusterList);
model.addAttribute("content","listKind");
        return "index";
    }

}
