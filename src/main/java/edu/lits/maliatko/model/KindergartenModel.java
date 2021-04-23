package edu.lits.maliatko.model;

import edu.lits.maliatko.pojo.Address;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

public class KindergartenModel {

    private Integer id;
    private Integer number;
    private String name;
    private Address address;

    public KindergartenModel() {
    }

    public KindergartenModel( Integer number, String name, Address address) {

        this.number = number;
        this.name = name;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
