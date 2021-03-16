package edu.lits.maliatko.repository;

import edu.lits.maliatko.pojo.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {
}
