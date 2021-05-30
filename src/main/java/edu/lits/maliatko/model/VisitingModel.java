package edu.lits.maliatko.model;

public class VisitingModel {
    private Integer id;
    private Integer childId;
    private String name;
    private Integer presence;
    private String visitingDate;
    private Integer loggerId;

    public VisitingModel() {
    }

    public VisitingModel(Integer id, Integer childId, String name, Integer presence, String visitingDate, Integer loggerId) {
        this.id = id;
        this.childId = childId;
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

    public Integer getChildId() {
        return childId;
    }

    public void setChildId(Integer childId) {
        this.childId = childId;
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

    public String getVisitingDate() {
        return visitingDate;
    }

    public void setVisitingDate(String visitingDate) {
        this.visitingDate = visitingDate;
    }

    public Integer getLoggerId() {
        return loggerId;
    }

    public void setLoggerId(Integer loggerId) {
        this.loggerId = loggerId;
    }
}
