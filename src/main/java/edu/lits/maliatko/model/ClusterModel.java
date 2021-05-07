package edu.lits.maliatko.model;

import edu.lits.maliatko.pojo.Kindergarten;

public class ClusterModel {

    private Integer id;
    private String name;
    private Kindergarten kindergarten;

    public ClusterModel() {
    }

    public ClusterModel(Integer id, String name, Kindergarten kindergarten) {
        this.id = id;
        this.name = name;
        this.kindergarten = kindergarten;
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

    public Kindergarten getKindergarten() {
        return kindergarten;
    }

    public void setKindergarten(Kindergarten kindergarten) {
        this.kindergarten = kindergarten;
    }
}
