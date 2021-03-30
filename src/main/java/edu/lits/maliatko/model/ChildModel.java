package edu.lits.maliatko.model;

public class ChildModel {

    private String name;
    private Integer groupId;

    public ChildModel() {
    }

    public ChildModel(String name, Integer groupId) {
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
