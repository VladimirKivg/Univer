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
    private Kid kidId;

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
    private Payment paymentId;

    public Receipt() {
    }

    public Receipt(Kid kidId, Integer visitedDays, Double costPerDay, Double debtOverpay, Double sumToPay, Date payPeriod, Payment paymentId) {
        this.kidId = kidId;
        this.visitedDays = visitedDays;
        this.costPerDay = costPerDay;
        this.debtOverpay = debtOverpay;
        this.sumToPay = sumToPay;
        this.payPeriod = payPeriod;
        this.paymentId = paymentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Kid getKidId() {
        return kidId;
    }

    public void setKidId(Kid kidId) {
        this.kidId = kidId;
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

    public Payment getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Payment paymentId) {
        this.paymentId = paymentId;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "id=" + id +
                ", kidId=" + kidId +
                ", visitedDays=" + visitedDays +
                ", costPerDay=" + costPerDay +
                ", debtOverpay=" + debtOverpay +
                ", sumToPay=" + sumToPay +
                ", payPeriod=" + payPeriod +
                ", paymentId=" + paymentId +
                '}';
    }
}
