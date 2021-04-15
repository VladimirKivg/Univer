package edu.lits.maliatko.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class VisitingModel {
    private Integer id;
    private String name;
    private Integer presence;
    @DateTimeFormat(pattern="dd/MM/yyyy, HH:mm:ss")
    private Date visitingDate;
    private Integer loggerId;

    public VisitingModel() {
    }

    public VisitingModel(Integer id, String name, Integer presence, Date visitingDate, Integer loggerId) {
        this.id = id;
        this.name = name;
        this.presence = presence;
        this.visitingDate = visitingDate;
        this.loggerId = loggerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPresence() {
        return presence;
    }

    public void setPresence(Integer presence) {
        this.presence = presence;
    }

    public Date getVisitingDate() {
        return visitingDate;
    }

    public void setVisitingDate(Date visitingDate) {
        this.visitingDate = visitingDate;
    }

    public Integer getLoggerId() {
        return loggerId;
    }

    public void setLoggerId(Integer loggerId) {
        this.loggerId = loggerId;
    }
}
