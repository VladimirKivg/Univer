package edu.lits.maliatko.model;

public class ChildModel {

    private Integer id;
    private String name;
    private String surname;
    private String fatherName;

    public ChildModel() {
    }

    public ChildModel(Integer id, String name, String surname, String fatherName) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.fatherName = fatherName;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
