package edu.lits.maliatko.model;

import edu.lits.maliatko.pojo.Kindergarten;

public class CreatingGroupsModel {
    private Integer id;
    private String nameGroup;
    private Kindergarten kindergartenId;

    public CreatingGroupsModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public Kindergarten getKindergartenId() {
        return kindergartenId;
    }

    public void setKindergartenId(Kindergarten kindergartenId) {
        this.kindergartenId = kindergartenId;
    }
}



