package edu.lits.maliatko.model.test;

import edu.lits.maliatko.pojo.Child;
import edu.lits.maliatko.pojo.User;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

public class CheckVisitingModel {

    private Integer id;
    private Child child;
    private Date visitingDate;
    private Integer presence;
    private User userLogger;

    public CheckVisitingModel() {
    }

    public CheckVisitingModel(Integer id, Child child, Date visitingDate, Integer presence, User userLogger) {
        this.id = id;
        this.child = child;
        this.visitingDate = visitingDate;
        this.presence = presence;
        this.userLogger = userLogger;
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

    public Date getVisitingDate() {
        return visitingDate;
    }

    public void setVisitingDate(Date visitingDate) {
        this.visitingDate = visitingDate;
    }

    public Integer getPresence() {
        return presence;
    }

    public void setPresence(Integer presence) {
        this.presence = presence;
    }

    public User getUserLogger() {
        return userLogger;
    }

    public void setUserLogger(User userLogger) {
        this.userLogger = userLogger;
    }
}
