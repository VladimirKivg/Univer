package edu.lits.maliatko.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "group")
public class GroupA {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native",strategy ="native" )
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "kindergarten_id")
    private Kindergarten kindergartenId;

    public GroupA() {
    }

    public GroupA(String name, Kindergarten kindergartenId) {
        this.name = name;
        this.kindergartenId = kindergartenId;
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

    public Kindergarten getKindergartenId() {
        return kindergartenId;
    }

    public void setKindergartenId(Kindergarten kindergartenId) {
        this.kindergartenId = kindergartenId;
    }

    @Override
    public String toString() {
        return "GroupA{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", kindergartenId=" + kindergartenId +
                '}';
    }
}
