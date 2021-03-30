package edu.lits.maliatko.model;

public class UserEducatorModel {

    private String name;
    private Integer groupId;

    public UserEducatorModel() {
    }

    public UserEducatorModel(String name, Integer groupId) {
        this.name = name;
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
}
