package edu.lits.maliatko.service;

import edu.lits.maliatko.model.PaymentModel;

import java.util.List;

public interface PaymentService {
    List<PaymentModel> findAll();

    void deleteById(Integer id);
}
