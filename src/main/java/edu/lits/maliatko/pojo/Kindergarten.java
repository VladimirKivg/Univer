package edu.lits.maliatko.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "kindergarten")
public class Kindergarten {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native",strategy ="native" )
    private Integer id;        // id
    @Column(name = "number")
    private Integer number;  // number
    @Column(name = "name")
    private String name;     // name

//    @ManyToOne
    private Address addressId;  //address_id
}