package edu.lits.maliatko.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
@Entity(name = "Payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native",strategy ="native" )
    private Integer id;//id
    @Column(name = "date")
    private Date date;//date
    @Column(name = "bank_payment_number")
    private String bankPaymentNumber;//bank_payment_number
    @Column(name = "description")
    private String description;//description
    @Column(name = "paymentcol")
    private String paymentCol;//paymentcol
    @Column(name = "pay_amount")
    private Double payAmount;//pay_amount
    @Column(name = "register_date")
    private Date registerDate;//register_date

}
