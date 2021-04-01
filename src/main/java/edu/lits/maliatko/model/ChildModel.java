package edu.lits.maliatko.model;

import edu.lits.maliatko.pojo.Cluster;

public class ChildModel {

    private String name;
private String surname;
private String fatherName;
    public ChildModel() {
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
