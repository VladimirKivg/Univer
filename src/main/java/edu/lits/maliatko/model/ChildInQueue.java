package edu.lits.maliatko.model;

import java.time.LocalDate;
import java.util.Objects;

public class ChildInQueue {
    private Integer id;
    private String surname;
    private String name;
    private LocalDate dateOfBirth;

    public ChildInQueue() {
    }

    @Override
    public String toString() {
        return "ChildInQueue{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChildInQueue child = (ChildInQueue) o;
        return Objects.equals(id, child.id) &&
                Objects.equals(surname, child.surname) &&
                Objects.equals(name, child.name) &&
                Objects.equals(dateOfBirth, child.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, name, dateOfBirth);
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
