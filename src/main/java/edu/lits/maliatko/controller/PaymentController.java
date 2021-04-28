package edu.lits.maliatko.controller;

import edu.lits.maliatko.model.PaymentModel;
import edu.lits.maliatko.pojo.Payment;
import edu.lits.maliatko.repository.PaymentRepository;
import edu.lits.maliatko.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @RequestMapping("/list")
    public String list(ModelMap model) {

        List<PaymentModel> paymentModelList = paymentService.findAll();

        model.addAttribute("payments", paymentModelList);
        model.addAttribute("content", "paymentList");
        return "index";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, ModelMap model) {

        paymentService.deleteById(id);

        return "redirect:/payment/list";
    }

}