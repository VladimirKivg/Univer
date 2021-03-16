package edu.lits.maliatko.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
@Entity(name = "receipt")
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native",strategy ="native" )
    private Integer id;//id

    //    @ManyToOne
    private Kid kidId;//kid_id

    @Column(name = "visited_days")
    private Integer visitedDays;//visited_days
    @Column(name = "cost_per_day")
    private Double costPerDay;//cost_per_day
    @Column(name = "debt_overpay")
    private Double debtOverpay;//debt_overpay
    @Column(name = "sum_to_pay")
    private Double sumToPay;//sum_to_pay
    @Column(name = "pay_period")
    private Date payPeriod;//pay_period

    //    @ManyToOne
    private Payment paymentId;//payment_id
}
