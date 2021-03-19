package edu.lits.maliatko.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native",strategy ="native" )
    private Integer id;

    @Column(name = "role")
    private String role;

    public Role() {
    }

    public Role(String role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }
}
