package edu.lits.maliatko.service;

import edu.lits.maliatko.model.PaymentModel;
import edu.lits.maliatko.pojo.Payment;

import java.util.List;

public interface PaymentService {
    List<PaymentModel> findAll();

    void deleteById(Integer id);
}
