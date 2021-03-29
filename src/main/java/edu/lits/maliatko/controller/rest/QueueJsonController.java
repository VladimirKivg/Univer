package edu.lits.maliatko.controller.rest;

import edu.lits.maliatko.pojo.Child;
import edu.lits.maliatko.pojo.Queue;
import edu.lits.maliatko.repository.QueueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/json")
public class QueueJsonController {

    @Autowired
    private QueueRepository queueRepository;

    @RequestMapping("/queue")
    public List<Queue> listKinder(Model model){
        Iterable<Queue> all1 = queueRepository.findAll();
        List<Queue> childList=new ArrayList<>();
        all1.forEach(childList::add);

        return childList;
    }

}

