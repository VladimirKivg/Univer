package edu.lits.maliatko.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "group")
public class GroupA {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native",strategy ="native" )
    private Integer id;  // id
    @Column(name = "name")
    private String name;  // name

//    @ManyToOne
    private Kindergarten kindergartenId; // kindergarten_id
}
