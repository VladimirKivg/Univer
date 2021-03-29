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
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.exceptions.TemplateInputException;

import java.util.Optional;

@Controller
public class InfoKidController {


    @Autowired
    private ChildRepository kidRepository;

    @RequestMapping("/info-kid-id")
    public String infirmKind1(Model model){
        model.addAttribute("content","kidInfoId");
    return "index";}



    @RequestMapping("/info-kid")
    public String informKind(@RequestParam(value = "id")String idStr, Model model) {

        try {
            int id=Integer.parseInt(idStr);
        Child child = kidRepository.findById(id).get();

        model.addAttribute("child", child);

        model.addAttribute("content","kidInfo");
//kidIfo
        } catch (Exception e) {
            String message="дитини за таким ID не знайдено, поверніться будьласка в попереднє меню і спробуйте ще раз";

            model.addAttribute("message", message);
            model.addAttribute("content","kidInfoNot");
            return "index";}
        return "index";}

}
