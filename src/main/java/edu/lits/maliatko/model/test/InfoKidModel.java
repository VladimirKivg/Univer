package edu.lits.maliatko.model.test;

import edu.lits.maliatko.pojo.Address;
import edu.lits.maliatko.pojo.Cluster;
import edu.lits.maliatko.pojo.User;

import java.util.Date;


public class InfoKidModel  {

    private Integer id;
    private String surname;
    private String name;
    private String fatherName;
    private Date birthDate;
    private Address address;
    private User userParentOne;
    private String benefits;
    private String status;
    private User userParentTwo;
    private Cluster cluster;

    public InfoKidModel() {
    }

    public InfoKidModel(Integer id, String surname, String name, String fatherName, Date birthDate, Address address, User userParentOne, String benefits, String status, User userParentTwo, Cluster cluster) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.fatherName = fatherName;
        this.birthDate = birthDate;
        this.address = address;
        this.userParentOne = userParentOne;
        this.benefits = benefits;
        this.status = status;
        this.userParentTwo = userParentTwo;
        this.cluster = cluster;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public User getUserParentOne() {
        return userParentOne;
    }

    public void setUserParentOne(User userParentOne) {
        this.userParentOne = userParentOne;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUserParentTwo() {
        return userParentTwo;
    }

    public void setUserParentTwo(User userParentTwo) {
        this.userParentTwo = userParentTwo;
    }

    public Cluster getCluster() {
        return cluster;
    }

    public void setCluster(Cluster cluster) {
        this.cluster = cluster;
    }
}
