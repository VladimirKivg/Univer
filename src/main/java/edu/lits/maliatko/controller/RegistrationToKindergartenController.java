package edu.lits.maliatko.controller;

import edu.lits.maliatko.pojo.Payment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RegistrationToKindergartenController {

    @RequestMapping("/registration")
    public String list(ModelMap model) {
        model.addAttribute("content", "registrationToKindergarten");
        return "index";
    }

}
