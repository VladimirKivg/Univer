package edu.lits.maliatko.model;

import java.util.Date;

public class PaymentModel {

    private Integer id;
    private Date date;
    private String bankPaymentNumber;
    private String description;
    private Double payAmount;
    private Date registerDate;

    public PaymentModel() {
    }

    public PaymentModel(Integer id, Date date, String bankPaymentNumber, String description, Double payAmount, Date registerDate) {
        this.id = id;
        this.date = date;
        this.bankPaymentNumber = bankPaymentNumber;
        this.description = description;
        this.payAmount = payAmount;
        this.registerDate = registerDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBankPaymentNumber() {
        return bankPaymentNumber;
    }

    public void setBankPaymentNumber(String bankPaymentNumber) {
        this.bankPaymentNumber = bankPaymentNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Double payAmount) {
        this.payAmount = payAmount;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
}
