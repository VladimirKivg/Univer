package edu.lits.maliatko.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/childInQueue")
public class  ChildInQueueController {


    private static final List<ChildInQueue> childInQueueList = new ArrayList<>();

    static {
        ChildInQueue child1 = new ChildInQueue();
        child1.setId(1);
        child1.setSurname("Гринчук");
        child1.setName("Тетяна");
        child1.setDateOfBirth(LocalDate.of(2017, 01, 01));
        childInQueueList.add(child1);

        ChildInQueue child2 = new ChildInQueue();
        child2.setId(2);
        child2.setSurname("Чуйко");
        child2.setName("Іван");
        child2.setDateOfBirth(LocalDate.of(2017, 02, 03));
        childInQueueList.add(child2);
    }

    @RequestMapping("/list")
    public String list(ModelMap model) {
        model.addAttribute("childInQueueList", childInQueueList);
        model.addAttribute("content", "");
        return "index";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, ModelMap model) {
        childInQueueList.remove(id - 1);// this logic is not correct, id doesn’t depend on index
        return "redirect:/childInQueue/list";
    }

    @RequestMapping("/add-childInQueue")
    public String addChildInQueue(ChildInQueue child, ModelMap model, BindingResult result) {
        model.addAttribute("content", "");
        return "index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(ChildInQueue child, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            model.addAttribute("content", "");
            return "index";
        }
        childInQueueList.add(child);
        return "redirect:/childInQueue/list";
    }

    @RequestMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        ChildInQueue child = childInQueueList.get(0); // this logic is not correct, group has to be                        //                                    selected by it’s id.
        model.addAttribute("child", child);
        model.addAttribute("content", "");
        return "index";
    }

    @RequestMapping("/update/{id}")
    public String updateChildInQueue(@PathVariable("id") int id, ChildInQueue child,
                              BindingResult result, Model model) {

        childInQueueList.get(id).setSurname(child.getSurname());
        childInQueueList.get(id).setName(child.getName());
        childInQueueList.get(id).setDateOfBirth(child.getDateOfBirth());
        return "redirect:/childInQueue/list";
    }

}


