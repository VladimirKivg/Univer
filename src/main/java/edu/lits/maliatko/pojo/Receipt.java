package edu.lits.maliatko.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "receipt")
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "kid_id")
    private Child child;

    @Column(name = "visited_days")
    private Integer visitedDays;

    @Column(name = "cost_per_day")
    private Double costPerDay;

    @Column(name = "debt_overpay")
    private Double debtOverpay;

    @Column(name = "sum_to_pay")
    private Double sumToPay;

    @Column(name = "pay_period")
    private Date payPeriod;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    public Receipt() {
    }

    public Receipt(Child child, Integer visitedDays, Double costPerDay, Double debtOverpay, Double sumToPay, Date payPeriod, Payment payment) {
        this.child = child;
        this.visitedDays = visitedDays;
        this.costPerDay = costPerDay;
        this.debtOverpay = debtOverpay;
        this.sumToPay = sumToPay;
        this.payPeriod = payPeriod;
        this.payment = payment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public Integer getVisitedDays() {
        return visitedDays;
    }

    public void setVisitedDays(Integer visitedDays) {
        this.visitedDays = visitedDays;
    }

    public Double getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(Double costPerDay) {
        this.costPerDay = costPerDay;
    }

    public Double getDebtOverpay() {
        return debtOverpay;
    }

    public void setDebtOverpay(Double debtOverpay) {
        this.debtOverpay = debtOverpay;
    }

    public Double getSumToPay() {
        return sumToPay;
    }

    public void setSumToPay(Double sumToPay) {
        this.sumToPay = sumToPay;
    }

    public Date getPayPeriod() {
        return payPeriod;
    }

    public void setPayPeriod(Date payPeriod) {
        this.payPeriod = payPeriod;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "id=" + id +
                ", kidId=" + child +
                ", visitedDays=" + visitedDays +
                ", costPerDay=" + costPerDay +
                ", debtOverpay=" + debtOverpay +
                ", sumToPay=" + sumToPay +
                ", payPeriod=" + payPeriod +
                ", paymentId=" + payment +
                '}';
    }
}
