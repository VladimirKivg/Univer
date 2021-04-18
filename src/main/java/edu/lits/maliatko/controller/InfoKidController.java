package edu.lits.maliatko.controller;
//Вова

import edu.lits.maliatko.model.test.InfoKidModel;
import edu.lits.maliatko.pojo.Child;
import edu.lits.maliatko.pojo.Queue;
import edu.lits.maliatko.pojo.User;
import edu.lits.maliatko.repository.QueueRepository;
import edu.lits.maliatko.repository.ChildRepository;
import edu.lits.maliatko.service.InfoKidService;
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
    private InfoKidService infoKidService;

    @RequestMapping("/info-kid-id")
    public String infirmKind1(Model model) {
        model.addAttribute("content", "kidInfoId");
        return "index";
    }
    @RequestMapping("/info-kid")
    public String informKind(@RequestParam(value = "id") String idStr, Model model) {


        try {

            int id = Integer.parseInt(idStr);
            InfoKidModel infoKidModel = infoKidService.findById(id);
            String cluster ="барабуля";
            if (infoKidModel.getCluster()==null){
                cluster="ще не визначено";
            }else {
                cluster=infoKidModel.getCluster().getName();
            }
            if (null==infoKidModel.getUserParentTwo()){
                model.addAttribute("cluster",cluster);
                model.addAttribute("child",infoKidModel);
                model.addAttribute("content", "kidInfoNotParentTwo");
            }else {
                model.addAttribute("cluster",cluster);
            model.addAttribute("child", infoKidModel);

            model.addAttribute("content", "kidInfo");
            }

        } catch (Exception e) {
            String message = "дитини за таким ID не знайдено, поверніться будьласка в попереднє меню і спробуйте ще раз";

            model.addAttribute("message", message);
            model.addAttribute("content", "kidInfoNot");
            return "index";
        }
        return "index";
    }

}
