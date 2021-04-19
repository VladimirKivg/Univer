package edu.lits.maliatko.service;

import edu.lits.maliatko.model.PaymentModel;
import edu.lits.maliatko.pojo.Payment;
import edu.lits.maliatko.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class  PaymentImpl implements PaymentService{

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public List<PaymentModel> findAll() {
        Iterable<Payment> all = paymentRepository.findAll();
        List<PaymentModel>paymentModelList=new ArrayList<>();
        for (Payment payment:all){
            PaymentModel paymentModel = new PaymentModel(payment.getId(), payment.getDate(), payment.getBankPaymentNumber(), payment.getDescription(), payment.getPayAmount(), payment.getRegisterDate());
            paymentModelList.add(paymentModel);
        }
        return paymentModelList;
    }

    @Override
    public void deleteById(Integer id) {
paymentRepository.deleteById(id);
    }
}
