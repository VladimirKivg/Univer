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
    private Date date;

    @Column(name = "bank_payment_number")
    private String bankPaymentNumber;

    @Column(name = "description")
    private String description;

    @Column(name = "pay_amount")
    private Double payAmount;

    @Column(name = "register_date")
    private Date registerDate;

    public Payment() {
    }

    public Payment(Date date, String bankPaymentNumber, String description, Double payAmount, Date registerDate) {
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

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", date=" + date +
                ", bankPaymentNumber='" + bankPaymentNumber + '\'' +
                ", description='" + description + '\'' +
                ", payAmount=" + payAmount +
                ", registerDate=" + registerDate +
                '}';
    }
}
