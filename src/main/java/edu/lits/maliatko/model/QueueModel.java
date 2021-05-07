package edu.lits.maliatko.model;

import edu.lits.maliatko.pojo.Child;
import edu.lits.maliatko.pojo.Kindergarten;
import java.util.Date;

public class QueueModel {

    private Integer id;
    private Child child;
    private Kindergarten kindergarten;
    private Date applyDate;

    public QueueModel() {
    }

    public QueueModel(Integer id, Child child, Kindergarten kindergarten, Date applyDate) {
        this.id = id;
        this.child = child;
        this.kindergarten = kindergarten;
        this.applyDate = applyDate;
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

    public Kindergarten getKindergarten() {
        return kindergarten;
    }

    public void setKindergarten(Kindergarten kindergarten) {
        this.kindergarten = kindergarten;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }
}
