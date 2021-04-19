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

//    @Autowired
//    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentService paymentService;

    @RequestMapping("/list")
    public String list(ModelMap model) {

        List<PaymentModel> paymentModelList = paymentService.findAll();

//        Iterable<Payment> payments = paymentRepository.findAll();
//        List<Payment> result = new ArrayList<>();
//        payments.forEach(result::add);// одна шз фіормуліровок фор іч, тільки білш сучастний варіант

        model.addAttribute("payments", paymentModelList);
        model.addAttribute("content", "paymentList");
        return "index";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, ModelMap model) {

        paymentService.deleteById(id);

//        paymentRepository.deleteById(id);

        return "redirect:/payment/list";
    }

}