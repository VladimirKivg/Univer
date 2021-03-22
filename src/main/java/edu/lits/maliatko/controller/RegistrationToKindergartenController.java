package edu.lits.maliatko.controller;

import edu.lits.maliatko.pojo.Kid;
import edu.lits.maliatko.pojo.Payment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RegistrationToKindergartenController {

    @RequestMapping("/registration")
    public String list(ModelMap model) {
        model.addAttribute("content", "registrationToKindergarten");
        return "index";
    }

    @RequestMapping(value = "/addKidToList", method = RequestMethod.POST)
    public String addKidToList(Kid kid) {
        return "redirect:/registration";
    }
}
